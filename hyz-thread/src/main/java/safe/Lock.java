package safe;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:53
 * 使用Lock锁解决线程安全问题
 */
@Slf4j
public class Lock implements Runnable {
    private int ticket = 100;

    private final ReentrantLock reentrantLock = new ReentrantLock(true);//1.创建reentrantLock对象

    public void run() {
        while (true) {
            payTicket();
        }
    }

    public void payTicket() {
        try {
            //2.调用lock
            reentrantLock.lock();
            if (ticket > 0) {
                log.info("{}-->正在卖第{}张票", Thread.currentThread().getName(), ticket);
                ticket--;
            }
        } finally {
            //3.调用unlock
            reentrantLock.unlock();
        }
    }
}

