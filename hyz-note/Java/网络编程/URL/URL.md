# URL

- URL(Uniform Resource Locator)

> 统一资源定位符，它表示 Internet 上某一资源的地址

- 它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate这个资源

- 通过 URL 我们可以访问 Internet 上的各种网络资源

> 比如最常见的 www，ftp站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。

URL的基本结构由5部分组成

`<传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表`

> 例如`http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123`
片段名：即锚点，例如看小说，直接定位到章节
参数列表：参数名=参数值&参数名=参数值....

为了表示URL,java.net 中实现了类URL

```java
public URL (String spec)：通过一个表示URL地址的字符串可以构造一个URL对象。
例如：URL url = new URL ("http://www. atguigu.com/");
public URL(URL context, String spec)：通过基 URL 和相对 URL 构造一个 URL 对象。
例如：URL downloadUrl = new URL(url, “download.html")
public URL(String protocol, String host, String file); 例如：new URL("http","www.atguigu.com", “download. html");
public URL(String protocol, String host, int port, String file); 例如: URL gamelan = new URL("http", "www.atguigu.com", 80, “download.html");
```

URL类的构造器都声明抛出非运行时异常，必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获

一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的方法来获取这些属性

```java
public String getProtocol( ) 获取该URL的协议名
public String getHost( ) 获取该URL的主机名
public String getPort( ) 获取该URL的端口号
public String getPath( ) 获取该URL的文件路径
public String getFile( ) 获取该URL的文件名
public String getQuery( ) 获取该URL的查询名
```

URL（Uniform Resource Locator）是一种用于定位和访问互联网资源的地址标识符。它是一种标准化的字符串格式，用于在网络上定位和访问资源，如网页、图像、视频、文件等。

一个URL通常由以下几个部分组成：

1. 协议（Protocol）：URL中的协议部分指定了访问资源所使用的协议，如HTTP、HTTPS、FTP等。协议部分以冒号（:）结尾，例如：http://、https://、ftp://。

2. 主机（Host）：URL中的主机部分指定了资源所在的服务器主机名或IP地址。主机部分紧跟在协议部分后面，以两个斜杠（//）分隔，例如：[www.example.com。](http://www.example.com。)

3. 端口（Port）：URL中的端口部分指定了服务器上提供服务的端口号。端口部分紧跟在主机部分后面，使用冒号（:）指定，例如：:80。

4. 路径（Path）：URL中的路径部分指定了服务器上资源的路径或目录结构。路径部分紧跟在端口部分后面，以斜杠（/）开头，例如：/path/to/resource。

5. 查询字符串（Query String）：URL中的查询字符串部分用于传递参数给服务器。查询字符串以问号（?）开头，参数由键值对组成，键和值之间使用等号（=）连接，多个键值对之间使用与号（&）连接，例如：?key1=value1&key2=value2。

6. 片段标识符（Fragment Identifier）：URL中的片段标识符部分指定了资源中的特定片段或位置。片段标识符以井号（#）开头，例如：#section1。

综合起来，一个完整的URL示例如下：

```shell
http://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section1
```

在上述示例中，协议部分是`http://`，主机部分是`www.example.com`，端口部分是`:8080`，路径部分是`/path/to/resource`，查询字符串部分是`?key1=value1&key2=value2`，片段标识符部分是`#section1`。

URL在互联网中广泛应用，它是访问和定位网络资源的基本方式，使得用户能够通过简单的字符串标识符来访问网页、下载文件、浏览图片等。

下面是一个使用`java.net.URL`类的简单示例：

```java
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("http://www.example.com");

            // 获取URL的各个部分
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref: " + url.getRef());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们创建了一个URL对象，并通过调用URL对象的不同方法来获取URL的各个部分信息。使用`getProtocol()`方法获取协议部分，`getHost()`方法获取主机部分，`getPort()`方法获取端口部分，`getPath()`方法获取路径部分，`getQuery()`方法获取查询字符串部分，`getFile()`方法获取文件部分，`getRef()`方法获取片段标识符部分。

注意，由于`java.net.URL`类的构造函数可能会抛出`MalformedURLException`异常，因此在实际使用中需要进行异常处理。

请注意，上述示例中的URL是一个示例URL，实际应用中需要根据需要替换为正确的URL。
