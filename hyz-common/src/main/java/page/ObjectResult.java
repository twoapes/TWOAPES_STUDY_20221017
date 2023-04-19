package page;

import enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2022-02-10 9:46
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ObjectResult<T> extends Result {
    private T data;

    private ObjectResult() {
        super();
    }


    private ObjectResult(String code, String type, String msg) {
        super(code, type, msg);
    }

    private ObjectResult(String code, String type, String msg, T data) {
        super(code, type, msg);
        this.data = data;
    }

    /**
     * @param msg  msg
     * @param data data
     * @return success message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static <T> ObjectResult<T> success(String msg, T data) {
        return new ObjectResult<>(SUCCESS, ResultEnum.SUCCESS.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg  msg
     * @param data data
     * @return warning message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static <T> ObjectResult<T> warning(String msg, T data) {
        return new ObjectResult<>(WARNING, ResultEnum.WARNING.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg  msg
     * @param data data
     * @return error message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static <T> ObjectResult<T> error(String msg, T data) {
        return new ObjectResult<>(ERROR, ResultEnum.ERROR.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg msg
     * @return success message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static ObjectResult<String> success(String msg) {
        return new ObjectResult<>(SUCCESS, ResultEnum.SUCCESS.name().toLowerCase(Locale.ROOT), msg);
    }

    /**
     * @param msg msg
     * @return warning message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static ObjectResult<String> warning(String msg) {
        return new ObjectResult<>(WARNING, ResultEnum.WARNING.name().toLowerCase(Locale.ROOT), msg);
    }

    /**
     * @param msg msg
     * @return error message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static ObjectResult<String> error(String msg) {
        return new ObjectResult<>(ERROR, ResultEnum.ERROR.name().toLowerCase(Locale.ROOT), msg);
    }
}
