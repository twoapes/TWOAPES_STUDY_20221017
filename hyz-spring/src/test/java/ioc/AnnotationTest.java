package ioc;

import ioc.bean.BeanService;
import ioc.componentScan.ComponentScanService;
import ioc.componentScan.ComponentScanService2;
import ioc.configuration.ConfigurationService;
import ioc.object.AnnotationService;
import ioc.value.ValueService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.BeanUtil;

/**
 * @author add by huyingzhao
 * 2023-02-24 14:45
 */
@Slf4j
public class AnnotationTest extends BeanUtil {
    /**
     * @author add by huyingzhao
     * 2022-10-01 13:45
     */
    @Test
    public void createObject() {
        AnnotationService annotationService = getBean(AnnotationService.class, ioc.object.AppConfig.class);
        annotationService.annotation();
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 13:58
     */
    @Test
    public void annotation() {
        AnnotationService annotationService = getBean(AnnotationService.class, ioc.object.AppConfig.class);
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
    @Test
    public void value() {
        String stringBuilder = "\n--------------using Value annotation---------------" + "\n";
        log.info(stringBuilder);
        ValueService valueService = getBean(ValueService.class, ioc.value.AppConfig.class);
        String str = "\n";
        str += "placeholder:" + valueService.getValue1() + "\n";
        str += "string:" + valueService.getValue2() + "\n";
        str += "SpringEL:" + valueService.getValue3() + "\n";
        str += "be based upon for Value extend:" + valueService.getValue4() + "\n";
        log.info(str);
    }

    /**
     * @author method add by huyingzhao
     * 2022-10-10 18:09
     */
    @Test
    public void bean() {
        String stringBuilder = "\n--------------using Bean annotation---------------" + "\n";
        log.info(stringBuilder);
        BeanService beanService = getBean(BeanService.class, ioc.bean.AppConfig.class);
        String str = "\n";
        String str2 = "\n";
        str += ("autowire di object:" + beanService.getBeanDao()) + "\n";
        str += ("bean's autowireCandidate di object:" + beanService.getBeanDao2()) + "\n\n";
        str += ("first create object prototype(bean1):" + beanService.getBeanDao3()) + "\n";
        str2 += ("second  create object prototype(bean1):" + beanService.getBeanDao4()) + "\n";
        beanService = getBean(BeanService.class, ioc.bean.AppConfig.class);
        str += ("first create object prototype(bean2):" + beanService.getBeanDao3()) + "\n";
        str2 += ("second  create object prototype(bean2):" + beanService.getBeanDao4()) + "\n";
        beanService = getBean(BeanService.class, ioc.bean.AppConfig.class);
        str += ("first create object prototype(bean3):" + beanService.getBeanDao3()) + "\n";
        str2 += ("first create object prototype(bean3):" + beanService.getBeanDao4()) + "\n";
        log.info(str + str2);
    }

    /**
     * @author method add by huyingzhao
     * 2022-10-10 18:09
     */
    @Test
    public void configuration() {
        String stringBuilder = "\n--------------using Configuration annotation---------------" + "\n";
        log.info(stringBuilder);
        ConfigurationService configurationService = getBean(ConfigurationService.class, ioc.configuration.AppConfig.class);
        configurationService.configuration();
    }


    /**
     * @author add by huyingzhao
     * 2022-08-07 13:50
     */
    @Test
    public void componentScan() {
        componentScanDI1();
        componentScanDI2();
        componentScanDI3();
    }

    private void componentScanDI1() {
        String stringBuilder = "\n--------------using ComponentScan annotation(ComponentScanAnnotation annotation)---------------" + "\n";
        log.info(stringBuilder);
        ComponentScanService componentScanService = getBean(ComponentScanService.class, ioc.componentScan.AppConfig.class);
        log.info("componentScanService:" + componentScanService);
    }

    private void componentScanDI2() {
        String stringBuilder = "\n--------------using ComponentScan annotation(Component annotation)---------------" + "\n";
        log.info(stringBuilder);
        ComponentScanService2 componentScanService2 = getBean(ComponentScanService2.class, ioc.componentScan.AppConfig2.class);
        log.info("componentScanService2:" + componentScanService2);
    }

    private void componentScanDI3() {
        String stringBuilder = "\n--------------using ComponentScan annotation(spring.components)---------------" + "\n";
        log.info(stringBuilder);
        ComponentScanService componentScanService = getBean(ComponentScanService.class, ioc.componentScan.AppConfig.class);
        log.info("componentScanService:" + componentScanService);
        //spring.components exclude componentScanService2,so can't create object,but componentScanService make no difference
        ComponentScanService2 componentScanService2 = getBean(ComponentScanService2.class, ioc.componentScan.AppConfig2.class);
        log.info("componentScanService2:" + componentScanService2);
    }
}
