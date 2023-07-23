package ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ioc.junit.service.impl.XmlServiceImpl;

/**
 * @author add by huyingzhao
 * 2023-02-24 14:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ioc/xmlService.xml"})
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
