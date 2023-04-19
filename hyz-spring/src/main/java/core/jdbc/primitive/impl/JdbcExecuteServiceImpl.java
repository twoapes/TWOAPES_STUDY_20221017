package core.jdbc.primitive.impl;

import core.jdbc.primitive.JdbcExecuteService;
import core.entity.JdbcPOJO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import core.entity.ParameterPOJO;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huyingzhao
 * 2022-02-01 0:34:40
 */
@Slf4j
@Service
public class JdbcExecuteServiceImpl extends JdbcConnectServiceImpl implements JdbcExecuteService {
    public JdbcExecuteServiceImpl(JdbcPOJO jdbcPOJO) {
        super(jdbcPOJO);
    }

    /**
     * update single data
     *
     * @param parameterPOJO parameterPOJO
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    public void execute(ParameterPOJO parameterPOJO) {
        if (parameterPOJO == null)
            return;

        try {
            log.debug("execute update now....");
            openUpdate(parameterPOJO);
            preparedUpdate(parameterPOJO);
            executeUpdate(parameterPOJO);
        } catch (SQLException e) {
            rollback();
            log.error(e.getMessage(), e);
        } finally {
            commit();
            parameterPOJO.clear();
        }
    }

    /**
     * @param updateEntities updateEntities
     * @return executeBatch
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    public List<ParameterPOJO> executeBatch(List<ParameterPOJO> updateEntities) {
        List<ParameterPOJO> entities = new ArrayList<>();

        if (updateEntities == null || updateEntities.size() == 0)
            return entities;

        log.debug("execute update now....");
        try {
            for (ParameterPOJO parameterPOJO : updateEntities) {
                openBatch(parameterPOJO);
                preparedBatch(parameterPOJO);
            }
        } catch (SQLException e) {
            rollback();
            log.error(e.getMessage(), e);
        } finally {
            executeBatch();
        }
        return entities;
    }

    /**
     * @param updateEntities updateEntities
     * @author add by huyingzhao
     * 2022-06-07 9:18
     */
    public void execute(List<ParameterPOJO> updateEntities) {
        if (!(updateEntities == null || updateEntities.size() == 0)) {
            log.debug("execute update now....");
            int count = 0;
            for (ParameterPOJO parameterPOJO : updateEntities) {
                log.info("update(" + updateEntities.size() + "):" + (++count));
                execute(parameterPOJO);
            }
        }
    }

    /**
     * only Blob object
     *
     * @param parameterPOJO parameterPOJO
     * @param o             o
     * @author add by huyingzhao
     * 2022-06-07 9:17
     */
    public void updateBlob(ParameterPOJO parameterPOJO, Object o) {
        if (parameterPOJO == null || o == null)
            return;

        List<Object> parameters = parameterPOJO.getParameters();

        if (parameterPOJO.getSql() != null && parameters != null && parameters.size() >= 1) {
            if (o instanceof File) {
                updateBlob(parameterPOJO, parameters, (File) o);
            } else if (o instanceof String) {
                updateBlob(parameterPOJO, parameters, (String) o);
            }
        }
    }

    /**
     * only Blob object and single data
     *
     * @param parameterPOJO parameterPOJO
     * @param parameters    parameters
     * @param str           str
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void updateBlob(ParameterPOJO parameterPOJO, List<Object> parameters, String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    openPrepared(parameterPOJO.getSql());
                    preparedParameters(parameters, 2);
                    openOrCloseAutoCommit(true);
                    log.debug("sql:\n" + parameterPOJO.getSql());
                    InputStream in = new ByteArrayInputStream(str.getBytes(Charset.forName(jdbcPOJO.getJdbcChars())));
                    preparedStatement.setBinaryStream(1, in, in.available());
                    int i = preparedStatement.executeUpdate();
                    parameterPOJO.setI(i);
                    log.debug("update:" + (i > 0 ? "count:" + i + "" : "non data update"));
                }
            } catch (Exception e) {
                rollback();
                log.error(e.getMessage(), e);
            } finally {
                commit();
                parameterPOJO.clear();
            }
        }
    }

    /**
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void executeBatch() {
        try {
            openOrCloseAutoCommit(true);
            int[] ints = preparedStatement.executeBatch();
            if (ints != null) {
                log.debug("update:" + (ints.length > 0 ? "count:" + ints.length + "" : "non data update"));
            }
        } catch (SQLException e) {
            rollback();
            log.error(e.getMessage(), e);
        } finally {
            commit();
        }
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @param parameters    parameters
     * @param file          file
     * @author add by huyingzhao
     * 2022-06-07 9:15
     */
    private void updateBlob(ParameterPOJO parameterPOJO, List<Object> parameters, File file) {
        if (file != null && file.isFile() && file.length() > 0) {
            try {
                if (file.length() > 0) {
                    openPrepared(parameterPOJO.getSql());
                    preparedParameters(parameters, 2);
                    openOrCloseAutoCommit(true);
                    log.debug("sql:\n" + parameterPOJO.getSql());
                    BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
                    preparedStatement.setBlob(1, fileInputStream, fileInputStream.available());
                    int i = preparedStatement.executeUpdate();
                    parameterPOJO.setI(i);
                    log.debug("update:" + (i > 0 ? "count:" + i + "" : " non data update"));
                }
            } catch (Exception e) {
                rollback();
                log.error(e.getMessage(), e);
            } finally {
                commit();
                parameterPOJO.clear();
            }
        }
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */

    private void openUpdate(ParameterPOJO parameterPOJO) throws SQLException {
        openPrepared(parameterPOJO.getSql());
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void preparedUpdate(ParameterPOJO parameterPOJO) throws SQLException {
        List<Object> parameters = parameterPOJO.getParameters();
        if (parameterPOJO.getSql() != null && parameters != null) {
            preparedParameters(parameters, 1);
        }
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void executeUpdate(ParameterPOJO parameterPOJO) throws SQLException {
        if (connection == null)
            return;

        openOrCloseAutoCommit(true);
        log.debug("sql:\n" + parameterPOJO.getSql());
        int i = preparedStatement.executeUpdate();
        parameterPOJO.setI(i);
        log.debug("update:" + (i > 0 ? "count:" + i + "" : " non data update"));
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void openBatch(ParameterPOJO parameterPOJO) throws SQLException {
        openPrepared(parameterPOJO.getSql());
    }

    /**
     * @param parameterPOJO parameterPOJO
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-07 9:16
     */
    private void preparedBatch(ParameterPOJO parameterPOJO) throws SQLException {
        List<Object> parameters = parameterPOJO.getParameters();
        if (parameters != null) {
            preparedBatch(parameters);
        }
    }

    /**
     * @param parameters parameters
     */
    private void preparedBatch(List<Object> parameters) throws SQLException {
        int index = 1;
        if (!isNullClose(preparedStatement)) {
            if (parameters != null && parameters.size() > 0) {
                preparedStatement.clearParameters();
                for (Object parameter : parameters) {
                    preparedStatement.setObject(index++, parameter);
                }
                preparedStatement.addBatch();
                log.debug("current" + parameters);
            } else {
                preparedStatement.addBatch();
            }
        }
    }

    private void commit() {
        try {
            if (isConnected() && !connection.getAutoCommit()) {
                connection.commit();
                log.debug("commit success");
            }
        } catch (SQLException e) {
            rollback();
            log.error(e.getMessage(), e);
        }
    }

    private void rollback() {
        try {
            if (isConnected()) {
                connection.rollback();
                log.debug("rollback success");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

}
