# Map接口

`Map` 接口是 Java 集合框架中用于存储键值对（key-value pairs）的接口。它提供了一种将键映射到值的方式，其中每个键在 `Map` 中是唯一的，而每个键可以关联一个对应的值。`Map` 接口提供了一系列方法来操作键值对，如添加、获取、删除和遍历等。

以下是 `Map` 接口的一些重要概念：

1. 键值对：`Map` 中的数据以键值对的形式存储。每个键与对应的值构成一个键值对。键用于唯一标识一个值。

2. 键的唯一性：`Map` 中的键是唯一的，每个键只能对应一个值。如果在 `Map` 中插入具有相同键的多个键值对，则后面的键值对会覆盖前面的键值对。

3. 无序性：`Map` 中的键值对通常是无序的，即键值对的顺序不固定。不同的 `Map` 实现可能有不同的键值对存储顺序。

4. 值的重复性：`Map` 中的值可以是重复的，不同的键可以关联相同的值。

`Map` 接口定义了一些常用的方法来操作键值对，其中一些重要的方法包括：

- `put(K key, V value)`：将指定的键值对添加到 `Map` 中。

- `get(Object key)`：根据键获取对应的值。

- `remove(Object key)`：从 `Map` 中移除指定键的键值对。

- `containsKey(Object key)`：检查 `Map` 是否包含指定的键。

- `containsValue(Object value)`：检查 `Map` 是否包含指定的值。

- `isEmpty()`：检查 `Map` 是否为空。

- `size()`：返回 `Map` 中键值对的数量。

- `keySet()`：返回包含所有键的集合。

- `values()`：返回包含所有值的集合。

- `entrySet()`：返回包含所有键值对的集合。

`Map` 接口的常见实现类包括 `HashMap`、`TreeMap` 和 `LinkedHashMap`。这些实现类提供了不同的性能、排序和顺序特性，可以根据需要选择合适的实现类来存储和操作键值对。

双列数据，保存具有映射关系"key-value对"的集合

Map接口概述

- Map与Collection并列存在

> 用于保存具有映射关系的数据key-value

- Map中的key和value 都可以是任何引用类型的数据

- Map中的key用Set来存放,不允许重复,即同一个Map对象所对应的类,须重写hashCode()和equals()方法

- 常用String类作为Map的"键"

- key和value之间存在单向一对一关系,即通过指定的key总能找到唯一的,确定的value

- Map接口的常用实现类

> HashMap,TreeMap,LinkedHashMap和Properties

其中，HashMap是 Map 接口使用频率最高的实现类

常用方法

```java
Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
void putAll(Map m):将m中的所有key-value对存放到当前map中
Object remove(Object key)：移除指定key的key-value对，并返回value
void clear()：清空当前map中的所有数据
```

```java
Object get(Object key)：获取指定key对应的value
boolean containsKey(Object key)：是否包含指定的key
boolean containsValue(Object value)：是否包含指定的value
int size()：返回map中key-value对的个数
boolean isEmpty()：判断当前map是否为空
boolean equals(Object obj)：判断当前map和参数对象obj是否相等
```

```java
Set keySet()：返回所有key构成的Set集合
Collection values()：返回所有value构成的Collection集合
Set entrySet()：返回所有key-value对构成的Set集合
```
