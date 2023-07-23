# LinkedHashSet

LinkedHashSet是HashSet的子类
LinkedHashSet根据元素的hashCode值来决定元素的存储位置,但它同时使用双向链表维护元素的次序,这使得元素看起来是以插入顺序保存的
LinkedHashSet插入性能略低于HashSet,但在迭代访问Set里的全部元素时有很好的性能
LinkedHashSet不允许集合元素重复

下面是一个使用LinkedHashSet的详细示例代码：

```java
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // 创建一个LinkedHashSet实例
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 添加元素到LinkedHashSet
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("apple"); // 添加重复元素，将被忽略

        System.out.println("LinkedHashSet的大小: " + set.size()); // 输出：3

        // 遍历LinkedHashSet
        System.out.println("LinkedHashSet的元素:");
        for (String element : set) {
            System.out.println(element);
        }

        // 判断元素是否存在于LinkedHashSet中
        System.out.println("LinkedHashSet中是否包含banana: " + set.contains("banana")); // 输出：true

        // 从LinkedHashSet中删除元素
        set.remove("orange");
        System.out.println("LinkedHashSet的大小: " + set.size()); // 输出：2

        // 清空LinkedHashSet
        set.clear();
        System.out.println("LinkedHashSet是否为空: " + set.isEmpty()); // 输出：true
    }
}
```

以上代码创建了一个LinkedHashSet实例，并演示了常见的操作。与HashSet不同的是，LinkedHashSet保持了元素的插入顺序。首先，通过add()方法添加元素到LinkedHashSet，注意到添加重复元素时，LinkedHashSet会自动去重。然后，通过size()方法获取LinkedHashSet的大小，使用增强型for循环遍历LinkedHashSet中的元素，并使用contains()方法判断元素是否存在于LinkedHashSet中。接下来，通过remove()方法删除LinkedHashSet中的元素，并再次使用size()方法验证大小的变化。最后，通过clear()方法清空LinkedHashSet，并使用isEmpty()方法判断LinkedHashSet是否为空。

运行上述代码，将会输出以下结果：

```shell
LinkedHashSet的大小: 3
LinkedHashSet的元素:
apple
banana
orange
LinkedHashSet中是否包含banana: true
LinkedHashSet的大小: 2
LinkedHashSet是否为空: true
```

可以看到，LinkedHashSet保持了元素的插入顺序，同时具备了HashSet的去重功能。因此，元素的插入顺序与遍历顺序是一致的。其他的操作方法与HashSet相似，可以根据需要进行添加、删除和查找操作。
