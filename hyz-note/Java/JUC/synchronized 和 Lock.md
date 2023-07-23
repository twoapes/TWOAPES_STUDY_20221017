# synchronized 和 Lock

下面是一个使用 `synchronized` 和 `Lock` 的示例代码，展示了它们之间的异同点：

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedVsLockDemo {
    private int count = 0;
    private final Object lockObject = new Object();
    private final Lock lock = new ReentrantLock();

    // 使用 synchronized
    public void incrementWithSynchronized() {
        synchronized (lockObject) {
            count++;
        }
    }

    // 使用 Lock
    public void incrementWithLock() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        final SynchronizedVsLockDemo demo = new SynchronizedVsLockDemo();

        // 使用 synchronized 的多线程示例
        Runnable synchronizedRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    demo.incrementWithSynchronized();
                }
            }
        };

        // 使用 Lock 的多线程示例
        Runnable lockRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    demo.incrementWithLock();
                }
            }
        };

        Thread thread1 = new Thread(synchronizedRunnable);
        Thread thread2 = new Thread(lockRunnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count (synchronized): " + demo.getCount());
    }
}
```

这个示例中，我们有一个共享的计数器 `count`，并且定义了两个方法 `incrementWithSynchronized()` 和 `incrementWithLock()` 来递增计数器的值。

`incrementWithSynchronized()` 方法使用 `synchronized` 关键字来同步访问计数器。在方法内部，我们使用一个对象 `lockObject` 作为同步锁。

`incrementWithLock()` 方法使用 `Lock` 接口的实现类 `ReentrantLock` 来同步访问计数器。我们通过调用 `lock()` 方法获取锁，并在方法执行结束后使用 `unlock()` 方法释放锁。

在 `main()` 方法中，我们创建了两个线程 `thread1` 和 `thread2`，分别执行使用 `synchronized` 和 `Lock` 的递增操作。我们使用 `join()` 方法等待这两个线程执行完毕，并打印最终的计数器值。

异同点：

- 相同点：

  - `synchronized` 和 `Lock` 都可以用于实现多线程的同步。

  - 它们都可以防止多个线程同时访问共享资源。

  - 它们都提供了互斥访问的机制，保证了线程的安全性。

- 不同点：

  - `synchronized` 是 Java 关键字，而 `Lock` 是 Java 提供的一个接口。

  - `synchronized` 是隐式获取和释放锁，而 `Lock` 则需要显式地调用 `lock()` 和

`unlock()` 方法来获取和释放锁。

- `synchronized` 无法中断正在等待获取锁的线程，而 `Lock` 可以使用 `tryLock()` 方法来尝试获取锁并判断是否成功，还可以使用 `lockInterruptibly()` 方法来响应中断。

- `Lock` 比 `synchronized` 更灵活，例如，可以实现公平锁、可重入锁，还可以尝试获取锁、超时获取锁等。

- 由于 `Lock` 是显示的，因此在使用时需要手动释放锁，否则可能导致死锁的发生。而 `synchronized` 在代码块或方法执行结束后会自动释放锁。

请注意，`Lock` 是在 Java 5 中引入的，并且相较于 `synchronized` 提供了更多的功能和灵活性。但在大多数情况下，`synchronized` 是足够的，并且更加简单和易于使用。只有在需要更高级的功能时，才需要考虑使用 `Lock`。
