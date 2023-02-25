package aop;

import aop.cglib.joinPoint.service.JoinPointService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.AOPUtil;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:00
 */
@Slf4j
public class JoinPointTest extends AOPUtil {
    /**
     * using JoinPoint
     */
    @Test
    public void runJoinPointDI() {
        log.info("\n" + "---------------using JoinPoint---------------" + "\n");
        JoinPointService joinPointService = getBean(JoinPointService.class, "joinPoint");
        joinPointService.joinPointService();
    }
}
