package document;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author add by huyingzhao
 * 2022-10-14 9:53
 */
@Persistent
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Document {
    @AliasFor("collection")
    String value() default "";

    @AliasFor("value")
    String collection() default "";

    String language() default "";

    String collation() default "";
}
