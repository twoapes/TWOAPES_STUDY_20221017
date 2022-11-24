import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.*;

/**
 * @author add by huyingzhao
 * 2022-09-01 18:03
 */
@Slf4j
public class UtilTest {
    /**
     * test DateUtils
     *
     * @author add by huyingzhao
     * 2022-07-27 11:38
     */
    @Test
    public void dateUtilsTest() {
        log.info(String.valueOf(DateUtil.get(2022, 7, 27)));
        log.info(String.valueOf(DateUtil.get(2022, 7, 27, 11, 11, 11)));
        log.info("addDay1:" + DateUtil.addDay(DateUtil.nowTime(), 1));
        log.info("addDay2:" + DateUtil.addDay(DateUtil.nowTime(), -1));
        log.info("getYear:" + DateUtil.getYear(DateUtil.nowTime()));
        log.info("getMonth:" + DateUtil.getMonth(DateUtil.nowTime()));
        log.info("getDay:" + DateUtil.getDay(DateUtil.nowTime()));
        log.info("getLocalDateTime:" + DateUtil.getLocalDateTime(DateUtil.nowTime()));
        log.info("getLocalTime:" + DateUtil.getLocalTime(DateUtil.nowTime()));
        log.info("getLocalDate:" + DateUtil.getLocalDate(DateUtil.nowTime()));
        log.info("diffDay:" + DateUtil.diffDay(DateUtil.get(2022, 7, 27, 11, 11, 11), DateUtil.nowTime()));
        log.info("diff:" + DateUtil.diff(DateUtil.get(2022, 7, 22, 11, 1, 10), DateUtil.get(2022, 7, 23, 11, 1, 11)));
        log.info("lengthOfYear:" + DateUtil.lengthOfYear(DateUtil.nowTime()));
        log.info("lengthOfMonth:" + DateUtil.lengthOfMonth(DateUtil.nowTime()));
    }

    /**
     * test RandomUtil
     * test NumberUtils
     *
     * @author add by huyingzhao
     * 2022-07-27 11:38
     */
    @Test
    public void numberTest() {
        log.info("longRandom:" + RandomUtil.longRandom(5));
        log.info("numberToThousand:" + NumberUtil.numberToThousand(51233.1415926));
        log.info("numberToThousand:" + NumberUtil.numberToThousand(123456));
        log.info("thousandToNumber:" + NumberUtil.thousandToNumber("123,456"));
        log.info("add:" + NumberUtil.add(12, 12));
        log.info("multiply:" + NumberUtil.multiply(12, 12));
    }

    /**
     * test StringUtils
     *
     * @author add by huyingzhao
     * 2022-07-27 11:38
     */
    @Test
    public void stringUtilsTest() {
        log.info(StringUtil.stringToThousand("123456"));

        String str = "english:ENGLISH,java:JAVA,idiom:IDIOM";
        log.info(StringUtil.toMap(str).toString());

        for (String s : StringUtil.stringToList(CharsetUtil.UTF_8, "123\n456\n789")) {
            log.info(s);
        }
    }

    /**
     * test local
     *
     * @author method add by huyingzhao
     * 2022-10-13 16:06
     */
    @Test
    public void localTest() {
        log.info("getLocalPort:" + LocalUtil.getLocalPort());
        log.info("getLocalIP:" + LocalUtil.getLocalIP());
    }

    /**
     * test ComputerUtils
     *
     * @author add by huyingzhao
     * 2022-07-27 11:38
     */
    @Test
    public void computerUtilsTest() {
        String e = ComputerUtil.encodeAES(CharsetUtil.UTF_8, "test");
        String d = ComputerUtil.decodeAES(CharsetUtil.UTF_8, e);
        log.info("encode:" + e);
        log.info("decode:" + d);
    }
}