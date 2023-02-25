package ioc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import pojo.*;
import service.XmlService;
import util.IOCUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.*;

@Slf4j
public class XmlTest extends IOCUtil {
    /**
     * @author add by huyingzhao
     * 2022-09-30 14:27
     */
    @Test
    public void createObject() {
        Student student = getBean(Student.class, "object", "object");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 14:27
     */
    @Test
    public void alias() {
        Student student = getBean(Student.class, "object", "aliasObject");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:47
     */
    @Test
    public void property() {
        Student student = getBean(Student.class, "property");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:47
     */
    @Test
    public void pNameSpace() {
        Student student = getBean(Student.class, "pNameSpace");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void nullLabel() {
        Student student = getBean(Student.class, "null");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void special() {
        Student student = getBean(Student.class, "special", "special1");
        student(student);
        student = getBean(Student.class, "special", "special2");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void xmlService() {
        XmlService xmlService = getBean(XmlService.class, "xmlService");
        xmlService.xml();
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void inside() {
        Teacher teacher = getBean(Teacher.class, "inside");
        Student student = teacher.getStudent();
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void cascade1() {
        Teacher teacher = getBean(Teacher.class, "cascade", "cascade1");
        Student student = teacher.getStudent();
        student(student);
        teacher = getBean(Teacher.class, "cascade", "cascade2");
        student = teacher.getStudent();
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void aggregate() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        Teacher teacher = getBean(Teacher.class, "aggregate", "aggregate1");
        String[] students = teacher.getStudents();
        stringBuilder.append("--------------array---------------").append("\n");
        stringBuilder.append("students:").append(Arrays.toString(students)).append("\n");
        log.info(stringBuilder.toString());

        stringBuilder.setLength(0);
        List<String> studentList = teacher.getStudentList();
        stringBuilder.append("--------------list---------------").append("\n");
        stringBuilder.append("studentList:").append(studentList).append("\n");
        log.info(stringBuilder.toString());

        stringBuilder.setLength(0);
        Map<String, String> studentMap = teacher.getStudentMap();
        stringBuilder.append("--------------Map---------------").append("\n");
        stringBuilder.append("studentMap:").append(studentMap).append("\n");
        log.info(stringBuilder.toString());

        stringBuilder.setLength(0);
        Set<String> studentSet = teacher.getStudentSet();
        stringBuilder.append("--------------Set---------------").append("\n");
        stringBuilder.append("studentSet:").append(studentSet).append("\n");
        log.info(stringBuilder.toString());

        stringBuilder.setLength(0);
        List<Student> studentObjectList = teacher.getStudentObjectList();
        stringBuilder.append("--------------List(object)---------------").append("\n");
        stringBuilder.append("studentObjectList:").append(studentObjectList).append("\n");
        log.info(stringBuilder.toString());

        stringBuilder = new StringBuilder("\n");
        teacher = getBean(Teacher.class, "aggregate", "aggregate2");
        studentObjectList = teacher.getStudentObjectList();
        stringBuilder.append("--------------List(public object)---------------").append("\n");
        stringBuilder.append("studentObjectList:").append(studentObjectList).append("\n");
        log.info(stringBuilder.toString());
    }


    /**
     * @author add by huyingzhao
     * 2022-09-30 18:46
     */
    @Test
    public void scope() {
        //singleton,load configuration then create object
        Student student1 = getBean(Student.class, "scope", "scope1");
        Student student2 = getBean(Student.class, "scope", "scope1");
        StringBuilder stringBuilder = new StringBuilder("\n");
        //Spring default is singleton
        stringBuilder.append("--------------scope(singleton)---------------").append("\n");
        stringBuilder.append("is the same as object:").append(student1 == student2).append("\n");
        log.info(stringBuilder.toString());

        //property,call getBean then create object
        student1 = getBean(Student.class, "scope", "scope2");
        student2 = getBean(Student.class, "scope", "scope2");
        stringBuilder.setLength(0);
        stringBuilder.append("--------------scope(property)---------------").append("\n");
        stringBuilder.append("is the same as object:").append(student1 == student2).append("\n");
        log.info(stringBuilder.toString());
        //more request and session scope
    }

    /**
     * bean life cycle
     *
     * @author add by huyingzhao
     * 2022-09-30 23:24
     */
    @Test
    public void lifeCycle() {
        log.info("--------------non after advice--------------");
        LifeCycle lifeCycle = getBean(LifeCycle.class, "lifeCycle");
        log.info("The fourth step:call object\t" + lifeCycle);
        log.info("\n\n--------------has after advice--------------");
        UnLifeCycle unLifeCycle = getBean(UnLifeCycle.class, "unLifeCycle");
        log.info("The six step:call object\t" + unLifeCycle);
    }

    /**
     * autowired
     *
     * @author add by huyingzhao
     * 2022-10-01 11:35
     */
    @Test
    public void autowired() {
        Student student = getBean(Student.class, "autowired", "autowired1");
        student(student);
        student = getBean(Student.class, "autowired", "autowired2");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-09-30 16:25
     */
    @Test
    public void constructor() {
        Student student = getBean(Student.class, "constructorArg", "constructorArg1");
        student(student);
        student = getBean(Student.class, "constructorArg", "constructorArg2");
        student(student);
        student = getBean(Student.class, "constructorArg", "constructorArg3");
        student(student);
        student = getBean(Student.class, "constructorArg", "constructorArg4");
        student(student);
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 15:14
     */
    @Test
    public void properties() {
        final Charset charset = StandardCharsets.UTF_8;
        StringBuilder stringBuilder = new StringBuilder("--------------using Properties object---------------" + "\n");
        pojo.Properties pro = getBean(pojo.Properties.class, "properties");
        String property = pro.getProperties();
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

        log.info(stringBuilder.toString());
    }

    /**
     * @author add by huyingzhao
     * 2022-10-01 15:18
     */
    @Test
    public void statics() {
        StringBuilder stringBuilder = new StringBuilder("--------------static.xml factory---------------").append("\n");
        Static aStatic = getBean(Static.class, "static");

        stringBuilder.append("aStatic object init success").append("\n");
        stringBuilder.append("static1:").append(Static.getStatic1()).append("\n");
        stringBuilder.append("static2:").append(Static.getStatic2()).append("\n");
        stringBuilder.append("aStatic:").append(aStatic).append("\n");

        Static1 static1 = getBean(Static1.class, "static", "static1");

        stringBuilder.append("static1 object init success").append("\n");
        stringBuilder.append("static1:").append(static1).append("\n");

        Static2 static2 = getBean(Static2.class, "static", "static2");

        stringBuilder.append("static2 object init success").append("\n");
        stringBuilder.append("static2:").append(static2).append("\n");

        log.info(stringBuilder.toString());
    }


    /**
     * @author method add by huyingzhao
     * 2022-10-14 10:51
     */
    @Test
    public void imports() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append("---------------more configuration(using import label)---------------").append("\n");
        pojo.Import anImport = getBean(pojo.Import.class, "import");

        stringBuilder.append("anImport object init success").append("\n");
        stringBuilder.append("import1:").append(anImport.getImport1()).append("\n");
        stringBuilder.append("import2:").append(anImport.getImport2()).append("\n");

        Import1 import1 = getBean(Import1.class, "import", "import1");
        stringBuilder.append("import1 object init success").append("\n");
        stringBuilder.append("import1:").append(import1).append("\n");

        Import2 import2 = getBean(Import2.class, "import", "import2");
        stringBuilder.append("import2 object init success").append("\n");
        stringBuilder.append("import2:").append(import2).append("\n");

        log.info(stringBuilder.toString());

        stringBuilder.setLength(0);
        stringBuilder.append("---------------more configuration(using more configuration)---------------").append("\n");
        anImport = getBean(pojo.Import.class, "import");

        stringBuilder.append("anImport object init success").append("\n");
        stringBuilder.append("import1:").append(anImport.getImport1()).append("\n");
        stringBuilder.append("import2:").append(anImport.getImport2()).append("\n");

        import1 = getBean(Import1.class, "import", "import1");
        stringBuilder.append("import1 object init success").append("\n");
        stringBuilder.append("import1:").append(import1).append("\n");

        import2 = getBean(Import2.class, "import", "import2");
        stringBuilder.append("import2 object init success").append("\n");
        stringBuilder.append("import2:").append(import2).append("\n");

        log.info(stringBuilder.toString());
    }

    /**
     * @param student student
     * @author add by huyingzhao
     * 2023-02-24 11:49
     */
    private void student(Student student) {
        String stringBuilder = "\n" +
                "name:" + student.getName() + "\n" +
                "age:" + student.getAge();
        log.info(stringBuilder);
    }
}
