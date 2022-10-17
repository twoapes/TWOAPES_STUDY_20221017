package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:22
 * default value
 */
@Slf4j
public class DefaultValue {
    public static void defaultValue() {
        int[] ins = new int[4];
        ins[0] = 1;
        ins[1] = 2;
        ins[2] = 3;
        for (int i : ins) {
            log.info(String.valueOf(i));
        }
    }
}
