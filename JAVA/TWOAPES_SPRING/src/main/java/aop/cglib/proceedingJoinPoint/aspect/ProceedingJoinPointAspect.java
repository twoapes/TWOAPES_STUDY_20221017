package aop.cglib.proceedingJoinPoint.aspect;


import enums.ISO8601Enum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import util.ComputerUtil;
import util.DateUtil;

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
            String now = DateUtil.format(DateUtil.nowTime(), ISO8601Enum.YYYY_MM_DD_HE_HMS_S_S);
            ComputerUtil.end(startTime,"(" + className + "." + methodName+") ---> "+now);
            return ret;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
