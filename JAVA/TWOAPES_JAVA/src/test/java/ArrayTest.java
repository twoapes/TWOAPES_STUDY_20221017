import array.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2022-09-13 13:37
 * array test
 */
@Slf4j
public class ArrayTest {
    /**
     * test CreateDimensionalArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:36
     */
    @Test
    public void createDimensionalArrayTest() {
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
        log.info("str:{}",str);
        str = "";
        str += (Arrays.toString(new int[]{100, 200, 300}));
        log.info("str:{}",str);
    }

    /**
     * test MethodTransferDimensionalArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:36
     */
    @Test
    public void methodTransferDimensionalArrayTest() {
        int[] ins=new int[]{1, 2, 3, 4, 5, 6};
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < ins.length; i++) {
            ins[i] = 5 * (i + 1);
            stringBuilder.append(ins[i]).append("\n");
        }
        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test UsingArrays
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void usingArraysTest() {
        double[] doubleArrays = {1.1, 13.3, 7.2};
        Arrays.sort(doubleArrays);
        StringBuilder str = new StringBuilder("\n");
        int index = 0;
        for (double d : doubleArrays) {
            str.append("d(").append(++index).append("):").append(d).append("\t");
        }

        log.info("str:{}",str);
    }

    /**
     * test LinearLookupMethod
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void linearLookupMethodTest() {
        int[] ins=new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder str = new StringBuilder("\n");
        for (int in : ins) {
            if (in % 2 == 0) {
                str.append(in).append("\t");
            }
        }

        log.info(String.valueOf(str));
    }

    /**
     * test ObjectArray
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void objectArrayTest() {
        ObjectArray.objectArray();
    }

    /**
     * test BinaryChop
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void binaryChopTest() {
        BinaryChop.binaryChop(4);
        BinaryChop.binaryChop(14);
    }

    /**
     * test InsertSort
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void insertSortTest() {
        double[] doubleArrays = {1.1, 13.3, 7.2};
        for (int i = 1; i < doubleArrays.length; i++) {
            for (int j = i; j > 0; j--) {
                if (doubleArrays[j] < doubleArrays[j - 1]) {
                    double temp = doubleArrays[j - 1];
                    doubleArrays[j - 1] = doubleArrays[j];
                    doubleArrays[j] = temp;
                } else
                    break;
            }
        }
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (double d : doubleArrays) {
            stringBuilder.append("d(").append(++index).append("):").append(d).append("\t");
        }

        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test SelectSort
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void selectSortTest() {
        double[] doubleArrays = {1.1, 13.3, 7.2, 3.3, 195.3};
        SelectSort.selectSort(doubleArrays);
    }

    /**
     * test DefaultValue
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void defaultValueTest() {
        int[] ins = new int[4];
        ins[0] = 1;
        ins[1] = 2;
        ins[2] = 3;
        for (int i : ins) {
            log.info("i:{}", i);
        }
    }

    /**
     * test HandleArray
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void handleArrayTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        int[] ins = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i <= ins.length - 1; i++) {
            stringBuilder.append("i:").append(ins[i]).append("\n");
        }

        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test CopyString
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void copyStringTest() {
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

        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test DyadicArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void dyadicArrayTest() {
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
        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test MethodTransferDyadicArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void methodTransferDyadicArrayTest() {
        MethodTransferDyadicArray.methodTransferDyadicArray();
    }

    /**
     * test VariableParameterLength
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void variableParameterLengthTest() {
        VariableParameterLength.variableParameterLength(1.0, 3.5, 33.8);
        VariableParameterLength.variableParameterLength(1.2, 3.14, 220.8);
    }
}
