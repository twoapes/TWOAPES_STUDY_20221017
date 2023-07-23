# for循环

在Java中，for循环是一种常用的循环结构，用于重复执行一段代码，直到满足指定的条件。for循环通常用于已知循环次数的情况下。

下面是for循环的基本语法：

```java
for (initialization; condition; update) {
    // 循环体代码
}
```

其中：

- `initialization` 是循环开始前的初始化表达式，通常用于初始化循环变量。
- `condition` 是循环的条件表达式，当条件为真时，执行循环体；当条件为假时，跳出循环。
- `update` 是循环每次迭代后的更新表达式，通常用于递增或递减循环变量。

以下是一个使用for循环的简单示例：

```java
public class ForLoopDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
    }
}
```

在上述示例中，我们使用for循环从1到5打印了计数器的值。在循环的每次迭代中，首先将计数器 `i` 初始化为1，然后检查条件 `i <= 5` 是否为真。如果条件为真，则执行循环体中的代码，并将计数器 `i` 的值打印出来。之后，执行更新表达式 `i++` 将计数器 `i` 递增。循环会继续进行，直到条件为假（`i > 5`），然后跳出循环。

运行上述代码，将会得到以下输出：

```shell
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

这个示例展示了for循环的基本用法，以及如何在循环体中执行重复的代码。通过控制初始化、条件和更新表达式，我们可以控制循环的次数和行为。
