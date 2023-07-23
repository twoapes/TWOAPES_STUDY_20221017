# Iterator迭代器接口

- Iterator对象称为迭代器(设计模式的一种)，主要用于遍历Collection集合中的元素

- GOF给迭代器模式的定义为

> 提供一种方法访问一个容器(container)对象中各个元素，而又不需暴露该对象的内部细节
迭代器模式，就是为容器而生
类似于“公交车上的售票员”、“火车上的乘务员”、“空姐”

- Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象

- Iterator仅用于遍历集合，Iterator 本身并不提供承装对象的能力

- 如果需要创建Iterator对象，则必须有一个被迭代的集合

- 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前

Iterator接口的方法

Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法
如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException

## 使用 foreach 循环遍历集合元素

Java 5.0 提供了 foreach 循环迭代访问 Collection和数组
遍历操作不需获取Collection或数组的长度，无需使用索引访问元素
遍历集合的底层调用Iterator完成操作
foreach还可以用来遍历数组

下面是使用迭代器(`Iterator`)接口操作`List`接口的详细示例：

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        // 创建一个List集合
        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // 使用迭代器遍历集合并删除元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("元素: " + element);

            if (element.equals("Python")) {
                iterator.remove();
            }
        }

        // 输出修改后的集合
        System.out.println("修改后的集合: " + list);
    }
}
```

这个示例演示了如何使用迭代器(`Iterator`)接口操作`List`接口。首先，我们创建了一个`ArrayList`对象，并向列表中添加了一些元素。然后，我们使用迭代器(`iterator()`)方法获取迭代器实例，并使用`hasNext()`方法检查是否还有下一个元素。在循环中，我们使用`next()`方法获取当前元素的值，并输出它。如果当前元素的值等于"Python"，我们使用迭代器的`remove()`方法删除该元素。

请注意，如果在循环中使用普通的`list.remove()`方法来删除元素，会导致`ConcurrentModificationException`并发修改异常。因此，我们使用迭代器的`remove()`方法来安全地删除元素。迭代器允许我们在遍历集合的同时修改它，而不会引发异常。

最后，我们输出修改后的集合，验证元素"Python"是否被成功删除。

这个示例展示了使用迭代器进行遍历和删除操作，你可以根据需要进行修改和扩展。
