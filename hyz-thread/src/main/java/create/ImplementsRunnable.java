package create;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:50
 * 创建线程方式二：实现Runnable接口
 */
@Slf4j
public class ImplementsRunnable implements Runnable {//1

    public void run() {//2
        log.info("thread name {}",Thread.currentThread().getName());
    }
}
