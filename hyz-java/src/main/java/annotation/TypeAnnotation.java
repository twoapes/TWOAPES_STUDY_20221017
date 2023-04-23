package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类型注解
 *
 * @author add by huyingzhao
 * 2023-03-12 19:32
 */
//为了在运行时访问类型注解,我们必须为其指定一个 @Retention 注解,
@Retention(RetentionPolicy.RUNTIME)
// 并将其 RetentionPolicy 属性设置为 RUNTIME.此外,我们还必须为其指定一个 @Target 注解
// 并将其 ElementType 属性设置为 TYPE_USE.这告诉编译器,该注解可以用于任何类型的使用上.
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface TypeAnnotation {
    String value();
}
