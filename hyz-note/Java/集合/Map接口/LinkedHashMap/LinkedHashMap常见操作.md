# LinkedHashMap常见操作

以下是一个简单的 `LinkedHashMap` 常见操作的示例代码：

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 创建一个 LinkedHashMap 实例
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // 添加键值对
        linkedHashMap.put("apple", 10);
        linkedHashMap.put("banana", 5);
        linkedHashMap.put("orange", 8);

        // 获取键对应的值
        int appleCount = linkedHashMap.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // 判断是否包含指定的键
        boolean containsKey = linkedHashMap.containsKey("banana");
        System.out.println("Contains key 'banana': " + containsKey);

        // 获取 LinkedHashMap 的大小（键值对数量）
        int size = linkedHashMap.size();
        System.out.println("Size of LinkedHashMap: " + size);

        // 迭代遍历 LinkedHashMap 的键值对
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 修改指定键对应的值
        linkedHashMap.put("apple", 15);
        System.out.println("Updated number of apples: " + linkedHashMap.get("apple"));

        // 删除指定的键值对
        linkedHashMap.remove("orange");
        System.out.println("Size after removing 'orange': " + linkedHashMap.size());

        // 清空 LinkedHashMap
        linkedHashMap.clear();
        System.out.println("Size after clearing: " + linkedHashMap.size());
    }
}
```

这个示例展示了如何使用 `LinkedHashMap` 进行常见的操作，包括添加键值对、获取值、判断键是否存在、获取 LinkedHashMap 的大小、迭代遍历键值对、修改值、删除键值对以及清空 LinkedHashMap。

请注意，`LinkedHashMap` 会保持键值对的插入顺序或最近访问顺序，所以迭代遍历 LinkedHashMap 的键值对时，它们的顺序会与插入或访问的顺序一致。

你可以根据实际需求使用 `LinkedHashMap` 的各种方法和操作，这只是一个简单的示例。`LinkedHashMap` 还提供了其他方法，如 `getOrDefault()`、`putIfAbsent()`、`removeEldestEntry()` 等，可以根据具体场景选择适合的方法。
