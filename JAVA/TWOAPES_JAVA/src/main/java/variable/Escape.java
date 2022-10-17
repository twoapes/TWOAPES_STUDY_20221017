package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-05 17:28
 * escape character
 */
@Slf4j
public class Escape {
    public static void escape() {
        String stringBuilder = "windows line break:\\r\\n" + "\r\n" +
                "linux line feed:\\n" + "\n" +
                "java With line break:System.getProperty(\"line.separator\")" + System.getProperty("line.separator") +
                "double quote escape character:\\\"" +
                "single quote escape character:\\'" +
                "backslashes escape character:\\\\" +
                "tab character escape character:\\t";
        log.info(stringBuilder);
    }
}