package spring.ioc;

import org.junit.Test;
import spring.ioc.annotation.AnnotationInjectionAttribute;
import spring.ioc.annotation.AnnotationInjectionObject;
import spring.ioc.xml.InjectionAttribute;
import spring.ioc.xml.InjectionObject;

import java.nio.charset.StandardCharsets;

/**
 * @author add by huyingzhao
 * 2022-07-30 9:32
 */
public class IOCTest {
    /**
     * Instantiating beans using xml profile
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void xmlTest() {
        InjectionObject.createObject();
        InjectionObject.alias();
        InjectionAttribute.setter();
        InjectionAttribute.pNameSpace();
        InjectionAttribute.nullLabel();
        InjectionAttribute.special();
        InjectionAttribute.bean();
        InjectionAttribute.aggregate();
        InjectionAttribute.scope();
        InjectionAttribute.autowired();
        InjectionAttribute.lifeCycle();
        InjectionAttribute.constructor();
        InjectionAttribute.propertiesDI(StandardCharsets.UTF_8);
        InjectionAttribute.factoryDI();
        InjectionAttribute.staticDI();
        InjectionAttribute.importDI();
    }

    /**
     * Instantiating beans using annotation
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void annotationTest() {
        AnnotationInjectionObject.createObject();
        AnnotationInjectionAttribute.autowired();
        AnnotationInjectionAttribute.value();
        AnnotationInjectionAttribute.bean();
        AnnotationInjectionAttribute.configuration();
        AnnotationInjectionAttribute.componentScan();
    }
}
