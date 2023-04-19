package core.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2022-06-06 22:32
 */
@Component
@Data
public class SftpPOJO {
    @Value("${sftp.host}")
    private String sftpHost;
    @Value("${sftp.userName}")
    private String sftpUserName;
    @Value("${sftp.password}")
    private String sftpPassword;
    @Value("${sftp.port}")
    private String sftpPort;
    @Value("${sftp.privateKey}")
    private String sftpPrivateKey;
}