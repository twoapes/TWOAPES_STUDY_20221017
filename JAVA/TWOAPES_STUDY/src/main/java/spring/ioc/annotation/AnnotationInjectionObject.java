package spring.ioc.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import spring.ioc.annotation.object.AnnotationService;
import spring.ioc.annotation.object.AppConfig;
import statics.ApplicationUtil;

/**
 * @author add by huyingzhao
 * 2022-10-01 12:14
 * create object
 */
@Slf4j
public class AnnotationInjectionObject extends AnnotationDI {
    /**
     * @author add by huyingzhao
     * 2022-10-01 13:45
     */
    public static void createObject() {
        log.info("--------------using annotation create object---------------" + "\n");
        ApplicationContext applicationContext = ApplicationUtil.openClass(AppConfig.class);
        AnnotationService annotationService = annotationService(applicationContext);
        annotationService.annotation();
    }
}