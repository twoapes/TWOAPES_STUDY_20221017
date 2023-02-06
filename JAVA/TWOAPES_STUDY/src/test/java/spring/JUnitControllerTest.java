package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.ioc.xml.service.impl.XmlServiceImpl;

/**
 * junit
 *
 * @author huyingzhao
 * 2022-02-24 17:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ioc/xml.xml"})
public class JUnitControllerTest {
    @Autowired
    private XmlServiceImpl xmlService;

    /**
     * test XmlServiceImpl
     *
     * @author add by huyingzhao
     * 2022-09-02 12:52
     */
    @Test
    public void test() {
        xmlService.xml();
    }
}
