# Enumeration

Enumeration 接口是 Iterator 迭代器的 “古老版本”

```java
Enumeration stringEnum = new StringTokenizer("a-b*c-d-e-g", "-");
while(stringEnum.hasMoreElements()){
Object obj = stringEnum.nextElement();
System.out.println(obj);
}
```

`Enumeration` 是 Java 中用于遍历集合（如 `Vector`、`Hashtable` 等）的接口。它定义了两个方法 `hasMoreElements()` 和 `nextElement()`，用于判断是否还有元素和获取下一个元素。下面是一个 `Enumeration` 的详细示例：

```java
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationExample {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // 获取枚举器
        Enumeration<String> enumeration = fruits.elements();

        // 使用 hasMoreElements() 判断是否还有元素
        while (enumeration.hasMoreElements()) {
            // 使用 nextElement() 获取下一个元素
            String fruit = enumeration.nextElement();
            System.out.println(fruit);
        }
    }
}
```

输出结果：

```shell
Apple
Banana
Orange
Mango
```

在上面的示例中，我们创建了一个 `Vector` 对象 `fruits`，并添加了一些水果。然后，通过调用 `elements()` 方法获取一个 `Enumeration` 对象 `enumeration`，该对象用于遍历 `fruits` 集合。

在循环中，我们使用 `hasMoreElements()` 方法判断是否还有元素未被遍历，如果有，则通过 `nextElement()` 方法获取下一个元素，并在控制台打印出来。

通过这种方式，我们可以使用 `Enumeration` 接口遍历集合中的元素，适用于那些不支持使用迭代器的旧版本集合类。
