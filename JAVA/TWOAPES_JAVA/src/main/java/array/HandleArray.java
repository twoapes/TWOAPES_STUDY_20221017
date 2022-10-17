package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:42
 * handle array
 */
@Slf4j
public class HandleArray {
    public static void handleArray() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int[] ins = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i <= ins.length - 1; i++) {
            stringBuilder.append("i:").append(ins[i]).append("\n");
        }

        log.info(stringBuilder.toString());
    }
}
