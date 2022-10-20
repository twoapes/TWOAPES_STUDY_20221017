import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * @author add by huyingzhao
 * 2022-10-14 15:57
 * thread pool with a scheduled execution
 * maybe delayed 0.01 second
 */
@Slf4j
public class TimedThreadPoolTest {
    @Test
    public void test() {
        TimedThreadPool<Object> p = new TimedThreadPool<>(3);
        TestThread<Object> tt2 = new TestThread<>(1, p);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2022-10-14 16:36:22";
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        p.add(tt2, date);
///        for (int i = 0; i < 10; i++) {
//            TestThread tt = new TestThread(i + 1, p);
//            System.out.println("++ add thread " + (i + 1));
//            p.add(tt, later());
//            Thread.sleep(270);
//        }
    }
}

@Data
class TimedThreadPool<E> {
    private int size;

    // only running thread list
    private Vector<PooledThread<E>> threads = new Vector<>();

    private final Lock lock = new Lock();

    /**
     * @param size thread pool size
     */
    public TimedThreadPool(int size) {
        this.size = size;
    }

    /**
     * @param thread      thread
     * @param executeTime executeTime
     */
    public void add(Thread thread, Date executeTime) {
        new PooledThread<>(executeTime, thread, this).start();
    }

    /**
     * @param thread thread
     */
    protected void addExecutable(PooledThread<E> thread) {
        threads.add(thread);
    }

    /**
     * @param thread thread
     */
    protected void remove(PooledThread<E> thread) {
        threads.remove(thread);
    }

    /**
     * @return isFull
     */
    public boolean isFull() {
        return threads.size() >= size;
    }

    /**
     * @return getRunningThreadNum
     */
    public int getRunningThreadNum() {
        return threads.size();
    }

///    private static Date later() {
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.SECOND, 2);
//        return c.getTime();
//    }
}

/**
 * Lock
 */
class Lock {

}

/**
 * PooledThread
 */
@Slf4j
class PooledThread<E> extends Thread {

    private final Date executeDate;

    private final Thread executable;

    private final TimedThreadPool<E> pool;

    /**
     * @param executeDate executeDate
     * @param executable  executable
     * @param pool        pool
     */
    PooledThread(Date executeDate, Thread executable, TimedThreadPool<E> pool) {
        this.executeDate = executeDate;
        this.executable = executable;
        this.pool = pool;
    }

    @Override
    public void run() {
        Lock lock = pool.getLock();
        boolean finished = false;
        try {
            while (!finished) {
                boolean runnable = executeDate.before(new Date());
                synchronized (lock) {
                    if (!pool.isFull() && runnable) {
                        pool.addExecutable(this);
                    } else if (pool.isFull()) {
                        lock.wait();
                    }
                }

                if (runnable) {
                    executable.start();
                    pool.remove(this);
                    finished = true;

                    synchronized (lock) {
                        lock.notify();
                    }
                }

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        } finally {
            pool.remove(this);
        }
    }
}

@Slf4j
class TestThread<E> extends Thread {
    protected int id;

    private final TimedThreadPool<E> pool;

    TestThread(int id, TimedThreadPool<E> pool) {
        this.id = id;
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            log.info(">>> the thread " + id + " started: "
                    + pool.getRunningThreadNum());
            Thread.sleep(2000);
            log.info("=== the thread " + id + " ended: "
                    + pool.getRunningThreadNum());
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}
