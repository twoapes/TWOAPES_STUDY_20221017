package aop.cglib.proceedingJoinPoint.dao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-08-01 10:08
 */
@Slf4j
public class ProceedingJoinPointDao {
    public ProceedingJoinPointDao() {
        log.info("call aop.cglib.proceedingJoinPoint.dao.ProceedingJoinPointDao.ProceedingJoinPointDao");
    }

    public void init() {
        log.info("call aop.cglib.proceedingJoinPoint.dao.ProceedingJoinPointDao.init");
    }
}
