package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author add by huyingzhao
 * 2023-03-11 14:29
 * 可重复注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatableAnnotation1 {
    RepeatableAnnotation2[] value();
}
