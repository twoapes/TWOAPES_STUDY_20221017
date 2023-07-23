# Collections常用方法

同步控制
Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题

```java
查找、替换
Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
Object min(Collection)
Object min(Collection，Comparator)
int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
void copy(List dest,List src)：将src中的内容复制到dest中
boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
```

`Collections` 是 Java 中提供的一个工具类，用于操作集合（Collection）和 Map 的工具方法。它提供了一系列静态方法，用于对集合进行排序、查找、修改等常见操作。下面是一些 `Collections` 常用方法的详细示例：

1. 排序方法：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        System.out.println("Before sorting: " + numbers);

        // 使用 Collections.sort 方法进行排序
        Collections.sort(numbers);

        System.out.println("After sorting: " + numbers);
    }
}
```

输出结果：

```shell
Before sorting: [5, 2, 8, 1, 3]
After sorting: [1, 2, 3, 5, 8]
```

2.查找方法：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        int key = 8;

        // 使用 Collections.binarySearch 方法进行二分查找
        int index = Collections.binarySearch(numbers, key);

        if (index >= 0) {
            System.out.println(key + " found at index " + index);
        } else {
            System.out.println(key + " not found");
        }
    }
}
```

输出结果：

```shell
8 found at index 4
```

3.集合的最大值和最小值：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        // 使用 Collections.max 方法获取最大值
        int max = Collections.max(numbers);

        // 使用 Collections.min 方法获取最小值
        int min = Collections.min(numbers);

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
```

输出结果：

```shell
Max: 8
Min: 1
```

4.集合的反转：

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        System.out.println("Before reverse: " + numbers);

        // 使用 Collections.reverse 方法进行反转
        Collections.reverse(numbers);

        System.out.println("After reverse: " + numbers);
    }
}
```

输出结果：

```shell
Before reverse: [5, 2, 8, 1, 3]
After reverse: [3, 1, 8, 2, 5]
```

这些示例展示了 `Collections` 类中的一些常用方法，包括排序、查找、获取最大值和最小值以及集合反转。你可以根据自己的需求使用这些方法对集合进行相应的操作。
