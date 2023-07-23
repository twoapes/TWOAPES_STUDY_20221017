# Math类

```txt
java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回
值类型一般为double型。
abs 绝对值
acos,asin,atan,cos,sin,tan 三角函数
sqrt 平方根
pow(double a,doble b) a的b次幂
log 自然对数
exp e为底指数
max(double a,double b)
min(double a,double b)
random() 返回0.0到1.0的随机数
long round(double a) double型数据a转换为long型（四舍五入）
toDegrees(double angrad) 弧度—>角度
toRadians(double angdeg) 角度—>弧度
```

下面是一些使用Java中的Math类的常见示例：

1. 获取绝对值：

```java
int number = -5;
int absoluteValue = Math.abs(number);
System.out.println("绝对值: " + absoluteValue);
```

2.计算平方根：

```java
double number = 16;
double squareRoot = Math.sqrt(number);
System.out.println("平方根: " + squareRoot);
```

3.计算最大值：

```java
int x = 10;
int y = 5;
int max = Math.max(x, y);
System.out.println("最大值: " + max);
```

4.计算最小值：

```java
int x = 10;
int y = 5;
int min = Math.min(x, y);
System.out.println("最小值: " + min);
```

5.生成随机数：

```java
double random = Math.random();
System.out.println("随机数: " + random);
```

6.向上取整：

```java
double number = 3.2;
double roundedUp = Math.ceil(number);
System.out.println("向上取整: " + roundedUp);
```

7.向下取整：

```java
double number = 3.8;
double roundedDown = Math.floor(number);
System.out.println("向下取整: " + roundedDown);
```

8.四舍五入：

```java
double number = 3.7;
long rounded = Math.round(number);
System.out.println("四舍五入: " + rounded);
```

这些示例展示了Math类的一些常用功能。Math类还有其他方法，可根据具体需求进行查阅和使用。
