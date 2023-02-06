package spring.aop.cglib.joinPoint.di;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import spring.aop.cglib.joinPoint.service.JoinPointService;
import statics.ApplicationUtil;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:00
 */
@Slf4j
public class JoinPointDI {
    /**
     *using JoinPoint
     */
    public static void runJoinPointDI() {
        log.info("\n" + "---------------using JoinPoint---------------" + "\n");
        ApplicationContext context = ApplicationUtil.open("spring/aop/joinPoint.xml");
        JoinPointService joinPointService = joinPointService(context);
        joinPointService.joinPointService();
        ApplicationUtil.close(context);
    }


    /**
     * @param applicationContext applicationContext
     * @return JoinPointService
     */
    private static JoinPointService joinPointService(ApplicationContext applicationContext) {
        JoinPointService joinPointService = null;
        if (applicationContext != null) {
            joinPointService = applicationContext.getBean("joinPointService", JoinPointService.class);
        }
        return joinPointService;
    }
}
