package aop.cglib.proceedingJoinPoint.di;

import aop.cglib.proceedingJoinPoint.service.ProceedingJoinPointService;
import core.AppCore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:32
 */
@Slf4j
public class ProceedingJoinPointDI {
    public static void runProceedingJoinPointDI() {
        log.info("---------------using ProceedingJoinPoint---------------");
        ApplicationContext context = AppCore.open("aop/proceedingJoinPoint.xml");
        ProceedingJoinPointService proceedingJoinPointService = proceedingJoinPoint(context);
        proceedingJoinPointService.proceedingJoinPointService();
        AppCore.close(context);
    }

    /**
     * @param applicationContext applicationContext
     * @return ProceedingJoinPointService
     */
    private static ProceedingJoinPointService proceedingJoinPoint(ApplicationContext applicationContext) {
        ProceedingJoinPointService studentService = null;
        if (applicationContext != null) {
            studentService = applicationContext.getBean("proceedingJoinPointService", ProceedingJoinPointService.class);
        }
        return studentService;
    }
}
