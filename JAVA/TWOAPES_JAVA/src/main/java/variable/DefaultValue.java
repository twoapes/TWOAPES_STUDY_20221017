package variable;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-05 13:42
 * default value
 */
@Slf4j
@Setter
public class DefaultValue {
    private static int a;
    private static byte b;
    private static short c;
    private static long d;
    private static double aDouble;
    private static float bFloat;
    private static char aChar;
    private static boolean is;
    private static Object object;
    private static String string;

    public static void defaultValue() {
        String stringBuilder = "int default value:" + a + "\n" +
                "byte default value:" + b + "\n" +
                "short default value:" + c + "\n" +
                "long default value:" + d + "\n" +
                "double default value:" + aDouble + "\n" +
                "float default value:" + bFloat + "\n" +
                "char default value:" + aChar + "\n" +
                "boolean default value:" + is + "\n" +
                "object default value:" + object + "\n" +
                "String default value" + string + "\n";
        log.info(stringBuilder);
    }
}
