package core.jdbc.primitive.impl;

import core.jdbc.exception.JdbcException;
import core.jdbc.primitive.JdbcConnectService;
import core.entity.JdbcPOJO;
import enums.JdbcEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statics.ComputerUtils;

import java.sql.*;
import java.util.List;
import java.util.Locale;

/**
 * @author huyingzhao
 * 2022-02-01 0:33:19
 */
@Slf4j
@Service
public class JdbcConnectServiceImpl implements JdbcConnectService {
    JdbcPOJO jdbcPOJO;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection;

    @Autowired
    public JdbcConnectServiceImpl(JdbcPOJO jdbcPOJO) {
        this.jdbcPOJO = jdbcPOJO;
    }

    /**
     * @return boolean
     */
    public boolean isConnected() {
        return !isNullClose(connection);
    }

    public void open() {
        boolean isIpReachable = ComputerUtils.isConnectIp(jdbcPOJO.getJdbcHost())
                && (!(jdbcPOJO.getJdbcType() == null || jdbcPOJO.getJdbcUsername() == null
                || jdbcPOJO.getJdbcPassword() == null));
        if (isIpReachable) {
            try {
                String url = getUrl(jdbcPOJO.getJdbcType());
                if (jdbcPOJO.isJdbcIsCo()) {
                    url = url + jdbcPOJO.getJdbcHost() + ":" + jdbcPOJO.getJdbcPort() + ":"
                            + jdbcPOJO.getJdbcSid();
                } else {
                    url = url + jdbcPOJO.getJdbcHost() + ":" + jdbcPOJO.getJdbcPort() + "/"
                            + jdbcPOJO.getJdbcSid();
                }

                if (connection == null) {
                    connection = getConnection(url);
                } else {
                    if (connection.isClosed()) {
                        connection = getConnection(url);
                        getMeta();
                        log.info("database reconnection");
                    } else {
                        log.info("database has been connected");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                log.error(e.getMessage(), e);
            } finally {
                openOrCloseAutoCommit(false);
            }
        }
    }

    public void close() throws Exception {
        openOrCloseAutoCommit(false);
        closeResultSet();
        closePreparedStatement();
        if (isNullClose(preparedStatement) && isNullClose(resultSet)) {
            try {
                if (isConnected()) {
                    connection.close();
                    log.info("database connection pool is close");
                } else if (connection == null) {
                    log.debug("database connection pool is null");
                } else {
                    log.debug("database connection pool is close");
                }
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }

            error = 0;
        } else {
            if (error <= 10) {
                try {
                    log.warn("warn!!!  the current database is too busy,reconnection (" + (++error) + ") times");
                    Thread.sleep(5 * 1000);
                    close();
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            } else {
                error = 0;
                throw new JdbcException("error");
            }
        }
    }

    /**
     * @param o o
     * @return isNullClose
     */
    boolean isNullClose(Wrapper o) {
        try {
            if (o instanceof Connection) {
                return connection == null || connection.isClosed();
            } else if (o instanceof PreparedStatement) {
                return preparedStatement == null || preparedStatement.isClosed();
            } else if (o instanceof ResultSet) {
                return resultSet == null || resultSet.isClosed();
            } else {
                return o == null;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    void openOrCloseAutoCommit(boolean isClose) {
        try {
            if (isConnected()) {
                if (jdbcPOJO.getJdbcType().equals(JdbcEnum.ORACLE.name())) {
                    connection.setAutoCommit(isClose);
                } else {
                    connection.setAutoCommit(false);
                }
                log.debug("database successfully closed automatic submission");
            } else {
                log.debug("database is not open");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    private String getUrl(String url) {
        String type;
        url = url.toUpperCase(Locale.ROOT);
        if (url.equals(JdbcEnum.MYSQL.name())) {
            type = "jdbc:mysql";
        } else if (url.equals(JdbcEnum.ORACLE.name())) {
            type = "jdbc:oracle:thin:@";
        } else if (url.equals(JdbcEnum.SQL_SERVER2005.name())) {
            type = "jdbc:sqlserver";
        } else if (url.equals(JdbcEnum.SQL_SERVER2000.name())) {
            type = "jdbc:microsoft:sqlserver";

        } else if (url.equals(JdbcEnum.DB2.name())) {
            type = "jdbc:db2";

        } else if (url.equals(JdbcEnum.SYBASE.name())) {
            type = "jdbc:sybase";
        } else {
            type = "select database error,please check database type";
            log.error(type);
        }
        return type;
    }

    private int error = 0;

    /**
     * @throws SQLException SQLException
     */
    private void getMeta() throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.setLength(0);
        stringBuilder.append("oracle version:").append(databaseMetaData.getDatabaseProductVersion()).append("\n");
        stringBuilder.append("oracle name:").append(databaseMetaData.getDatabaseProductName()).append("\n");
        stringBuilder.append("drivers name:").append(databaseMetaData.getDriverName()).append("\n");
        stringBuilder.append("drivers version:").append(databaseMetaData.getDriverVersion()).append("\n");
        stringBuilder.append("drivers main version:").append(databaseMetaData.getDriverMajorVersion()).append("\n");
        stringBuilder.append("drivers sub version:").append(databaseMetaData.getDriverMinorVersion()).append("\n");
        log.info(stringBuilder.toString());
    }

    /**
     * @param url url
     */
    private Connection getConnection(String url) throws ClassNotFoundException, SQLException {
        if (url == null)
            return null;
        Class.forName(getDrive());
        connection = DriverManager.getConnection(url, jdbcPOJO.getJdbcUsername(), jdbcPOJO.getJdbcPassword());
        return connection;
    }

    /**
     * @return getDrive
     */
    private String getDrive() {
        String driver;
        if (jdbcPOJO.getJdbcType().equals(JdbcEnum.ORACLE.name())) {
            driver = "oracle.jdbc.OracleDriver";
        } else if (jdbcPOJO.getJdbcType().equals(JdbcEnum.POSTGRES.name())) {
            driver = "org.postgresql.Driver";
        } else if (jdbcPOJO.getJdbcType().equals(JdbcEnum.MYSQL.name())) {
            driver = "com.mysql.cj.jdbc.Driver";
        } else {
            driver = "select database error,please check database type";
        }
        return driver;
    }

    void closeResultSet() {
        try {
            if (!isNullClose(resultSet)) {
                resultSet.close();
                log.debug("close ResultSet");
            } else {
                log.debug("non close");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void closePreparedStatement() {
        try {
            if (!isNullClose(preparedStatement)) {
                preparedStatement.close();
                log.info("close PreparedStatement");
            } else {
                log.debug("non close");
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * @param sql sql
     * @throws SQLException SQLException
     * @author add by huyingzhao
     * 2022-06-29 11:38
     */
    void openPrepared(String sql) throws SQLException {
        if (preparedStatement == null && sql != null && connection != null) {
            preparedStatement = connection.prepareStatement(sql);
        }
    }

    /**
     * @param parameters parameters
     */
    void preparedParameters(List<Object> parameters, int index) throws SQLException {
        if (!isNullClose(preparedStatement) && index > 0) {
            preparedStatement.clearParameters();
            for (Object parameter : parameters) {
                preparedStatement.setObject(index++, parameter);
            }
            log.debug("current parameters" + parameters);
        }
    }
}
