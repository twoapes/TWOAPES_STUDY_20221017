package springboot.aspect;


import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import statics.ComputerUtils;
import statics.DateUtils;

/**
 * @author huyingzhao
 * 2022-03-06 19:42
 */
@Component
@Aspect
@Slf4j
public class AnnotationAspect {
    private int index;

    /**
     * before method
     */
    @Before("execution(public * springboot.service.*.*(..))")
    public void before() {
        try {
            String now = DateUtils.format(DateUtils.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_S_S);
            log.info("begin({}=========={}==========({})begin",++index,now,index);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * around method
     *
     * @param pjp ProceedingJoinPoint is JoinPoint plus
     * @return around
     */
    @Around("execution(public * springboot.service.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            // 执行目标方法
            Object ret = pjp.proceed();
            String className = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            String now = DateUtils.format(DateUtils.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_S_S);
            ComputerUtils.end(startTime, "==========(" + (index) + ")" + now + ":" + className + "." + methodName+"==========");
            return ret;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * after method
     */
    @After("execution(public * springboot.service.*.*(..))")
    public void after() {
        try {
            String now = DateUtils.format(DateUtils.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_S_S);
            log.info("end({}=========={}==========({})end",index,now,index);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
