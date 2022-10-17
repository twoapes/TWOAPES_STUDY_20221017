package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:32
 * binary chop
 */
@Slf4j
public class BinaryChop {
    public static void binaryChop(int value) {
        int[] arrays = {2, 3, 4, 5, 6};

        boolean is = false;
        int begin = 0;
        int end = arrays.length - 1;

        while (begin <= end) {
            int mind = (begin + end) / 2;
            if (value == arrays[mind]) {
                log.info("arrays["+value+"][" + mind + "]");
                is = true;
                break;
            } else if (value < arrays[mind]) {
                end = mind - 1;
            } else {
                begin = mind + 1;
            }
        }
        if (!is) {
            log.info("arrays not find:" + value);
        }
    }
}
