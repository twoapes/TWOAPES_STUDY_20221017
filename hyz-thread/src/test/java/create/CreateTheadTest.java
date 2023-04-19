package create;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author add by huyingzhao
 * 2023-03-12 00:11
 * 创建线程方式
 */
@Slf4j
public class CreateTheadTest {
    /**
     * 创建线程方式一：继承于Thread类
     *
     * @author add by huyingzhao
     * 2023-03-03 11:22
     */
    @Test
    public void extendsThread() {
        try {
            ExtendsThread thread1 = new ExtendsThread();//3
            thread1.start();//4
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 创建线程方式二：实现Runnable接口
     *
     * @author add by huyingzhao
     * 2023-03-03 11:22
     */
    @Test
    public void implementsRunnable() {
        try {
            ImplementsRunnable thread2 = new ImplementsRunnable();//3
            Thread thread = new Thread(thread2);//4
            thread.start();//5
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 创建线程方式三：实现Callable接口
     *
     * @author add by huyingzhao
     * 2023-03-01 20:51
     */
    @Test
    public void implementsCallable() {
        ImplementsCallable thread3 = new ImplementsCallable();//3
        try {
            FutureTask<Integer> futureTask = new FutureTask<>(thread3);//4
            Thread thread = new Thread(futureTask);//5
            thread.start();
            Integer sum = futureTask.get();//6
            log.info("总和为:" + sum);
            Thread.sleep(1000);
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 创建线程方式四：使用线程池
     *
     * @author add by huyingzhao
     * 2023-03-01 20:51
     */
    @Test
    public void threadPoolExecutor() {
        create.ThreadPoolExecutor thread1 = new create.ThreadPoolExecutor();
        create.ThreadPoolExecutor thread2 = new create.ThreadPoolExecutor();
        try {
            java.util.concurrent.ThreadPoolExecutor executorService = (java.util.concurrent.ThreadPoolExecutor) Executors.newFixedThreadPool(10);//1
            executorService.execute(thread1);
            executorService.execute(thread2);
            Thread.sleep(1000);
            executorService.shutdown();//3
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}
