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
     * 毫秒（ms）：1毫秒等于1/1,000秒,通常用于衡量计算机处理速度、程序执行时间等。
     * 秒（s）：1秒等于1,000毫秒,通常用于衡量事件发生的持续时间、音频视频长度等。
     * 分钟（min）：1分钟等于60秒,通常用于衡量时间间隔或时长,如电影时长等。
     * 小时（h）：1小时等于60分钟,通常用于衡量时间间隔或时长,如工作时长等。
     * 天（d）：1天等于24小时,通常用于衡量日期间隔或持续时间,如假期时长等。
     * 周（wk）：1周等于7天,通常用于衡量日期间隔或持续时间,如休假时长等。
     * 月（mo）：1月的长度不固定,通常用于衡量日期间隔或持续时间,如租房合同期限等。
     * 年（y）：1年等于12个月,通常用于衡量日期间隔或持续时间,如人的年龄等。
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
            str = now + " ms";
        } else if (consuming >= 1000 && consuming < 1000 * 60) {
            now = (consuming / 1000);
            str = now + " s";
        } else if (consuming >= 1000 * 60 && consuming < 1000 * 60 * 60) {
            now = consuming / 1000 / 60;
            str = now + " min";
        } else if (consuming >= 1000 * 60 * 60 && consuming < 1000 * 60 * 60 * 24) {
            now = consuming / 1000 / 60 / 60;
            str = now + " h";
        } else if (consuming >= 1000 * 60 * 60 * 24 && consuming < 1000 * 60 * 60 * 24 * 365L) {
            now = consuming / 1000 / 60 / 60 / 24;
            str = now + " d";
        } else if (consuming >= 1000 * 60 * 60 * 24 * 365L && consuming < Double.MAX_VALUE - 1) {
            now = consuming / 1000 / 60 / 60 / 24 / 365;
            str = now + " y";
        } else {
            str = "error";
        }

        log.info("[{}] consuming: [{}]", desc, str);
    }
}
