package ioc.value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author add by huyingzhao
 * 2022-08-07 15:41
 */
@ComponentScan("ioc.value")
@PropertySource("classpath:hyz.properties")
public class AppConfig {
}