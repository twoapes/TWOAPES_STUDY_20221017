package array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-06-04 21:32
 * create one dimensional array
 */
@Slf4j
public class CreateDimensionalArray {
    public static void createDimensionalArray() {
        int[] ints = new int[10];
        ints[0] = 100;
        ints[1] = 200;
        ints[2] = 300;
        ints[3] = 400;
        ints[4] = 500;
        ints[5] = 600;
        ints[6] = 700;
        ints[7] = 800;
        ints[8] = 900;
        ints[9] = 1000;

        String str = "\n";
        str += ("ints[0] --> " + ints[0] + "\t");
        str += ("ints[1] --> " + ints[1] + "\t");
        str += ("ints[2] --> " + ints[2] + "\t");
        str += ("ints[3] --> " + ints[3] + "\t");
        str += ("ints[4] --> " + ints[4] + "\t");
        str += ("ints[5] --> " + ints[5] + "\t");
        str += ("ints[6] --> " + ints[6] + "\t");
        str += ("ints[7] --> " + ints[7] + "\t");
        str += ("ints[8] --> " + ints[8] + "\t");
        str += ("ints[9] --> " + ints[9] + "\t");
        log.info(str);
        str = "";
        str += (Arrays.toString(new int[]{100, 200, 300}));
        log.info(str);
    }
}
