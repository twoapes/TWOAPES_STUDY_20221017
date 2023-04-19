package safe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 解决线程安全问题
 *
 * @author add by huyingzhao
 * 2023-03-12 00:13
 */
@Slf4j
public class SafeTest {
    /**
     * 使用同步代码块解决线程安全问题
     *
     * @author add by huyingzhao
     * 2023-03-02 12:27
     */
    @Test
    public void synchronizedCode() {
        Runnable run = new SynchronizedCode();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 使用同步方法解决线程安全问题
     *
     * @author add by huyingzhao
     * 2023-03-02 12:27
     */
    @Test
    public void synchronizedMethod() {
        Runnable run = new SynchronizedMethod();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 使用Lock锁解决线程安全问题
     *
     * @author add by huyingzhao
     * 2023-03-02 12:27
     */
    @Test
    public void lock() {
        Runnable run = new Lock();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}
