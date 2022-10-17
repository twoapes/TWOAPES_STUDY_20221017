package constant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-07-10 16:32
 * constant
 */
@Slf4j
public class Constant {
    /**
     * @author add by huyingzhao
     * 2022-08-04 11:39
     */
    public static void constant() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        final double PI = Math.PI;
        double radius = 20;
        double area = radius * radius * PI;
        stringBuilder.append("round's radius:").append(radius).append(" area is ").append(area);

        radius = 30;
        area = radius * radius * PI;
        stringBuilder.append("round's radius:").append(radius).append(" area is ").append(area);
        log.info(stringBuilder.toString());
    }
}
