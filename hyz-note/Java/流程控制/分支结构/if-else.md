# if -else

在Java中，if-else语句是一种常用的条件控制结构，用于根据给定的条件选择不同的执行路径。if-else语句允许根据条件的真假执行不同的代码块。

下面是if-else语句的基本语法：

```java
if (condition) {
    // 当条件为真时执行的代码块
} else {
    // 当条件为假时执行的代码块
}
```

其中：

- `condition` 是一个布尔表达式，用于判断条件的真假。
- 如果 `condition` 为真，则执行 `if` 代码块中的语句。
- 如果 `condition` 为假，则执行 `else` 代码块中的语句。

以下是一个使用if-else语句的简单示例：

```java
public class IfElseDemo {
    public static void main(String[] args) {
        int num = 10;

        if (num > 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is non-positive");
        }
    }
}
```

在上述示例中，我们定义了一个整数变量 `num` 并赋值为 10。然后使用if-else语句根据 `num` 的值判断其正负性，并输出相应的消息。由于 `num` 的值为 10，大于0，因此执行了 `if` 代码块中的语句，输出 "Number is positive"。

运行上述代码，将会得到以下输出：

```shell
Number is positive
```

这个示例展示了if-else语句根据给定的条件执行不同的代码块。如果条件为真，则执行 `if` 代码块；如果条件为假，则执行 `else` 代码块。
