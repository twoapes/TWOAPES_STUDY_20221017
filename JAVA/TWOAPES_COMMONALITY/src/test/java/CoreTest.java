import core.AppConfig;
import core.AppCore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2022-12-20 4:41 PM
 */
public class CoreTest {
    @Test
    public void init(){
        ApplicationContext context= AppCore.openClass(AppConfig.class);
//        PoImpl po=context.getBean(PoImpl.class);
//        po.test();
        AppCore.close(context);
    }
}
