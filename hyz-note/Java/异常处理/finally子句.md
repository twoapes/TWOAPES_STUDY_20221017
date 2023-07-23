# finally子句

无论异常是否产生， finally子句总会被执行

- 如果try块中没有出现异常， 执行final Statements， 然后执行try语句的下一条语句

- 如果try块中有一条语句引起了异常并被catch块捕获， 会跳过try块的其他语句，执行catch块和finally子句,执行try语句后的下一条语句

- 如果try块中的一条语句引起异常， 但是没有被任何catch块捕获， 就会跳过try块中的其他语句， 执行finally子句， 并且将异常传递给这个方法的调用者

捕获异常的最后一步是通过finally语句为异常处理提供一个统一的出口，使得在控制流转到程序的其它部分以前，能够对程序的状态作统一的管理

不论在try代码块中是否发生了异常事件，catch语句是否执行，catch语句是否有异常，catch语句中是否有return，finally块中的语句都会被执行

finally语句和catch语句是任选的

`finally` 子句是Java中用于定义必须在 `try` 块或 `catch` 块结束后执行的代码的关键字。无论是否发生异常，`finally` 中的代码都会被执行，这使得我们能够在程序发生异常时执行必要的清理操作。

下面是一个简单的Java示例，展示了 `finally` 子句的用法：

```java
import java.io.*;

public class Example {
  public static void main(String[] args) {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader("file.txt"));
      String line = reader.readLine();
      System.out.println("Read line: " + line);
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    } finally {
      try {
        if (reader != null) {
          reader.close(); // 无论是否发生异常，都需要关闭文件
        }
      } catch (IOException e) {
        System.out.println("An error occurred while closing the file: " + e.getMessage());
      }
    }
  }
}
```

在这个示例中，我们试图读取一个文件并打印其中的一行。如果发生任何IO异常，我们将捕获并打印异常消息。无论是否发生异常，`finally` 中的代码都会被执行，以确保文件被关闭。

在 `finally` 子句中，我们使用了一个嵌套的 `try-catch` 块来捕获关闭文件时可能出现的异常。如果文件无法被关闭，我们会打印出一个错误消息。

总之，`finally` 子句是Java中用于定义必须在 `try` 块或 `catch` 块结束后执行的代码的关键字。它使我们能够在程序发生异常时执行必要的清理操作。
