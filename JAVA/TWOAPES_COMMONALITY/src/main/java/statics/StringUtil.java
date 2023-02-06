package statics;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        return NumberUtils.numberToThousand(Double.parseDouble(num));
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
}