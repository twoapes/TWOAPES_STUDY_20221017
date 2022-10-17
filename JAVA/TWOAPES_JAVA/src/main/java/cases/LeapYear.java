package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 18:01
 * determine whether it is a leap year
 */
@Slf4j
public class LeapYear {
    public static void leapYear(int year) {
        log.info(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "leap year" : "non leap year");
    }
}
