# HashSet

- HashSet是Set接口的典型实现,大多数时候使用Set集合时都使用这个实现类

- HashSet按Hash算法来存储集合中的元素,因此具有很好的存取,查找,删除性能

HashSet 具有以下特点

- 不能保证元素的排列顺序

- HashSet 不是线程安全的

- 集合元素可以是 null

  HashSet 集合判断两个元素相等的标准
两个对象通过 hashCode() 方法比较相等，并且两个对象的 equals() 方法返回值也相等

- 对于存放在Set容器中的对象，对应的类一定要重写equals()和hashCode(Object obj)方法，以实现对象相等规则

  即："相等的对象必须具有相等的散列码"

HashSet 集合判断两个元素相等的标准
两个对象通过 hashCode() 方法比较相等，并且两个对象的 equals() 方法返回值也相等

- 对于存放在Set容器中的对象，对应的类一定要重写equals()和hashCode(Object obj)方法，以实现对象相等规则

  即：“相等的对象必须具有相等的散列码”

- 向HashSet中添加元素的过程

  当向 HashSet 集合中存入一个元素时，HashSet 会调用该对象的 hashCode() 方法
来得到该对象的 hashCode 值，然后根据 hashCode 值，通过某种散列函数决定该对象在 HashSet 底层数组中的存储位置

  这个散列函数会与底层数组的长度相计算得到在数组中的下标，并且这种散列函数计算还尽可能保证能均匀存储元素，越是散列分布，该散列函数设计的越好

如果两个元素的hashCode()值相等，会再继续调用equals方法，如果equals方法结果为true，添加失败

如果为false，那么会保存该元素，但是该数组的位置已经有元素了，那么会通过链表的方式继续链接

如果两个元素的equals()方法返回true，但它们的hashCode()返回值不相等，hashSet 将会把它们存储在不同的位置，但依然可以添加成功

![image.png](https://flowus.cn/preview/3fe87a91-b17a-4548-b91f-6786ff962c42)

重写hashCode()方法的基本原则

- 在程序运行时,同一个对象多次调用hashCode()方法应该返回相同的值

- 当两个对象的equals()方法比较返回true时,这两个对象的hashCode()方法的返回值也应相等

- 对象中用作equals()方法比较的Field,都应该用来计算hashCode值

重写 equals() 方法的基本原则

- 以自定义的Customer类为例,何时需要重写equals()

- 当一个类有自己特有的“逻辑相等”概念,当改写equals()的时候,总是要改写hashCode(),根据一个类的equals方法(改写后),两个截然不同的实例有可能在逻辑上是相等的,但是,根据Object.hashCode()方法,它们仅仅是两个对象

- 因此,违反了"相等的对象必须具有相等的散列码"

复写equals方法的时候一般都需要同时复写hashCode方法,通常参与计算hashCode的对象的属性也应该参与到equals()中进行计算

下面是一个使用HashSet的详细示例代码：

```java
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        // 创建一个HashSet实例
        HashSet<String> set = new HashSet<>();

        // 添加元素到HashSet
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("apple"); // 添加重复元素，将被忽略

        System.out.println("HashSet的大小: " + set.size()); // 输出：3

        // 遍历HashSet
        System.out.println("HashSet的元素:");
        for (String element : set) {
            System.out.println(element);
        }

        // 判断元素是否存在于HashSet中
        System.out.println("HashSet中是否包含banana: " + set.contains("banana")); // 输出：true

        // 从HashSet中删除元素
        set.remove("orange");
        System.out.println("HashSet的大小: " + set.size()); // 输出：2

        // 清空HashSet
        set.clear();
        System.out.println("HashSet是否为空: " + set.isEmpty()); // 输出：true
    }
}
```

以上代码创建了一个HashSet实例，并演示了常见的操作。首先，通过add()方法添加元素到HashSet，注意到添加重复元素时，HashSet会自动去重。然后，通过size()方法获取HashSet的大小，使用增强型for循环遍历HashSet中的元素，并使用contains()方法判断元素是否存在于HashSet中。接下来，通过remove()方法删除HashSet中的元素，并再次使用size()方法验证大小的变化。最后，通过clear()方法清空HashSet，并使用isEmpty()方法判断HashSet是否为空。

运行上述代码，将会输出以下结果：

```shell
HashSet的大小: 3
HashSet的元素:
banana
orange
apple
HashSet中是否包含banana: true
HashSet的大小: 2
HashSet是否为空: true
```

可以看到，HashSet中的重复元素被自动去重，元素的顺序是无序的，并且可以通过常见的方法进行添加、删除和查找操作。
