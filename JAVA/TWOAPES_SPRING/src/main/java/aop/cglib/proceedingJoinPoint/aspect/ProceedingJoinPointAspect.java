package aop.cglib.proceedingJoinPoint.aspect;


import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import statics.ComputerUtils;
import statics.DateUtils;

/**
 * @author huyingzhao
 * 2022-03-06 17:32
 */
@Slf4j
public class ProceedingJoinPointAspect {


    /**
     * Around method
     *
     * @param pjp ProceedingJoinPoint
     * @return time
     */
    public Object time(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startTime = System.currentTimeMillis();
            Object ret = pjp.proceed();
            String className = pjp.getTarget().getClass().getName();
            String methodName = pjp.getSignature().getName();
            String now = DateUtils.format(DateUtils.nowTime(), ISO8601.YYYY_MM_DD_HE_HMS_S_S);
            ComputerUtils.end(startTime, now + "\t" + className + "." + methodName);
            return ret;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
