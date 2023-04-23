package aop.cglib.joinPoint.service;

import aop.cglib.joinPoint.dao.JoinPointDao;
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
        log.info("call aop.cglib.joinPoint.service.JoinPointService.joinPointService");
        joinPointDao.init();
    }
}
