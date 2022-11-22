package entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author add by huyingzhao
 * 2022-09-25 11:11
 * TO for controller or dao
 */
@Data
@ApiModel(value = "StudentTO", description = "student")
@ToString
public class StudentTO {
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