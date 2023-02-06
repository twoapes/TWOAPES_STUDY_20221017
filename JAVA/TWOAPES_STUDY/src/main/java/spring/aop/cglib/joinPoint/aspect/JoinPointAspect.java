package spring.aop.cglib.joinPoint.aspect;


import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import statics.DateUtils;

/**
 * @author huyingzhao
 * 2022-03-06 14:16
 */
@Slf4j
public class JoinPointAspect {
    public void time(JoinPoint joinPoint) {
        String now = DateUtils.format(DateUtils.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_S_S);
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("(" + className + "." + methodName + ") ---> " + now);
    }
}
