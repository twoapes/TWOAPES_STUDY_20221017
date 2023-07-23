# while循环

在Java中，while循环是一种常用的循环结构，用于重复执行一段代码，直到满足指定的条件。while循环通常用于未知循环次数的情况下，只要条件为真，循环将一直执行。

下面是while循环的基本语法：

```java
while (condition) {
    // 循环体代码
}
```

其中：

- `condition` 是循环的条件表达式，当条件为真时，执行循环体；当条件为假时，跳出循环。

以下是一个使用while循环的简单示例：

```java
public class WhileLoopDemo {
    public static void main(String[] args) {
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
    }
}
```

在上述示例中，我们使用while循环从1到5打印了计数器的值。在循环开始时，首先检查条件 `count <= 5` 是否为真。如果条件为真，则执行循环体中的代码，并将计数器 `count` 的值打印出来。之后，执行 `count++` 将计数器 `count` 递增。循环会继续进行，直到条件为假（`count > 5`），然后跳出循环。

运行上述代码，将会得到以下输出：

```shell
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

这个示例展示了while循环的基本用法，以及如何在循环体中执行重复的代码。只要条件为真，循环将继续执行。通过控制条件的真假，我们可以控制循环的行为和终止条件。
