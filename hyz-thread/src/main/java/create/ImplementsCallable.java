package create;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:50
 * 创建线程方式三：实现Callable接口
 */
@Slf4j
public class ImplementsCallable implements Callable<Integer> {//1

    public Integer call() throws Exception {//2
        int sum = 0;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                log.info(String.valueOf(i));
                sum += i;
            }
        }

        return sum;
    }
}

