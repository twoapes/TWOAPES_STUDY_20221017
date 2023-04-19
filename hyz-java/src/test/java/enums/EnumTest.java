package enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @author add by huyingzhao
 * 2023-03-11 13:04
 */
@Slf4j
public class EnumTest {

    /**
     * 使用enum定义枚举类
     *
     * @author add by huyingzhao
     * 2023-03-12 00:09
     */
    @Test
    public void customTest() {
        log.info("name:{}", CustomEnum.ONE.name());
        log.info("value:{}", CustomEnum.ONE.value());
    }

    @Test
    public void randomDay() {
        DayEnum day = getRandomDay();
        switch (day) {
            case MONDAY:
                log.info("今天是星期一。");
                break;
            case TUESDAY:
                log.info("今天是星期二。");
                break;
            case WEDNESDAY:
                log.info("今天是星期三。");
                break;
            case THURSDAY:
                log.info("今天是星期四。");
                break;
            case FRIDAY:
                log.info("今天是星期五。");
                break;
            case SATURDAY:
                log.info("今天是星期六。");
                break;
            case SUNDAY:
                log.info("今天是星期日。");
                break;
            default:
                log.info("无效的日期。");
                break;
        }
    }

    public DayEnum getRandomDay() {
        Random random = new Random();
        int index = random.nextInt(DayEnum.values().length);
        return DayEnum.values()[index];
    }
}
