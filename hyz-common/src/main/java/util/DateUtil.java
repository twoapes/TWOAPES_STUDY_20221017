package util;

import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author add by huyingzhao
 * 2022-06-30 17:34
 * only date related
 */
@Slf4j
public class DateUtil {
    private static Calendar calendar;

    static {
        calendar = Calendar.getInstance();
    }

    /**
     * @return get now time
     * @author add by huyingzhao
     * 2022-06-30 18:06
     */
    public static Date nowTime() {
        calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    /**
     * @param date   date
     * @param format format
     * @return Date to String
     * @author add by huyingzhao
     * 2022-06-30 18:05
     */
    public static String format(Date date, ISO8601 format) {
        if (date == null) {
            return null;
        }

        return getSimpleDateFormat(format).format(date);
    }

    /**
     * @param format format
     * @return getSimpleDateFormat
     * @author add by huyingzhao
     * 2022-07-27 10:27
     */
    private static SimpleDateFormat getSimpleDateFormat(ISO8601 format) {
        return new SimpleDateFormat(format.value());
    }
}
