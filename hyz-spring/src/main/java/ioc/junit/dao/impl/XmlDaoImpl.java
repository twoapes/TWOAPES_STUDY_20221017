package ioc.junit.dao.impl;

import ioc.junit.dao.XmlDao;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-02-24 12:02
 */
@Slf4j
public class XmlDaoImpl implements XmlDao {
    public void xml() {
        log.info("ioc.junit.dao.impl.XmlDaoImpl.xml");
    }
}