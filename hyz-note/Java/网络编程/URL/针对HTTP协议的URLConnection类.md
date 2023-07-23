# 针对HTTP协议的URLConnection类

URL的方法openStream()

> 能从网络上读取数据
若希望输出数据，例如向服务器端的 CGI （公共网关接口-Common Gateway Interface-的简称，是用户浏览器和服务器端的应用程序进行连接的接口）程序发送一些数据，则必须先与URL建立连接，然后才能对其进行读写，此时需要使用URLConnection

URLConnection

> 表示到URL所引用的远程对象的连接。当与一个URL建立连接时，首先要在一个 URL 对象上通过方法 openConnection() 生成对应的 URLConnection对象。如果连接过程失败，将产生IOException.

```java
URL netchinaren = new URL ("http://www.atguigu.com/index.shtml");
URLConnectonn u = netchinaren.openConnection( );
```

`java.net.URLConnection`类是Java中用于表示与URL之间的连接的抽象类，它提供了许多用于与URL进行通信的方法。对于HTTP协议，`URLConnection`类可以用来发送HTTP请求并接收HTTP响应。

下面是一个使用`URLConnection`类发送HTTP GET请求并获取响应的简单示例：

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTTPGetExample {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("http://www.example.com");

            // 打开连接
            URLConnection connection = url.openConnection();

            // 设置请求属性
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // 发送GET请求
            connection.connect();

            // 读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 打印响应
            System.out.println("Response:");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们创建了一个`URL`对象表示要访问的URL地址。然后，通过`openConnection()`方法获取`URLConnection`对象，并设置了请求属性，例如设置了User-Agent。接下来，调用`connect()`方法建立与服务器的连接，并发送GET请求。最后，通过`getInputStream()`方法获取服务器的响应流，并使用`BufferedReader`逐行读取响应内容，将其存储在`StringBuilder`中，并打印出来。

请注意，上述示例中的URL是一个示例URL，实际应用中需要根据需要替换为正确的URL。另外，实际应用中可能还需要处理异常、设置其他请求属性、处理响应数据等。
