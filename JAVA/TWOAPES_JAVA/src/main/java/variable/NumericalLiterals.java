package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-11 13:06
 * numerical literals
 */
@Slf4j
public class NumericalLiterals {
    public static void numericalLiterals() {
        byte a = 3;
        int b = 4;
        long l = 54321L;
        double d = 5.0D;
        float f = 100.2F;

        String stringBuilder = "integer direct quantity(byte):" + a + "\n" +
                "integer literals(int):" + b + "\n" +
                "integer literals(long):" + l + "\n" +
                "floating point literals(double):" + d + "\n" +
                "floating point literals(float):" + f + "\n";
        log.info(stringBuilder);
    }
}