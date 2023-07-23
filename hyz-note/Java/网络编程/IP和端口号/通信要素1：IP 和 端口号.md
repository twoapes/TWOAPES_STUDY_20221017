# 通信要素1：IP 和 端口号

先找本机`C:\Windows\System32\drivers\etc\hosts`是否有域名地址,如果没有则通过DNS服务器找主机

InetAddress类没有提供公共的构造器，而是提供了如下几个静态方法来获取InetAddress实例

`public static InetAddress getLocalHost()`

`public static InetAddress getByName(String host)`

InetAddress提供了如下几个常用的方法

`public String getHostAddress()：返回 IP 地址字符串（以文本表现形式）。
public String getHostName()：获取此 IP 地址的主机名
public boolean isReachable(int timeout)：测试是否可以达到该地址`

以下是一个简单的示例代码，演示如何使用Java Socket类来连接到指定的IP地址和端口号，并发送和接收数据。

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // 服务器的IP地址
        int serverPort = 8080; // 服务器的端口号

        try {
            // 创建Socket对象，连接到服务器
            Socket socket = new Socket(serverIP, serverPort);

            // 创建输入流和输出流
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);

            // 发送数据到服务器
            String message = "Hello, Server!";
            outputWriter.println(message);

            // 接收服务器的响应
            String response = inputReader.readLine();
            System.out.println("服务器响应：" + response);

            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，首先我们指定了服务器的IP地址和端口号（这里假设为127.0.0.1和8080）。然后，通过`Socket`类创建一个Socket对象，并指定要连接的服务器的IP地址和端口号。接下来，我们使用`BufferedReader`和`PrintWriter`来读取和写入数据。

在这个示例中，我们发送了一个简单的消息到服务器，然后从服务器接收响应。注意，这个示例只是一个基本的演示，实际的网络通信可能涉及更复杂的数据交换和协议。

请确保在运行示例代码时，服务器在指定的IP地址和端口上正常运行，并能够处理和响应客户端的请求。
