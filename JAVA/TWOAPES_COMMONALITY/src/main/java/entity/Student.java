package entity;

import lombok.Data;
import lombok.ToString;
import java.beans.ConstructorProperties;

/**
 * @author add by huyingzhao
 * 2022-10-13 17:19
 * entity for generic class
 */
@Data
@ToString
public class Student {
    private String name;
    private int age;

    public Student() {
//        log.info("call {}","ioc.xml.pojo.Student.Student");
    }

    @ConstructorProperties({"name", "age"})
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}