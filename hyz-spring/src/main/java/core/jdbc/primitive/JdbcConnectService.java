package core.jdbc.primitive;

/**
 * @author add by huyingzhao
 * 2022-09-25 13:42
 */
public interface JdbcConnectService {
    /**
     * @return boolean
     */
    boolean isConnected();

    /**
     * @author add by huyingzhao
     * 2022-09-25 13:05
     */
    void open();

    /**
     * @author add by huyingzhao
     * 2022-09-25 13:08
     */
    void close() throws Exception;
}