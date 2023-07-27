package springboot.domain.vocabulary;

import com.fasterxml.jackson.annotation.JsonFormat;
import document.XLSXColumnEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

/**
 * @author add by huyingzhao
 * 2022-09-24 13:49
 */
@Data
@Document(collection = "vocabulary")
@ApiModel(value = "VocabularyVO", description = "vocabulary")
public class VocabularyVO {
    @Id
    @ApiModelProperty(value = "id")
    private String id;
    @XLSXColumnEnum(name = "name", index = 0)
    @ApiModelProperty(value = "name")
    private String name;
    @XLSXColumnEnum(name = "value", index = 1)
    @ApiModelProperty(value = "value")
    private String value;
    @XLSXColumnEnum(name = "createTime", index = 2)
    @ApiModelProperty(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @XLSXColumnEnum(name = "lastModifyTime", index = 3)
    @ApiModelProperty(value = "lastModifyTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;
}