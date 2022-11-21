package ioc.annotation.attribute.configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-08-07 16:20
 */
@Slf4j
public class ConfigurationDao {
    public void configuration(){
        log.info("call {}","ioc.annotation.attribute.configuration.ConfigurationDao.configuration");
    }
}