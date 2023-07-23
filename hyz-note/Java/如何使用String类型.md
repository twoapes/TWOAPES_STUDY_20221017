# 如何使用String类

在Java中,`String`类是一个内置类,用于表示字符串。它是不可变的,也就是说一旦创建,字符串的内容就不能被修改。`String`类提供了许多用于操作字符串的方法。

以下是一些`String`类的特点和功能:

- 字符串的创建:可以使用字符串字面量或通过`new`关键字创建`String`对象。

```java
String str1 = "Hello"; // 使用字符串字面量创建
String str2 = new String("World"); // 使用new关键字创建
```

- 不可变性:`String`对象的内容一旦确定就不可更改。当对字符串进行拼接、替换等操作时,实际上是创建了新的字符串对象。

```java
String str = "Hello";
str = str + " World"; // 创建了新的字符串对象
```

- 字符串操作:`String`类提供了许多方法用于处理字符串,例如获取长度、拼接、截取、替换、转换大小写等。

```java
String str = "Hello World";
int length = str.length(); // 获取字符串长度
String concatStr = str.concat("!"); // 字符串拼接
String subStr = str.substring(6); // 截取子串
String replacedStr = str.replace("World", "Java"); // 字符串替换
```

- 字符串比较:`String`类提供了用于比较字符串的方法,包括比较内容和比较大小写不敏感等。

```java
String str1 = "Hello";
String str2 = "hello";
boolean isEqual = str1.equals(str2); // 比较内容是否相等
boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2); // 比较内容（忽略大小写）是否相等
```

- 字符串格式化:`String`类支持格式化字符串,使用占位符和参数来构建格式化的字符串。

```java
String name = "Alice";
int age = 25;
String formattedStr = String.format("My name is %s and I am %d years old.", name, age);
```

`String`类是非常常用和重要的类,在Java编程中经常被用于处理文本和字符串操作。由于字符串的不可变性,它具有线程安全的特性,适合在多线程环境下使用。

- String类**使用final修饰**,**不可被继承**

- String类使用**实现了Comparable接口**,**可序列化和比较**

- String类内部**final chart[] value存储**字符串数据

- String类**不可变字符序列**

字符串重新赋值后内存区域重新赋值,不能使用原来的value

对现有字符串连接也要内存区域重新赋值,不能使用原来的value

调用replace方法时也要内存区域重新赋值,不能使用原来的value

字面量的方式创建的字符串在**字符串常量池**中,而字符串常量池**不会存储相同的字符串**
