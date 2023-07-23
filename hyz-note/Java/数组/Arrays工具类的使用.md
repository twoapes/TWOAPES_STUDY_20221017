# Arrays工具类的使用

java.util.Arrays类即为操作数组的工具类，包含了用来操作数组（比如排序和搜索）的各种方法

```txt
Arrays 类的构造函数：
Arrays 类的构造函数可以用于创建数组对象，其中包括默认构造函数和拷贝构造函数。
默认构造函数创建一个空数组，其中元素的类型为基本数据类型。
拷贝构造函数创建一个新的数组对象，该数组与原始数组具有相同的元素类型和数量。

Arrays 类的 asList() 方法：
asList() 方法返回一个 List 对象，该对象包含数组中的元素。
如果数组中包含不同类型的元素，asList() 方法将返回一个 List 对象，其中包含这些元素。
如果数组中的元素不能以任何顺序添加到列表中，则将返回一个空列表。

Arrays 类的 copyOf() 方法：
copyOf() 方法返回一个新的数组对象，该对象是原始数组的副本。
如果原始数组中包含不同类型的元素，copyOf() 方法将返回一个新的数组对象，其中包含这些元素。
如果原始数组中的元素不能以任何顺序添加到副本数组中，则将返回一个新的数组对象，其中包含原始数组中的所有元素。

Arrays 类的 sort() 方法：
sort() 方法可以用于对数组进行排序。该方法会改变原始数组的顺序，而不是返回一个新的排序后的数组。
如果数组中包含不同类型的元素，sort() 方法将返回一个新的排序后的数组，其中包含这些元素。
如果数组中的元素不能以任何顺序添加到排序后的数组中，则将返回一个新的数组对象，其中包含原始数组中的所有元素。

Arrays 类的 parallelSort() 方法：
parallelSort() 方法可以用于对数组进行并行排序。该方法使用多线程来对数组进行排序，可以提高排序的效率。
如果数组中包含不同类型的元素，parallelSort() 方法将返回一个新的排序后的数组，其中包含这些元素。
如果数组中的元素不能以任何顺序添加到并行排序后的数组中，则将返回一个新的数组对象，其中包含原始数组中的所有元素。

Arrays 类的 binarySearch() 方法：
binarySearch() 方法可以用于在数组中查找指定元素。该方法使用二分查找算法来查找指定元素，如果找到则返回该元素在数组中的下标，否则返回 -1。
如果数组中包含不同类型的元素，binarySearch() 方法将返回一个新的查找结果，其中包含这些元素。
如果要查找的元素不存在于数组中，则将返回 -1。
```

以下是一个使用Java的`java.util.Arrays`工具类的示例代码：

```java
import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 9, 1, 7};

        // 打印数组
        System.out.println("原始数组: " + Arrays.toString(numbers));

        // 对数组进行排序
        Arrays.sort(numbers);
        System.out.println("排序后的数组: " + Arrays.toString(numbers));

        // 搜索元素
        int key = 7;
        int index = Arrays.binarySearch(numbers, key);
        System.out.println("元素 " + key + " 在数组中的索引位置: " + index);

        // 填充数组
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 99);
        System.out.println("填充后的数组: " + Arrays.toString(filledArray));

        // 比较数组
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 4};
        boolean isEqual = Arrays.equals(arr1, arr2);
        System.out.println("arr1和arr2是否相等: " + isEqual);
    }
}
```

在示例代码中，我们首先创建了一个整型数组`numbers`，包含了一些数字。然后使用`Arrays.toString()`方法打印原始数组。

接下来，我们使用`Arrays.sort()`方法对数组进行排序，并使用`Arrays.toString()`方法打印排序后的数组。

然后，我们使用`Arrays.binarySearch()`方法在排序后的数组中搜索指定元素的索引位置，并打印结果。

接着，我们创建了一个新的整型数组`filledArray`，使用`Arrays.fill()`方法将数组填充为指定的值，并使用`Arrays.toString()`方法打印填充后的数组。

最后，我们创建了两个整型数组`arr1`和`arr2`，使用`Arrays.equals()`方法比较这两个数组是否相等，并打印结果。

运行该示例代码，将会输出以下结果：

```java
原始数组: [5, 3, 9, 1, 7]
排序后的数组: [1, 3, 5, 7, 9]
元素 7 在数组中的索引位置: 3
填充后的数组: [99, 99, 99, 99, 99]
arr1和arr2是否相等: false
```

这说明`Arrays`工具类提供了一些便捷的方法来操作数组，包括打印数组、排序数组、搜索数组、填充数组和比较数组等功能。
