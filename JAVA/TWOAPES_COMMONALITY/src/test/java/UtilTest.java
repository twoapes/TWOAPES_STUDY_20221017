import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import statics.*;

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
        log.info(String.valueOf(DateUtils.get(2022, 7, 27)));
        log.info(String.valueOf(DateUtils.get(2022, 7, 27, 11, 11, 11)));
        log.info("getMinimum" + DateUtils.getMinimum());
        log.info("getMaximum:" + DateUtils.getMaximum());
        log.info("assignDate1:" + DateUtils.assignDate(1, DateUtils.nowTime()));
        log.info("assignDate2:" + DateUtils.assignDate(-1, DateUtils.nowTime()));
        log.info("getYear:" + DateUtils.getYear(DateUtils.nowTime()));
        log.info("getMonth:" + DateUtils.getMonth(DateUtils.nowTime()));
        log.info("getDay:" + DateUtils.getDay(DateUtils.nowTime()));
        log.info("getLocalDateTime:" + DateUtils.getLocalDateTime(DateUtils.nowTime()));
        log.info("getLocalTime:" + DateUtils.getLocalTime(DateUtils.nowTime()));
        log.info("getLocalDate:" + DateUtils.getLocalDate(DateUtils.nowTime()));
        log.info("getDiffForDay:" + DateUtils.getDiffForDay(DateUtils.get(2022, 7, 27, 11, 11, 11), DateUtils.nowTime()));
        log.info("getDiff:" + DateUtils.getDiff(DateUtils.get(2022, 7, 22, 11, 1, 10), DateUtils.get(2022, 7, 23, 11, 1, 11)));
        log.info("lengthOfYear:" + DateUtils.lengthOfYear(DateUtils.nowTime()));
        log.info("lengthOfMonth:" + DateUtils.lengthOfMonth(DateUtils.nowTime()));
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
        log.info("numberToThousand:" + NumberUtils.numberToThousand(51233.1415926));
        log.info("numberToThousand:" + NumberUtils.numberToThousand(123456));
        log.info("thousandToNumber:" + NumberUtils.thousandToNumber("123,456"));
        log.info("add:" + NumberUtils.add(12, 12));
        log.info("multiply:" + NumberUtils.multiply(12, 12));
    }

    /**
     * test StringUtils
     *
     * @author add by huyingzhao
     * 2022-07-27 11:38
     */
    @Test
    public void stringUtilsTest() {
        log.info(StringUtils.stringToThousand("123456"));

        String str = "english:ENGLISH,java:JAVA,idiom:IDIOM";
        log.info(StringUtils.toMap(str).toString());

        for (String s : StringUtils.stringToList(CharsetUtil.UTF_8, "123\n456\n789")) {
            log.info(s);
        }
    }

    /**
     * test local
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
        String e = ComputerUtils.encodeAES(CharsetUtil.UTF_8, "test");
        String d = ComputerUtils.decodeAES(CharsetUtil.UTF_8, e);
        log.info("encode:" + e);
        log.info("decode:" + d);
    }
}