package variable;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author add by huyingzhao
 * 2022-05-29 15:19
 * primitive type
 */
@Slf4j
public class PrimitiveType {
    public static void primitiveType() {
        StringBuilder stringBuilder=new StringBuilder("\n");
        // byte
        stringBuilder.append("primitive:byte number of bits:" + Byte.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Byte").append("\n");
        stringBuilder.append("minimum:Byte.MIN_VALUE=" + Byte.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Byte.MAX_VALUE=" + Byte.MAX_VALUE).append("\n\n");

        // short
        stringBuilder.append("primitive:short number of bits:" + Short.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Short").append("\n");
        stringBuilder.append("minimum:Short.MIN_VALUE=" + Short.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Short.MAX_VALUE=" + Short.MAX_VALUE).append("\n\n");

        // int
        stringBuilder.append("primitive:int number of bits:" + Integer.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Integer").append("\n");
        stringBuilder.append("minimum:Integer.MIN_VALUE=" + Integer.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Integer.MAX_VALUE=" + Integer.MAX_VALUE).append("\n\n");

        // long
        stringBuilder.append("primitive:long number of bits:" + Long.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Long").append("\n");
        stringBuilder.append("minimum:Long.MIN_VALUE=" + Long.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Long.MAX_VALUE=" + Long.MAX_VALUE).append("\n\n");

        // float
        stringBuilder.append("primitive:float number of bits:" + Float.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Float").append("\n");
        stringBuilder.append("minimum:Float.MIN_VALUE=" + Float.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Float.MAX_VALUE=" + Float.MAX_VALUE).append("\n\n");

        // double
        stringBuilder.append("primitive:double number of bits:" + Double.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Double").append("\n");
        stringBuilder.append("minimum:Double.MIN_VALUE=" + Double.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Double.MAX_VALUE=" + Double.MAX_VALUE).append("\n\n");

        // char
        stringBuilder.append("primitive:char number of bits:" + Character.SIZE).append("\n");
        stringBuilder.append("wrapper:java.lang.Character").append("\n");
        stringBuilder.append("minimum:Character.MIN_VALUE=" + Character.MIN_VALUE).append("\n");
        stringBuilder.append("maximum:Character.MAX_VALUE=" + Character.MAX_VALUE).append("\n\n");


        //float
        float floatValue = 1.4e-45f;
        //double
        double doubleValue = 4.9e-324;
        BigDecimal floatValueDecimal = BigDecimal.valueOf(floatValue);
        BigDecimal doubleValueDecimal = BigDecimal.valueOf(doubleValue);

        // scientific notation to unscientific notation
        stringBuilder.append("scientific notation(float):").append(floatValue).append("\tunscientific notation(float):").append(floatValueDecimal.toPlainString()).append("\n");
        stringBuilder.append("scientific notation(double):").append(doubleValue).append("\tunscientific notation(double):").append(doubleValueDecimal.toPlainString()).append("\n\n");

        //three special values returned by double and float
        stringBuilder.append("positive infinity:").append(Double.POSITIVE_INFINITY).append("\n");
        stringBuilder.append("negative infinity:").append(Double.NEGATIVE_INFINITY).append("\n");
        stringBuilder.append("NaN:").append(Double.NaN).append("\n\n");
//        stringBuilder.append(Double.isNaN(Math.sqrt(-2)));
        log.info(stringBuilder.toString());
    }
}