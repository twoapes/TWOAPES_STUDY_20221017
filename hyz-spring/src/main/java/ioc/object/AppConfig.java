package ioc.object;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author add by huyingzhao
 * 2023-02-24 14:50
 */
@ComponentScan({"ioc.object"})
@PropertySource("classpath:hyz.properties")
public class AppConfig {
    @Bean
    public AnnotationDao annotationDao() {
        return new AnnotationDao();
    }
}
