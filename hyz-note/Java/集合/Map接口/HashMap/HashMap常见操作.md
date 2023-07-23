# HashMap常见操作

以下是一个简单的 `HashMap` 的详细示例代码：

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // 创建一个 HashMap 实例
        Map<String, Integer> hashMap = new HashMap<>();

        // 添加键值对
        hashMap.put("apple", 10);
        hashMap.put("banana", 5);
        hashMap.put("orange", 8);

        // 获取键对应的值
        int appleCount = hashMap.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // 判断是否包含指定的键
        boolean containsKey = hashMap.containsKey("banana");
        System.out.println("Contains key 'banana': " + containsKey);

        // 获取 HashMap 的大小（键值对数量）
        int size = hashMap.size();
        System.out.println("Size of HashMap: " + size);

        // 迭代遍历 HashMap 的键值对
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 修改指定键对应的值
        hashMap.put("apple", 15);
        System.out.println("Updated number of apples: " + hashMap.get("apple"));

        // 删除指定的键值对
        hashMap.remove("orange");
        System.out.println("Size after removing 'orange': " + hashMap.size());

        // 清空 HashMap
        hashMap.clear();
        System.out.println("Size after clearing: " + hashMap.size());
    }
}
```

这个示例演示了如何使用 `HashMap` 进行常见操作，包括添加键值对、获取值、判断键是否存在、获取 HashMap 的大小、迭代遍历键值对、修改值、删除键值对以及清空 HashMap。

请注意，这只是一个简单的示例，`HashMap` 还有许多其他方法和功能可以探索和使用，例如 `putAll()`、`keySet()`、`values()` 等。你可以根据实际需求使用 `HashMap` 的各种方法和操作。
