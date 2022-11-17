import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2022-09-27 15:37
 * volatile keyword
 */
@Slf4j
public class VolatileTest {
    private volatile boolean isStop;
    private volatile int anInt;

    public void setStop(boolean stop) {
        isStop = stop;
    }

    public void add() {
        anInt++;
    }

    /**
     * state change
     *
     * @author method add by huyingzhao
     * 2022-09-27 15:46
     */
    @Test
    public void volatileThreadTest() {
        new VolatileThread().start();
        while (!isStop) {
            Thread.onSpinWait();
        }
        log.info("stop");
    }

    /**
     * read more and write less
     *
     * @author method add by huyingzhao
     * 2022-09-27 15:46
     */
    @Test
    public void volatileThread2Test() {
        new VolatileThread2().start();
        while (anInt < 100) {
            Thread.onSpinWait();
        }
        log.info("stop");
    }

    class VolatileThread extends java.lang.Thread {
        @Override
        public void run() {
            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }

            setStop(true);
        }
    }

    class VolatileThread2 extends java.lang.Thread {
        @Override
        public void run() {
            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }

            for (int i = 0; i < 200; i++) {
                add();
            }
        }
    }
}


