package document;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author add by huyingzhao
 * 2022-10-13 13:47
 * only for column
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface OracleColumn {
    /**
     * @return column name
     * @author add by huyingzhao
     * 2022-10-24 14:51
     */
    String name() default "";
}
