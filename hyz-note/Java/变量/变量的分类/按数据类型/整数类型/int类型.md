# int类型

整型
最小值是-2,147,483,648(-2^31)
最大值是2,147,483,647(2^31 - 1)
int数据类型是32位,有符号的,以二进制补码表示的整数

以下是一个简单的Java代码示例，演示了如何声明和使用整数（int）类型变量：

```java
public class IntDemo {
    public static void main(String[] args) {
        int number = 42; // 声明一个int类型变量并初始化为42
        System.out.println("Number: " + number);

        int anotherNumber; // 声明一个int类型变量
        anotherNumber = 10; // 赋值给变量
        System.out.println("Another number: " + anotherNumber);

        int sum = number + anotherNumber; // 对两个int类型变量求和
        System.out.println("Sum: " + sum);

        int product = number * anotherNumber; // 两个int类型变量相乘
        System.out.println("Product: " + product);
    }
}
```

这个示例中，我们声明了两个`int`类型的变量`number`和`anotherNumber`，并对它们进行了赋值和操作。在`main`方法中，我们将这些变量的值打印到控制台上。

请注意，Java中的`int`类型表示整数值，范围为-2,147,483,648到2,147,483,647之间（32位有符号整数）。
