package spring.ioc.xml.service.impl;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import spring.ioc.xml.dao.XmlDao;
import spring.ioc.xml.service.XmlService;

/**
 * @author add by huyingzhao
 * 2022-09-30 16:45
 */
@Setter
@Slf4j
public class XmlServiceImpl implements XmlService {
    private XmlDao xmlDao;

    public void xml(){
        log.info("service call dao:ioc.xml.service.impl.XmlServiceImpl.xml");
        xmlDao.xml();
    }
}