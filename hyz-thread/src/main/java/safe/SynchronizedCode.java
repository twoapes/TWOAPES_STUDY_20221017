package safe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:52
 * 使用同步代码块解决线程安全问题
 */
@Slf4j
public class SynchronizedCode implements Runnable {
    private int ticket = 100;

    public void run() {
        while (true) {
            payTicket();
        }
    }

    public void payTicket() {
        synchronized (SynchronizedCode.class) {
            if (ticket > 0) {
                log.info("{}-->正在卖第{}张票", Thread.currentThread().getName(), ticket);
                ticket--;
            }
        }
    }
}
