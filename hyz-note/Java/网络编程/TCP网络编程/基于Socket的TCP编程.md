# 基于Socket的TCP编程

Java语言的基于套接字编程分为服务端编程和客户端编程

其通信模型如图所示

![image.png](https://flowus.cn/preview/2d837e8a-e353-4019-a627-4d3e44e4f246)

客户端Socket的工作过程包含以下四个基本的步骤

- 创建 Socket

> 根据指定服务端的 IP 地址或端口号构造 Socket 类对象。若服务器端响应，则建立客户端到服务器的通信线路。若连接失败，会出现异常

- 打开连接到 Socket 的输入/出流

> 使用 getInputStream()方法获得输入流，使用getOutputStream()方法获得输出流，进行数据传输

- 按照一定的协议对 Socket 进行读/写操作

> 通过输入流读取服务器放入线路的信息（但不能读取自己放入线路的信息），通过输出流将信息写入线程

- 关闭 Socket

> 断开客户端到服务器的连接，释放线路

基于Socket的TCP编程是使用TCP协议进行网络通信的一种编程方式。下面是一个简单的Java示例，演示了如何使用Socket进行TCP编程。

服务器端代码：

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

            System.out.println("服务器启动，等待客户端连接...");

            // 等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接，地址：" + clientSocket.getInetAddress());

            // 创建输入流和输出流
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

客户端代码：

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

在上述示例中，服务器端通过创建ServerSocket对象，并监听指定的端口号（这里使用8080）。当客户端连接到服务器时，服务器接受连接请求，并创建与客户端通信的Socket对象。

客户端通过创建Socket对象，指定服务器的IP地址和端口号，然后与服务器建立连接。

服务器和客户端之间使用BufferedReader和PrintWriter来进行数据的读取和写入。服务器从客户端接收消息并打印，然后将响应发送给客户端。客户端发送消息给服务器，并接收服务器的响应。

请确保在运行示例代码时，服务器先运行并监听指定的端口，然后再运行客户端代码来建立连接并进行通信。
