# HashMap源码中的重要常量

- DEFAULT_INITIAL_CAPACITY

> HashMap的默认容量，16

- MAXIMUM_CAPACITY

> HashMap的最大支持容量，2^30

- DEFAULT_LOAD_FACTOR

> HashMap的默认加载因子

- TREEIFY_THRESHOLD

> Bucket中链表长度大于该默认值，转化为红黑树

- UNTREEIFY_THRESHOLD

> Bucket中红黑树存储的Node小于该默认值，转化为链表

- MIN_TREEIFY_CAPACITY

> 桶中的Node被树化时最小的hash表容量
当桶中Node的数量大到需要变红黑树时，若hash表容量小MIN_TREEIFY_CAPACITY时，此时应执行resize扩容操作这个MIN_TREEIFY_CAPACITY的值至少是TREEIFY_THRESHOLD的4倍

```txt
table：存储元素的数组，总是2的n次幂
entrySet：存储具体元素的集
size：HashMap中存储的键值对的数量
modCount：HashMap扩容和结构改变的次数
threshold：扩容的临界值，=容量*填充因子
loadFactor：填充因子
```

- HashMap的内部存储结构其实是数组和链表的结合
当实例化一个HashMap时，系统会创建一个长度为Capacity的Entry数组，这个长度在哈希表中被称为容量(Capacity)，在这个数组中可以存放元素的位置我们称之为“桶”(bucket)，每个bucket都有自己的索引，系统可以根据索引快速的查找bucket中的元素

- 每个bucket中存储一个元素，即一个Entry对象，但每一个Entry对象可以带一个引用变量，用于指向下一个元素，因此，在一个桶中，就有可能生成一个Entry链
而且新添加的元素作为链表的head

```txt
向HashMap中添加entry1(key，value)，需要首先计算entry1中key的哈希值(根据key所在类的hashCode()计算得到)，此哈希值经过处理以后，得到在底层Entry[]数组中要存储的位置i
如果位置i上没有元素，则entry1直接添加成功
如果位置i上已经存在entry2(或还有链表存在的entry3，entry4)，则需要通过循环的方法，依次比较entry1中key和其他的entry
如果彼此hash值不同，则直接添加成功。如果hash值不同，继续比较二者是否equals。如果返回值为true，则使用entry1的value去替换equals为true的entry的value
如果遍历一遍以后，发现所有的equals返回都为false,则entry1仍可添加成功。entry1指向原有的entry元素
```

```txt
当HashMap中的元素越来越多的时候，hash冲突的几率也就越来越高，因为数组的长度是固定的
所以为了提高查询的效率，就要对HashMap的数组进行扩容，而在HashMap数组扩容之后，最消耗性能的点就出现了：原数组中的数据必须重新计算其在新数组中的位置，并放进去，这就是resize
```

```txt
当HashMap中的元素个数超过数组大小(数组总大小length,不是数组中个数size)*loadFactor时，就会进行数组扩容，loadFactor的默认值(DEFAULT_LOAD_FACTOR)为0.75，这是一个折中的取值
也就是说，默认情况下，数组大小(DEFAULT_INITIAL_CAPACITY)为16，那么当HashMap中元素个数超过16*0.75=12（这个值就是代码中的threshold值，也叫做临界值）的时候，就把数组的大小扩展为 2*16=32，即扩大一倍，然后重新计算每个元素在数组中的位置，而这是一个非常消耗性能的操作，所以如果我们已经预知HashMap中元素的个数，那么预设元素的个数能够有效的提高HashMap的性能
```
