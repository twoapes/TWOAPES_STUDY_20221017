package array;

/**
 * @author add by huyingzhao
 * 2022-06-19 13:41
 * insertion sort
 */
public class InsertSort {
    public static void insertSort(double[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    double temp = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = temp;
                } else
                    break;
            }
        }
    }
}
