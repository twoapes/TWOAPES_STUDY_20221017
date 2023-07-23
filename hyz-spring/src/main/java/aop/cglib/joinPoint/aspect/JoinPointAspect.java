package aop.cglib.joinPoint.aspect;


import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import util.ComputerUtil;
import util.DateUtil;

/**
 * @author huyingzhao
 * 2022-03-06 14:16
 */
@Slf4j
public class JoinPointAspect {
    public void time(JoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String now = DateUtil.format(DateUtil.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_SSS);
        ComputerUtil.end(startTime, now + "\t" + className + "." + methodName);
    }
}
