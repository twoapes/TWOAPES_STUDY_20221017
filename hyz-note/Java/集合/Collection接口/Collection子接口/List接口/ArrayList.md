# ArrayList

- ArrayList是List接口的典型实现类,主要实现类

- 本质上,ArrayList是对象引用的一个"变长数组"

JDK1.7

> ArrayList像饿汉式，直接创建一个初始容量为10的数组

JDK1.8

> ArrayList像懒汉式，一开始创建一个长度为0的数组，当添加第一个元素时再创建一个始容量为10的数组
Arrays.asList(...) 方法返回的 List 集合，既不是 ArrayList 实例，也不是Vector 实例
Arrays.asList(...) 返回值是一个固定长度的 List 集合

当使用Java中的ArrayList时，你可以按照以下步骤创建和使用它：

1. 导入ArrayList类：

```java
import java.util.ArrayList;
```

2.创建ArrayList实例：

```java
ArrayList<String> myList = new ArrayList<String>();
```

在这个例子中，ArrayList被参数化为String类型，这意味着它只能存储字符串类型的元素。你可以根据需要选择其他类型，例如`Integer`、`Double`等。

3.添加元素到ArrayList：

```java
myList.add("Apple");
myList.add("Banana");
myList.add("Orange");
```

使用`add()`方法可以将元素添加到ArrayList中。这些元素将按照添加的顺序存储在列表中。

4.获取ArrayList的大小：

```java
int size = myList.size();
System.out.println("Size: " + size);
```

`size()`方法返回ArrayList中元素的数量。

5.访问ArrayList的元素：

```java
String firstElement = myList.get(0);
System.out.println("First Element: " + firstElement);
```

使用`get()`方法，通过指定索引可以获取ArrayList中的元素。请注意，索引从0开始，因此第一个元素的索引为0。

6.遍历ArrayList：

```java
for (String element : myList) {
    System.out.println(element);
}
```

使用增强的for循环可以遍历ArrayList中的所有元素，并对它们进行操作。

7.检查元素是否存在：

```java
boolean containsBanana = myList.contains("Banana");
System.out.println("Contains Banana: " + containsBanana);
```

`contains()`方法可用于检查ArrayList中是否存在指定的元素。如果存在，它将返回`true`；否则，返回`false`。

8.删除元素：

```java
myList.remove("Orange");
```

使用`remove()`方法可以从ArrayList中删除指定的元素。

以上是使用ArrayList的基本操作示例。你可以根据需要对其进行扩展和修改。
