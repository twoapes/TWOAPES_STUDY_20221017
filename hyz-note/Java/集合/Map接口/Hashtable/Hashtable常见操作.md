# Hashtable常见操作

以下是一个简单的 `Hashtable` 常用操作的示例代码：

```java
import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {
        // 创建一个 Hashtable 实例
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // 添加键值对
        hashtable.put("apple", 10);
        hashtable.put("banana", 5);
        hashtable.put("orange", 8);

        // 获取键对应的值
        int appleCount = hashtable.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // 判断是否包含指定的键
        boolean containsKey = hashtable.containsKey("banana");
        System.out.println("Contains key 'banana': " + containsKey);

        // 获取 Hashtable 的大小（键值对数量）
        int size = hashtable.size();
        System.out.println("Size of Hashtable: " + size);

        // 迭代遍历 Hashtable 的键值对
        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            int value = hashtable.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 修改指定键对应的值
        hashtable.put("apple", 15);
        System.out.println("Updated number of apples: " + hashtable.get("apple"));

        // 删除指定的键值对
        hashtable.remove("orange");
        System.out.println("Size after removing 'orange': " + hashtable.size());

        // 清空 Hashtable
        hashtable.clear();
        System.out.println("Size after clearing: " + hashtable.size());
    }
}
```

这个示例展示了如何使用 `Hashtable` 进行常见的操作，包括添加键值对、获取值、判断键是否存在、获取 Hashtable 的大小、迭代遍历键值对、修改值、删除键值对以及清空 Hashtable。

与 `HashMap` 类似，`Hashtable` 也提供了类似的方法和操作来处理键值对。然而，需要注意的是，`Hashtable` 是线程安全的，多个线程可以同时访问和修改 `Hashtable` 的内容。因此，在多线程环境下，`Hashtable` 是一个可靠的选择，但在单线程环境下，`HashMap` 可能更适合，因为它没有线程同步的开销。

请根据实际需求使用 `Hashtable` 的方法和操作，这只是一个简单的示例。`Hashtable` 还提供了其他方法，如 `containsValue()`、`keys()`、`values()` 等，可以根据具体场景选择适合的方法。
