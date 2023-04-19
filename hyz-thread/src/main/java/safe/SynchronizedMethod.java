package safe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:53
 * 使用同步方法解决线程安全问题
 */
@Slf4j
public class SynchronizedMethod implements Runnable {
    private int ticket = 100;

    public void run() {
        while (true) {
            payTicket();
        }
    }

    public synchronized void payTicket() {
        if (ticket > 0) {
            log.info("{}-->正在卖第{}张票", Thread.currentThread().getName(), ticket);
            ticket--;
        }
    }
}

