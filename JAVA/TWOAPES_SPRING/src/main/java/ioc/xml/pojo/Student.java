package ioc.xml.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.beans.ConstructorProperties;

/**
 * @author add by huyingzhao
 * 2022-09-30 13:56
 */
@Data
@ToString
@Slf4j
public class Student {
    private String name;
    private int age;

    public Student() {
        log.debug("call ioc.xml.pojo.Student.Student");
    }

    @ConstructorProperties({"name", "age"})
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}