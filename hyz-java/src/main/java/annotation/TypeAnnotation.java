package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类型注解
 * @author add by huyingzhao
 * 2023-03-12 19:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface TypeAnnotation {
    String value();
}
