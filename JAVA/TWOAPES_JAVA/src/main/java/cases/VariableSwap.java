package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 17:57
 * Variable exchange (no use of the third variable)
 */
@Slf4j
public class VariableSwap {
    public static void variableSwap() {
        int a = 2;
        int b = 3;
        log.info("before replacement\ta:" + a + "\t:" + b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        log.info("after replacement\ta:" + a + "\t:" + b);
    }
}
