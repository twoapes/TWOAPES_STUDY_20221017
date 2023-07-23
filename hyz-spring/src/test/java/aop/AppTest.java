package aop;

import aop.annotation.App;
import aop.cglib.joinPoint.service.JoinPointService;
import aop.cglib.proceedingJoinPoint.service.ProceedingJoinPointService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.BeanUtil;

/**
 * @author add by huyingzhao
 * 2022-10-06 16:18
 */
@Slf4j
public class AppTest extends BeanUtil {
    @Test
    public void appDI() {
        log.info("\n" + "---------------AOP for annotation---------------" + "\n");
        App app = getBean(App.class, aop.annotation.AppConfig.class);
        app.add();
    }

    /**
     * using JoinPoint
     */
    @Test
    public void runJoinPointDI() {
        log.info("\n" + "---------------using JoinPoint---------------" + "\n");
        JoinPointService joinPointService = getBean(JoinPointService.class,"aop", "joinPoint");
        joinPointService.joinPointService();
    }

    @Test
    public void runProceedingJoinPointDI() {
        log.info("\n" + "---------------using ProceedingJoinPoint---------------");
        ProceedingJoinPointService proceedingJoinPointService = getBean(ProceedingJoinPointService.class,"aop","proceedingJoinPoint");
        proceedingJoinPointService.proceedingJoinPointService();
    }
}