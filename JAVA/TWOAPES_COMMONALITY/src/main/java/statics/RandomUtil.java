package statics;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author add by huyingzhao
 * 2022-08-02 14:49
 */
public class RandomUtil {

    /**
     * @param i i
     * @return longRandom
     */
    public static Number longRandom(int i) {
        BigDecimal bigDecimal = BigDecimal
                .valueOf(((Math.pow(10, i) - Math.pow(10, i - 1) - 1) * Math.random() + Math.pow(10, i - 1)));
        bigDecimal = BigDecimal.valueOf(((bigDecimal.longValue()) * Math.PI));
        String stringL = String.valueOf(bigDecimal.longValue());
        if (stringL.length() == i) {
            return bigDecimal.longValue();
        } else {
            return Long.parseLong((int) (2 * Math.random()) == 1 ? stringL.substring(1, i) : stringL.substring(0, i));
        }
    }

    /**
     * start 0 end ran
     *
     * @param ran ran
     * @return randomBetween
     * @author add by huyingzhao
     * 2022-08-02 14:51
     */
    public static int randomBetween(int ran) {
        return randomBetween(ran, ran);
    }

    /**
     * @param start start
     * @param end   end
     * @return randomBetween
     * @author add by huyingzhao
     * 2022-08-02 14:51
     */

    public static int randomBetween(int start, int end) {
        if (start > end) {
            return -1;
        }

        if (start == end) {
            return new Random().nextInt(end + 1);
        }

        int ran = new Random().nextInt(end + 1);
        if (ran >= start) {
            return ran;
        } else {
            return randomBetween(start, end);
        }
    }
}
