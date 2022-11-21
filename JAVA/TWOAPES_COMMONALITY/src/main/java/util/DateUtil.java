package util;

import enums.ISO8601Enum;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

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
    public static Date parse(String str, ISO8601Enum format) {
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
    public static String format(Date date, ISO8601Enum format) {
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
    public static String format(Date date, ISO8601Enum format, TimeZone timeZone) {
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
    public static String format(Date date, ISO8601Enum format, Locale locale, TimeZone timeZone) {
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
    private static SimpleDateFormat getSimpleDateFormat(ISO8601Enum format) {
        return new SimpleDateFormat(format.value());
    }

    /**
     * @param format format
     * @param locale locale
     * @return getSimpleDateFormat
     * @author add by huyingzhao
     * 2022-07-27 10:27
     */
    private static SimpleDateFormat getSimpleDateFormat(ISO8601Enum format, Locale locale) {
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
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }


    /**
     * get days for month
     *
     * @param year  year
     * @param month month
     * @return getDaysForMonth
     * @author add by huyingzhao
     * 2022-11-16 13:58
     */
    public static int getDaysForMonth(int year, int month) {
        switch (month) {
            case 1 -> calendar.set(year, Calendar.JANUARY, 1);
            case 2 -> calendar.set(year, Calendar.FEBRUARY, 1);
            case 3 -> calendar.set(year, Calendar.MARCH, 1);
            case 4 -> calendar.set(year, Calendar.APRIL, 1);
            case 5 -> calendar.set(year, Calendar.MAY, 1);
            case 6 -> calendar.set(year, Calendar.JUNE, 1);
            case 7 -> calendar.set(year, Calendar.JULY, 1);
            case 8 -> calendar.set(year, Calendar.AUGUST, 1);
            case 9 -> calendar.set(year, Calendar.SEPTEMBER, 1);
            case 10 -> calendar.set(year, Calendar.OCTOBER, 1);
            case 11 -> calendar.set(year, Calendar.NOVEMBER, 1);
            default -> calendar.set(year, Calendar.DECEMBER, 1);
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * get weeks for year
     *
     * @param year year
     * @return getWeeksForYear
     * @author add by huyingzhao
     * 2022-11-16 14:03
     */
    public static int getWeeksForYear(int year) {
        calendar.set(year, Calendar.DECEMBER, 31);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        return getDaysForYear(calendar.getTime());
    }

    /**
     * get dates for year
     *
     * @param date date
     * @return getDaysForYear
     * @author add by huyingzhao
     * 2022-11-16 14:03
     */
    public static int getDaysForYear(Date date) {
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(7);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * get first day for week
     *
     * @param date date
     * @return getFirstDayForWeek
     * @author add by huyingzhao
     * 2022-11-16 14:07
     */
    public static Date getFirstDayForWeek(Date date) {
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        return calendar.getTime();
    }

    /**
     * get last day for week
     *
     * @param date date
     * @return getFirstDayForWeek
     * @author add by huyingzhao
     * 2022-11-16 14:07
     */
    public static Date getLastDayForWeek(Date date) {
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
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
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get hour
     *
     * @param date date
     * @return getHour
     * @author add by huyingzhao
     * 2022-11-16 13:56
     */
    public static int getHour(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR);
    }

    /**
     * get minute
     *
     * @param date date
     * @return getMinute
     * @author add by huyingzhao
     * 2022-11-16 13:55
     */
    public static int getMinute(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * get second
     *
     * @param date date
     * @return getSecond
     * @author add by huyingzhao
     * 2022-11-16 13:55
     */
    public static int getSecond(Date date) {
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * get week
     *
     * @param date date
     * @return getWeekDay
     * @author add by huyingzhao
     * 2022-11-16 13:55
     */
    public static int getWeekDay(Date date) {
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek - 1;
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

        calendar.setTime(date);
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

        calendar.setTime(date);
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

        calendar.setTime(date);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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

    /**
     * util.Date to sql.Timestamp
     *
     * @param date date
     * @return getSqlDate
     * @author add by huyingzhao
     * 2022-07-07 13:45
     */
    public static Timestamp getSqlTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * get current time for timeMillis
     *
     * @return getCurrentTimeMillis
     * @author add by huyingzhao
     * 2022-07-07 13:45
     */
    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * add for year
     *
     * @param date   date
     * @param amount amount
     * @return addYear
     * @author add by huyingzhao
     * 2022-11-16 14:17
     */
    public static Date addYear(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    /**
     * add for month
     *
     * @param date   date
     * @param amount amount
     * @return addMonth
     * @author add by huyingzhao
     * 2022-11-16 14:26
     */
    public static Date addMonth(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * add for week
     *
     * @param date   date
     * @param amount amount
     * @return addWeek
     * @author add by huyingzhao
     * 2022-11-16 14:27
     */
    public static Date addWeek(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    /**
     * add for day
     *
     * @param date   date
     * @param amount amount
     * @return addDay
     * @author add by huyingzhao
     * 2022-11-16 14:27
     */
    public static Date addDay(Date date, int amount) {
        return add(date, Calendar.DATE, amount);
    }

    /**
     * add for hour
     *
     * @param date   date
     * @param amount amount
     * @return addHour
     * @author add by huyingzhao
     * 2022-11-16 14:26
     */
    public static Date addHour(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    /**
     * add for minute
     *
     * @param date   date
     * @param amount amount
     * @return addMinute
     * @author add by huyingzhao
     * 2022-11-16 14:25
     */
    public static Date addMinute(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    /**
     * add for second
     *
     * @param date   date
     * @param amount amount
     * @return addSecond
     * @author add by huyingzhao
     * 2022-11-16 14:22
     */
    public static Date addSecond(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    /**
     * add for milliseconds
     *
     * @param date   date
     * @param amount amount
     * @return addMilliseconds
     * @author add by huyingzhao
     * 2022-11-16 14:21
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    /**
     * @param date   date
     * @param field  field
     * @param amount amount
     * @return add
     * @author add by huyingzhao
     * 2022-11-16 14:20
     */
    private static Date add(Date date, int field, int amount) {
        if (date == null) {
            log.error("date must not null: {}", date);
            return null;
        }

        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    /**
     * diff for time
     *
     * @param begin begin
     * @param end   end
     * @return diffTime
     * @author add by huyingzhao
     * 2022-11-16 14:37
     */
    public static long diffTime(Date begin, Date end) {
        return end.getTime() - begin.getTime();
    }

    /**
     * diff for second
     *
     * @param begin begin
     * @param end   end
     * @return diffSecond
     * @author add by huyingzhao
     * 2022-11-16 14:44
     */
    public static long diffSecond(Date begin, Date end) {
        return (end.getTime() - begin.getTime()) / 1000;
    }

    /**
     * diff for minute
     *
     * @param begin begin
     * @param end   end
     * @return diffMinute
     * @author add by huyingzhao
     * 2022-11-16 14:59
     */
    public static long diffMinute(Date begin, Date end) {
        return (end.getTime() - begin.getTime()) / 1000 / 60;
    }

    /**
     * diff for hour
     *
     * @param begin begin
     * @param end   end
     * @return diffHour
     * @author add by huyingzhao
     * 2022-11-16 14:54
     */
    public static long diffHour(Date begin, Date end) {
        return ((end.getTime() - begin.getTime()) / 1000 / 60 / 60);
    }


    /**
     * diff for day
     *
     * @param begin begin
     * @param end   end
     * @return diffDay
     * @author add by huyingzhao
     * 2022-11-16 14:51
     */
    public static long diffDay(Date begin, Date end) {
        if (begin == null || end == null) {
            return 0;
        }

        return ((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000));
    }

    /**
     * diff for month
     *
     * @param begin begin
     * @param end   end
     * @return diffMonth
     * @author add by huyingzhao
     * 2022-11-16 14:50
     */
    public static int diffMonth(Date begin, Date end) {
        if (begin == null || end == null) {
            return 0;
        }

        int month;
        int years = diffYear(begin, end);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(begin);
        c2.setTime(end);
        month = years * 12 + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));
        int days = c2.get(Calendar.DATE) - c1.get(Calendar.DATE);
        if (days > 0) {
            month = month + 1;
        }
        return month;
    }

    /**
     * diff for year
     *
     * @param begin begin
     * @param end   end
     * @return diffYear
     * @author add by huyingzhao
     * 2022-11-16 14:49
     */
    public static int diffYear(Date begin, Date end) {
        if (begin == null || end == null) {
            return 0;
        }

        return getYear(end) - getYear(begin);
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
    public static String diff(Date startDate, Date endDate) {
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
     * nowTime in [startTime, endTime]
     *
     * @param nowTime   nowTime
     * @param startTime startTime
     * @param endTime   endTime
     * @return isBetweenDate
     * @author add by huyingzhao
     * 2022-11-16 15:53
     */
    public static boolean isBetweenDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

    /**
     * month for one day
     *
     * @param date date
     * @return getMonthStart
     * @author add by huyingzhao
     * 2022-11-19 15:17
     */
    public static Date getMonthStart(Date date) {
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * month for last day
     *
     * @param date date
     * @return getMonthEnd
     * @author add by huyingzhao
     * 2022-11-19 15:17
     */
    public static Date getMonthEnd(Date date) {
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * @param date date
     * @return yyyyMMdd HH:mm:ss
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date getMinimum(Date date) {
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        return calendar.getTime();
    }

    /**
     * @param date date
     * @return yyyyMMdd HH:mm:ss
     * @author add by huyingzhao
     * 2022-07-01 9:33
     */
    public static Date getMaximum(Date date) {
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        return calendar.getTime();
    }
}
