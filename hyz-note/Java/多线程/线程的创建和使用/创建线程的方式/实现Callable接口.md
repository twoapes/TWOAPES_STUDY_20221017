# 实现Callable接口

> 1.创建一个Callable的实现类
2.实现call方法,将此线程需要执行的操作声明在call()中
3.创建Callable接口实现类的对象
4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中,创建FutureTask对象
5.将FutureTask对象作为参数传递到Thread对象,创建Thread对象,并调用start方法
6.获取Callable中call方法返回值

实现Callable接口, 实现call()方法, 得使用Thread+FutureTask配合, 这种方式支持拿到异步执行任务的结果

与使用Runnable相比, Callable功能更强大些

- 相比run()方法

  可以有返回值

- 方法可以抛出异常

- 支持泛型的返回值

- 需要借助FutureTask类

  比如获取返回结果

Future接口

- 可以对具体Runnable

  Callable任务的执行结果进行取消

  查询是否完成,获取结果等

- FutrueTask是Futrue接口的唯一的实现类

- FutureTask同时实现了Runnable, Future接口

  它既可以作为Runnable被线程执行,又可以作为Future得到Callable的返回值

使用Java实现`Callable`接口的方式创建线程，可以按照以下步骤进行操作：

1. 创建一个类，实现`Callable`接口，并指定泛型类型为线程执行结果的类型。例如，创建一个名为`MyCallable`的类实现`Callable`接口，并指定返回值类型为`String`：

```java
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 线程执行的代码逻辑
        System.out.println("线程开始执行");
        Thread.sleep(1000); // 线程休眠1秒钟
        System.out.println("线程执行结束");
        return "线程执行结果";
    }
}
```

在上述示例中，`MyCallable`类实现了`Callable<String>`接口，并重写了`call()`方法，在`call()`方法中编写了线程的逻辑代码。在本例中，线程输出"线程开始执行"，休眠1秒钟，输出"线程执行结束"，最后返回一个`String`类型的线程执行结果。

2.在主线程中创建`ExecutorService`对象，并使用`submit()`方法提交`Callable`对象来执行线程，并获得`Future`对象来获取线程的返回结果。例如，在`main()`方法中进行如下操作：

  ```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 创建线程池
        MyCallable myCallable = new MyCallable(); // 创建实现了Callable接口的对象
        Future<String> future = executorService.submit(myCallable); // 提交Callable对象执行，并获得Future对象
        executorService.shutdown(); // 关闭线程池
        
        try {
            String result = future.get(); // 获取线程执行结果
            System.out.println("线程执行结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，创建了一个单线程的线程池`ExecutorService`，然后创建了`MyCallable`对象`myCallable`。通过`executorService.submit(myCallable)`方法提交`myCallable`对象来执行线程，并获得了一个`Future`对象`future`。接着关闭线程池，调用`executorService.shutdown()`方法。

  最后，通过`future.get()`方法获取线程的执行结果，并将结果打印输出。

3.在`main()`方法中进行异常处理。在使用`future.get()`方法获取线程执行结果时，需要注意捕获可能抛出的异常。可以使用`try-catch`块对异常进行处理，确保程序的正常执行。
