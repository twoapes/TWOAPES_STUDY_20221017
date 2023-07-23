# String类

String实例化方式
1.字面量
2.new 构造器
String的特性

- String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现

- String是一个final类，代表不可变的字符序列

- 字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改

- String对象的字符内容是存储在一个字符数组value[]中的

## 结论

- 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。

- 只要其中有一个是变量，结果就在堆中

- 如果拼接的结果调用intern()方法，返回值就在常量池中

## 常用方法

- int length()：返回字符串的长度： return value.length

- char charAt(int index)： 返回某索引处的字符return value[index]

- boolean isEmpty()：判断是否是空字符串：return value.length == 0

- String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写

- String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写

- String trim()：返回字符串的副本，忽略前导空白和尾部空白

- boolean equals(Object obj)：比较字符串的内容是否相同

- boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写

- String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”

- int compareTo(String anotherString)：比较两个字符串的大小

- String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。

- String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

- boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束

- boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始

- boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

- boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true

- int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引

- int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始

- int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引

- int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
注：indexOf和lastIndexOf方法如果未找到都是返回-1

- String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

- String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。

- String replaceAll(String regex, String replacement) ： 使用给定的replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

- String replaceFirst(String regex, String replacement) ： 使用给定的replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

- boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。

- String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。

- String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中

```txt
字符串->基本数据类型、包装类
Integer包装类的public static int parseInt(String s)：可以将由“数字”字符组成的字符串转换为整型。
类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。
基本数据类型、包装类->字符串
调用String类的public String valueOf(int n)可将int型转换为字符串
相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double d)、valueOf(boolean b)可由参数的相应类型到字符串的转换
字符数组->字符串
String 类的构造器：String(char value[]) 和 String(char value[], int offset, int count) 分别用字符数组中的全部字符和部分字符创建字符串对象。
字符串->字符数组
public char[] toCharArray()：将字符串中的全部字符存放在一个字符数组中的方法。
public void getChars(int srcBegin, int srcEnd, char[] dst,int dstBegin)：提供了将指定索引范围内的字符串存放到数组中的方法
字节数组->字符串
String(byte[])：通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
String(byte[]，int offset，int length) ：用指定的字节数组的一部分，即从数组起始位置offset开始取length个字节构造一个字符串对象。
字符串->字节数组
public byte[] getBytes() ：使用平台的默认字符集将此 String 编码为byte 序列，并将结果存储到一个新的 byte 数组中。
public byte[] getBytes(String charsetName) ：使用指定的字符集将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组
```

下面是一些常用的String类方法的详细示例：

1. 创建字符串对象：

```java
String str1 = "Hello";
String str2 = new String("World");
```

2.连接字符串：

```java
String str1 = "Hello";
String str2 = "World";
String result = str1 + " " + str2;
System.out.println(result);
```

输出结果：`Hello World`

3.获取字符串长度：

```java
String str = "Hello";
int length = str.length();
System.out.println("字符串长度: " + length);
```

输出结果：`字符串长度: 5`

4.判断字符串是否为空：

```java
String str = "";
boolean isEmpty = str.isEmpty();
System.out.println("字符串是否为空: " + isEmpty);
```

输出结果：`字符串是否为空: true`

5.判断字符串是否包含指定字符/字符串：

```java
String str = "Hello World";
boolean contains1 = str.contains("Hello");
boolean contains2 = str.contains("Java");
System.out.println("包含Hello: " + contains1);
System.out.println("包含Java: " + contains2);
```

输出结果：

```shell
包含Hello: true
包含Java: false
```

6.判断字符串是否以指定字符/字符串开头或结尾：

```java
String str = "Hello World";
boolean startsWith = str.startsWith("Hello");
boolean endsWith = str.endsWith("World");
System.out.println("以Hello开头: " + startsWith);
System.out.println("以World结尾: " + endsWith);
```

输出结果：

```shell
以Hello开头: true
以World结尾: true
```

7.获取指定位置的字符：

```java
String str = "Hello";
char ch = str.charAt(1);
System.out.println("位置1的字符: " + ch);
```

输出结果：`位置1的字符: e`

8.字符串切割：

```java
String str = "Hello,World";
String[] parts = str.split(",");
for (String part : parts) {
    System.out.println(part);
}
```

输出结果：

```shell
Hello
World
```

9.字符串替换：

```java
String str = "Hello,World";
String replaced = str.replace(",", " ");
System.out.println(replaced);
```

输出结果：`Hello World`

10.字符串转换为大写/小写：

```java
String str = "Hello";
String upperCase = str.toUpperCase();
String lowerCase = str.toLowerCase();
System.out.println("大写: " + upperCase);
System.out.println("小写: " + lowerCase);
```

输出结果：

```shell
大写: HELLO
小写: hello
```

11.去除字符串前后的空格：

```java
String str = "  Hello World  ";
String trimmed = str.trim();
System.out.println(trimmed);
```

输出结果：`Hello World`

这些示例展示了String类的一些常用方法。String类提供了许多方法来操作和处理字符串，包括连接、比较、截取、替换、转换大小写等。根据具体需求，可以选择适当的方法来处理和操作字符串。
