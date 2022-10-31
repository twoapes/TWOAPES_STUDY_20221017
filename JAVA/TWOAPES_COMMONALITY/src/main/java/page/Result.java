package page;

import lombok.Data;

/**
 * @author add by huyingzhao
 * 2022-06-01 9:38
 */
@Data
public class Result {
    private String code;
    private String msg;

    private String type;
    static final String SUCCESS = "200";
    static final String WARNING = "200";
    static final String ERROR = "500";

    /**
     * Result
     */
    Result() {
    }

    /**
     * Result
     * @param code
     * @param type
     * @param msg
     */
    Result(String code, String type, String msg) {
        this.code = code;
        this.type = type;
        this.msg = msg;
    }
}