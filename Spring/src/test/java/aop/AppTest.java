package aop;

import aop.annotation.App;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.AOPUtil;

/**
 * @author add by huyingzhao
 * 2022-10-06 16:18
 */
@Slf4j
public class AppTest extends AOPUtil {
    @Test
    public void appDI() {
        log.info("\n" + "---------------AOP for annotation---------------" + "\n");
        App app = getBean(App.class, aop.annotation.AppConfig.class);
        app.add();
    }
}