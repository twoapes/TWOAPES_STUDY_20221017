package cases;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2022-10-08 18:29
 * yanghui triangle
 */
@Slf4j
public class PascalTriangle {

    public static void pascalTriangle() {
        int index = 15;
        int[][] arr = new int[index][index];
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < index; i++) {
            stringBuilder.append("\t".repeat(index - i + 1));
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                    stringBuilder.append("\t\t");
                    stringBuilder.append(arr[i][j]);
                } else {
                    stringBuilder.append("\t\t");
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    stringBuilder.append(arr[i][j]);
                }
            }
            stringBuilder.append("\n");
        }

        log.info(stringBuilder.toString());
    }
}
