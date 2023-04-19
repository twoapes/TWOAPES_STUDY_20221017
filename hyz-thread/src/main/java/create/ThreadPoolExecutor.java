package create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:51
 * 创建线程方式四：使用线程池
 */
@Slf4j
public class ThreadPoolExecutor implements Runnable {//2

    public void run() {
        int sum = 0;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                log.info(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }

        log.info(String.valueOf(sum));
    }
}
