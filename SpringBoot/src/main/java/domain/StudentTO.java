package domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2022-09-25 11:11
 */
@Data
@Component
@ConfigurationProperties(prefix = "student")
@ToString
public class StudentTO {
    /*
     * id
     */
    private int id;
    /*
     * name
     */
    private String name;
    /*
     * age
     */
    private int age;
}