package util;

import java.util.Random;

/**
 * @author add by huyingzhao
 * 2022-08-02 14:49
 */
public class RandomUtil {
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
