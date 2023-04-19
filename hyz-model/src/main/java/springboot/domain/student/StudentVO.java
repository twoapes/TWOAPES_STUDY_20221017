package springboot.domain.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "StudentVO", description = "studentVO")
public class StudentVO {
    /*
     * id
     */
    @ApiModelProperty(value = "id")
    private int id;
    /*
     * name
     */
    @ApiModelProperty(value = "name")
    private String name;
    /*
     * age
     */
    @ApiModelProperty(value = "age")
    private int age;
}