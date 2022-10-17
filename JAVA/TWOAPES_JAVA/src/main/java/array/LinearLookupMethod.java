package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:31
 * linear lookup method
 */
@Slf4j
public class LinearLookupMethod {
    public static void linearLookupMethod(int[] ins) {
        StringBuilder str = new StringBuilder("\n");
        for (int in : ins) {
            if (in % 2 == 0) {
                str.append(in).append("\t");
            }
        }

        log.info(String.valueOf(str));
    }
}
