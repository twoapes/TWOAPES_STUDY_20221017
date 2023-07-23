# long类型

长整型

- 最小值是-9,223,372,036,854,775,808(-2^63)

- 最大值是9,223,372,036,854,775,807(2^63 -1)

- long数据类型是64位,有符号的,以二进制补码表示的整数

- 这种类型主要使用在需要比较大整数的系统上

以下是一个演示如何使用Java实现`long`类型的示例代码：

```java
public class LongDemo {
    public static void main(String[] args) {
        long number = 1234567890L; // 声明一个long类型变量并初始化为1234567890
        System.out.println("Number: " + number);

        long anotherNumber; // 声明一个long类型变量
        anotherNumber = 9876543210L; // 赋值给变量
        System.out.println("Another number: " + anotherNumber);

        long sum = number + anotherNumber; // 对两个long类型变量求和
        System.out.println("Sum: " + sum);

        long product = number * anotherNumber; // 两个long类型变量相乘
        System.out.println("Product: " + product);
    }
}
```

在这个示例中，我们声明了两个`long`类型的变量`number`和`anotherNumber`，并对它们进行了赋值和操作。与`int`类型不同的是，在给`long`类型变量赋值时，需要在数值后面添加`L`或`l`后缀，以告诉编译器这是一个`long`类型的字面值。

请注意，`long`类型表示长整数值，范围为-9,223,372,036,854,775,808到9,223,372,036,854,775,807之间（64位有符号整数）。
