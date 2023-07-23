# Properties常见操作

以下是一个简单的 `Properties` 常见操作的示例代码：

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        // 创建一个 Properties 实例
        Properties properties = new Properties();

        // 加载属性文件
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取属性值
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // 设置属性值
        properties.setProperty("url", "jdbc:mysql://localhost:3306/mydb");
        properties.setProperty("timeout", "5000");

        // 写入属性文件
        try {
            FileOutputStream fos = new FileOutputStream("config.properties");
            properties.store(fos, "Updated properties");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在这个示例中，假设存在一个名为 "config.properties" 的属性文件，其中包含了 "username" 和 "password" 的键值对。代码通过 `Properties` 类加载属性文件并读取相应的属性值。然后，代码设置了新的属性值，并将更新后的属性写回到属性文件中。

请确保在运行代码之前存在一个名为 "config.properties" 的属性文件，并包含合适的键值对。

`Properties` 类提供了其他许多常用的方法，如 `getProperty()`, `setProperty()`, `remove()`, `stringPropertyNames()`, 等等，可以根据具体的需求使用适当的方法来操作属性。
