package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2023-03-13 17:35
 */
@Slf4j
public class ValueTransferTest {
    /**
     * 基本类型赋值
     *
     * @author add by huyingzhao
     * 2023-03-30 23:45
     */
    @Test
    public void base() {
        // 声明和赋值 boolean 类型的变量
        boolean b = true;
        // 声明和赋值 byte 类型的变量
        byte by = 127;
        // 声明和赋值 short 类型的变量
        short s = 32767;
        // 声明和赋值 int 类型的变量
        int i = 2147483647;
        // 声明和赋值 long 类型的变量
        long l = 9223372036854775807L;
        // 声明和赋值 float 类型的变量
        float f = 3.14159265358979323846f;
        // 声明和赋值 double 类型的变量
        double d = 3.14159265358979323846;
        // 输出所有变量的值
        log.info("boolean: {}", b);
        log.info("byte: {}", by);
        log.info("short: {}", s);
        log.info("int:  {}", i);
        log.info("long: {}", l);
        log.info("float: {}", f);
        log.info("double: {}", d);
    }

    /**
     * 引用数据类型赋值
     */
    @Test
    public void dataType() {
        // 创建一个整型数组并初始化
        int[] arr1 = {1, 2, 3};
        // 将arr1的引用赋值给arr2
        int[] arr2 = arr1;
        // 修改arr2的第一个元素
        arr2[0] = 5;
        // 输出arr1的值
        log.info("arr1 {}", Arrays.toString(arr1));
        // 输出arr2的值
        log.info("arr2 {}", Arrays.toString(arr2));
    }

    /**
     * 值传递
     */
    @Test
    public void passValue() {
        int num = 10;
        log.info("调用方法之前，num 的值为：{}", num);
        changeNum(num);
        log.info("调用方法之后，num 的值为: {}", num);
    }

    /**
     * @param number number
     * @author add by huyingzhao
     * 2023-03-30 23:55
     */
    private void changeNum(int number) {
        System.out.println("在方法内部，number 的值为: " + number);
        number = 20;
        System.out.println("修改值之后，number 的值为: " + number);
    }
}