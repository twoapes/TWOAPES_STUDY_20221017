package dto;

import document.XLSXColumnEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author add by huyingzhao
 * 2022-11-27 16:28
 */
@Data
public class ExportVocabularyPO {
    /*
     * id
     */
    private String id;
    /*
     * name
     */
    @XLSXColumnEnum(name = "name", index = 0)
    private String name;
    /*
     * value
     */
    @XLSXColumnEnum(name = "value", index = 1)
    private String value;
    /*
     * type
     */
    @XLSXColumnEnum(name = "type", index = 2, map = "ENGLISH:english,JAVA:java,IDIOM:idiom")
    private String type;
    /*
     * createTime
     */
    @XLSXColumnEnum(name = "createTime", index = 3)
    private Date createTime;
    /*
     * lastModifyTime
     */
    @XLSXColumnEnum(name = "lastModifyTime", index = 4)
    private Date lastModifyTime;
}
