package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:55
 * method transfer dyadic array
 */
@Slf4j
public class MethodTransferDyadicArray {
    public static void methodTransferDyadicArray() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int[][] ints = new int[3][4];
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                stringBuilder.append("[").append(i + 1).append("],[").append(j + 1).append("]value:").append(++count).append("\n");
                ints[i][j] = count;
            }
        }

        stringBuilder.append("sum:").append(sum(ints)).append("\n");
        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * @param ints ints
     * @return sum
     */
    private static int sum(int[][] ints) {
        int total = 0;
        for (int[] anInt : ints) {
            for (int i : anInt) {
                total += i;
            }
        }

        return total;
    }
}
