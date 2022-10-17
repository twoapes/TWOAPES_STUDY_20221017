package ioc.annotation.attribute.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author add by huyingzhao
 * 2022-08-07 16:19
 */
@Data
@Slf4j
public class ConfigurationService {
    @Autowired
    private ConfigurationDao configurationDao;
    public void configuration(){
        log.info("service call dao:configurationDao.configuration()");
        configurationDao.configuration();
    }
}