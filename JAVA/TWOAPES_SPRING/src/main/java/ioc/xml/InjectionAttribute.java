package ioc.xml;

import ioc.xml.pojo.*;
import ioc.xml.service.XmlService;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.*;

/**
 * @author add by huyingzhao
 * 2022-09-30 18:25
 * di attribute
 */
@Slf4j
public class InjectionAttribute extends XmlDI {

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:47
     */
    public static void setter() {
        Student student = student("property");
        String stringBuilder = "--------------using setter method---------------" + "\n" +
                "name:" + student.getName() + "\n" +
                "age:" + student.getAge();
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:47
     */
    public static void pNameSpace() {
        //xmlns:p also call the p-namespace
        Student student = student("pNameSpace");
        String stringBuilder = "--------------using xmlns:p---------------" + "\n" +
                "name:" + student.getName() + "\n" +
                "age:" + student.getAge();
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    public static void nullLabel() {
        Student student = student("null");
        String stringBuilder = "--------------set null value---------------" + "\n" +
                "name:" + student.getName() + "\n" +
                "age:" + student.getAge();
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    public static void special() {
        Student student = student("special1");
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("--------------set the value for the special attribute(escape method)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);


        student = student("special2");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------set the value for the special attribute(CDATA method)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    public static void bean() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("--------------outer bean---------------").append("\n");
        log.info("stringBuilder :{}",stringBuilder);
        XmlService xmlService = xmlService();
        xmlService.xml();

        stringBuilder.setLength(0);
        Teacher teacher = teacher("inside");
        Student student = teacher.getStudent();
        stringBuilder.append("--------------interior bean---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        teacher = teacher("cascade1");
        student = teacher.getStudent();
        stringBuilder.append("--------------cascade assignment(using ref)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        teacher = teacher("cascade2");
        student = teacher.getStudent();
        stringBuilder.append("--------------cascade assignment(using '.')---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    public static void aggregate() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        Teacher teacher = teacher("aggregate1");
        String[] students = teacher.getStudents();
        stringBuilder.append("--------------array---------------").append("\n");
        stringBuilder.append("students:").append(Arrays.toString(students)).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        List<String> studentList = teacher.getStudentList();
        stringBuilder.append("--------------list---------------").append("\n");
        stringBuilder.append("studentList:").append(studentList).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        Map<String, String> studentMap = teacher.getStudentMap();
        stringBuilder.append("--------------Map---------------").append("\n");
        stringBuilder.append("studentMap:").append(studentMap).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        Set<String> studentSet = teacher.getStudentSet();
        stringBuilder.append("--------------Set---------------").append("\n");
        stringBuilder.append("studentSet:").append(studentSet).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        List<Student> studentObjectList = teacher.getStudentObjectList();
        stringBuilder.append("--------------List(object)---------------").append("\n");
        stringBuilder.append("studentObjectList:").append(studentObjectList).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        teacher = teacher("aggregate2");
        studentObjectList = teacher.getStudentObjectList();
        stringBuilder.append("--------------List(public object)---------------").append("\n");
        stringBuilder.append("studentObjectList:").append(studentObjectList).append("\n");
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    public static void scope() {
        //singleton,load configuration then create object
        Student student1 = student("scope1");
        Student student2 = student("scope1");
        StringBuilder stringBuilder = new StringBuilder("\n");
        //Spring default is singleton
        stringBuilder.append("--------------scope(singleton)---------------").append("\n");
        stringBuilder.append("is the same as object:").append(student1 == student2).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        //property,call getBean then create object
        student1 = student("scope2");
        student2 = student("scope2");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------scope(property)---------------").append("\n");
        stringBuilder.append("is the same as object:").append(student1 == student2).append("\n");
        log.info("stringBuilder :{}",stringBuilder);
        //more request and session scope
    }

    /**
     * bean life cycle
     *
     * @author add by huyingzhao
     * 2022-09-30 23:24
     */
    public static void lifeCycle() {
        log.info("--------------non after advice--------------");
        lifeCycleUnProcessors();
        log.info("\n\n--------------has after advice--------------");
        lifeCycle2Processors();
    }

    /**
     * autowired
     *
     * @author add by huyingzhao
     * 2022-10-01 11:35
     */
    public static void autowired() {
        Student student = student("autowired1");
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("--------------autowired(name di)---------------").append("\n");
        stringBuilder.append(student).append("\n");
        log.info("stringBuilder :{}",stringBuilder);

        student = student("autowired2");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------autowired(type di)---------------").append("\n");
        stringBuilder.append(student).append("\n");
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 11:57
     */
    public static void jdbcDI() {
        Jdbc jdbc = jdbc();
        String stringBuilder = "--------------using outer for configuration---------------" + "\n" +
                "jdbc:" + jdbc;
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 16:25
     */
    public static void constructor() {
        Student student = student("constructorArg1");
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("--------------parameter construction method(constructor-arg using name)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);

        student = student("constructorArg2");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------parameter construction method(constructor-arg using index)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);


        student = student("constructorArg3");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------parameter construction method(constructor-arg using type)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);


        student = student("constructorArg4");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------parameter construction method(constructor-arg using ConstructorProperties annotation)---------------").append("\n");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge());
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @param charset charset
     * @author add by huyingzhao
     * 2022-10-01 15:14
     */
    public static void propertiesDI(Charset charset) {
        StringBuilder stringBuilder = new StringBuilder("--------------using Properties object---------------" + "\n");
        String property = properties();
        if (property != null) {
            Properties properties = new Properties();
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(property.getBytes(charset)); InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, charset)) {
                properties.load(inputStreamReader);
                if (properties.getProperty("username") != null) {
                    stringBuilder.append("username:").append(properties.getProperty("username")).append("\n");
                }

                if (properties.getProperty("url") != null) {
                    stringBuilder.append("url:").append(properties.getProperty("url")).append("\n");
                }


                if (properties.getProperty("password") != null) {
                    stringBuilder.append("password:").append(properties.getProperty("password")).append("\n");
                }

                if (properties.getProperty("classname") != null) {
                    stringBuilder.append("classname:").append(properties.getProperty("classname")).append("\n");
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }

        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 15:14
     */
    public static void factoryDI() {
        StringBuilder stringBuilder = new StringBuilder("--------------using factory attribute---------------").append("\n");
        Student student = student("factory");
        stringBuilder.append("name:").append(student.getName()).append("\n");
        stringBuilder.append("age:").append(student.getAge()).append("\n");
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 15:18
     */
    public static void staticDI() {
        StringBuilder stringBuilder = new StringBuilder("--------------static factory---------------").append("\n");
        Static aStatic = staticInit();

        stringBuilder.append("aStatic object init success").append("\n");
        stringBuilder.append("static1:").append(Static.getStatic1()).append("\n");
        stringBuilder.append("static2:").append(Static.getStatic2()).append("\n");
        stringBuilder.append("aStatic:").append(aStatic).append("\n");

        Static1 static1 = staticInit1();

        stringBuilder.append("static1 object init success").append("\n");
        stringBuilder.append("static1:").append(static1).append("\n");

        Static2 static2 = staticInit2();

        stringBuilder.append("static2 object init success").append("\n");
        stringBuilder.append("static2:").append(static2).append("\n");

        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * @author method add by huyingzhao
     * 2022-10-14 10:51
     */
    public static void importDI() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("---------------more configuration(using import label)---------------").append("\n");
        Import anImport = usingImport();

        stringBuilder.append("anImport object init success").append("\n");
        stringBuilder.append("import1:").append(anImport.getImport1()).append("\n");
        stringBuilder.append("import2:").append(anImport.getImport2()).append("\n");

        Student import1 = usingImport1();
        stringBuilder.append("import1 object init success").append("\n");
        stringBuilder.append("import1:").append(import1).append("\n");

        Teacher import2 = usingImport2();
        stringBuilder.append("import2 object init success").append("\n");
        stringBuilder.append("import2:").append(import2).append("\n");

        log.info("stringBuilder :{}",stringBuilder);

        stringBuilder.setLength(0);
        stringBuilder.append("---------------more configuration(using more configuration)---------------").append("\n");
        anImport = usingImport();

        stringBuilder.append("anImport object init success").append("\n");
        stringBuilder.append("import1:").append(anImport.getImport1()).append("\n");
        stringBuilder.append("import2:").append(anImport.getImport2()).append("\n");

        import1 = usingImport1();
        stringBuilder.append("import1 object init success").append("\n");
        stringBuilder.append("import1:").append(import1).append("\n");

        import2 = usingImport2();
        stringBuilder.append("import2 object init success").append("\n");
        stringBuilder.append("import2:").append(import2).append("\n");

        log.info("stringBuilder :{}",stringBuilder);
    }
}
