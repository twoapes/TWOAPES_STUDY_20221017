package util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author add by huyingzhao
 * 2022-06-07 21:37
 * String execute
 */
@Slf4j
public class StringUtil extends org.apache.commons.lang3.StringUtils {
    /**
     * @param charset charset
     * @param str     copy content(every line)
     * @return stringToList
     * @author add by huyingzhao
     * 2022-06-07 21:40
     */
    public static List<String> stringToList(Charset charset, String str) {
        ArrayList<String> strings = new ArrayList<>();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(charset));
             InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return strings;
    }

    /**
     * hump to turned underline
     *
     * @param cameCase cameCase
     * @return toTurnedLine
     * @author add by huyingzhao
     * 2022-06-29 15:56
     */
    public static String toTurnedLine(String cameCase) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(cameCase);
        StringBuilder stringBuilder = new StringBuilder("\n");
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "_" + matcher.group(0).toLowerCase(Locale.ROOT));
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * String to a thousand
     *
     * @param num num
     * @return stringToThousand
     */
    public static String stringToThousand(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }

        return NumberUtil.numberToThousand(Double.parseDouble(num));
    }

    /**
     * final String to Map,such as english:ENGLISH,java:JAVA,idiom:IDIOM
     *
     * @param string string
     * @return toMap
     * @author add by huyingzhao
     * 2022-09-13 21:03
     */
    public static Map<String, String> toMap(String string) {
        Map<String, String> map = new HashMap<>();
        if (string == null || string.isEmpty()) {
            return map;
        }

        if (!string.contains(",")) {
            return map;
        }

        if (!string.contains(":")) {
            return map;
        }

        String[] strings = string.split(",");
        for (String s : strings) {
            String[] m = s.split(":");
            String key = m[0];
            String value = m[1];
            map.put(key, value);
        }

        return map;
    }

    /**
     * @param str str
     * @return to utf-8
     * @author add by huyingzhao
     * 2022-11-15 17:44
     */
    public static String toUTF_8(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes(StandardCharsets.UTF_8);
                } catch (Exception e) {
                    log.info(e.getMessage(), e);
                    b = new byte[0];
                }

                for (int value : b) {
                    int k = value;
                    if (k < 0)
                        k += 256;
                    sb.append("%").append(Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    /**
     * @param str str
     * @return line to hump
     * @author add by huyingzhao
     * 2022-11-15 17:59
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * @param str str
     * @return hump to line
     * @author add by huyingzhao
     * 2022-11-15 18:00
     */
    public static String humpToLine(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    /**
     * @param s s
     * @return first one to lower case
     * @author add by huyingzhao
     * 2022-11-15 18:01
     */
    public static String firstOneToLower(String s) {
        if (org.apache.commons.lang3.StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return Character.toLowerCase(s.charAt(0)) + s.substring(1);
        }
    }

    /**
     * @param s s
     * @return first one to upper case
     * @author add by huyingzhao
     * 2022-11-15 18:01
     */
    public static String firstOneToUpper(String s) {
        if (org.apache.commons.lang3.StringUtils.isBlank(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
    }

    /**
     * @param object object
     * @return Object to String
     * @author add by huyingzhao
     * 2022-11-15 18:04
     */
    public static String getString(Object object) {
        if (null == object) {
            return "";
        }

        try {
            return object.toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * @param object object
     * @return String to Integer
     * @author add by huyingzhao
     * 2022-11-15 18:06
     */
    public static int getInt(String object) {
        if (null == object) {
            return 0;
        }
        try {
            return Integer.parseInt(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * @param object object
     * @return String to Boolean
     * @author add by huyingzhao
     * 2022-11-15 18:07
     */
    public static boolean getBoolean(String object) {
        if (null == object) {
            return false;
        }
        try {
            return Boolean.parseBoolean(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * @param a a
     * @param b b
     * @return equals
     * @author add by huyingzhao
     * 2022-11-15 18:11
     */
    public static boolean equals(String a, String b) {
        return Objects.equals(a, b);

    }

    /**
     * @param a a
     * @param b b
     * @return equalsIgnoreCase
     * @author add by huyingzhao
     * 2022-11-15 18:11
     */
    public static boolean equalsIgnoreCase(String a, String b) {
        return a == null ? b == null : a.equalsIgnoreCase(b);
    }

    /**
     * @param obj obj
     * @param fun fun
     * @param <T> <T>
     * @return ifNoNull
     * @author add by huyingzhao
     * 2022-11-15 18:15
     */
    public static <T> String ifNoNull(T obj, Function<T, String> fun) {
        if (obj != null) {
            return fun.apply(obj);
        }

        return null;
    }

    /**
     * @param src   src
     * @param start start
     * @param to    to
     * @return sub String
     * @author add by huyingzhao
     * 2022-11-15 18:31
     */
    public static String subString(String src, String start, String to) {
        int indexFrom = start == null ? 0 : src.indexOf(start);
        int indexTo = to == null ? src.length() : src.indexOf(to);
        if (indexFrom >= 0 && indexTo >= 0 && indexFrom <= indexTo) {
            if (null != start) {
                indexFrom += start.length();
            }

            return src.substring(indexFrom, indexTo);
        } else {
            return null;
        }
    }

    /**
     * @param src    src
     * @param start  start
     * @param to     to
     * @param toLast toLast
     * @return sub String
     * @author add by huyingzhao
     * 2022-11-15 18:31
     */
    public static String subString(String src, String start, String to, boolean toLast) {
        if (!toLast) {
            return subString(src, start, to);
        } else {
            int indexFrom = start == null ? 0 : src.indexOf(start);
            int indexTo = to == null ? src.length() : src.lastIndexOf(to);
            if (indexFrom >= 0 && indexTo >= 0 && indexFrom <= indexTo) {
                if (null != start) {
                    indexFrom += start.length();
                }

                return src.substring(indexFrom, indexTo);
            } else {
                return null;
            }
        }
    }

    /**
     * @param str   str
     * @param start start
     * @param end   end
     * @return sub String
     */
    public static String subString(final String str, int start, int end) {
        if (str == null) {
            return "";
        }

        if (end < 0) {
            end = str.length() + end;
        }

        if (start < 0) {
            start = str.length() + start;
        }

        if (end > str.length()) {
            end = str.length();
        }

        if (start > end) {
            return "";
        }

        if (start < 0) {
            start = 0;
        }

        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * @param str str
     * @return split for comma Long
     * @author add by huyingzhao
     * 2022-11-15 18:22
     */
    public static List<Long> splitToLongList(String str) {
        if (isEmpty(str)) {
            return null;
        }

        return Arrays.stream(split(str, ",")).map(String::trim).map(Long::valueOf).collect(Collectors.toList());
    }

    /**
     * @param str str
     * @return split for comma Integer
     * @author add by huyingzhao
     * 2022-11-15 18:22
     */
    public static List<Integer> splitToIntegerList(String str) {
        if (isEmpty(str)) {
            return null;
        }

        return Arrays.stream(split(str, ",")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * @param str str
     * @return split for comma String
     * @author add by huyingzhao
     * 2022-11-15 18:26
     */
    public static List<String> splitToStringList(String str) {
        if (isEmpty(str)) {
            return null;
        }

        return Arrays.stream(split(str, ",")).map(String::trim).collect(Collectors.toList());
    }

    /**
     * @param str str
     * @return split for comma String
     * @author add by huyingzhao
     * 2022-11-15 18:26
     */
    public static Set<String> splitToStringSet(String str) {
        if (isEmpty(str)) {
            return null;
        }

        return Arrays.stream(split(str, ",")).map(String::trim).collect(Collectors.toSet());
    }

    /**
     * @author add by huyingzhao
     * 2022-11-15 18:40
     * @param value value
     * @return is empty for CharSequence
     */
    public static boolean isEmpty(CharSequence value) {
        return value == null || value.length() == 0;
    }
    /**
     * @author add by huyingzhao
     * 2022-11-15 18:40
     * @param value value
     * @return is empty for Object
     */
    public static boolean isEmpty(Object value) {
        return value == null || value.toString().trim().length() == 0;
    }
    /**
     * @author add by huyingzhao
     * 2022-11-15 18:40
     * @param value value
     * @return is blank for Object
     */
    public static boolean isBlank(Object value) {
        return value == null || value.toString().length() == 0;
    }

    /**
     * @param str str
     * @return isNumber
     * @author add by huyingzhao
     * 2022-11-15 18:39
     */
    public static boolean isNumber(String str) {
        if (isEmpty(str)) {
            return false;
        } else {
            char[] chars = str.toCharArray();
            int sz = chars.length;
            boolean hasExp = false;
            boolean hasDecPoint = false;
            boolean allowSigns = false;
            boolean foundDigit = false;
            int start = chars[0] == '-' ? 1 : 0;
            int i;
            if (sz > start + 1 && chars[start] == '0' && chars[start + 1] == 'x') {
                i = start + 2;
                if (i == sz) {
                    return false;
                } else {
                    while (i < chars.length) {
                        if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f')
                                && (chars[i] < 'A' || chars[i] > 'F')) {
                            return false;
                        }

                        ++i;
                    }

                    return true;
                }
            } else {
                --sz;

                for (i = start; i < sz || i < sz + 1 && allowSigns && !foundDigit; ++i) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        foundDigit = true;
                        allowSigns = false;
                    } else if (chars[i] == '.') {
                        if (hasDecPoint || hasExp) {
                            return false;
                        }

                        hasDecPoint = true;
                    } else if (chars[i] != 'e' && chars[i] != 'E') {
                        if (chars[i] != '+' && chars[i] != '-') {
                            return false;
                        }

                        if (!allowSigns) {
                            return false;
                        }

                        allowSigns = false;
                        foundDigit = false;
                    } else {
                        if (hasExp) {
                            return false;
                        }

                        if (!foundDigit) {
                            return false;
                        }

                        hasExp = true;
                        allowSigns = true;
                    }
                }

                if (i < chars.length) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        return true;
                    } else if (chars[i] != 'e' && chars[i] != 'E') {
                        if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
                            return foundDigit;
                        } else if (chars[i] != 'l' && chars[i] != 'L') {
                            return false;
                        } else {
                            return foundDigit && !hasExp;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return !allowSigns && foundDigit;
                }
            }
        }
    }

    /**
     * @param str str
     * @return trim
     * @author add by huyingzhao
     * 2022-11-15 18:39
     */
    public static String trim(String str) {
        return str != null ? str.trim() : null;
    }

    /**
     * @author add by huyingzhao
     * 2022-11-15 18:41
     * @param map map
     * @return is null or empty for Map
     */
    public static Boolean isNullOrEmpty(Map<?,?> map) {
        return null == map || map.isEmpty();
    }

    /**
     * @author add by huyingzhao
     * 2022-11-15 18:41
     * @param str str
     * @return is null or empty for String
     */
    public static Boolean isNullOrEmpty(String str) {
        return null == str || str.isEmpty();
    }

    /**
     * @author add by huyingzhao
     * 2022-11-15 18:41
     * @param strings strings
     * @return is null or empty for more String
     */
    public static Boolean isNullOrEmpty(String... strings) {
        for (String aStr : strings) {
            if (aStr == null || aStr.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}