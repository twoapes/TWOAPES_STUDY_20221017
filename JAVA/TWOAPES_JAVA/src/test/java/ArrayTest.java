import array.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2022-09-13 13:37
 * Array
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
        CreateDimensionalArray.createDimensionalArray();
    }

    /**
     * test MethodTransferDimensionalArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:36
     */
    @Test
    public void methodTransferDimensionalArrayTest() {
        MethodTransferDimensionalArray.methodTransferDimensionalArray(new int[]{1, 2, 3, 4, 5, 6});
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
        UsingArrays.usingArrays(doubleArrays);
        StringBuilder str = new StringBuilder("\n");
        int index = 0;
        for (double d : doubleArrays) {
            str.append("d(").append(++index).append("):").append(d).append("\t");
        }

        log.info(str.toString());
    }

    /**
     * test LinearLookupMethod
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void linearLookupMethodTest() {
        LinearLookupMethod.linearLookupMethod(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
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
        InsertSort.insertSort(doubleArrays);
        int index = 0;
        StringBuilder str = new StringBuilder("\n");
        for (double d : doubleArrays) {
            str.append("d(").append(++index).append("):").append(d).append("\t");
        }

        log.info(str.toString());
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
        DefaultValue.defaultValue();
    }

    /**
     * test HandleArray
     *
     * @author add by huyingzhao
     * 2022-09-13 13:41
     */
    @Test
    public void handleArrayTest() {
        HandleArray.handleArray();
    }

    /**
     * test CopyString
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void copyStringTest() {
        CopyString.copyString();
    }

    /**
     * test DyadicArray
     *
     * @author add by huyingzhao
     * 2022-09-13 14:19
     */
    @Test
    public void dyadicArrayTest() {
        DyadicArray.dyadicArray();
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
