package aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author add by huyingzhao
 * 2022-10-06 15:54
 */
@Configuration
@ComponentScan(basePackages = {"aop.annotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    @Bean
    public App app() {
        return new App();
    }
}