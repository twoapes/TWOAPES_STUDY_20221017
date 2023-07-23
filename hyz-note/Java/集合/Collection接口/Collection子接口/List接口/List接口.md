# List接口

List接口是Java编程语言中的一个接口，它是Java集合框架中的一部分。List接口定义了一组操作，用于处理元素的有序集合。与Set接口不同，List接口允许存储重复的元素，并且可以按照插入的顺序进行访问。

以下是List接口的一些主要概念：

1. 有序性：List中的元素按照插入的顺序进行存储，并且可以通过索引访问。这意味着你可以按照插入的顺序获取元素，并且元素在List中的位置是有意义的。

2. 索引：List中的每个元素都有一个与之关联的索引，用于唯一标识元素在List中的位置。索引从0开始，依次递增。

3. 可变性：List接口允许添加、删除和修改元素。你可以通过添加新元素来扩展List的大小，删除元素以减小大小，并且可以修改特定位置上的元素。

4. 元素重复：List接口允许存储重复的元素。这意味着你可以在List中多次添加相同的元素，并且它们将保留在特定的顺序中。

5. 迭代器：List接口提供了一个迭代器，用于遍历List中的元素。你可以使用迭代器逐个访问List中的元素，也可以使用增强型for循环进行遍历。

6. 实现类：List接口是一个接口，它有多个实现类，包括ArrayList、LinkedList和Vector等。每个实现类都提供了不同的性能和特性，以满足不同的需求。

通过使用List接口，你可以轻松地操作有序集合，并且能够方便地对元素进行添加、删除和修改操作，以及按需访问特定位置的元素。

总之，`List`接口提供了一种有序集合的抽象表示，允许存储重复元素并提供了对元素的索引访问。它是Java集合框架中重要且常用的接口之一。

- 鉴于Java中数组用来存储数据的局限性,我们通常使用List替代数组

- List集合类中元素有序,且可重复,集合中的每个元素都有其对应的顺序索引

- List容器中的元素都对应一个整数型的序号记载其在容器中的位置,可以根据序号存取容器中的元素

- JDK API中List接口的实现类常用的有

List除了从Collection集合继承的方法外,List 集合里添加了一些根据索引来操作集合元素的方法

```java
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
```
