# do-while循环

在Java中，do-while循环是一种常用的循环结构，类似于while循环，但它会先执行循环体中的代码，然后再检查条件是否为真。这意味着无论条件是否满足，循环体至少会被执行一次。

下面是do-while循环的基本语法：

```java
do {
    // 循环体代码
} while (condition);
```

其中：

- `condition` 是循环的条件表达式，当条件为真时，继续执行循环体；当条件为假时，跳出循环。

以下是一个使用do-while循环的简单示例：

```java
public class DoWhileLoopDemo {
    public static void main(String[] args) {
        int count = 1;
        do {
            System.out.println("Count: " + count);
            count++;
        } while (count <= 5);
    }
}
```

在上述示例中，我们使用do-while循环从1到5打印了计数器的值。在循环开始时，首先执行循环体中的代码，并将计数器 `count` 的值打印出来。之后，检查条件 `count <= 5` 是否为真。如果条件为真，则继续执行循环体，再次打印计数器的值并递增计数器。循环会继续进行，直到条件为假（`count > 5`），然后跳出循环。

运行上述代码，将会得到以下输出：

```shell
Count: 1
Count: 2
Count: 3
Count: 4
Count: 5
```

这个示例展示了do-while循环的基本用法。无论条件是否满足，循环体至少会被执行一次。通过控制条件的真假，我们可以控制循环的行为和终止条件。
