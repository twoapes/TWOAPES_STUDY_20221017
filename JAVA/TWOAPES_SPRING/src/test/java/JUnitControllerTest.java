import aop.annotation.AppDI;
import aop.cglib.joinPoint.di.JoinPointDI;
import aop.cglib.proceedingJoinPoint.di.ProceedingJoinPointDI;
import aop.jdk.JDKProxyDI;
import ioc.annotation.AnnotationInjectionAttribute;
import ioc.annotation.AnnotationInjectionObject;
import ioc.xml.InjectionAttribute;
import ioc.xml.InjectionObject;
import ioc.xml.service.impl.XmlServiceImpl;
import jdbc.di.JDBCDI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.CharsetUtil;

/**
 * junit
 *
 * @author huyingzhao
 * 2022-02-24 17:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ioc/xml.xml"})
public class JUnitControllerTest {
    private XmlServiceImpl xmlService;

    @Autowired
    public void setXmlService(XmlServiceImpl xmlService) {
        this.xmlService = xmlService;
    }

    /**
     * test XmlServiceImpl
     *
     * @author add by huyingzhao
     * 2022-09-02 12:52
     */
    @Test
    public void test() {
        xmlService.xml();
    }


    //////////////////////////////////////////////////IOC begin//////////////////////////////////////////////////

    /////////////////////////xml begin/////////////////////////

    /**
     * Instantiating beans using xml profile
     * for object
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void createObjectXMLTest() {
        InjectionObject.createObject();
    }

    /**
     * Instantiating beans using xml profile
     * for object
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void aliasXMLTest() {
        InjectionObject.alias();
    }


    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void setterXMLTest() {
        InjectionAttribute.setter();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void pNameSpaceXMLTest() {
        InjectionAttribute.pNameSpace();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void nullLabelXMLTest() {
        InjectionAttribute.nullLabel();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void specialXMLTest() {
        InjectionAttribute.special();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void beanXMLTest() {
        InjectionAttribute.bean();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void aggregateXMLTest() {
        InjectionAttribute.aggregate();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void scopeXMLTest() {
        InjectionAttribute.scope();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void autowiredXMLTest() {
        InjectionAttribute.autowired();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void lifeCycleXMLTest() {
        InjectionAttribute.lifeCycle();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void jdbcDIXMLTest() {
        InjectionAttribute.jdbcDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void constructorXMLTest() {
        InjectionAttribute.constructor();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void propertiesDIXMLTest() {
        InjectionAttribute.propertiesDI(CharsetUtil.UTF_8);
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void factoryDIXMLTest() {
        InjectionAttribute.factoryDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void staticDIXMLTest() {
        InjectionAttribute.staticDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void importDIXMLTest() {
        InjectionAttribute.importDI();
    }

    /////////////////////////xml end/////////////////////////


    /////////////////////////annotation begin/////////////////////////

    /**
     * Instantiating beans using annotation
     * for object
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void createObjectAnnotationTest() {
        AnnotationInjectionObject.createObject();
    }

    /**
     * Instantiating beans using annotation
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void autowiredAnnotationTest() {
        AnnotationInjectionAttribute.autowired();
    }

    /**
     * Instantiating beans using annotation
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void valueAnnotationTest() {
        AnnotationInjectionAttribute.value();
    }

    /**
     * Instantiating beans using annotation
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void beanAnnotationTest() {
        AnnotationInjectionAttribute.bean();
    }

    /**
     * Instantiating beans using annotation
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void configurationAnnotationTest() {
        AnnotationInjectionAttribute.configuration();
    }

    /**
     * Instantiating beans using annotation
     * for attribute
     *
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void componentScanAnnotationTest() {
        AnnotationInjectionAttribute.componentScan();
    }

    /////////////////////////annotation end/////////////////////////

    //////////////////////////////////////////////////IOC end//////////////////////////////////////////////////


    //////////////////////////////////////////////////AOP begin//////////////////////////////////////////////////

    /**
     * test AppDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void appDITest() {
        AppDI.appDI();
    }

    /**
     * test JoinPointDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void runJoinPointDITest() {
        JoinPointDI.runJoinPointDI();
    }

    /**
     * test ProceedingJoinPointDI
     *
     * @author add by huyingzhao
     * 2022-07-30 10:18
     */
    @Test
    public void runProceedingJoinPointDITest() {
        ProceedingJoinPointDI.runProceedingJoinPointDI();
    }

    @Test
    public void jDKProxyDITest() {
        JDKProxyDI.jDKProxyDI();
    }

    //////////////////////////////////////////////////AOP end//////////////////////////////////////////////////

    //////////////////////////////////////////////////JDBC begin//////////////////////////////////////////////////
    @Test
    public void jdbc1Test() {
        JDBCDI.jdbc1();
    }

    @Test
    public void jdbc2Test() {
        JDBCDI.jdbc2();
    }
    //////////////////////////////////////////////////JDBC end//////////////////////////////////////////////////

}

