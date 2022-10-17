package ioc.annotation.attribute.value;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.*;

/**
 * @author add by huyingzhao
 * 2022-08-07 0:42
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Value("${hyz.name}")
public @interface ValueAnnotation {
}