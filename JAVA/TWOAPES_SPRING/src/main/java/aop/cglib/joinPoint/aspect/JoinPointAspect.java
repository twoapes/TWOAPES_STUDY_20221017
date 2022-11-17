package aop.cglib.joinPoint.aspect;


import enums.ISO8601Enum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import util.DateUtil;

/**
 * @author huyingzhao
 * 2022-03-06 14:16
 */
@Slf4j
public class JoinPointAspect {
    public void time(JoinPoint joinPoint) {
        String now = DateUtil.format(DateUtil.nowTime(), ISO8601Enum.YYYY_MM_DD_HE_HMS_S_S);
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("(" + className + "." + methodName + ") ---> " + now);
    }
}
