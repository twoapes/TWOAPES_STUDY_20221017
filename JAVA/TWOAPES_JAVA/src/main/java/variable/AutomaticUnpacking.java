package variable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-11 15:20
 * auto boxing and auto unboxing
 */
@Slf4j
public class AutomaticUnpacking {
    public static void automaticUnpacking() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        // auto boxing
        Integer i = 1;
        stringBuilder.append("auto boxing:").append(i).append("\n");
        // auto unboxing
        int j = i;
        stringBuilder.append("auto unboxing:").append(j).append("\n");

        String s = "100";
        Integer integer = Integer.valueOf(s);
        stringBuilder.append("Integer to wrapper:").append(integer).append("\n");
        s = "101.2";
        Double aDouble = Double.valueOf(s);
        stringBuilder.append("Double to wrapper:").append(aDouble).append("\n");
        s = "true";
        Boolean b = Boolean.valueOf(s);
        stringBuilder.append("Boolean to wrapper:").append(b).append("\n");

        int intValue = integer;
        stringBuilder.append("int to base:").append(intValue).append("\n");
        double doubleValue = aDouble;
        stringBuilder.append("double to base:").append(doubleValue).append("\n");
        boolean booleanValue = b;
        stringBuilder.append("boolean to base:").append(booleanValue).append("\n");

        int x = 50;
        stringBuilder.append("binary:").append(Integer.toBinaryString(x)).append("\n");
        stringBuilder.append("octal:").append(Integer.toOctalString(x)).append("\n");
        stringBuilder.append("hex:").append(Integer.toHexString(x)).append("\n");

        Integer integer1 = Integer.valueOf(128);
        Integer integer2 = Integer.valueOf(128);
        stringBuilder.append("wrong method(==):").append(integer1 == integer2).append("\n");
        stringBuilder.append("correct method(equals):").append(integer1.equals(integer2)).append("\n");
        log.info(stringBuilder.toString());
    }
}