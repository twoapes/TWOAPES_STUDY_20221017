# BigInteger与BigDecimal

- Integer类作为int的包装类，能存储的最大整型值为231-1，Long类也是有限的，最大为263-1。如果要表示再大的整数，不管是基本数据类型还是他们的包装类都无能为力，更不用说进行运算了。

- java.math包的BigInteger可以表示不可变的任意精度的整数。BigInteger 提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、位操作以及一些其他操作。
构造器

- BigInteger(String val)：根据字符串构建BigInteger对象

常用方法

- 一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。

- BigDecimal类支持不可变的、任意精度的有符号十进制定点数。

```java
public BigDecimal(double val)
public BigDecimal(String val)
```

```java
public BigDecimal add(BigDecimal augend)
public BigDecimal subtract(BigDecimal subtrahend)
public BigDecimal multiply(BigDecimal multiplicand)
public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
  
BigInteger bi = new BigInteger("12433241123");
BigDecimal bd = new BigDecimal("12435.351");
BigDecimal bd2 = new BigDecimal("11");
log.info(String.valueOf(bi));
log.info(String.valueOf(bd.divide(bd2, BigDecimal.ROUND_HALF_UP)));
log.info(String.valueOf(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP)));
```

BigInteger和BigDecimal是Java中用于处理大整数和大浮点数的类。下面是它们的一些示例用法：

1. BigInteger示例：

```java
import java.math.BigInteger;

BigInteger num1 = new BigInteger("1234567890");
BigInteger num2 = new BigInteger("9876543210");

BigInteger sum = num1.add(num2);
System.out.println("Sum: " + sum);

BigInteger difference = num1.subtract(num2);
System.out.println("Difference: " + difference);

BigInteger product = num1.multiply(num2);
System.out.println("Product: " + product);

BigInteger quotient = num1.divide(num2);
System.out.println("Quotient: " + quotient);

BigInteger remainder = num1.remainder(num2);
System.out.println("Remainder: " + remainder);

BigInteger power = num1.pow(3);
System.out.println("Power: " + power);
```

2.BigDecimal示例：

```java
import java.math.BigDecimal;
import java.math.RoundingMode;

BigDecimal num1 = new BigDecimal("3.14159");
BigDecimal num2 = new BigDecimal("2.71828");

BigDecimal sum = num1.add(num2);
System.out.println("Sum: " + sum);

BigDecimal difference = num1.subtract(num2);
System.out.println("Difference: " + difference);

BigDecimal product = num1.multiply(num2);
System.out.println("Product: " + product);

BigDecimal quotient = num1.divide(num2, 5, RoundingMode.HALF_UP);
System.out.println("Quotient: " + quotient);

BigDecimal power = num1.pow(2);
System.out.println("Power: " + power);
```

在上述示例中，我们使用BigInteger类执行大整数的加法、减法、乘法、除法、取余和幂运算。而对于BigDecimal类，我们执行了大浮点数的加法、减法、乘法、除法和幂运算。在使用BigDecimal进行除法运算时，我们还指定了保留的小数位数和舍入模式。

这些示例展示了BigInteger和BigDecimal类的一些常见用法。它们提供了各种方法来执行数学运算，并具有高精度和无损失的特性，非常适合处理大数值的场景。
