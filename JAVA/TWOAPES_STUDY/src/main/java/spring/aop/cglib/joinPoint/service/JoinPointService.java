package spring.aop.cglib.joinPoint.service;

import spring.aop.cglib.joinPoint.dao.JoinPointDao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-08-01 10:00
 */
@Slf4j
@Data
public class JoinPointService {
    private JoinPointDao joinPointDao;

    public void joinPointService() {
        log.info("service call dao:joinPointDao.init()");
        joinPointDao.init();
    }
}