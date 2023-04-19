package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-13 17:56
 */
@Slf4j
public class RecursionTest {
    /**
     * 使用递归方法
     *
     * @author add by huyingzhao
     * 2023-03-13 17:57
     */
    @Test
    public void recursion() {
        // 计算 5 的阶乘
        int result = Factorial.factorial(5);
        log.info("5 的阶乘是 " + result);
    }
}

class Factorial {

    /**
     * 计算一个数字的阶乘。
     *
     * @param n 要计算阶乘的数字
     * @return 阶乘结果
     * @throws IllegalArgumentException 如果 n 小于 0
     */
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("n 必须大于等于 0");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

