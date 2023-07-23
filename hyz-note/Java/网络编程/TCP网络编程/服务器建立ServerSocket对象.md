# 服务器建立ServerSocket对象

ServerSocket 对象负责等待客户端请求建立套接字连接，类似邮局某个窗口中的业务员

也就是说，服务器必须事先建立一个等待客户请求建立套接字连接的ServerSocket对象

所谓“接收”客户的套接字请求，就是accept()方法会返回一个 Socket 对象

当使用Socket进行TCP编程时，服务器端需要使用ServerSocket对象来监听指定的端口号，并接受客户端的连接请求。以下是服务器端创建ServerSocket对象的一般步骤：

1. 指定服务器的监听端口号：确定服务器要监听的端口号，以便客户端能够连接到该端口。

2. 创建ServerSocket对象：使用指定的端口号创建一个ServerSocket对象。可以通过传入端口号作为参数来实现。

3. 接受连接请求：调用ServerSocket对象的`accept()`方法来接受客户端的连接请求。该方法会阻塞，直到有客户端连接请求到达。

4. 进行数据交互：通过返回的Socket对象的输入流和输出流进行数据的读取和写入。可以使用`getInputStream()`方法获取输入流，使用`getOutputStream()`方法获取输出流。

5. 关闭连接：当通信结束后，关闭与客户端的连接，同时关闭ServerSocket对象。

以下是一个简单的示例代码，演示了服务器端创建ServerSocket对象的过程：

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        int port = 8080; // 监听的端口号

        try {
            // 创建ServerSocket对象
            ServerSocket serverSocket = new ServerSocket(port);

            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接，地址：" + clientSocket.getInetAddress());

            // 进行数据交互
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            // 接收客户端的数据
            String message = inputReader.readLine();
            System.out.println("客户端发送的消息：" + message);

            // 发送响应给客户端
            outputWriter.println("服务器已收到消息：" + message);

            // 关闭连接
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，通过创建`ServerSocket`对象并传入指定的端口号，服务器端可以监听该端口并等待客户端的连接请求。之后，通过调用`accept()`方法接受客户端的连接请求，并返回与客户端通信的`Socket`对象。使用返回的`Socket`对象的输入流和输出流进行数据的读取和写入操作。最后，通过调用`close()`方法关闭连接。

请注意，在实际使用时，确保端口号与实际应用场景相匹配，并处理可能出现的异常情况。
