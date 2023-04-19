package page;


import enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2022-10-13 14:13
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class PageResult<T> extends Result {
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;
    private List<T> content;

    private PageResult(String code, String type, String msg) {
        super(code, type, msg);
    }

    private PageResult(String code, String type, String msg, long totalElements, int totalPages, int pageNumber, int pageSize, List<T> content) {
        super(code, type, msg);
        this.totalElements = totalElements;
        this.pageNumber = pageNumber;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
        this.content = content;
    }

    /**
     * @param msg           msg
     * @param totalElements totalElements
     * @param totalPages    totalPages
     * @param pageNumber    pageNumber
     * @param pageSize      pageSize
     * @param content       content
     * @param <T>           <T>
     * @return success
     * @author add by huyingzhao
     * 2023-04-18 08:53
     */
    public static <T> PageResult<T> success(String msg, long totalElements, int totalPages, int pageNumber, int pageSize, List<T> content) {
        return new PageResult<>(SUCCESS, ResultEnum.SUCCESS.name().toLowerCase(Locale.ROOT), msg, totalElements, totalPages, pageNumber, pageSize, content);
    }
}
