# TreeMap

`TreeMap` 是 Java 中的一个有序映射实现，它实现了 `SortedMap` 接口，并基于红黑树数据结构来存储键值对。下面是关于 `TreeMap` 的一些概念解释：

1. 有序性：
`TreeMap` 中的键值对是按照键的自然顺序或自定义比较器的顺序进行排序的。这使得 `TreeMap` 可以提供按键有序的遍历和检索功能。

2. 红黑树：
`TreeMap` 内部使用红黑树（Red-Black Tree）来存储键值对。红黑树是一种自平衡的二叉搜索树，它能够保持树的平衡性，使得插入、删除和查找操作的时间复杂度为 O(log n)。

3. 自然顺序和自定义比较器：
`TreeMap` 默认使用键的自然顺序进行排序，也可以通过提供自定义的比较器来指定键的排序方式。自然顺序是基于键类型的默认排序规则，而自定义比较器是根据自定义的比较逻辑进行排序。

4. 键的唯一性：
`TreeMap` 中的键是唯一的，不允许重复键。如果插入了重复的键，则新的值会覆盖原有的值。

5. 查找效率：
由于 `TreeMap` 使用红黑树作为内部数据结构，它具有较高的查找效率。通过红黑树的特性，可以快速定位和检索键值对。

`TreeMap` 提供了一系列的方法和操作，包括添加键值对、获取值、删除键值对、按范围检索键值对等。它适用于需要按键有序访问和检索的场景，并且具有较高的查找效率。

- TreeMap存储 Key-Value 对时,需要根据 key-value 对进行排序

- TreeMap 可以保证所有的 Key-Value 对处于有序状态

- TreeSet底层使用红黑树结构存储数据

- TreeMap的Key的排序

自然排序

> TreeMap的所有的Key必须实现Comparable接口,而且所有的Key应该是同一个类的对象,否则将会抛出ClasssCastException

定制排序

> 创建TreeMap时,传入一个 Comparator 对象,该对象负责对TreeMap中的所有key进行排序,此时不需要Map的Key实现Comparable 接口

TreeMap判断两个key相等的标准

> 两个key通过compareTo()方法或者compare()方法返回0
