import core.name.NameService;
import core.name.impl.NameServiceImpl;
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
        NameService nameService=getBean(NameServiceImpl.class, util.AppConfig.class);
        log.info(nameService.fullName2(1));
    }
}
