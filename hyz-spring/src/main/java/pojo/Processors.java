package pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author add by huyingzhao
 * 2023-02-24 13:26
 */
@Slf4j
public class Processors implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("the third step:call pojo.Processors.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("The fifth step:call pojo.Processors.postProcessAfterInitialization");
        return bean;
    }
}
