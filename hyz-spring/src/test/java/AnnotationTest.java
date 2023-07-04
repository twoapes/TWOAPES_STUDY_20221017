import core.sftp.impl.SftpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.BeanUtil;

/**
 * @author add by huyingzhao
 * 2023-02-24 14:45
 */
@Slf4j
public class AnnotationTest extends BeanUtil {
    @Test
    public void jdbc(){
        SftpServiceImpl sftpService=getBean(SftpServiceImpl.class, util.AppConfig.class);
        sftpService.open();
        sftpService.close();
    }
}
