# Vector

Vector 是一个古老的集合,JDK1.0就有了

大多数操作与ArrayList相同,区别之处在于Vector是线程安全的
在各种list中,最好把ArrayList作为缺省选择

当插入,删除频繁时,使用LinkedList

Vector总是比ArrayList慢,所以尽量避免使用

```java
void addElement(Object obj)
void insertElementAt(Object obj,int index)
void setElementAt(Object obj,int index)
void removeElement(Object obj)
void removeAllElements()
```

当使用Java中的Vector时，你可以按照以下步骤创建和使用它：

1. 导入Vector类：

```java
import java.util.Vector;
```

2.创建Vector实例：

```java
Vector<String> vector = new Vector<String>();
```

在这个例子中，Vector被参数化为String类型，这意味着它只能存储字符串类型的元素。你可以根据需要选择其他类型，例如`Integer`、`Double`等。

3.添加元素到Vector：

```java
vector.add("Apple");
vector.add("Banana");
vector.add("Orange");
```

使用`add()`方法可以将元素添加到Vector中。这些元素将按照添加的顺序存储在列表中。

4.获取Vector的大小：

```java
int size = vector.size();
System.out.println("Size: " + size);
```

`size()`方法返回Vector中元素的数量。

5.访问Vector的元素：

```java
String firstElement = vector.firstElement();
System.out.println("First Element: " + firstElement);

String lastElement = vector.lastElement();
System.out.println("Last Element: " + lastElement);
```

使用`firstElement()`方法可以获取Vector的第一个元素，使用`lastElement()`方法可以获取Vector的最后一个元素。

6.遍历Vector：

```java
for (String element : vector) {
    System.out.println(element);
}
```

使用增强的for循环可以遍历Vector中的所有元素，并对它们进行操作。

7.插入和删除元素：

```java
vector.insertElementAt("Mango", 1); // 在索引1的位置插入"Mango"
vector.remove(2); // 删除索引为2的元素
```

使用`insertElementAt(E element, int index)`方法可以在指定索引位置插入元素，使用`remove(int index)`方法可以删除指定索引处的元素。

以上是使用Vector的基本操作示例。由于Vector是线程安全的，可以在多线程环境下使用。你可以根据需要对其进行扩展和修改。
