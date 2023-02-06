package spring.ioc.xml.dao.impl;

import lombok.extern.slf4j.Slf4j;
import spring.ioc.xml.dao.XmlDao;

/**
 * @author add by huyingzhao
 * 2022-09-30 16:44
 */
@Slf4j
public class XmlDaoImpl implements XmlDao {
    public void xml() {
        log.info("call ioc.xml.dao.impl.XmlDaoImpl.xml");
    }
}