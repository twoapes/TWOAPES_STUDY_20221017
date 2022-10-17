package jdbc.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 *         2022-05-25 16:37
 */
@Component
@Data
public class JdbcPOJO {
    @Value("${jdbc.jdbcUsername}")
    private String jdbcUsername;
    @Value("${jdbc.jdbcSid}")
    private String jdbcSid;
    @Value("${jdbc.jdbcPassword}")
    private String jdbcPassword;
    @Value("${jdbc.jdbcHost}")
    private String jdbcHost;
    @Value("${jdbc.jdbcPort}")
    private String jdbcPort;
    @Value("${jdbc.jdbcType}")
    private String jdbcType;
    @Value("${jdbc.jdbcChars}")
    private String jdbcChars;
    @Value("${jdbc.jdbcSpeed}")
    private String jdbcSpeed;
    @Value("${jdbc.jdbcDataType}")
    private String jdbcDataType;
    @Value("${jdbc.jdbcIsCo}")
    private boolean jdbcIsCo;
}
