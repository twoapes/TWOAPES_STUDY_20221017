package ioc.xml.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author add by huyingzhao
 * 2022-09-30 23:53
 * After advice
 */
@Slf4j
public class Processors implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("the third step:call ioc.xml.pojo.Processors.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("The fifth step:call ioc.xml.pojo.Processors.postProcessAfterInitialization");
        return bean;
    }
}