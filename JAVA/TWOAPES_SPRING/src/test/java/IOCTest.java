import ioc.annotation.AnnotationInjectionAttribute;
import ioc.annotation.AnnotationInjectionObject;
import ioc.xml.InjectionAttribute;
import ioc.xml.InjectionObject;
import org.junit.Test;
import statics.CharsetUtil;

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
        InjectionAttribute.jdbcDI();
        InjectionAttribute.constructor();
        InjectionAttribute.propertiesDI(CharsetUtil.UTF_8);
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
