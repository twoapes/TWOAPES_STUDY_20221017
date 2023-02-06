package spring.ioc.annotation.attribute.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author add by huyingzhao
 * 2022-08-07 16:18
 */
@Configuration
@ComponentScan("spring.ioc.annotation.attribute.configuration")
@Slf4j
public class AppConfig {
    @Bean
    public ConfigurationService configurationService() {
        //using @Configuration then ConfigurationDao is singleton
        ConfigurationDao configurationDao1 = configurationDao();
        ConfigurationDao configurationDao2 = configurationDao();
        log.info("configurationDao1:" + configurationDao1);
        log.info("configurationDao2:" + configurationDao2);
        log.info("configurationDao1==configurationDao2:" + (configurationDao1 == configurationDao2));
        return new ConfigurationService();
    }

    @Bean
    public ConfigurationDao configurationDao() {
        return new ConfigurationDao();
    }
}