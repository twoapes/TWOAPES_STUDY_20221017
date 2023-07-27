package springboot.domain.vocabulary;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author add by huyingzhao
 * 2023-04-17 11:33
 */
@Data
@ApiModel(value = "VocabularyDML", description = "vocabulary")
public class VocabularyDML {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "value")
    private String value;
    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "lastModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;
}
