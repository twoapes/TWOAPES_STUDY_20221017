# synchronized关键字

`synchronized`是Java中的关键字，用于实现线程同步，以避免多个线程同时访问共享资源时可能发生的竞态条件（race condition）。当一个线程获取了某个对象的锁（或者是类的锁），其他线程在该对象上的`synchronized`块或方法调用将被阻塞，直到该线程释放了锁。

`Synchronized`关键字有两种使用方式：作用于代码块和作用于方法块。

1. 作用于代码块：
使用`synchronized`关键字修饰的代码块可以确保同一时间只有一个线程执行该代码块。代码块的锁是括号内的对象实例或者类对象。

  下面是一个使用`synchronized`关键字修饰的代码块的示例：

  ```java
public class SynchronizedDemo {
    private static int counter = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (lock) { // 使用lock对象进行同步
                for (int i = 0; i < 1000; i++) {
                    counter++;
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }
}
```

在上面的示例中，`synchronized (lock)`用于修饰代码块，保证了`counter++`操作的原子性和线程安全性。`counter`变量在两个线程之间进行共享，并且使用了一个共享的`lock`对象作为锁。

2.作用于方法块：
使用`synchronized`关键字修饰的方法块可以确保同一时间只有一个线程执行该方法。方法块的锁是该方法所属的对象实例（非静态方法）或者类对象（静态方法）。

  下面是一个使用`synchronized`关键字修饰的方法块的示例：

  ```java
public class SynchronizedDemo {
    private int counter = 0;

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();

        Thread thread1 = new Thread(() -> demo.increment());
        Thread thread2 = new Thread(() -> demo.increment());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + demo.counter);
    }

    public synchronized void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }
}
```

在上面的示例中，`increment()`方法被修饰为`synchronized`，因此同一时间只有一个线程可以执行该方法。两个线程共

享同一个`SynchronizedDemo`实例，并且调用了`increment()`方法对`counter`进行累加操作。

无论是`synchronized`的代码块还是方法块，都可以保证线程安全性，但需要注意的是过多地使用`synchronized`可能会导致性能问题，因为它会引入锁的竞争和阻塞。在Java 5及以后的版本中，引入了更高效的并发编程方式，如使用`java.util.concurrent`包中的锁和并发集合来替代`synchronized`关键字的使用。
