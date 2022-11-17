import ioc.annotation.AnnotationInjectionAttribute;
import ioc.annotation.AnnotationInjectionObject;
import ioc.xml.InjectionAttribute;
import ioc.xml.InjectionObject;
import util.CharsetUtil;

import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2022-07-30 9:32
 */
public class IOCTest {
    /**
     * Instantiating beans using xml profile
     * for object
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
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void setterXMLTest(){
        InjectionAttribute.setter();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void pNameSpaceXMLTest(){
        InjectionAttribute.pNameSpace();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void nullLabelXMLTest(){
        InjectionAttribute.nullLabel();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void specialXMLTest(){
        InjectionAttribute.special();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void beanXMLTest(){
        InjectionAttribute.bean();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void aggregateXMLTest(){
        InjectionAttribute.aggregate();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void scopeXMLTest(){
        InjectionAttribute.scope();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void autowiredXMLTest(){
        InjectionAttribute.autowired();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void lifeCycleXMLTest(){
        InjectionAttribute.lifeCycle();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void jdbcDIXMLTest(){
        InjectionAttribute.jdbcDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void constructorXMLTest(){
        InjectionAttribute.constructor();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void propertiesDIXMLTest(){
        InjectionAttribute.propertiesDI(CharsetUtil.UTF_8);
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void factoryDIXMLTest(){
        InjectionAttribute.factoryDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void staticDIXMLTest(){
        InjectionAttribute.staticDI();
    }

    /**
     * Instantiating beans using xml profile
     * for attribute
     * @author add by huyingzhao
     * 2022-10-24 09:05
     */
    @Test
    public void importDIXMLTest(){
        InjectionAttribute.importDI();
    }


    /**
     * Instantiating beans using annotation
     * for object
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
     * @author add by huyingzhao
     * 2022-09-30 14:10
     */
    @Test
    public void componentScanAnnotationTest() {
        AnnotationInjectionAttribute.componentScan();
    }
}
