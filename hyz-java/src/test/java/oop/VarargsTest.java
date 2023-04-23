package oop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author add by huyingzhao
 * 2023-03-13 17:26
 */
@Slf4j
public class VarargsTest {
    /**
     * 可变个数的形参
     *
     * @author add by huyingzhao
     * 2023-03-13 17:26
     */
    @Test
    public void varargs() {
        // 求 1, 2, 3, 4 的和
        int result = sum(1, 2, 3, 4);
        log.info("1 + 2 + 3 + 4 = {}", result);

        // 求 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 的和
        result = sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        log.info("1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = {}", result);

        log.info("oldMethod:{}", Arrays.toString(oldMethod(new String[]{"1", "2", "3"})));
        log.info("newsMethod:{}", Arrays.toString(newsMethod(new String[]{"1", "2", "3"})));
        log.info("newsMethod:{}", Arrays.toString(newsMethod("1", "2", "3")));
    }

    /**
     * 计算任意数量的整数之和。
     *
     * @param nums 任意数量的整数
     * @return 所有整数的和
     */
    private int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /**
     * 1.5之前
     *
     * @param args args
     * @author add by huyingzhao
     * 2023-03-13 17:26
     */
    public String[] oldMethod(String[] args) {
        return args;
    }

    /**
     * 1.5之后
     *
     * @param args args
     * @author add by huyingzhao
     * 2023-03-13 17:26
     */
    public String[] newsMethod(String... args) {
        return args;
    }
}
