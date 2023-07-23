# wait() 和 sleep()

以下是一个简单的 Java 示例，用于演示 `wait()` 和 `sleep()` 方法的区别：

```java
public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("Thread 1 starts execution.");
                        System.out.println("Thread 1 waits for lock...");
                        lock.wait(); // 线程1等待，释放锁
                        System.out.println("Thread 1 is awake and continues execution.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("Thread 2 starts execution.");
                        System.out.println("Thread 2 sleeps for 2 seconds...");
                        Thread.sleep(2000); // 线程2睡眠，但锁仍然被持有
                        System.out.println("Thread 2 is awake and continues execution.");
                        lock.notify(); // 唤醒等待的线程1
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
```

在这个示例中，我们有两个线程 `thread1` 和 `thread2`，它们都共享了一个对象 `lock` 作为同步锁。

`thread1` 在执行过程中通过 `lock.wait()` 方法进入等待状态，并释放了持有的锁，直到其他线程调用 `lock.notify()` 方法来唤醒它。

`thread2` 在执行过程中通过 `Thread.sleep(2000)` 方法暂停了2秒钟的执行，但并没有释放锁。在休眠结束后，它继续执行并调用了 `lock.notify()` 来唤醒等待的 `thread1`。

通过运行这个示例，你可以观察到 `wait()` 和 `sleep()` 方法的不同效果：

- `wait()` 方法会释放对象的锁，并使线程进入等待状态，直到被其他线程调用相同对象的 `notify()` 或 `notifyAll()` 方法来唤醒。

- `sleep()` 方法使线程进入暂停状态，但不会释放对象的锁。线程在指定的时间休眠后，会继续执行。
