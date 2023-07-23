# Collection接口方法

- Collection接口是List,Set 和Queue接口的父接口,该接口里定义的方法既可用于操作Set 集合,也可用于操作List 和Queue 集合

- JDK不提供此接口的任何直接实现，而是提供更具体的子接口实现

> 如：Set和List

- 在JDK 5.0之前，Java集合会丢失容器中所有对象的数据类型，把所有对象都当成Object类型处理

- 从JDK 5.0增加了泛型以后，Java 集合可以记住容器中对象的数据类型

```txt
1.添加text
add(Object obj)
addAll(Collection coll)
2.获取有效元素的个数
int size()
3.清空集合
void clear()
4.是否是空集合
boolean isEmpty()
5.是否包含某个元素
boolean contains(Object obj)//是通过元素的equals方法来判断是否是同一个对象
boolean containsAll(Collection c)//也是调用元素的equals方法来比较的拿,两个集合的元素挨个比较
6.删除
boolean remove(Object obj) //通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
boolean removeAll(Collection coll)//取当前集合的差集
7.取两个集合的交集
boolean retainAll(Collection c)//把交集的结果存在当前集合中，不影响
8.集合是否相等
boolean equals(Object obj)
9.转成对象数组
Object[] toArray()
10.获取集合对象的哈希值
hashCode()
11.遍历
iterator()//返回迭代器对象，用于集合遍历
```

下面是`Collection`常用接口方法的详细示例：

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        // 创建一个ArrayList集合
        Collection<String> collection = new ArrayList<>();

        // 添加元素
        collection.add("Java");
        collection.add("Python");
        collection.add("C++");

        // 判断集合是否为空
        boolean isEmpty = collection.isEmpty();
        System.out.println("集合是否为空: " + isEmpty);

        // 获取集合的大小
        int size = collection.size();
        System.out.println("集合的大小: " + size);

        // 判断集合是否包含某个元素
        boolean containsElement = collection.contains("Java");
        System.out.println("集合是否包含Java: " + containsElement);

        // 删除元素
        collection.remove("C++");

        // 使用迭代器遍历集合
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("元素: " + element);
        }

        // 清空集合
        collection.clear();

        // 判断集合是否为空
        isEmpty = collection.isEmpty();
        System.out.println("集合是否为空: " + isEmpty);
    }
}
```

这个示例演示了`Collection`接口的常用方法。首先，我们创建了一个`ArrayList`对象，并向集合中添加了一些元素。然后，我们使用`isEmpty()`方法检查集合是否为空，并使用`size()`方法获取集合的大小。接下来，我们使用`contains()`方法判断集合是否包含特定元素，并使用`remove()`方法删除指定元素。然后，我们使用迭代器(`Iterator`)来遍历集合中的元素，并输出它们的值。最后，我们使用`clear()`方法清空集合，并再次使用`isEmpty()`方法验证集合是否为空。

这个示例覆盖了`Collection`接口的常用方法，你可以根据需要进行修改和扩展。
