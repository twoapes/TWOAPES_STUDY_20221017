package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import document.Document;
import document.Id;
import document.XLSXColumnEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author add by huyingzhao
 * 2022-09-24 13:49
 */
@Data
@Document(collection = "hyz_voc")
@ApiModel(value = "VocabularyTO", description = "vocabulary")
public class VocabularyTO {
    @Id
    @ApiModelProperty(value = "id")
    private String id;
    @XLSXColumnEnum(name = "name", index = 0)
    @ApiModelProperty(value = "name")
    private String name;
    @XLSXColumnEnum(name = "value", index = 1)
    @ApiModelProperty(value = "value")
    private String value;
    @XLSXColumnEnum(name = "type", index = 2, map = "CODE:code,")
    @ApiModelProperty(value = "type")
    private String type;
    @XLSXColumnEnum(name = "createTime", index = 3)
    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @XLSXColumnEnum(name = "lastModifyTime", index = 4)
    @ApiModelProperty(value = "lastModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;
}