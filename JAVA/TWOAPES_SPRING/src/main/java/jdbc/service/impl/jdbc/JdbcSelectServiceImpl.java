package jdbc.service.impl.jdbc;

import document.OracleColumn;
import enums.ISO8601;
import enums.JdbcEnum;
import jdbc.service.JdbcSelectService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import jdbc.pojo.ParameterPOJO;
import statics.DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.*;

/**
 * @author huyingzhao
 * 2022-02-01 0:29:27
 */
@Service
public class JdbcSelectServiceImpl extends Select implements JdbcSelectService {
    /**
     * @param parameterPOJO parameterPOJO
     * @return selectResultMap
     * @author add by huyingzhao
     * 2022-06-07 9:09
     */
    public List<Map<String, Object>> selectResultMap(ParameterPOJO parameterPOJO) {
        if (parameterPOJO != null && parameterPOJO.getSql() != null) {
            return select(isResultSet(parameterPOJO.getParameters(), parameterPOJO.getSql()), parameterPOJO, JdbcEnum.DATA.name());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @param pojo          pojo
     * @return selectResult
     * @author add by huyingzhao
     * 2022-06-07 9:10
     */
    public <T> List<T> selectResult(ParameterPOJO parameterPOJO, T pojo) {
        if (parameterPOJO != null && parameterPOJO.getSql() != null) {
            return select(isResultSet(parameterPOJO.getParameters(), parameterPOJO.getSql()), pojo, parameterPOJO, JdbcEnum.DATA.name());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @return selectOriginal
     * @author add by huyingzhao
     * 2022-06-07 9:11
     */
    public Map<String, String> selectOriginal(ParameterPOJO parameterPOJO) {
        select(isResultSet(parameterPOJO.getParameters(), parameterPOJO.getSql()), parameterPOJO, JdbcEnum.ORIGINAL_DATA.name());
        return getCommMap();
    }
}

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
class Select extends JdbcConnectServiceImpl {
    private Map<String, String> commMap;

    Select() {
        commMap = new HashMap<>();
    }


    /**
     * @param resultSet resultSet
     * @param select    select
     * @param para      para
     */
    List<Map<String, Object>> getSelect(ResultSet resultSet, ParameterPOJO select, String para) throws SQLException {
        List<Map<String, Object>> dataList = new ArrayList<>();
        if (para.equals(JdbcEnum.ORIGINAL_DATA.name())) {
            getSelect(resultSet);
        } else if (para.equals(JdbcEnum.DATA.name())) {
            getSelect(resultSet);
            dataList = getResult(resultSet, select);
        }

        return dataList;
    }

    /**
     * @param resultSet     resultSet
     * @param o             o
     * @param parameterPOJO parameterPOJO
     * @param para          para
     */
    <T> List<T> getSelect(ResultSet resultSet, T o, ParameterPOJO parameterPOJO, String para) throws SQLException {
        List<T> dataList = new ArrayList<>();
        if (para.equals(JdbcEnum.ORIGINAL_DATA.name())) {
            getSelect(resultSet);
        } else if (para.equals(JdbcEnum.DATA.name())) {
            getSelect(resultSet);
            if (o != null) {
                dataList = getResult(o, resultSet, parameterPOJO);
            }
        }

        return dataList;
    }

    /**
     * @param o     o
     * @param speed speed
     * @throws SQLException SQLException
     */
    String bcToString(Object o, int speed) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder("\n");
        if (o != null) {
            if (o instanceof Blob) {
                try (InputStream inputStream = ((Blob) o).getBinaryStream(); InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName(jdbcPOJO.getJdbcChars())); BufferedReader bufferedReader = new BufferedReader(inputStreamReader, speed)) {
                    String read;
                    while ((read = bufferedReader.readLine()) != null) {
                        stringBuilder.append(read).append("\n");
                    }
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            } else if (o instanceof Clob) {
                Clob clob = (Clob) o;
                String value = clob.getSubString(1, (int) (clob.length()));
                stringBuilder.append(value);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * @param is            is
     * @param parameterPOJO parameterPOJO
     */
    List<Map<String, Object>> select(boolean is, ParameterPOJO parameterPOJO, String string) {
        commMap.clear();
        List<Map<String, Object>> dataList = new ArrayList<>();
        if (parameterPOJO == null) {
            return dataList;
        } else if (is) {
            try {
                dataList = getSelect(resultSet, parameterPOJO, string);
                log.info("sql:{}" , parameterPOJO.getSql());
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            } finally {
                parameterPOJO.clear();
                closeResultSet();
            }
        }

        return dataList;
    }

    /**
     * @param is   is
     * @param o    o
     * @param pojo pojo
     * @return select
     */
    <T> List<T> select(boolean is, T o, ParameterPOJO pojo, String string) {
        commMap.clear();
        List<T> dataList = new ArrayList<>();
        if (pojo == null) {
            return dataList;
        } else if (is) {
            try {
                dataList = getSelect(resultSet, o, pojo, string);
                log.info("sql:{}" , pojo.getSql());
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            } finally {
                pojo.clear();
                closeResultSet();
            }
        }

        return dataList;
    }

    /**
     * @param resultSet ResultSet
     */
    private void getSelect(ResultSet resultSet) throws SQLException {
        log.info("searching.....");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            commMap.put(resultSetMetaData.getColumnName(i), resultSetMetaData.getColumnTypeName(i));
        }
    }

    /**
     * @param o             o
     * @param resultSet     resultSet
     * @param parameterPOJO parameterPOJO
     */
    @SuppressWarnings("unchecked")
    private <T> List<T> getResult(T o, ResultSet resultSet, ParameterPOJO parameterPOJO) {
        List<T> dataList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T t = (T) o.getClass().getDeclaredConstructor().newInstance();
                getClasses(t, parameterPOJO);
                dataList.add(t);
            }
            parameterPOJO.setI(dataList.size());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return dataList;
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @param resultSet     resultSet
     */
    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> getResult(ResultSet resultSet, ParameterPOJO parameterPOJO) {
        List<Map<String, Object>> dataList = new ArrayList<>();
        try {
            Map<String, Object> stringObjectMap = new HashMap<>();
            while (resultSet.next()) {
                stringObjectMap = stringObjectMap.getClass().getDeclaredConstructor().newInstance();
                for (Map.Entry<String, String> stringStringEntry : commMap.entrySet()) {
                    String key = stringStringEntry.getKey();
                    String type = stringStringEntry.getValue();
                    Object o = null;
                    if (jdbcPOJO.getJdbcType().equals(JdbcEnum.ORACLE.name())) {
                        if (JdbcEnum.BLOB.name().equals(type)) {
                            if (parameterPOJO.isSkip()) {
                                o = JdbcEnum.SKIP.name();
                            } else {
                                o = bcToString(resultSet.getBlob(key), Integer.parseInt(jdbcPOJO.getJdbcSpeed()));
                            }

                        } else if (JdbcEnum.CLOB.name().equals(type)) {
                            if (parameterPOJO.isSkip()) {
                                o = JdbcEnum.SKIP.name();
                            } else {
                                o = bcToString(resultSet.getClob(key), Integer.parseInt(jdbcPOJO.getJdbcSpeed()));
                            }

                        } else if (JdbcEnum.VARCHAR.name().equals(type)) {
                            o = resultSet.getString(key);
                            if (o == null)
                                o = "";

                        } else if (JdbcEnum.VARCHAR2.name().equals(type)) {
                            o = resultSet.getString(key);
                            if (o == null)
                                o = "";

                        } else if (JdbcEnum.CHAR.name().equals(type)) {
                            o = resultSet.getString(key);
                            if (o == null)
                                o = "";
                        } else if (JdbcEnum.LONG.name().equals(type)) {
                            o = resultSet.getLong(key);
                        } else if (JdbcEnum.NUMBER.name().equals(type)) {
                            o = resultSet.getBigDecimal(key);
                            if (o == null)
                                o = 0;
                        } else if (JdbcEnum.DATE.name().equals(type)) {
                            o = DateUtils.format(resultSet.getDate(key), ISO8601.iso8601(jdbcPOJO.getJdbcDataType()));
                        } else if (JdbcEnum.TIMESTAMP.name().equals(type)) {
                            o = resultSet.getTimestamp(key);
                        } else if ("TIMESTAMP WITH LOCAL TIME ZONE".equals(type)) {
                            o = resultSet.getTimestamp(key);
                        } else if ("TIMESTAMP WITH TIME ZONE".equals(type)) {
                            o = resultSet.getTimestamp(key);
                        } else {
                            o = resultSet.getString(key);
                            if (o == null)
                                o = "";
                        }

                    } else if (jdbcPOJO.getJdbcType().equals(JdbcEnum.POSTGRES.name())) {
                        o = resultSet.getString(key);
                        if (o == null)
                            o = "";
                    } else if (jdbcPOJO.getJdbcType().equals(JdbcEnum.MYSQL.name())) {
                        if (JdbcEnum.VARCHAR.name().equals(type)) {
                            o = resultSet.getString(key);
                            if (o == null)
                                o = "";
                        } else if (JdbcEnum.DATE.name().equals(type)) {
                            o = DateUtils.format(resultSet.getDate(key), ISO8601.iso8601(jdbcPOJO.getJdbcDataType()));
                        }
                    }

                    stringObjectMap.put(key, o);
                }

                dataList.add(stringObjectMap);
            }

            parameterPOJO.setI(dataList.size());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return dataList;
    }

    /**
     * @param t             t
     * @param parameterPOJO parameterPOJO
     * @throws IllegalAccessException IllegalAccessException
     * @throws SQLException           SQLException
     */
    private <T> void getClasses(T t, ParameterPOJO parameterPOJO) throws IllegalAccessException, SQLException {
        Field[] fields = t.getClass().getDeclaredFields();
        List<Field> fieldList = new ArrayList<>();
        Set<String> row = commMap.keySet();

        for (Field field : fields) {
            if (field != null) {
                if (field.isAnnotationPresent(OracleColumn.class)) {
                    OracleColumn column = field.getAnnotation(OracleColumn.class);
                    if (row.contains(column.name())) fieldList.add(field);
                } else if (row.contains(field.getName().toUpperCase())) {
                    fieldList.add(field);
                }
            }
        }

        if (parameterPOJO.isSkip()) {
            for (Field field : fieldList) {
                OracleColumn column = field.getAnnotation(OracleColumn.class);
                field.setAccessible(true);
                String commType;
                if (column == null) {
                    commType = commMap.get(field.getName().toUpperCase());
                } else {
                    commType = commMap.get(column.name().toUpperCase());
                }

                if ("BLOB".equals(commType) || "CLOB".equals(commType)) {
                    field.set(t, "SKIP");
                } else {
                    String columnLabel;
                    if (column == null) {
                        columnLabel = field.getName().toUpperCase();
                    } else {
                        columnLabel = column.name();
                    }

                    String type = field.getType().getName();
                    Object o = set(type, columnLabel, commType);
                    if (o != null) field.set(t, o);
                }
                field.setAccessible(false);
            }
        } else {
            for (Field field : fieldList) {
                OracleColumn column = field.getAnnotation(OracleColumn.class);
                String columnLabel;
                if (column == null) {
                    columnLabel = field.getName().toUpperCase();
                } else {
                    columnLabel = column.name();
                }
                String type = field.getType().getName();
                String commType;
                if (column == null) {
                    commType = commMap.get(field.getName().toUpperCase());
                } else {
                    commType = commMap.get(column.name().toUpperCase());
                }
                Object o = set(type, columnLabel, commType);
                if (o != null) {
                    field.setAccessible(true);
                    field.set(t, o);
                    field.setAccessible(false);
                }
            }
        }
    }

    /**
     *
     * @param type        type
     * @param columnLabel columnLabel
     * @param commType    commType
     */
    private Object set(String type, String columnLabel, String commType) throws SQLException {
        Object o = null;
        final String TYPE = jdbcPOJO.getJdbcType();
        if ("java.lang.String".equals(type)) {
            String result;
            if (commType.equals(JdbcEnum.BLOB.name())) {
                if (TYPE.equals(JdbcEnum.ORACLE.name())) {
                    result = bcToString(resultSet.getBlob(columnLabel), Integer.parseInt(jdbcPOJO.getJdbcSpeed()));
                } else if (TYPE.equals(JdbcEnum.POSTGRES.name())) {
                    result = resultSet.getString(columnLabel);
                } else {
                    result = resultSet.getString(columnLabel);
                }
            } else if (commType.equals(JdbcEnum.CLOB.name())) {
                if (TYPE.equals(JdbcEnum.ORACLE.name())) {
                    result = bcToString(resultSet.getClob(columnLabel), Integer.parseInt(jdbcPOJO.getJdbcSpeed()));
                } else if (TYPE.equals(JdbcEnum.POSTGRES.name())) {
                    result = resultSet.getString(columnLabel);
                } else {
                    result = resultSet.getString(columnLabel);
                }
            } else if (commType.equals(JdbcEnum.DATE.name()) || (commType.equals(JdbcEnum.TIMESTAMP.name()))) {
                result = DateUtils.format(resultSet.getDate(columnLabel), ISO8601.iso8601(jdbcPOJO.getJdbcDataType()));
            } else if (commType.equals(JdbcEnum.NUMBER.name())) {
                result = resultSet.getString(columnLabel);
            } else {
                result = resultSet.getString(columnLabel);
            }

            o = (result == null ? "" : result);
        } else if ("short".equals(type) || "java.lang.Short".equals(type)) {
            o = resultSet.getShort(columnLabel);
        } else if ("byte".equals(type) || "java.lang.Byte".equals(type)) {
            o = resultSet.getByte(columnLabel);
        } else if ("int".equals(type) || "java.lang.Integer".equals(type)) {
            o = resultSet.getInt(columnLabel);
        } else if ("long".equals(type) || "java.lang.Long".equals(type)) {
            o = resultSet.getLong(columnLabel);
        } else if ("double".equals(type) || "java.lang.Double".equals(type)) {
            o = resultSet.getDouble(columnLabel);
        } else if ("boolean".equals(type) || "java.lang.Boolean".equals(type)) {
            o = resultSet.getBoolean(columnLabel);
        } else if ("java.math.BigDecimal".equals(type)) {
            o = resultSet.getBigDecimal(columnLabel);
        } else if ("java.sql.Array".equals(type)) {
            o = resultSet.getArray(columnLabel);
        } else if ("java.util.Date".equals(type)) {
            o = resultSet.getDate(columnLabel);
        } else if ("java.sql.Timestamp".equals(type)) {
            o = resultSet.getTimestamp(columnLabel);
        } else if ("java.sql.Blob".equals(type)) {
            o = resultSet.getBlob(columnLabel);
        } else if ("java.sql.Clob".equals(type)) {
            o = resultSet.getClob(columnLabel);
        }
        return o;
    }

    /**
     * @param parameters parameters
     * @param sql        sql
     * @return isResultSet
     * @author add by huyingzhao
     * 2022-06-29 11:40
     */
    boolean isResultSet(List<Object> parameters, String sql) {
        try {
            if (isNullClose(resultSet)) {
                openPrepared(sql);
                preparedParameters(parameters, 1);
                if (!isNullClose(preparedStatement) && preparedStatement.execute()) {
                    resultSet = preparedStatement.getResultSet();
                    return !isNullClose(resultSet);
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
