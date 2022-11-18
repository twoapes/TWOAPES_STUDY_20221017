import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author add by huyingzhao
 * 2022-09-13 13:37
 * array test
 */
@Slf4j
public class ArrayTest {
    /**
     * test dimensional array
     *
     * @author add by huyingzhao
     * 2022-09-13 14:36
     */
    @Test
    public void dimensionalArrayTest() {
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

        log.info("ints:{}", ints);
        log.info("ints:{}", Arrays.toString(new int[]{100, 200, 300}));
    }

    /**
     * test Using arrays
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void usingArraysTest() {
        double[] doubleArrays = {1.1, 13.3, 7.2};
        Arrays.sort(doubleArrays);
        log.info("doubleArrays:{}", doubleArrays);
    }

    /**
     * test linear lookup method
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void linearLookupMethodTest() {
        int[] ins = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int in : ins) {
            if (in % 2 == 0) {
                stringBuilder.append(in).append("\t");
            }
        }

        log.info("stringBuilder:{}",stringBuilder);
    }

    /**
     * test object array
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void objectArrayTest() {
        ObjectPojo[] objectPojoList = new ObjectPojo[2];
        objectPojoList[0] = new ObjectPojo();
        ObjectPojo objectPojo1 = objectPojoList[0];
        objectPojo1.setI(1);
        objectPojo1.setJ(2);
        objectPojoList[1] = new ObjectPojo();
        ObjectPojo objectPojo2 = objectPojoList[1];
        objectPojo2.setI(3);
        objectPojo2.setJ(4);
        log.info("objectPojoList:{}", Arrays.deepToString(objectPojoList));
    }

    /**
     * test binary chop
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void binaryChopTest() {
        Array.binaryChop(4);
        Array.binaryChop(14);
    }

    /**
     * test insert sort
     *
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

        log.info("stringBuilder:{}", stringBuilder);
    }

    /**
     * test select sort
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void selectSortTest() {
        double[] doubleArrays = {1.1, 13.3, 7.2, 3.3, 195.3};
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < doubleArrays.length - 1; i++) {
            final double cur = doubleArrays[i];
            double last = 0;
            int lastIndex = i;
            for (int j = i + 1; j < doubleArrays.length; j++) {
                if (cur > doubleArrays[j]) {
                    last = doubleArrays[j];
                    lastIndex = j;
                }
            }

            if (lastIndex != i) {
                doubleArrays[lastIndex] = doubleArrays[i];
                doubleArrays[i] = last;
            }

            stringBuilder.append("(").append(i + 1).append("): ").append(cur).append("\t");
        }

        log.info("stringBuilder:{}", stringBuilder);
        log.info("doubleArrays:{}", doubleArrays);
    }

    /**
     * test default value
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

        List<Integer> integers=new ArrayList<>();
        for (int i : ins) {
            integers.add(i);
        }

        log.info("integers:{}", integers);
    }

    /**
     * test handle array
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void handleArrayTest() {
        StringBuilder stringBuilder = new StringBuilder("\n");

        int[] ins = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i <= ins.length - 1; i++) {
            stringBuilder.append("i:").append(ins[i]).append("\t");
        }

        log.info("stringBuilder:{}", stringBuilder);
    }

    /**
     * test copy string
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void copyStringTest() {
        int[] ins = {0, 1, 2, 3, 4, 5};
        int[] ins2 = new int[6];
        System.arraycopy(ins, 0, ins2, 0, 6);
        log.info("ins:{}", ins);
        log.info("ins2:{}", ins2);
        log.info("System.arraycopy <-----> Arrays.copyOfRange");
        int[] ins3 = Arrays.copyOfRange(ins, 0, ins.length);
        log.info("ins3:{}", ins3);
    }

    /**
     * test dyadic array
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void dyadicArrayTest() {
        int[][] ints = new int[3][3];
        int count = 0;
        for (int x = 0; x < ints.length; x++) {
            for (int y = 0; y < ints[x].length; y++) {
                ints[x][y] = ++count;
            }
        }

        log.info("dyadic array length:{}", ints.length);
        log.info("stringBuilder:{}", Arrays.deepToString(ints));
    }

    /**
     * test   dimensional array transfer
     *
     * @author add by huyingzhao
     * 2022-09-13 14:36
     */
    @Test
    public void dimensionalArrayTransferTest() {
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};

        for (int i = 0; i < ints.length; i++) {
            ints[i] = 5 * (i + 1);
        }

        log.info("ints:{}", ints);
    }

    /**
     * test  dyadic array transfer
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void dyadicArrayTransferTest() {
        int[][] ints = new int[3][4];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = count++;
                sum+=count;
            }
        }

        log.info("sum:{}", sum);
        log.info("ints:{}", Arrays.deepToString(ints));
    }

    /**
     * test variable parameter length
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void variableParameterLengthTest() {
        Array.variableParameterLength(1.0, 3.5, 33.8);
        Array.variableParameterLength(1.2, 3.14, 220.8);
    }
}

@Slf4j
class Array {
    /**
     * @author add by huyingzhao
     * 2022-11-18 21:20
     * @param numbers numbers
     */
    protected static void variableParameterLength(double... numbers) {
        if (numbers.length == 0) {
            log.warn("list must not empty");
        }

        double result = numbers[0];
        for (double number : numbers) {
            if (result < number) {
                result = number;
            }
        }

        log.info("numbers:{} result:{}", numbers, result);
    }

    /**
     * @author add by huyingzhao
     * 2022-11-18 21:20
     * @param value value
     */
    protected static void binaryChop(int value) {
        int[] arrays = {2, 3, 4, 5, 6};

        boolean is = false;
        int begin = 0;
        int end = arrays.length - 1;

        while (begin <= end) {
            int mind = (begin + end) / 2;
            if (value == arrays[mind]) {
                log.info("arrays find value:{} mind:{}", value, mind);
                is = true;
                break;
            } else if (value < arrays[mind]) {
                end = mind - 1;
            } else {
                begin = mind + 1;
            }
        }

        if (!is) {
            log.info("arrays not find:{}", value);
        }
    }
}

@Data
class ObjectPojo {
    private int i;
    private int j;
}
