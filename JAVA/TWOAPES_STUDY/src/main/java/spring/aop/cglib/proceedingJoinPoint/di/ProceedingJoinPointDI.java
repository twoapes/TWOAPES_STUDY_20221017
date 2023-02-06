package spring.aop.cglib.proceedingJoinPoint.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import spring.aop.cglib.proceedingJoinPoint.service.ProceedingJoinPointService;
import statics.ApplicationUtil;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:32
 */
@Slf4j
public class ProceedingJoinPointDI {
    public static void runProceedingJoinPointDI() {
        log.info("\n" + "---------------using ProceedingJoinPoint---------------");
        ApplicationContext context = ApplicationUtil.open("spring/aop/proceedingJoinPoint.xml");
        ProceedingJoinPointService proceedingJoinPointService = proceedingJoinPoint(context);
        proceedingJoinPointService.proceedingJoinPointService();
        ApplicationUtil.close(context);
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
