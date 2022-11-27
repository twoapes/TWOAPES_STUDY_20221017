package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author add by huyingzhao
 * 2022-09-24 13:49
 *
 * DTO for database
 */
@Data
@Document(collection = "hyz_voc")
@ApiModel(value = "hyz_voc", description = "vocabulary")
public class VocabularyDTO {
    /*
     * id
     */
    @Id
    @ApiModelProperty(value = "id")
    private String id;
    /*
     * name
     */
    @ApiModelProperty(value = "name")
    private String name;
    /*
     * value
     */
    @ApiModelProperty(value = "value")
    private String value;
    /*
     * type
     */
    @ApiModelProperty(value = "type")
    private String type;
    /*
     * createTime
     */
    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /*
     * lastModifyTime
     */
    @ApiModelProperty(value = "lastModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;
}