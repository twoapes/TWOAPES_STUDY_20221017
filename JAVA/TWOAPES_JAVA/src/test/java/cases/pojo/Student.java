package cases.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-13 17:19
 */
@Data
@ToString
@Slf4j
public class Student {
    private String name;
    private int age;
}