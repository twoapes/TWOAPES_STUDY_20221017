import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
/**
 * @author add by huyingzhao
 * 2023-02-10 12:00 AM
 * 多线程
 */
@Slf4j
public class ThreadTest {
    /**
     * 多线程例子1
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:14
     */
    @Test
    public void threadCase1() {
        log.info(Thread.currentThread().getName());
        log.info("运行案例1");
    }

    /**
     * 多线程例子2
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:16
     */
    @Test
    public void threadCase2() {
        ThreadCase2 threadCase2 = new ThreadCase2();
        threadCase2.start();
        log.info("运行案例2");
    }

    /**
     * 多线程例子3
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:16
     */
    @Test
    public void threadCase3() {
        ThreadCase3 threadCase3 = new ThreadCase3();
        threadCase3.setName("threadCase3");
        threadCase3.start();
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
                log.info("执行方法threadCase3");
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }

        log.info("运行案例3");
    }

    /**
     * 多线程例子4
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:16
     */
    @Test
    public void threadCase4() {
        Runnable runnable1 = new Runnable1();
        ThreadCase4 threadCase4 = new ThreadCase4(runnable1);
        threadCase4.start();
        log.info("运行案例4");
    }

    /**
     * 多线程例子5
     * 不共享数据
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:56
     */
    @Test
    public void threadCase5() {
        ThreadCase5 threadCase1 = new ThreadCase5("线程1");
        ThreadCase5 threadCase2 = new ThreadCase5("线程2");
        ThreadCase5 threadCase3 = new ThreadCase5("线程3");
        threadCase1.start();
        threadCase2.start();
        threadCase3.start();
        log.info("运行案例5");
    }

    /**
     * 多线程例子6
     * 共享数据
     *
     * @author method add by huyingzhao
     * 2022-10-09 10:56
     */
    @Test
    public void threadCase6() {
        ThreadCase6 threadCase = new ThreadCase6();
        Thread threadCase1 = new Thread(threadCase, "线程1");
        Thread threadCase2 = new Thread(threadCase, "线程2");
        Thread threadCase3 = new Thread(threadCase, "线程3");
        Thread threadCase4 = new Thread(threadCase, "线程4");
        Thread threadCase5 = new Thread(threadCase, "线程5");
        threadCase1.start();
        threadCase2.start();
        threadCase3.start();
        threadCase4.start();
        threadCase5.start();
        log.info("运行案例6");
    }

    /**
     * isAlive方法
     *
     * @author method add by huyingzhao
     * 2022-10-09 11:43
     */
    @Test
    public void threadCase7() {
        ThreadCase7 threadCase7 = new ThreadCase7();
        log.info("begin:" + threadCase7.isAlive());
        threadCase7.start();
        log.info("end:" + threadCase7.isAlive());
        log.info("运行案例7");
    }
}


@Slf4j
class ThreadCase2 extends Thread {
    @Override
    public void run() {
        super.run();
        log.info("运行run方法");
    }
}

@Slf4j
class ThreadCase3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
                log.info("执行方法run");
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}

@Slf4j
class Runnable1 implements Runnable {
    public void run() {
        log.info("运行Runnable1");
    }
}

@Slf4j
class ThreadCase4 extends Thread {
///    private ThreadCase4() {
//
//    }

    public ThreadCase4(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        super.run();
        log.info("运行ThreadCase4");
    }
}

@Slf4j
class ThreadCase5 extends Thread {
    private int count = 5;

    public ThreadCase5(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        StringBuilder stringBuilder = new StringBuilder("\n");
        while (count > 0) {
            count--;
            stringBuilder.append("count=").append(count).append("\n");
        }

        log.info(stringBuilder.toString());
    }
}

@Slf4j
class ThreadCase6 extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        super.run();
        count--;
        log.info("count=" + count);
    }
}

@Slf4j
class ThreadCase7 extends Thread {
    @Override
    public void run() {
        super.run();
        log.info("run=" + isAlive());
    }
}
