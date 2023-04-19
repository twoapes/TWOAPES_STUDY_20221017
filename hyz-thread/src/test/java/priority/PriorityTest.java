package priority;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author add by huyingzhao
 * 2023-03-03 11:44
 */
@Slf4j
public class PriorityTest {
    /**
     * 线程的优先级
     *
     * @author add by huyingzhao
     * 2023-03-03 11:44
     */
    @Test
    public void priority() {
        Priority priority = new Priority();
        Thread thread = Thread.currentThread();
        thread.setName("Thread1");
        thread.setPriority(Thread.MAX_PRIORITY);
        log.info("{}优先级:{}", thread.getName(), thread.getPriority());

        Priority priority2 = new Priority();
        Thread thread2 = Thread.currentThread();
        thread2.setName("Thread2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        log.info("{}优先级:{}", thread2.getName(), thread2.getPriority());
        priority.start();
        priority2.start();
    }
}