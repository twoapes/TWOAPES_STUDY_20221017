# StringBuffer类

- java.lang.StringBuffer代表可变的字符序列，JDK1.0中声明，可以对字符串内容进行增删，此时不会产生新的对象

- 很多方法与String相同

- 作为参数传递时，方法内部可以改变值

StringBuffer类不同于String，其对象必须使用构造器生成

有三个构造器

- StringBuffer()

初始容量为16的字符串缓冲区

- StringBuffer(int size)

构造指定容量的字符串缓冲区

- StringBuffer(String str)

将内容初始化为指定字符串内容

```java
StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
```

当append和insert时，如果原来value数组长度不够，可扩容

如上这些方法支持方法链操作,方法链的原理

```java
public int indexOf(String str)
public String substring(int start,int end)
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)
```

下面是一些常用的StringBuffer类方法的示例：

1. 创建StringBuffer对象并追加字符串：

```java
StringBuffer stringBuffer = new StringBuffer();
stringBuffer.append("Hello");
stringBuffer.append(" ");
stringBuffer.append("World!");
System.out.println(stringBuffer.toString());
```

输出结果：`Hello World!`

2.插入字符串到指定位置：

```java
StringBuffer stringBuffer = new StringBuffer("Hello!");
stringBuffer.insert(5, " World");
System.out.println(stringBuffer.toString());
```

输出结果：`Hello World!`

3.删除指定范围内的字符串：

```java
StringBuffer stringBuffer = new StringBuffer("Hello World!");
stringBuffer.delete(6, 12);
System.out.println(stringBuffer.toString());
```

输出结果：`Hello!`

4.反转字符串：

```java
StringBuffer stringBuffer = new StringBuffer("Hello");
stringBuffer.reverse();
System.out.println(stringBuffer.toString());
```

输出结果：`olleH`

5.替换指定范围内的字符串：

```java
StringBuffer stringBuffer = new StringBuffer("Hello World!");
stringBuffer.replace(6, 11, "Java");
System.out.println(stringBuffer.toString());
```

输出结果：`Hello Java!`

6.获取字符串的长度：

```java
StringBuffer stringBuffer = new StringBuffer("Hello World!");
int length = stringBuffer.length();
System.out.println("字符串长度: " + length);
```

输出结果：`字符串长度: 12`

7.清空字符串内容：

```java
StringBuffer stringBuffer = new StringBuffer("Hello World!");
stringBuffer.setLength(0);
System.out.println(stringBuffer.toString());
```

输出结果：`（空字符串）`

这些示例展示了StringBuffer类的一些常用方法。StringBuffer类是可变的字符串序列，可用于进行字符串的拼接、插入、删除、替换等操作。根据具体需求，可以选择适当的方法来操作和修改StringBuffer对象中的字符串内容。
