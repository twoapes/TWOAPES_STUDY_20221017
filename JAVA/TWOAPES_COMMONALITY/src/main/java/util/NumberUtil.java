package util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author add by huyingzhao
 * 2022-06-29 10:36
 */
@Slf4j
public class NumberUtil {

    /**
     * number to a thousand
     *
     * @param number number
     * @return String
     */
    public static String numberToThousand(Number number) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }

    /**
     * a thousand to number
     *
     * @param thousand a thousand
     * @return Number
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
     * addition and subtraction d1±d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double add(Number d1, Number d2) {
        BigDecimal bigDecimal = NumberInside.add(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * addition and subtraction d1±d2±d3±...
     *
     * @param d d
     * @return double
     */
    public static double add(Number... d) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (Number number : d) {
            bigDecimal = NumberInside.add(bigDecimal, BigDecimal.valueOf(number.doubleValue()));
        }

        return bigDecimal.doubleValue();
    }

    /**
     * addition and subtraction d1±d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double add(String d1, String d2) {
        BigDecimal bigDecimal = NumberInside.add(roundKeepTWO(d1), roundKeepTWO(d2));
        return bigDecimal.doubleValue();
    }

    /**
     * addition and subtraction d1±d2±d3±...
     *
     * @param d d
     * @return double
     */
    public static double add(String... d) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (String number : d) {
            bigDecimal = NumberInside.add(bigDecimal, roundKeepTWO(number));
        }

        return bigDecimal.doubleValue();
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double multiply(Number d1, Number d2) {
        BigDecimal bigDecimal = NumberInside.multiply(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * multiply d1*d2*d3*...
     *
     * @param d d
     * @return double
     */
    public static double multiply(Number... d) {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (Number number : d) {
            bigDecimal = NumberInside.multiply(bigDecimal, BigDecimal.valueOf(number.doubleValue()));
        }

        return bigDecimal.doubleValue();
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double multiply(String d1, String d2) {
        BigDecimal bigDecimal = NumberInside.multiply(roundKeepTWO(d1), roundKeepTWO(d2));
        return bigDecimal.doubleValue();
    }

    /**
     * multiply d1*d2*d3*...
     *
     * @param d d
     * @return double
     */
    public static double multiply(String... d) {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (String number : d) {
            bigDecimal = NumberInside.multiply(bigDecimal, roundKeepTWO(number));
        }

        return bigDecimal.doubleValue();
    }


    /**
     * divide d1/d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double divide(Number d1, Number d2) {
        BigDecimal bigDecimal = NumberInside.divide(BigDecimal.valueOf(d1.doubleValue()), BigDecimal.valueOf(d2.doubleValue()));
        return bigDecimal.doubleValue();
    }

    /**
     * divide d1/d2/d3/...
     *
     * @param d d
     * @return double
     */
    public static double divide(Number... d) {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (Number number : d) {
            bigDecimal = NumberInside.divide(bigDecimal, BigDecimal.valueOf(number.doubleValue()));
        }

        return bigDecimal.doubleValue();
    }

    /**
     * divide d1/d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return double
     */
    public static double divide(String d1, String d2) {
        BigDecimal bigDecimal = NumberInside.divide(roundKeepTWO(d1), roundKeepTWO(d2));
        return bigDecimal.doubleValue();
    }

    /**
     * divide d1/d2/d3/...
     *
     * @param d d
     * @return double
     */
    public static double divide(String... d) {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (String number : d) {
            bigDecimal = NumberInside.divide(bigDecimal, roundKeepTWO(number));
        }

        return bigDecimal.doubleValue();
    }

    /**
     * compare
     *
     * @param a a
     * @param c c
     * @param b b
     * @return boolean
     */
    public static boolean compareTo(String a, String c, String b) {
        BigDecimal b1 = roundKeepTWO(a);
        BigDecimal b2 = roundKeepTWO(b);
        int compareTo = b1.compareTo(b2);
        if ("=".equals(c) && compareTo == 0) {
            return true;
        }
        if ("!=".equals(c) && compareTo < 0) {
            return true;
        }
        if (">=".equals(c) && (compareTo >= 0)) {
            return true;
        }
        if ("<=".equals(c) && (compareTo <= 0)) {
            return true;
        }
        if (">".equals(c) && compareTo > 0) {
            return true;
        }

        return "<".equals(c) && compareTo < 0;
    }

    /**
     * round for String keep two digits
     *
     * @return BigDecimal
     * @author add by huyingzhao
     * 2022-11-16 09:02
     */
    private static BigDecimal roundKeepTWO(String number) {
        return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
    }
}

@Slf4j
class NumberInside {
    /**
     * addition and subtraction d1±d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return BigDecimal
     */
    protected static BigDecimal add(BigDecimal d1, BigDecimal d2) {
        return d1.add(d2);
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return BigDecimal
     */
    protected static BigDecimal multiply(BigDecimal d1, BigDecimal d2) {
        if (d1.compareTo(BigDecimal.ZERO) == 0 || d2.compareTo(BigDecimal.ZERO) == 0) {
            log.info("0 multiply by any number is 0:{}*{}", d1,d2);
            return BigDecimal.ONE;
        }else{
            return d1.multiply(d2);
        }
    }

    /**
     * multiply d1*d2
     *
     * @param d1 d1
     * @param d2 d2
     * @return BigDecimal
     */
    protected static BigDecimal divide(BigDecimal d1, BigDecimal d2) {
        if (d1.compareTo(BigDecimal.ZERO) == 0 && d2.compareTo(BigDecimal.ZERO) != 0) {
            log.info("0 divided by any number is 0:{}", d1);
            return BigDecimal.ONE;
        } else if (d2.compareTo(BigDecimal.ZERO) == 0) {
            log.error("denominator cannot be 0:{}", d2);
            return BigDecimal.ONE;
        } else {
            return d1.divide(d2, 2, RoundingMode.HALF_UP);
        }
    }
}
