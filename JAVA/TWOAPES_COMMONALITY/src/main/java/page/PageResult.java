package page;


import enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2022-10-13 14:13
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class PageResult<T> extends Result {
    private long nowPage;//page now
    private long pageSize;//size page
    private long total;//total
    private T data;//data

    private PageResult() {
        super();
    }

    private PageResult(String code, String type, String msg) {
        super(code, type, msg);
    }

    public PageResult(String code, String type, String msg, T data) {
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
    public static <T> PageResult<T> success(String msg, T data) {
        return new PageResult<>(SUCCESS, ResultEnum.SUCCESS.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg  msg
     * @param data data
     * @return warning message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static <T> PageResult<T> warning(String msg, T data) {
        return new PageResult<>(WARNING, ResultEnum.WARNING.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg  msg
     * @param data data
     * @return error message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static <T> PageResult<T> error(String msg, T data) {
        return new PageResult<>(ERROR, ResultEnum.ERROR.name().toLowerCase(Locale.ROOT), msg, data);
    }

    /**
     * @param msg msg
     * @return success message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static PageResult<String> success(String msg) {
        return new PageResult<>(SUCCESS, ResultEnum.SUCCESS.name().toLowerCase(Locale.ROOT), msg);
    }

    /**
     * @param msg msg
     * @return warning message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static PageResult<String> warning(String msg) {
        return new PageResult<>(WARNING, ResultEnum.WARNING.name().toLowerCase(Locale.ROOT), msg);
    }

    /**
     * @param msg msg
     * @return error message
     * @author add by huyingzhao
     * 2022-06-01 10:07
     */
    public static PageResult<String> error(String msg) {
        return new PageResult<>(ERROR, ResultEnum.ERROR.name().toLowerCase(Locale.ROOT), msg);
    }
}
