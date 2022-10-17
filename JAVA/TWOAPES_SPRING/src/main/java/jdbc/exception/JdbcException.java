package jdbc.exception;

/**
 * @author add by huyingzhao
 * 2022-10-14 11:06
 */
public class JdbcException extends Exception {
    public JdbcException() {
        super();
    }

    public JdbcException(String message) {
        super(message);
    }
}
