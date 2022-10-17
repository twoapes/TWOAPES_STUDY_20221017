import ioc.xml.service.impl.XmlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit
 *
 * @author huyingzhao
 * 2022-02-24 17:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ioc/xml.xml"})
@Slf4j
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
