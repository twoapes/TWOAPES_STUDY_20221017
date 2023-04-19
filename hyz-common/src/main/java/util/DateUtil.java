package util;

import enums.ISO8601;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
     * @param str    str
     * @param format format
     * @return String to Date
     * @author add by huyingzhao
     * 2022-06-30 18:06
     */
    public static Date parse(String str, ISO8601 format) {
        if (StringUtil.isBlank(str)) {
            return null;
        }

        try {
            return getSimpleDateFormat(format).parse(str);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }

        return null;
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
     * @param date   date
     * @param format format
     * @return Date to String
     * @author add by huyingzhao
     * 2022-06-30 18:05
     */
    public static String format(Date date, ISO8601 format, TimeZone timeZone) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = getSimpleDateFormat(format);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }

    /**
     * @param date   date
     * @param format format
     * @return Date to String
     * @author add by huyingzhao
     * 2022-06-30 18:05
     */
    public static String format(Date date, ISO8601 format, Locale locale, TimeZone timeZone) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = getSimpleDateFormat(format, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
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

    /**
     * @param format format
     * @param locale locale
     * @return getSimpleDateFormat
     * @author add by huyingzhao
     * 2022-07-27 10:27
     */
    private static SimpleDateFormat getSimpleDateFormat(ISO8601 format, Locale locale) {
        return new SimpleDateFormat(format.value(), locale);
    }

    /**
     * @param year  year
     * @param month month
     * @param day   day
     * @return yyyyMMdd
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date get(int year, int month, int day) {
        return get(year, month, day, 0, 0, 0);
    }

    /**
     * @param year   year
     * @param month  month
     * @param day    day
     * @param hour   hour
     * @param minute minute
     * @param second second
     * @return yyyyMMdd HH:mm:ss
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date get(int year, int month, int day, int hour, int minute, int second) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * @return yyyyMMdd HH:mm:ss
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date getMinimum() {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * @return yyyyMMdd HH:mm:ss
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date getMaximum() {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * assign date
     *
     * @param day  negative numbers are calculated forward, and not back
     * @param date date
     * @return assignDate
     * @author add by huyingzhao
     * 2022-07-01 10:51
     */
    public static Date assignDate(int day, Date date) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * get year
     *
     * @return getYear
     * @author add by huyingzhao
     * 2022-07-01 11:01
     */
    public static int getYear(Date date) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * get month
     *
     * @return getMonth
     * @author add by huyingzhao
     * 2022-07-01 11:01
     */
    public static int getMonth(Date date) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * get day
     *
     * @return day
     * @author add by huyingzhao
     * 2022-07-01 11:01
     */
    public static int getDay(Date date) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get localDateTime
     *
     * @param date date
     * @return getLocalDateTime
     * @author add by huyingzhao
     * 2022-07-01 11:15
     */
    public static LocalDateTime getLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * get localTime
     *
     * @param date date
     * @return getLocalTime
     * @author add by huyingzhao
     * 2022-07-01 11:15
     */
    public static LocalTime getLocalTime(Date date) {
        if (date == null) {
            return null;
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * get localDate
     *
     * @param date date
     * @return getLocalDate
     * @author add by huyingzhao
     * 2022-07-01 11:15
     */
    public static LocalDate getLocalDate(Date date) {
        if (date == null) {
            return null;
        }

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * date difference(for day)
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @return getDiffForDay
     * @author add by huyingzhao
     * 2022-07-01 11:16
     */
    public static int getDiffForDay(Date startDate, Date endDate) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        Calendar startCalender = Calendar.getInstance();
        startCalender.setTime(startDate);
        Calendar endCalender = Calendar.getInstance();
        endCalender.setTime(endDate);
        long time = (endCalender.getTimeInMillis() - startCalender.getTimeInMillis());
        return (int) (time / (1000 * 60 * 60 * 24));
    }

    /**
     * date difference(for time)
     *
     * @param startDate startDate
     * @param endDate   endDate
     * @return getDiff
     * @author add by huyingzhao
     * 2022-07-01 11:16
     */
    public static String getDiff(Date startDate, Date endDate) {
        log.debug("nowTime:" + format(nowTime(), ISO8601.YYYY_MM_DD_HE_HMS));
        Calendar startCalender = Calendar.getInstance();
        startCalender.setTime(startDate);
        Calendar endCalender = Calendar.getInstance();
        endCalender.setTime(endDate);
        long time = (int) (endCalender.getTimeInMillis() - startCalender.getTimeInMillis());
        if (time < 0) {
            return "0 00:00:00";
        }
        Date date = nowTime();
        date.setTime(time);
        long day = time / (1000 * 60 * 60 * 24);
        long hour = time / (1000 * 60 * 60);
        long minute = time / (1000 * 60);
        long second = time / 1000;
        return day % lengthOfMonth(date) + " " + hour % 24 + ":" + minute % 60 + ":" + second % 24;
    }

    /**
     * length of year
     *
     * @param date date
     * @return lengthOfYear
     * @author add by huyingzhao
     * 2022-07-27 11:17
     */
    public static int lengthOfYear(Date date) {
        return getLocalDate(date).lengthOfYear();
    }

    /**
     * length of month
     *
     * @param date date
     * @return lengthOfMonth
     * @author add by huyingzhao
     * 2022-07-27 11:17
     */
    public static int lengthOfMonth(Date date) {
        return getLocalDate(date).lengthOfMonth();
    }

    /**
     * util.Date to sql.Date
     *
     * @param date date
     * @return getSqlDate
     * @author add by huyingzhao
     * 2022-07-07 13:45
     */
    public static java.sql.Date getSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
