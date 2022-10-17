package cases;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author add by huyingzhao
 * 2022-10-08 17:49
 * Precise use of floating point numbers
 */
@Slf4j
public class AccurateFloating {
    public static void accurateFloating(){
        double d1=2;
        double d2=1.1;
        log.info("inexact computing:2-1.1="+(d1-d2));
        BigDecimal bigDecimal1=BigDecimal.valueOf(d1);
        BigDecimal bigDecimal2=BigDecimal.valueOf(d2);
        log.info("accurate computation:2-1.1="+(bigDecimal1.subtract(bigDecimal2)));

    }
}
