package document;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author add by huyingzhao
 * 2022-01-30 17:12
 * only for drop down
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XLSXDropEnum {
    /**
     * @return drop down
     * @author add by huyingzhao
     * 2022-10-24 14:51
     */
    String[] values();
}
