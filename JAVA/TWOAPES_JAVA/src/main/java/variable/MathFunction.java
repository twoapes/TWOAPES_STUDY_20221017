package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-05 23:08
 * math function
 */
@Slf4j
public class MathFunction {
    public static void mathFunction() {
        String stringBuilder =
                "square root calculations\n" +
                "4 square root:" + Math.sqrt(4) + "\n" +
                "12 square root:" + Math.sqrt(12) + "\n" +
                "0 square root:" + Math.sqrt(0) + "\n" +
                "negative no square root:" + Math.sqrt(-12) + "\n" +
                "calculation of power\n" +
                "4 pow 2:" + Math.pow(4, 2) + "\n" +
                "0 pow 0" + Math.pow(0, 0) + "\n" +
                "4 pow -2:" + Math.pow(4, -2) + "\n" +
                "trigonometric function calculation\n" +
                "sin90°:" + Math.sin(90) + "\n" +
                "sin45°:" + Math.sin(Math.PI / 2) + "\n" +
                "cos30°:" + Math.cos(30) + "\n" +
                "cos60°:" + Math.cos(0) + "\n" +
                "tan45°:" + Math.tan(45) + "\n" +
                "tan22.5°:" + Math.tan(Math.PI / 4) + "\n";
        log.info(stringBuilder);
    }
}