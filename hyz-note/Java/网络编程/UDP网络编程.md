# UDP网络编程

- 类DatagramSocket和DatagramPacket实现了基于UDP协议网络程序

- UDP数据报通过数据报套接字DatagramSocket发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达

- DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP地址和端口号以及接收端的IP地址和端口号

- UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接

> 如同发快递包裹一样

```java
public DatagramSocket(int port)创建数据报套接字并将其绑定到本地主机上的指定端口
套接字将被绑定到通配符地址，IP地址由内核来选择
public DatagramSocket(int port,InetAddress laddr)创建数据报套接字，将其绑定到指定的本地地址
本地端口必须在 0 到 65535 之间（包括两者）
如果IP地址为 0.0.0.0，套接字将被绑定到通配符地址，IP 地址由内核选择
public void close()关闭此数据报套接字
public void send(DatagramPacket p)从此套接字发送数据报包
DatagramPacket 包含的信息指示：将要发送的数据、其长度、远程主机的 IP 地址和远程主机的端口号
public void receive(DatagramPacket p)从此套接字接收数据报包。当此方法返回时，DatagramPacket的缓冲区填充了接收的数据。数据报包也包含发送方的 IP 地址和发送方机器上的端口号。 此方法在接收到数据报前一直阻塞。数据报包对象的 length 字段包含所接收信息的长度
如果信息比包的长度长，该信息将被截短
public InetAddress getLocalAddress()获取套接字绑定的本地地址
public int getLocalPort()返回此套接字绑定的本地主机上的端口号
public InetAddress getInetAddress()返回此套接字连接的地址
如果套接字未连接，则返回 null
public int getPort()返回此套接字的端口
如果套接字未连接，则返回 -1
public DatagramPacket(byte[] buf,int length)构造 DatagramPacket，用来接收长度为 length 的数据包。 length 参数必须小于等于 buf.length
public DatagramPacket(byte[] buf,int length,InetAddress address,int port)构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。length参数必须小于等于 buf.length
public InetAddress getAddress()返回某台机器的 IP 地址，此数据报将要发往该机器或者是从该机器接收到的
public int getPort()返回某台远程主机的端口号，此数据报将要发往该主机或者是从该主机接收到的
public byte[] getData()返回数据缓冲区
接收到的或将要发送的数据从缓冲区中的偏移量 offset 处开始，持续 length 长度
public int getLength()返回将要发送或接收到的数据的长度
```

流 程

1. DatagramSocket与DatagramPacket

2. 建立发送端，接收端

3. 建立数据包

4. 调用Socket的发送,接收方法

5. 关闭Socket

发送端与接收端是两个独立的运行程

UDP（User Datagram Protocol）是一种无连接的、不可靠的传输层协议。与TCP不同，UDP不需要在发送数据之前先建立连接，也不提供可靠的数据传输机制。UDP适用于一些对实时性要求较高、数据丢失可以容忍的应用场景，如音视频传输、实时游戏等。

UDP网络编程的基本步骤如下：

6.创建DatagramSocket对象：在客户端和服务器端分别创建一个DatagramSocket对象。DatagramSocket负责发送和接收UDP数据报。

7.创建DatagramPacket对象：创建一个DatagramPacket对象，用于在发送和接收时装载数据。

8.发送数据（客户端）：将要发送的数据填充到DatagramPacket对象中，并使用DatagramSocket的send()方法发送数据报到目标主机和端口。

9.接收数据（服务器端）：创建一个空的DatagramPacket对象，用于接收从客户端发送过来的数据报。使用DatagramSocket的receive()方法接收数据报。

10.处理数据：从接收到的DatagramPacket对象中获取数据，进行相应的处理。

11.关闭连接：在通信结束后，关闭DatagramSocket对象。

以下是一个简单的UDP客户端和服务器端的示例代码：

UDP客户端代码：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // 服务器的IP地址
        int serverPort = 8888; // 服务器的端口号

        try {
            // 创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();

            // 准备要发送的数据
            String message = "Hello, Server!";
            byte[] sendData = message.getBytes();

            // 创建DatagramPacket对象，指定服务器的IP地址和端口号
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(serverIP), serverPort);

            // 发送数据报
            socket.send(sendPacket);

            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

UDP服务器端代码：

```java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        int port = 8888; // 监听的端口号

        try {
            // 创建DatagramSocket对象，指定监听的端口号
            DatagramSocket socket = new DatagramSocket(port);

            // 创建接收数据的DatagramPacket对象
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // 接收数据报
            socket.receive(receivePacket);

            // 处理接收到的数据
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("接收到的消息：" + message);

            // 关闭连接
            socket.close();
        } catch (IOException e) {
           

 e.printStackTrace();
        }
    }
}
```

在上述示例中，UDP客户端通过创建DatagramSocket对象，将要发送的数据填充到DatagramPacket对象中，并使用send()方法发送数据报到服务器。UDP服务器端创建DatagramSocket对象并指定监听的端口号，然后使用receive()方法接收客户端发送过来的数据报，并从接收到的DatagramPacket对象中获取数据进行处理。

请注意，UDP是一种无连接的协议，因此客户端和服务器端之间的通信是无序的，且不保证数据的可靠性和顺序性。在实际使用中，需要根据应用场景的需求进行适当的处理和协议设计。
