# Hashtable

`Hashtable` 是 Java 中的一个哈希表实现，它实现了 `Map` 接口，并使用键值对存储数据。下面是关于 `Hashtable` 的一些概念解释：

1. 哈希表：
`Hashtable` 是基于哈希表的数据结构，它使用键值对存储数据。哈希表根据键的哈希码（hash code）将键值对映射到表中的位置，从而实现快速的插入、删除和查找操作。

2. 线程安全：
`Hashtable` 是线程安全的，多个线程可以同时访问和修改 `Hashtable` 的内容，而不需要额外的同步操作。它通过使用同步机制来保证线程安全性，但也会导致一定的性能开销。

3. 键的唯一性和值的可重复：
`Hashtable` 中的键是唯一的，不允许重复键。每个键对应一个值，值可以是重复的。

4. 效率：
`Hashtable` 提供了常数时间复杂度的插入、删除和查找操作。但由于线程安全的特性，相比于非线程安全的哈希表实现（如 `HashMap`），`Hashtable` 在性能方面可能稍逊一筹。

5. null 值和 null 键的不允许：
`Hashtable` 不允许存储 null 值或 null 键。如果试图存储 null 值或 null 键，将会抛出 `NullPointerException`。

`Hashtable` 提供了一系列的方法和操作，类似于 `HashMap`，包括添加键值对、获取值、删除键值对、遍历键值对等。它适用于需要线程安全的键值对存储和检索的场景。然而，在不需要线程安全的情况下，推荐使用性能更好的 `HashMap`。

- Hashtable是个古老的Map实现类,JDK1.0就提供了

  不同于HashMap,Hashtable是线程安全的

- Hashtable实现原理和HashMap相同,功能相同

  底层都使用哈希表结构，查询速度快，很多情况下可以互用

- 与HashMap不同,Hashtable不允许使用null作为key和value

- 与HashMap一样,Hashtable也不能保证其中Key-Value对的顺序

- Hashtable判断两个key相等,两个value相等的标准,与HashMap一致
