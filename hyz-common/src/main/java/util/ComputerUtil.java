package util;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author add by huyingzhao
 * 2022-06-29 10:29
 * only computer related
 */
@Slf4j
public class ComputerUtil {

    /**
     * @param file     file/directory
     * @param isSelect isSelect
     */
    public static void open(final File file, final boolean isSelect) {
        final String os = System.getProperty("os.name");
        if (file != null) try {
            if (file.exists()) {
                if (os.toLowerCase().contains("windows")) {
                    Runtime runtime = Runtime.getRuntime();
                    String shell = "rundll32 SHELL32.DLL,ShellExec_RunDLL Explorer.exe /";
                    if (isSelect) {
                        if (file.isDirectory()) {
                            runtime.exec("," + file.getPath());
                        } else {
                            runtime.exec(shell + "select," + file.getPath());
                            runtime.exec(shell + "," + file.getPath());
                        }
                    } else {
                        runtime.exec(shell + "," + file.getPath());
                    }
                } else {
                    Desktop desktop = Desktop.getDesktop();
                    if (isSelect) {
                        desktop.open(file.getParentFile());
                        desktop.open(file);
                    } else {
                        desktop.open(file);
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * base for unit
     *
     * @param sizeBigDecimal sizeBigDecimal
     * @return unit
     */
    public static String unit(BigDecimal sizeBigDecimal) {
        if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(1)) < 0) {
            return along(sizeBigDecimal, 0);
        } else if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(2)) < 0) {
            return along(sizeBigDecimal, 1);
        } else if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(3)) < 0) {
            return along(sizeBigDecimal, 2);
        } else if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(4)) < 0) {
            return along(sizeBigDecimal, 3);
        } else if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(5)) < 0) {
            return along(sizeBigDecimal, 4);
        } else if (sizeBigDecimal.compareTo(BigDecimal.valueOf(1024).pow(6)) < 0 && (sizeBigDecimal.longValue() <= Long.MAX_VALUE - 1)) {
            return along(sizeBigDecimal, 5);
        } else {
            return BigDecimal.ZERO + "B";
        }
    }

    /**
     * @param ip ip
     * @return isConnectIp
     */
    public static boolean isConnectIp(String ip) {
        boolean status;
        if (ip != null) {
            try {
                status = InetAddress.getByName(ip).isReachable(3 * 1000);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                status = false;
            }
        } else {
            status = false;
        }

        return status;
    }

    /**
     * end
     * 毫秒（ms）：1毫秒等于1/1,000秒，通常用于衡量计算机处理速度、程序执行时间等。
     * 秒（s）：1秒等于1,000毫秒，通常用于衡量事件发生的持续时间、音频视频长度等。
     * 分钟（min）：1分钟等于60秒，通常用于衡量时间间隔或时长，如电影时长等。
     * 小时（h）：1小时等于60分钟，通常用于衡量时间间隔或时长，如工作时长等。
     * 天（d）：1天等于24小时，通常用于衡量日期间隔或持续时间，如假期时长等。
     * 周（wk）：1周等于7天，通常用于衡量日期间隔或持续时间，如休假时长等。
     * 月（mo）：1月的长度不固定，通常用于衡量日期间隔或持续时间，如租房合同期限等。
     * 年（y）：1年等于12个月，通常用于衡量日期间隔或持续时间，如人的年龄等。
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

    /**
     * @param sizeBigDecimal sizeBigDecimal
     * @param end            end
     * @return calculate in order
     */
    private static String along(BigDecimal sizeBigDecimal, int end) {
        if (end < 0) {
            return "";
        } else {
            if (sizeBigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                return "0" + level(end);
            } else {
                BigDecimal result = sizeBigDecimal;
                for (int i = 0; i < end; i++) {
                    if (result.compareTo(BigDecimal.ZERO) == 0) {
                        result = BigDecimal.ZERO;
                        break;
                    } else {
                        result = result.divide(BigDecimal.valueOf(1024.0), 2, RoundingMode.DOWN);
                    }
                }

                result = result.divide(BigDecimal.ONE, 2, RoundingMode.DOWN);
                return result + level(end);
            }
        }
    }

    /**
     * @param level level
     * @return init level
     */
    private static String level(int level) {
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(0, "B");
        stringMap.put(1, "KB");
        stringMap.put(2, "MB");
        stringMap.put(3, "GB");
        stringMap.put(4, "TB");
        stringMap.put(5, "PB");// PB is very big unit
        /// stringMap.put(6, "EB");
        /// stringMap.put(7, "ZB");
        /// stringMap.put(8, "YB");
        /// stringMap.put(9, "NB");
        /// stringMap.put(10, "DB");
        return stringMap.get(level);
    }

    /**
     * @param charset charset
     * @param content content
     * @return encodeAES
     */
    public static String encodeAES(Charset charset, String content) {
        final Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(content.getBytes(charset));
    }

    /**
     * @param charset charset
     * @param content content
     * @return decodeAES
     */
    public static String decodeAES(Charset charset, String content) {
        final Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(content), charset);
    }
}
