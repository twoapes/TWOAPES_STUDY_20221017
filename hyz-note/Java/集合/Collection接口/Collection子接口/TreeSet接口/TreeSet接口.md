# TreeSet

- TreeSet 是 SortedSet 接口的实现

  TreeSet 可以确保集合元素处于排序状态

- TreeSet底层使用红黑树结构存储数据

- TreeSet 两种排序方法

  自然排序和定制排序

默认情况下，TreeSet 采用自然排序

TreeSet和TreeMap采用红黑树的存储结构

有序， 查询速度比List快

```java
Comparator comparator()
Object first()
Object last()
Object lower(Object e)
Object higher(Object e)
SortedSet subSet(fromElement, toElement)
SortedSet headSet(toElement)
SortedSet tailSet(fromElement)
```
