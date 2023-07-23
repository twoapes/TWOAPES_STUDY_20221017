# 客户端创建Socket对象

客户端程序可以使用Socket类创建对象，**创建的同时会自动向服务器方发起连接**

Socket的构造器是

- Socket(String host,int port)throws UnknownHostException,IOException

> 向服务器(域名是host,端口号为port)发起TCP连接，若成功，则创建Socket对象，否则抛出异常

- Socket(InetAddress address,int port)throws IOException

> 根据InetAddress对象所表示的IP地址以及端口号port发起连接

客户端建立socketAtClient对象的过程就是向服务器发出套接字连接请求

服务器程序的工作过程包含以下四个基本的步骤

- 调用 ServerSocket(int port)

> 创建一个服务器端套接字，并绑定到指定端口上,用于监听客户端的请求

- 调用 accept()

> 监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字对象

- 调用该Socket类对象的getOutputStream()和getInputStream()

> 获取输出流和输入流,开始网络数据的发送和接收

- 关闭ServerSocket和Socket对象

> 客户端访问结束，关闭通信套接字

当客户端使用Socket进行TCP编程时，需要创建一个Socket对象来与服务器建立连接和进行通信。以下是客户端创建Socket对象的一般步骤：

1. 指定服务器的IP地址和端口号：确定要连接的服务器的IP地址和端口号。

2. 创建Socket对象：使用指定的服务器IP地址和端口号创建一个Socket对象。可以通过传入服务器IP地址和端口号作为参数来实现。

3. 建立连接：调用Socket对象的`connect()`方法来与服务器建立连接。该方法会阻塞，直到连接成功建立或连接超时。

4. 进行数据交互：通过Socket对象的输入流和输出流进行数据的读取和写入。可以使用`getInputStream()`方法获取输入流，使用`getOutputStream()`方法获取输出流。

5. 关闭连接：当通信结束后，调用Socket对象的`close()`方法关闭连接。

以下是一个简单的示例代码，演示了客户端创建Socket对象的过程：

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // 服务器的IP地址
        int serverPort = 8080; // 服务器的端口号

        try {
            // 创建Socket对象，连接到服务器
            Socket socket = new Socket(serverIP, serverPort);

            // 进行数据交互
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

在上述示例中，通过创建`Socket`对象并传入服务器的IP地址和端口号，客户端可以连接到服务器。之后，可以使用`getInputStream()`方法获取输入流和`getOutputStream()`方法获取输出流，进行数据的读取和写入操作。最后，调用`close()`方法关闭连接。

请注意，在实际使用时，确保服务器的IP地址和端口号与实际应用场景相匹配，并处理可能出现的异常情况。
