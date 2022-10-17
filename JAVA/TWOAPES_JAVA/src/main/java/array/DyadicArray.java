package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:50
 * dyadic array
 */
@Slf4j
public class DyadicArray {
    public static void dyadicArray() {
        int[][] ints = new int[3][3];
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int x = 0; x < ints.length; x++) {
            for (int y = 0; y < ints[x].length; y++) {
                ints[x][y] = ++count;
                stringBuilder.append("set[").append(x).append("]").append("[").append(y).append("]").append("value:").append(ints[x][y]).append("\n");
            }
        }

        stringBuilder.append("dyadic array length:").append(ints.length);
        log.info(stringBuilder.toString());
    }
}
