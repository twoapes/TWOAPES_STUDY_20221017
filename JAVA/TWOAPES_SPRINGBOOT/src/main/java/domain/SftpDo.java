package domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2022-06-06 22:32
 * do for Value
 */
@Component
@Data
public class SftpDo {
    @Value("${sftp.sftpHost}")
    private String sftpHost;
    @Value("${sftp.sftpUserName}")
    private String sftpUserName;
    @Value("${sftp.sftpPassword}")
    private String sftpPassword;
    @Value("${sftp.sftpPort}")
    private String sftpPort;
    @Value("${sftp.sftpPrivateKey}")
    private String sftpPrivateKey;
}