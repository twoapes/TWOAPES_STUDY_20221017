package annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author add by huyingzhao
 * 2023-03-11 12:47
 */
@CustomAnnotation
@Slf4j
public class AnnotationTest {
    /**
     * 自定义注解
     *
     * @author add by huyingzhao
     * 2023-03-11 14:35
     */
    @Test
    public void annotation() {
        CustomAnnotation customAnnotation = this.getClass().getAnnotation(CustomAnnotation.class);
        log.info(customAnnotation.value());
    }

    /**
     * JDK1.8之后新增注解,可重复注解
     *
     * @author add by huyingzhao
     * 2023-03-11 14:35
     */
    @Test
    @RepeatableAnnotation2("1")
    @RepeatableAnnotation2("2")
    public void repeatableAnnotation() {

    }

    /**
     * JDK1.8之后新增注解,类型注解
     * 枚举值多了两个：TYPE_PARAMETER,TYPE_USE
     */
    @Test
    public void typeAnnotation() {
        List<@TypeAnnotation("type") String> strings = new ArrayList<>();
        strings.add("type");
        log.info(strings.toString());
        @TypeAnnotation("type")
        int i = 10;
        log.info(String.valueOf(i));
    }
}
