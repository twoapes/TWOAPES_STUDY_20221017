package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 16:53
 * automatic and cast type conversions
 */
@Slf4j
public class TypeConversion {
    public static void typeConversion() {
        byte b = 127;
        char c = 'W' ;
        short s = 23561;
        int i = 3333;
        long l = 400000L;
        float f = 3.14159F;
        double d = 54.523;
        log.info("b=" + b);
        log.info("b+c=" + (b + c));
        log.info("b+c+s=" + (b + c + s));
        log.info("b+c+s+i=" + (b + c + s + i));
        log.info("b+c+s+i+l=" + (b + c + s + i + l));
        log.info("b+c+s+i+l+f=" + (b + c + s + i + l + f));
        log.info("b+c+s+i+l+f+d=" + (b + c + s + i + l + f + d));
        log.info("long to int:" + (int) l);
        log.info("double to short:" + (short) l);
        log.info("double to int:" + (int) d);
        log.info("short to char:" + (char) s);
    }
}
