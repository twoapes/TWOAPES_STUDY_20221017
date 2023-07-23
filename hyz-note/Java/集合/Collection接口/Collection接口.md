# Collection接口

`Collection` 接口是 Java 集合框架中的根接口之一，它代表了一组对象的集合。`Collection` 接口定义了对集合进行常见操作的方法，如添加、删除、查找、遍历等。它提供了一种统一的方式来操作不同类型的集合。

以下是 `Collection` 接口的一些重要概念：

1. 元素：`Collection` 接口中的集合可以包含多个元素，每个元素可以是任意类型的对象。

2. 无序性：`Collection` 接口中的集合通常是无序的，即元素的顺序不固定。不同的集合实现可能有不同的元素存储顺序。

3. 不可重复性：`Collection` 接口中的集合通常不允许包含重复的元素。每个元素在集合中只能存在一次。

4. 大小可变性：`Collection` 接口中的集合的大小是可变的，可以根据需要添加或删除元素。

`Collection` 接口定义了一些常用的方法来操作集合，其中一些重要的方法包括：

- `add(E element)`：向集合中添加一个元素。

- `remove(Object element)`：从集合中移除指定的元素。

- `contains(Object element)`：检查集合是否包含指定的元素。

- `isEmpty()`：检查集合是否为空。

- `size()`：返回集合中元素的数量。

- `iterator()`：返回一个迭代器，用于遍历集合中的元素。

`Collection` 接口是其他集合接口和类的基础，例如 `List`、`Set` 和 `Queue` 接口都是继承自 `Collection` 接口，而具体的集合类如 `ArrayList`、`HashSet` 和 `LinkedList` 等都实现了 `Collection` 接口。

由于 `Collection` 接口是一个接口，它本身不能被实例化，但可以通过实例化具体的集合类来使用 `Collection` 接口定义的方法和特性。

单列数据，定义了存取一组对象的方法的集合

- List

  元素有序,可重复的集合

- Set

  元素无序、不可重复的集合
