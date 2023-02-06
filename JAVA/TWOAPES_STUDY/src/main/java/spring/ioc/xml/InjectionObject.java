package spring.ioc.xml;

import lombok.extern.slf4j.Slf4j;
import spring.ioc.xml.pojo.Student;

/**
 * @author add by huyingzhao
 * 2022-09-30 18:28
 * create object
 */
@Slf4j
public class InjectionObject extends XmlDI {
    /**
     * @author add by huyingzhao
     * 2022-09-30 14:27
     */
    public static void createObject() {
        Student student = student("object");
        String stringBuilder = "--------------create object(init)---------------" + "\n" + student + "\n";
        log.info(stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 14:27
     */
    public static void alias() {
        Student student = student("aliasObject");
        String stringBuilder = "--------------create object(using alias)---------------" + "\n" + student + "\n";
        log.info(stringBuilder);
    }
}