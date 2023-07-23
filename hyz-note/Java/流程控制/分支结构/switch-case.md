# switch-case

在Java中，switch-case语句是一种用于根据表达式的值选择不同执行路径的流控制语句。它提供了一种简洁的方式来处理多个可能的情况。

下面是switch-case语句的基本语法：

```java
switch (expression) {
    case value1:
        // 当expression的值等于value1时执行的代码
        break;
    case value2:
        // 当expression的值等于value2时执行的代码
        break;
    case value3:
        // 当expression的值等于value3时执行的代码
        break;
    // 可以添加更多的case分支
    default:
        // 当expression的值与任何case都不匹配时执行的代码
}
```

其中：

- `expression` 是一个可计算的表达式，通常是一个整数、字符或枚举类型。
- `value1`、`value2`、`value3` 等是与 `expression` 进行比较的值。
- 每个 `case` 分支下的代码将在对应值匹配时执行，然后通过 `break` 关键字终止switch语句的执行。
- `default` 分支是可选的，它处理 `expression` 的值与任何 `case` 都不匹配的情况。

下面是一个使用switch-case语句的简单示例：

```java
public class SwitchCaseDemo {
    public static void main(String[] args) {
        int dayOfWeek = 3;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
```

在上述示例中，我们定义了一个整数变量 `dayOfWeek` 并赋值为 3。然后使用switch-case语句根据 `dayOfWeek` 的值选择对应的星期几进行输出。由于 `dayOfWeek` 的值为 3，因此在第三个case分支中执行了相应的代码，输出 "Wednesday"。

运行上述代码，将会得到以下输出：

```shell
Wednesday
```

这个示例展示了switch-case语句根据 `expression` 的值选择对应的代码分支，并且在匹配到的分支执行完后通过 `break` 关键字终止了switch语句的执行。如果 `expression` 的值与任何 `case` 都不匹配，将执行默认的 `default` 分支。
