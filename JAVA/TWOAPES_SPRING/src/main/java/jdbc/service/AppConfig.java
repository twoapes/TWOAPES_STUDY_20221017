package jdbc.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author add by huyingzhao
 * 2022-08-07 15:41
 */
@ComponentScan({"jdbc.service", "jdbc.pojo"})
@PropertySource("classpath:hyz.properties")
public class AppConfig {
}