package util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author add by huyingzhao
 * 2022-06-29 10:29
 * only computer related
 */
@Slf4j
public class ComputerUtil {

    /**
     * end
     *
     * @param begin please using System.currentTimeMillis()
     * @param desc  desc
     */
    public static void end(long begin, String desc) {
        double consuming = (System.currentTimeMillis() - begin);
        consuming = BigDecimal.valueOf(consuming).divide(BigDecimal.ONE, 2, RoundingMode.HALF_UP).doubleValue();
        double now;
        String str;
        if (consuming < 1000) {
            now = consuming;
            str = now + "millisecond";
        } else if (consuming >= 1000 && consuming < 1000 * 60) {
            now = (consuming / 1000);
            str = now + "second";
        } else if (consuming >= 1000 * 60 && consuming < 1000 * 60 * 60) {
            now = consuming / 1000 / 60;
            str = now + "minute";
        } else if (consuming >= 1000 * 60 * 60 && consuming < 1000 * 60 * 60 * 24) {
            now = consuming / 1000 / 60 / 60;
            str = now + "hour";
        } else if (consuming >= 1000 * 60 * 60 * 24 && consuming < 1000 * 60 * 60 * 24 * 365L) {
            now = consuming / 1000 / 60 / 60 / 24;
            str = now + "day";
        } else if (consuming >= 1000 * 60 * 60 * 24 * 365L && consuming < Double.MAX_VALUE - 1) {
            now = consuming / 1000 / 60 / 60 / 24 / 365;
            str = now + "year";
        } else {
            str = "error";
        }

        log.info("[" + desc + "]consuming:" + str);
    }
}
