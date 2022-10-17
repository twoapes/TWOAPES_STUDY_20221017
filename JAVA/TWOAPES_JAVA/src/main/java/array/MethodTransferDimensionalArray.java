package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:44
 * method transfer dimensional array
 */
@Slf4j
public class MethodTransferDimensionalArray {
    /**
     * @param ins ins
     * @author add by huyingzhao
     * 2022-09-13 14:38
     */
    public static void methodTransferDimensionalArray(int[] ins) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < ins.length; i++) {
            ins[i] = 5 * (i + 1);
            stringBuilder.append(ins[i]).append("\n");
        }
        log.info(stringBuilder.toString());
    }
}
