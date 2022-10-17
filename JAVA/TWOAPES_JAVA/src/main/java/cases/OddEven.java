package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 17:41
 * using ternary operator judge parity
 */
@Slf4j
public class OddEven {
    public static void oddEven() {
        int m = (int) (Math.random() * 3 + 2);
        log.info(m % 2 == 0 ? "even" : "odd");
    }
}
