# 实现Runnable接口的方式

> 1.创建一个实现了Runnable接口的类
2.实现类去实现Runnable中的抽象`run()`方法
3.创建实现类的对象
4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
5.通过Thread类的对象调用start()

实现Runnable接口, 实现run()方法, 使用依然要用到Thread, 这种方式更常用

```java
public class Thread extends Object implements Runnable

- 继承Thread
  线程代码存放Thread子类run方法中

- 实现Runnable
  线程代码存在接口的子类的run方法

- 实现方式的好处
  避免了单继承的局限性
  多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源
```

使用Java实现Runnable接口的方式创建线程的步骤如下：

1.创建一个类并实现Runnable接口。这个类将作为线程的任务，在其中定义线程要执行的逻辑。

  ```java
public class MyRunnable implements Runnable {
    public void run() {
        // 线程执行的逻辑
    }
}
```

2.在主线程中，创建一个Runnable实例作为线程的任务，并将其传递给Thread类的构造函数。

  ```java
public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable(); // 创建Runnable实例
        Thread thread = new Thread(myRunnable); // 将Runnable实例传递给Thread的构造函数
        thread.start(); // 启动线程
    }
}
```

3.在run方法中定义线程要执行的逻辑。在该方法内部编写线程要执行的代码。

  ```java
public class MyRunnable implements Runnable {
    public void run() {
        // 线程执行的逻辑
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + i);
        }
    }
}
```

4.调用Thread对象的start()方法启动线程。start()方法会在后台创建一个新的线程，并调用Runnable对象的run()方法。

  ```java
public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable(); // 创建Runnable实例
        Thread thread = new Thread(myRunnable); // 将Runnable实例传递给Thread的构造函数
        thread.start(); // 启动线程
    }
}
```

5.运行程序，线程将在后台执行Runnable对象的run()方法中定义的逻辑。
