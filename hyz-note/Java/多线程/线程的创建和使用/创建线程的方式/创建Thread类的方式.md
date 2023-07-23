# 创建Thread的方式

> 1.创建一个继承于Thread类的子类
2.重写Thread类的`run()`方法
3.创建Thread类的子类的对象
4.通过此对象调用start()
①启动当前线程
② 调用当前线程的run()

重写的是run()方法， 而不是start()方法， 但是占用了继承的名额， Java中的类是单继承的

如果自己手动调用run()方法，那么就只是普通方法，没有启动多线程模式
run()方法由JVM调用，什么时候调用，执行的过程控制都有操作系统的CPU调度决定
想要启动多线程，必须调用start方法
一个线程对象只能调用一次start()方法启动，如果重复调用了，则将抛出以上的异常`IllegalThreadStateException`

使用Java实现继承Thread类的方式创建线程的步骤如下：

1. 创建一个类并继承Thread类。这个类将作为线程的任务，在其中重写Thread类的run()方法，定义线程要执行的逻辑。

  ```java
public class MyThread extends Thread {
    public void run() {
        // 线程执行的逻辑
    }
}
```

2.在主线程中，创建一个MyThread实例，并调用它的start()方法来启动线程。

  ```java
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(); // 创建MyThread实例
        myThread.start(); // 启动线程
    }
}
```

3.在run方法中定义线程要执行的逻辑。在该方法内部编写线程要执行的代码。

  ```java
public class MyThread extends Thread {
    public void run() {
        // 线程执行的逻辑
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + i);
        }
    }
}
```

4.调用MyThread对象的start()方法启动线程。start()方法会在后台创建一个新的线程，并调用MyThread类的run()方法。

  ```java
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(); // 创建MyThread实例
        myThread.start(); // 启动线程
    }
}
```

5.运行程序，线程将在后台执行MyThread类中重写的run()方法中定义的逻辑。
