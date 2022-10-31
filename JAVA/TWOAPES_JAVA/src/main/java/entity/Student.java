package entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author add by huyingzhao
 * 2022-10-13 17:19
 * entity for generic class
 */
@Data
@ToString
public class Student {
    /*
     * name
     */
    private String name;
    /*
     * age
     */
    private int age;
}