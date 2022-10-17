package ioc.annotation.object;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author add by huyingzhao
 * 2022-10-01 13:38
 */
@ComponentScan({"ioc.annotation.object", "ioc.annotation.object"})
@PropertySource("classpath:hyz.properties")
public class AppConfig {
    @Bean
    public AnnotationDao annotationDao() {
        return new AnnotationDao();
    }
}