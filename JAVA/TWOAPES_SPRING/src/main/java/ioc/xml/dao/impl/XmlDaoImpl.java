package ioc.xml.dao.impl;

import ioc.xml.dao.XmlDao;
import lombok.extern.slf4j.Slf4j;

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