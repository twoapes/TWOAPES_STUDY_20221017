package annotation;

import java.lang.annotation.*;

/**
 * @author add by huyingzhao
 * 2023-03-11 14:27
 * 可重复注解
 */
@Repeatable(RepeatableAnnotation1.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatableAnnotation2 {
    String value();
}
