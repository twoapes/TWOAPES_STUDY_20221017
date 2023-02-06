package spring.aop;

import spring.aop.annotation.AppDI;
import spring.aop.cglib.joinPoint.di.JoinPointDI;
import spring.aop.cglib.proceedingJoinPoint.di.ProceedingJoinPointDI;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2022-07-30 10:02
 */
public class AOPTest {
    /**
     * test AppDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void appDITest() {
        AppDI.appDI();
    }

    /**
     * test JoinPointDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void runJoinPointDITest() {
        JoinPointDI.runJoinPointDI();
    }

    /**
     * test ProceedingJoinPointDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void runProceedingJoinPointDITest() {
        ProceedingJoinPointDI.runProceedingJoinPointDI();
    }
}
