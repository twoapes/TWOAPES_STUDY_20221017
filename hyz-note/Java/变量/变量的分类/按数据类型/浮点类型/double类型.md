# double类型

双精度浮点型

- double数据类型是双精度,64位,符合IEEE 754标准的浮点数

- double类型同样不能表示精确的值，如货币

以下是一个使用Java实现double类型的示例代码：

```java
public class DoubleDemo {
    public static void main(String[] args) {
        double doubleValue = 3.14159;
        double scientificNotation = 2.5e10;

        System.out.println("doubleValue: " + doubleValue);
        System.out.println("scientificNotation: " + scientificNotation);

        // 浮点数运算
        double result1 = doubleValue + 1.5;
        double result2 = scientificNotation / 1e5;

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
    }
}
```

在这个示例中，我们声明了一个`double`类型的变量`doubleValue`，并将其初始化为`3.14159`。我们还声明了一个使用科学计数法表示的`double`类型的变量`scientificNotation`，其值为`2.5e10`。

我们使用`System.out.println()`方法打印出这两个`double`变量的值。

接下来，我们展示了对`double`类型数值进行运算的示例。我们使用`+`运算符将`doubleValue`和`1.5`相加，并将结果赋给`result1`变量。我们使用`/`运算符将`scientificNotation`除以`1e5`（科学计数法表示的10的5次方），并将结果赋给`result2`变量。

最后，我们将运算结果打印出来。

`double`类型用于存储浮点数值，具有更大的范围和精度，占用8个字节。可以使用常规的小数表示法或科学计数法来表示`double`类型的数值。
