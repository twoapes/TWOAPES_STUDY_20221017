# Properties

`Properties` 是 Java 中的一个特殊的类，它继承自 `Hashtable`，用于处理属性文件（.properties 文件）。`Properties` 类被设计用于处理键值对形式的配置信息，常用于读取和写入配置文件的操作。

下面是关于 `Properties` 的一些概念解释：

1. 属性文件：
属性文件是一种以键值对形式存储配置信息的文件，通常使用 `.properties` 扩展名。属性文件由一系列以 `key=value` 形式组成的行构成，其中 `key` 是属性名，`value` 是属性值。

2. 键值对存储：
`Properties` 类使用键值对的方式存储数据，其中键和值都是字符串类型。属性文件中的每一行都会被解析为一个键值对，其中等号（=）前面的部分作为键，等号后面的部分作为值。

3. 读取和写入属性文件：
`Properties` 提供了读取和写入属性文件的方法。可以使用 `load()` 方法从属性文件中加载配置信息到 `Properties` 对象中，也可以使用 `store()` 方法将 `Properties` 对象中的配置信息保存到属性文件中。

4. 默认值：
`Properties` 允许设置默认值，当获取某个属性的值时，如果该属性不存在，则返回默认值。可以使用 `getProperty()` 方法获取属性的值，并提供一个默认值作为参数。

5. 注释：
`Properties` 支持在属性文件中添加注释。在属性文件中，以 `#` 或 `!` 开头的行被视为注释，解析时会被忽略。

6. 加载顺序：
在加载属性文件时，`Properties` 会按照文件中的顺序读取键值对，并存储到 `Properties` 对象中。可以通过 `keys()` 方法获取属性的键的集合，保留了属性文件中的顺序。

`Properties` 类提供了一系列的方法来操作属性文件，包括读取和写入属性文件、获取属性值、设置默认值、遍历属性等。它是一种方便且常用的处理配置文件的工具类，在读取和写入应用程序配置信息时经常被使用。

Properties类是Hashtable的子类,该对象用于处理属性文件

> 由于属性文件里的 key,value 都是字符串类型
所以 Properties 里的 key和 value 都是字符串类型存取数据时
建议使用setProperty(String key,String value)方法和getProperty(String key)方法

```java
Properties pros = new Properties();
pros.load(new FileInputStream("jdbc.properties"));
String user = pros.getProperty("user");
System.out.println(user);
```
