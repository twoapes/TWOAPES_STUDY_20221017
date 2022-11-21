package aop.cglib.joinPoint.dao;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-08-01 10:01
 */
@Slf4j
public class JoinPointDao {
    public JoinPointDao() {
        log.info("call {}","aop.cglib.joinPoint.dao.JoinPointDao.JoinPointDao");
    }

    public void init() {
        log.info("call {}","aop.cglib.joinPoint.dao.JoinPointDao.init");
    }
}
