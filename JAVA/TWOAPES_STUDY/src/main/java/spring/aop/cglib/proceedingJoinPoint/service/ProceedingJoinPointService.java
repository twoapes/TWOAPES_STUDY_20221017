package spring.aop.cglib.proceedingJoinPoint.service;

import spring.aop.cglib.proceedingJoinPoint.dao.ProceedingJoinPointDao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-07-31 13:46
 */
@Slf4j
@Data
public class ProceedingJoinPointService {
    private ProceedingJoinPointDao proceedingJoinPointDao;

    public void proceedingJoinPointService() {
        log.info("service call dao: proceedingJoinPointDao.init()");
        proceedingJoinPointDao.init();
    }
}
