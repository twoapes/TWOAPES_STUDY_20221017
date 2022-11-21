package ioc.annotation;

import core.AppCore;
import ioc.annotation.object.AppConfig;
import ioc.annotation.attribute.bean.BeanService;
import ioc.annotation.attribute.componentScan.AppConfig2;
import ioc.annotation.attribute.componentScan.ComponentScanService;
import ioc.annotation.attribute.componentScan.ComponentScanService2;
import ioc.annotation.attribute.configuration.ConfigurationService;
import ioc.annotation.attribute.value.ValueService;
import ioc.annotation.object.AnnotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2022-10-01 12:14
 * Injection Attribute
 */
@Slf4j
public class AnnotationInjectionAttribute extends AnnotationDI {
    /**
     * @author add by huyingzhao
     * 2022-10-01 13:58
     */
    public static void autowired() {
        ApplicationContext applicationContext = AppCore.openClass(AppConfig.class);
        AnnotationService annotationService = annotationService(applicationContext);
        log.info("--------------using Autowire annotation---------------" + "\n");
        annotationService.autowired();
        annotationService.qualifier();
        annotationService.resource();
    }

    /**
     * Value annotation
     *
     * @author add by huyingzhao
     * 2022-10-01 13:58
     */
    public static void value() {
        String stringBuilder = "--------------using Value annotation---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(ioc.annotation.attribute.value.AppConfig.class);
        ValueService valueService = valueService(context);
        String str = "\n";
        //reference https://spring.io/projects/spring-framework#learn
        str += "placeholder:" + valueService.getValue1() + "\n";
        str += "string:" + valueService.getValue2() + "\n";
        str += "SpringEL:" + valueService.getValue3() + "\n";
        str += "be based upon for Value extend:" + valueService.getValue4() + "\n";
        log.info("str :{}",str);
    }

    /**
     * @author method add by huyingzhao
     * 2022-10-10 18:09
     */
    public static void bean() {
        String stringBuilder = "--------------using Bean annotation---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(ioc.annotation.attribute.bean.AppConfig.class);
        BeanService beanService = beanService(context);
        String str = "\n";
        String str2 = "\n";
        str += ("autowire di object:" + beanService.getBeanDao()) + "\n";
        str += ("bean's autowireCandidate di object:" + beanService.getBeanDao2()) + "\n\n";
        str += ("first create object prototype(bean1):" + beanService.getBeanDao3()) + "\n";
        str2 += ("second  create object prototype(bean1):" + beanService.getBeanDao4()) + "\n";
        context = AppCore.openClass(ioc.annotation.attribute.bean.AppConfig.class);
        beanService = beanService(context);
        str += ("first create object prototype(bean2):" + beanService.getBeanDao3()) + "\n";
        str2 += ("second  create object prototype(bean2):" + beanService.getBeanDao4()) + "\n";
        context = AppCore.openClass(ioc.annotation.attribute.bean.AppConfig.class);
        beanService = beanService(context);
        str += ("first create object prototype(bean3):" + beanService.getBeanDao3()) + "\n";
        str2 += ("first create object prototype(bean3):" + beanService.getBeanDao4()) + "\n";
        log.info(str + str2);
    }


    /**
     * @author method add by huyingzhao
     * 2022-10-10 18:09
     */
    public static void configuration() {
        String stringBuilder = "--------------using Configuration annotation---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(ioc.annotation.attribute.configuration.AppConfig.class);
        ConfigurationService configurationService = configurationService(context);
        configurationService.configuration();
    }

    /**
     * @author add by huyingzhao
     * 2022-08-07 13:50
     */
    public static void componentScan() {
        componentScanDI1();
        componentScanDI2();
        componentScanDI3();
    }

    private static void componentScanDI1() {
        String stringBuilder = "--------------using ComponentScan annotation(ComponentScanAnnotation annotation)---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(ioc.annotation.attribute.componentScan.AppConfig.class);
        ComponentScanService componentScanService = componentScanService(context);
        log.info("componentScanService:" + componentScanService);
    }

    private static void componentScanDI2() {
        String stringBuilder = "--------------using ComponentScan annotation(Component annotation)---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(AppConfig2.class);
        ComponentScanService2 componentScanService2 = componentScanService2(context);
        log.info("componentScanService2:" + componentScanService2);
    }

    private static void componentScanDI3() {
        String stringBuilder = "--------------using ComponentScan annotation(spring.components)---------------" + "\n";
        log.info("stringBuilder :{}",stringBuilder);
        ApplicationContext context = AppCore.openClass(ioc.annotation.attribute.componentScan.AppConfig.class);
        ComponentScanService componentScanService = componentScanService(context);
        log.info("componentScanService:" + componentScanService);
        context = AppCore.openClass(AppConfig2.class);
        //spring.components exclude componentScanService2,so can't create object,but componentScanService make no difference
        ComponentScanService2 componentScanService2 = componentScanService2(context);
        log.info("componentScanService2:" + componentScanService2);
    }
}