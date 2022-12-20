package document;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author add by huyingzhao
 * 2022-01-30 14:46
 * only link execute
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface XLSXLinkEnum {
    /*
     *url link
     */
    String url() default "";

    /*
     *email link
     */
    String email() default "";

    /*
     *file link
     */
    String file() default "";
}
