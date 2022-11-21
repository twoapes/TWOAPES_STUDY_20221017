package ioc.xml;

import core.AppCore;
import ioc.xml.pojo.*;
import ioc.xml.service.XmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author add by huyingzhao
 * 2022-09-30 13:58
 */
@Slf4j
class XmlDI {
    /**
     * @return xml
     * @author add by huyingzhao
     * 2022-10-01 23:47
     */
    private static ApplicationContext xml() {
        return AppCore.open("ioc/xml.xml");
    }

    /**
     * @param id id
     * @return student
     */
    static Student student(String id) {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean(id, Student.class);
    }

    /**
     * @param id id
     * @return teacher
     * @author add by huyingzhao
     * 2022-09-30 17:13
     */
    static Teacher teacher(String id) {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean(id, Teacher.class);
    }

    /**
     * @return xmlService
     */
    static XmlService xmlService() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("xmlService", XmlService.class);
    }

    /**
     * @return properties
     */
    static String properties() {
        ApplicationContext applicationContext = xml();
        Properties properties = applicationContext.getBean("properties", Properties.class);
        return properties.getProperties();
    }

    /**
     * @return staticInit
     */
    static Static staticInit() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("static", Static.class);
    }

    /**
     * @return staticInit1
     */
    static Static1 staticInit1() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("static1", Static1.class);
    }

    /**
     * @return staticInit2
     */
    static Static2 staticInit2() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("static2", Static2.class);
    }


    /**
     * @return usingImport
     */
    static Import usingImport() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("import", Import.class);
    }

    /**
     * @return usingImport1
     */
    static Student usingImport1() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("import1", Student.class);
    }

    /**
     * @return usingImport2
     */
    static Teacher usingImport2() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("import2", Teacher.class);
    }

    /**
     * @return jdbc
     */
    static Jdbc jdbc() {
        ApplicationContext applicationContext = xml();
        return applicationContext.getBean("jdbc", Jdbc.class);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 23:37
     */
    static void lifeCycleUnProcessors() {
        ApplicationContext applicationContext = AppCore.open("ioc/lifeCycle.xml");
        LifeCycle lifeCycle = applicationContext.getBean("lifeCycle", LifeCycle.class);
        log.info("The fourth step:call object {}", lifeCycle);
        AppCore.close(applicationContext);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 23:37
     */
    static void lifeCycle2Processors() {
        ApplicationContext applicationContext = AppCore.open("ioc/lifeCycle2.xml");
        LifeCycle2 lifeCycle2 = applicationContext.getBean("lifeCycle2", LifeCycle2.class);
        log.info("The six step:call object {}", lifeCycle2);
        AppCore.close(applicationContext);
    }

}