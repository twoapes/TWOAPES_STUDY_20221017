package spring.ioc.annotation;

import spring.ioc.annotation.attribute.bean.BeanService;
import spring.ioc.annotation.attribute.componentScan.ComponentScanService;
import spring.ioc.annotation.attribute.componentScan.ComponentScanService2;
import spring.ioc.annotation.attribute.configuration.ConfigurationService;
import spring.ioc.annotation.attribute.value.ValueService;
import spring.ioc.annotation.object.AnnotationService;
import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2022-10-01 12:12
 */
public class AnnotationDI {
    static AnnotationService annotationService(ApplicationContext applicationContext) {
        AnnotationService annotationService = null;
        if (applicationContext != null) {
            annotationService = applicationContext.getBean(AnnotationService.class);
        }

        return annotationService;
    }

    static ValueService valueService(ApplicationContext applicationContext) {
        ValueService valueService = null;
        if (applicationContext != null) {
            valueService = applicationContext.getBean(ValueService.class);
        }

        return valueService;
    }

    static BeanService beanService(ApplicationContext applicationContext) {
        BeanService BeanService = null;
        if (applicationContext != null) {
            BeanService = applicationContext.getBean(BeanService.class);
        }

        return BeanService;
    }

    static ConfigurationService configurationService(ApplicationContext applicationContext) {
        ConfigurationService configurationService = null;
        if (applicationContext != null) {
            configurationService = applicationContext.getBean(ConfigurationService.class);
        }

        return configurationService;
    }

    static ComponentScanService componentScanService(ApplicationContext applicationContext) {
        ComponentScanService componentScanService = null;
        if (applicationContext != null) {
            componentScanService = applicationContext.getBean(ComponentScanService.class);
        }

        return componentScanService;
    }

    static ComponentScanService2 componentScanService2(ApplicationContext applicationContext) {
        ComponentScanService2 componentScanService2 = null;
        if (applicationContext != null) {
            componentScanService2 = applicationContext.getBean(ComponentScanService2.class);
        }

        return componentScanService2;
    }
}