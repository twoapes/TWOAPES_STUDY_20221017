package pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author add by huyingzhao
 * 2023-02-24 12:07
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
