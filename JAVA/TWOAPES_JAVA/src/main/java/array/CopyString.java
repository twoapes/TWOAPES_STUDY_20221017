package array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-06-04 23:53
 * copy String
 */
@Slf4j
public class CopyString {
    public static void copyString() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int[] ins = {0, 1, 2, 3, 4, 5};
        int[] ins2 = new int[6];
        System.arraycopy(ins, 0, ins2, 0, 6);
        for (int i : ins2) {
            stringBuilder.append(i).append("\n");
        }

        stringBuilder.append("System.arraycopy <-----> Arrays.copyOfRange").append("\n");
        int[] ins3 = Arrays.copyOfRange(ins, 0, ins.length);
        for (int i : ins3) {
            stringBuilder.append(i).append("\n");
        }

        log.info(stringBuilder.toString());
    }
}
