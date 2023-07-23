# TreeMap常见操作

以下是一个简单的 `TreeMap` 常用方法的示例代码：

```java
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // 创建一个 TreeMap 实例
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // 添加键值对
        treeMap.put("apple", 10);
        treeMap.put("banana", 5);
        treeMap.put("orange", 8);

        // 获取键对应的值
        int appleCount = treeMap.get("apple");
        System.out.println("Number of apples: " + appleCount);

        // 判断是否包含指定的键
        boolean containsKey = treeMap.containsKey("banana");
        System.out.println("Contains key 'banana': " + containsKey);

        // 获取 TreeMap 的大小（键值对数量）
        int size = treeMap.size();
        System.out.println("Size of TreeMap: " + size);

        // 迭代遍历 TreeMap 的键值对
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }

        // 修改指定键对应的值
        treeMap.put("apple", 15);
        System.out.println("Updated number of apples: " + treeMap.get("apple"));

        // 删除指定的键值对
        treeMap.remove("orange");
        System.out.println("Size after removing 'orange': " + treeMap.size());

        // 获取最小键
        String minKey = treeMap.firstKey();
        System.out.println("Minimum key: " + minKey);

        // 获取最大键
        String maxKey = treeMap.lastKey();
        System.out.println("Maximum key: " + maxKey);

        // 按范围检索键值对
        Map<String, Integer> subMap = treeMap.subMap("apple", "banana");
        System.out.println("SubMap: " + subMap);
    }
}
```

这个示例展示了 `TreeMap` 常用方法的使用，包括添加键值对、获取值、判断键是否存在、获取 TreeMap 的大小、迭代遍历键值对、修改值、删除键值对、获取最小键、获取最大键以及按范围检索键值对。

请注意，`TreeMap` 会根据键的自然顺序或自定义比较器的顺序对键值对进行排序，并提供了相应的方法来支持按范围检索键值对。

你可以根据实际需求使用 `TreeMap` 的各种方法和操作，这只是一个简单的示例。`TreeMap` 还提供了其他方法，如 `ceilingKey()`、`floorKey()`、`higherKey()`、`lowerKey()` 等，可以根据具体场景选择适合的方法。
