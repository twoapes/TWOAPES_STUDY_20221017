package application;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @author add by huyingzhao
 * 2022-09-25 10:48
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan({"config", "springboot.*"})
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
@MapperScan(basePackages = {"springboot.mapper"})
@EnableAspectJAutoProxy
@Slf4j
public class SpringBootApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        log.info("spring.devtools.restart.enabled");
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
