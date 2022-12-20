package core.entity;

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
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.sid}")
    private String jdbcSid;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${jdbc.host}")
    private String jdbcHost;
    @Value("${jdbc.port}")
    private String jdbcPort;
    @Value("${jdbc.type}")
    private String jdbcType;
    @Value("${jdbc.chars}")
    private String jdbcChars;
    @Value("${jdbc.speed}")
    private String jdbcSpeed;
    @Value("${jdbc.dataType}")
    private String jdbcDataType;
    @Value("${jdbc.isCo}")
    private boolean jdbcIsCo;
}
