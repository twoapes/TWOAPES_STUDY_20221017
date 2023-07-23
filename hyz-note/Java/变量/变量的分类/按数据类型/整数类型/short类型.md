# short类型

短整型

- 最小值是-32768(-2^15)

- 最大值是32767(2^15 - 1)

- short数据类型是16位,有符号的,以二进制补码表示的整数

- 变量占用的空间为int的二分之一

以下是一个演示如何使用Java实现`short`类型的示例代码：

```java
public class ShortDemo {
    public static void main(String[] args) {
        short number = 1000; // 声明一个short类型变量并初始化为1000
        System.out.println("Number: " + number);

        short anotherNumber; // 声明一个short类型变量
        anotherNumber = 2000; // 赋值给变量
        System.out.println("Another number: " + anotherNumber);

        short sum = (short) (number + anotherNumber); // 对两个short类型变量求和，需要进行强制类型转换
        System.out.println("Sum: " + sum);

        short product = (short) (number * anotherNumber); // 两个short类型变量相乘，需要进行强制类型转换
        System.out.println("Product: " + product);
    }
}
```

在这个示例中，我们声明了两个`short`类型的变量`number`和`anotherNumber`，并对它们进行了赋值和操作。请注意，与`int`类型和`long`类型不同，`short`类型的字面值直接赋给变量即可，无需添加后缀。

需要注意的是，由于`short`类型只占用16位空间，比`int`类型和`long`类型的空间更小，因此在对`short`类型变量进行算术运算时，可能会出现溢出的情况。为了避免溢出错误，我们需要在执行算术运算之前将结果进行强制类型转换为`short`类型。

请记住，`short`类型的范围是-32,768到32,767之间（16位有符号整数）。
