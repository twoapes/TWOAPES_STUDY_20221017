import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import variable.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-09-01 11:36
 * variable
 */
@Slf4j
public class VariableTest {
    /**
     * test scope
     *
     * @author add by huyingzhao
     * 2022-09-12 22:57
     */
    @Test
    public void ScopeTest() {
        int sumI = 0;
        for (int i = 0; i < 10; i++) {
            sumI += i;
        }

        log.info("sumI:" + sumI);

        // log.info("i:"+i);//Can't be used outside the block
        String[] args = new String[20];
        int sumJ = 0;
        for (int j = 0; j < 20; j++) {
//            sumJ += i + j;//i is outside
            sumJ += j;
            args[j] = String.valueOf(sumJ);
        }

        log.info(Arrays.toString(args));
    }

    /**
     * test variable type
     *
     * @author add by huyingzhao
     * 2022-09-12 23:00
     */
    @Test
    public void variableTypeTest() {
        VariableType.variableTypeStatic();
        VariableType type = new VariableType();
        type.variableType();
    }

    /**
     * test primitive type
     *
     * @author add by huyingzhao
     * 2022-09-12 23:04
     */
    @Test
    public void primitiveTypeTest() {
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
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * test numerical literals
     *
     * @author add by huyingzhao
     * 2022-09-12 23:04
     */
    @Test
    public void numericalLiteralsTest() {
        byte a = 3;
        int b = 4;
        long l = 54321L;
        double d = 5.0D;
        float f = 100.2F;

        String stringBuilder = "integer direct quantity(byte):" + a + "\n" +
                "integer literals(int):" + b + "\n" +
                "integer literals(long):" + l + "\n" +
                "floating point literals(double):" + d + "\n" +
                "floating point literals(float):" + f + "\n";
        log.info("stringBuilder :{}",stringBuilder);
    }

    /**
     * test math function
     *
     * @author add by huyingzhao
     * 2022-09-13 10:09
     */
    @Test
    public void mathFunctionTest() {
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
        log.info("stringBuilder :{}", stringBuilder);
    }

    /**
     * test big value
     *
     * @author add by huyingzhao
     * 2022-09-13 10:15
     */
    @Test
    public void bigValueTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        BigInteger bigInteger1 = BigInteger.valueOf(100);
        BigInteger bigInteger2 = BigInteger.valueOf(2);
        stringBuilder.append("bigInteger1:").append(bigInteger1).append("\t").append("bigInteger2:").append(bigInteger2).append("\n");
        stringBuilder.append("add:100+2=").append(bigInteger1.add(bigInteger2)).append("\n");
        stringBuilder.append("subtract:100-2=").append(bigInteger1.subtract(bigInteger2)).append("\n");
        stringBuilder.append("multiply:100*2=").append(bigInteger1.multiply(bigInteger2)).append("\n");
        stringBuilder.append("divide:100/2=").append(bigInteger1.divide(bigInteger2)).append("\n");
        stringBuilder.append("mod:100%2=").append(bigInteger1.mod(bigInteger2)).append("\n");

        stringBuilder.append("compare");
        if (bigInteger1.compareTo(bigInteger2) > 0) {
            stringBuilder.append("bigInteger1>=bigInteger2:").append(bigInteger1).append(">").append(bigInteger2).append("\n");
        } else if (bigInteger1.compareTo(bigInteger2) < 0) {
            stringBuilder.append("bigInteger1<bigInteger2:").append(bigInteger1).append("<").append(bigInteger2).append("\n");
        } else {
            stringBuilder.append("bigInteger1=bigInteger2:").append(bigInteger1).append("=").append(bigInteger2).append("\n");
        }

        log.info("stringBuilder :{}", stringBuilder);
    }

    /**
     * test force conversion
     *
     * @author add by huyingzhao
     * 2022-09-13 10:20
     */
    @Test
    public void ForceConversionTest() {
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
        log.info("stringBuilder :{}", stringBuilder);
    }

    /***
     * test escape
     *
     * @author add by huyingzhao
     * 2022-09-13 10:20
     */
    @Test
    public void escapeTest() {
        String stringBuilder = "windows line break:\\r\\n" + "\r\n" +
                "linux line feed:\\n" + "\n" +
                "java With line break:System.getProperty(\"line.separator\")" + System.getProperty("line.separator") +
                "double quote escape character:\\\"" +
                "single quote escape character:\\'" +
                "backslashes escape character:\\\\" +
                "tab character escape character:\\t";
        log.info("stringBuilder :{}", stringBuilder);
    }

    /**
     * test default value
     *
     * @author add by huyingzhao
     * 2022-09-13 10:38
     */
    @Test
    public void defaultValueTest() {
        DefaultValue.defaultValue();
    }

    /**
     * test character type
     *
     * @author add by huyingzhao
     * 2022-09-13 10:40
     */
    @Test
    public void characterTypeTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        char letter = 'A';
        char numChar = '4';
        stringBuilder.append("'A':").append(letter).append("\n");
        stringBuilder.append("'4':").append(numChar).append("\n");

        // char
        char ch = (char) 0XAB0041;
        stringBuilder.append("(char) 0XAB0041 transformation result:").append(ch).append("\n");
        char ch2 = (char) 65.25;
        stringBuilder.append("(char) 65.25 transformation result:").append(ch2).append("\n");
        int i = (int) 'A';
        stringBuilder.append("(int) 'A' transformation result:").append(i).append("\n");

        i = '2' + 'a';
        stringBuilder.append("'2' + 'a' computed result:").append(i).append("\n");
        i = 2 + 'a';
        stringBuilder.append("2 + 'a' computed result:").append(i).append("\n");
        log.info("stringBuilder :{}", stringBuilder);
    }

    /**
     * test block scope
     *
     * @author add by huyingzhao
     * 2022-09-13 10:42
     */
    @Test
    public void blockScopeTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int k = 100;
        {
            int j = 0;
            stringBuilder.append(j).append("\n");
        }

        stringBuilder.append(k).append("\n");
        // stringBuilder.append(j);
        log.info("stringBuilder :{}", stringBuilder);
    }

    /**
     * test automatic unpacking
     *
     * @author add by huyingzhao
     * 2022-09-13 10:42
     */
    @Test
    public void automaticUnpackingTest() {
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
        log.info("stringBuilder :{}", stringBuilder);
    }
}