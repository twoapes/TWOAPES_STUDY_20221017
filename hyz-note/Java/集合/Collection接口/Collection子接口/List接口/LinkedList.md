# LinkedList

对于频繁的插入或删除元素的操作，建议使用LinkedList类，效率较高

LinkedList

> 双向链表，内部没有声明数组，而是定义了Node类型的first和last，用于记录首末元素
同时，定义内部类Node，作为LinkedList中保存数据的基本结构

Node除了保存数据，还定义了两个变量

- prev变量记录前一个元素的位置

- next变量记录下一个元素的位置

```java
void addFirst(Object obj)
void addLast(Object obj)
Object getFirst()
Object getLast()
Object removeFirst()
Object removeLast()
```

当使用Java中的LinkedList时，你可以按照以下步骤创建和使用它：

1. 导入LinkedList类：

```java
import java.util.LinkedList;
```

2.创建LinkedList实例：

```java
LinkedList<String> linkedList = new LinkedList<String>();
```

在这个例子中，LinkedList被参数化为String类型，这意味着它只能存储字符串类型的元素。你可以根据需要选择其他类型，例如`Integer`、`Double`等。

3.添加元素到LinkedList：

```java
linkedList.add("Apple");
linkedList.add("Banana");
linkedList.add("Orange");
```

使用`add()`方法可以将元素添加到LinkedList中。这些元素将按照添加的顺序存储在列表中。

4.获取LinkedList的大小：

```java
int size = linkedList.size();
System.out.println("Size: " + size);
```

`size()`方法返回LinkedList中元素的数量。

5.访问LinkedList的元素：

```java
String firstElement = linkedList.getFirst();
System.out.println("First Element: " + firstElement);

String lastElement = linkedList.getLast();
System.out.println("Last Element: " + lastElement);
```

使用`getFirst()`方法可以获取LinkedList的第一个元素，使用`getLast()`方法可以获取LinkedList的最后一个元素。

6.遍历LinkedList：

```java
for (String element : linkedList) {
    System.out.println(element);
}
```

使用增强的for循环可以遍历LinkedList中的所有元素，并对它们进行操作。

7.插入和删除元素：

```java
linkedList.add(1, "Mango"); // 在索引1的位置插入"Mango"
linkedList.remove(2); // 删除索引为2的元素
```

使用`add(int index, E element)`方法可以在指定索引位置插入元素，使用`remove(int index)`方法可以删除指定索引处的元素。

以上是使用LinkedList的基本操作示例。你可以根据需要对其进行扩展和修改。
