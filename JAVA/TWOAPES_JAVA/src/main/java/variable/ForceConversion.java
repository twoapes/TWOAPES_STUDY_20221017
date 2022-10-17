package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-11 14:47
 * type conversion
 */
@Slf4j
public class ForceConversion {
    public static void forceConversion() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        double x = 9.997;
        int nx = (int) x;
        stringBuilder.append("\n9.997 intercept results:").append(nx).append("\n");
        nx = (int) Math.round(x);
        stringBuilder.append("long to int:").append(nx).append("\n");
        byte b = (byte) 300;
        stringBuilder.append("byte maximum:" + Byte.MAX_VALUE).append("\n");
        stringBuilder.append("if out byte maximum:such as b=300==>").append(b).append("\n");
        double d = (Math.random() + 2);
        stringBuilder.append("using a random:").append(d).append("\n");
        boolean is = d <= 2.7;
        double i = is ? 0 : 1;
        stringBuilder.append("if i less than 2.7 then 0 else 1").append(i).append("\n");
        log.info(stringBuilder.toString());
    }
}