package statics;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2022-06-29 10:36
 */
@Slf4j
public class NumberUtils {

    /**
     * number to a thousand
     *
     * @param number number
     * @return numberToThousand
     */
    public static String numberToThousand(Number number) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    /**
     * a thousand to number
     *
     * @param thousand a thousand
     * @return thousandToNumber
     */
    public static Number thousandToNumber(String thousand) {
        Number number = 0;
        try {
            number = NumberFormat.getNumberInstance(Locale.getDefault()).parse(thousand);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }

        return number;
    }

    /**
     * addition and subtraction d1±d2±d3±d4
     *
     * @param d1 d1
     * @param d2 d2
     * @param d3 d3
     * @param d4 d4
     * @return add
     */
    public static double add(Number d1, Number d2, Number d3, Number d4) {
        BigDecimal bigDecimal = NumberInside.add(NumberInside.add(NumberInside.add(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue())),
                BigDecimal.valueOf(d3.doubleValue())), BigDecimal.valueOf(d4.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * addition and subtraction d1±d2±d3
     *
     * @param d1 d1
     * @param d2 d2
     * @param d3 d3
     * @return add
     */
    public static double add(Number d1, Number d2, Number d3) {
        BigDecimal bigDecimal = NumberInside.add(NumberInside.add(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue())),
                BigDecimal.valueOf(d3.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * addition and subtraction d1±d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return add
     */
    public static double add(Number d1, Number d2) {
        BigDecimal bigDecimal = NumberInside.add(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * multiply d1*d2*d3*d4
     *
     * @param d1 d1
     * @param d2 d2
     * @param d3 d3
     * @param d4 d4
     * @return multiply
     */
    public static double multiply(Number d1, Number d2, Number d3, Number d4) {
        return multiply(multiply(multiply(d1, d2), d3), d4);
    }

    /**
     * multiply d1*d2*d3
     *
     * @param d1 d1
     * @param d2 d2
     * @param d3 d3
     * @return multiply
     */
    public static double multiply(Number d1, Number d2, Number d3) {
        return multiply(multiply(d1, d2), d3);
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return multiply
     */
    public static double multiply(Number d1, Number d2) {
        BigDecimal bigDecimal = NumberInside.multiply(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue()));
        return bigDecimal.doubleValue();
    }
}

class NumberInside {
    /**
     * addition and subtraction d1±d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return add
     */
    protected static BigDecimal add(BigDecimal d1, BigDecimal d2) {
        return d1.add(d2);
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return multiply
     */
    protected static BigDecimal multiply(BigDecimal d1, BigDecimal d2) {
        return d1.multiply(d2);
    }
}
