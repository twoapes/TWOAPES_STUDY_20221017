package aop;

import aop.cglib.proceedingJoinPoint.service.ProceedingJoinPointService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.AOPUtil;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:32
 */
@Slf4j
public class ProceedingJoinPointTest extends AOPUtil {
    @Test
    public void runProceedingJoinPointDI() {
        log.info("\n" + "---------------using ProceedingJoinPoint---------------");
        ProceedingJoinPointService proceedingJoinPointService = getBean(ProceedingJoinPointService.class,"proceedingJoinPoint");
        proceedingJoinPointService.proceedingJoinPointService();
    }
}
