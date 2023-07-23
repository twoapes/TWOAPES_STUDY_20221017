package aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author add by huyingzhao
 * 2022-10-06 15:59
 */
@Slf4j
@Component
@Aspect
public class AppProxy {
    @Before("execution(public void aop.annotation.App.add(..))")
    public void before() {
        log.info("call aop.annotation.AppProxy.before");
    }
}