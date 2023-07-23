package ioc.junit.service.impl;

/**
 * @author add by huyingzhao
 * 2023-02-24 12:00
 */

import ioc.junit.dao.XmlDao;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ioc.junit.service.XmlService;

/**
 * @author add by huyingzhao
 * 2022-09-30 16:45
 */
@Setter
@Slf4j
public class XmlServiceImpl implements XmlService {
    private XmlDao xmlDao;

    public void xml(){
        log.info("ioc.junit.service.impl.XmlServiceImpl.xml");
        xmlDao.xml();
    }
}