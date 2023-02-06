package spring.ioc.xml.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author add by huyingzhao
 * 2022-09-30 17:03
 */
@Data
public class Teacher {
    private Student student;
    private String[] students;
    private Set<String> studentSet;
    private List<String> studentList;
    private Map<String,String> studentMap;
    private List<Student> studentObjectList;
    private String name;
    private int age;
}