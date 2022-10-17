package array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:40
 * select sort
 */
@Slf4j
public class SelectSort {
    /**
     * @param arrays arrays
     * @author add by huyingzhao
     * 2022-09-13 14:25
     */
    public static void selectSort(double[] arrays) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < arrays.length - 1; i++) {
            final double cur = arrays[i];
            double last = 0;
            int lastIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (cur > arrays[j]) {
                    last = arrays[j];
                    lastIndex = j;
                }
            }

            if (lastIndex != i) {
                arrays[lastIndex] = arrays[i];
                arrays[i] = last;
            }

            stringBuilder.append("(").append(i + 1).append("): ").append(array(arrays)).append("\n");
        }

        log.info(stringBuilder.toString());
    }

    private static String array(double[] arrays) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (double d : arrays) {
            stringBuilder.append(d).append("\t");
        }
        return stringBuilder.toString();
    }
}
