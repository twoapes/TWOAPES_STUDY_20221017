package spring.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import statics.ApplicationUtil;

/**
 * @author add by huyingzhao
 * 2022-10-06 16:18
 */
@Slf4j
public class AppDI {
    public static void appDI() {
        log.info("\n" + "---------------AOP for annotation---------------" + "\n");
        ApplicationContext applicationContext = ApplicationUtil.openClass(AppConfig.class);
        App app = app(applicationContext);
        app.add();
        ApplicationUtil.close(applicationContext);
    }

    /**
     * @param applicationContext applicationContext
     * @return app
     */
    private static App app(ApplicationContext applicationContext) {
        App app = null;
        if (applicationContext != null) {
            app = applicationContext.getBean(App.class);
        }

        return app;
    }
}