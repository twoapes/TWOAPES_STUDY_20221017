# Socket

Socket（套接字）是网络编程中用于实现网络通信的一种编程接口（API）。它提供了一种机制，使得不同设备或进程之间能够建立连接并进行数据传输。

Socket的概念如下：

- 客户端和服务器端都可以创建和使用Socket对象。

- Socket对象可以用于建立网络连接、发送数据、接收数据和关闭连接。

- 客户端Socket用于发起连接请求，服务器端Socket用于接受连接请求。

- Socket在客户端和服务器之间形成了一个双向通信的通道，使得它们可以进行数据交换。

- Socket提供了不同的接口和方法，以支持不同的传输协议（如TCP、UDP）和通信模式（如面向连接、无连接）。

Socket编程通常涉及以下步骤：

1. 创建Socket对象：在客户端或服务器端创建一个Socket对象，并指定要连接的服务器地址和端口号（对于客户端）或要绑定的本地地址和端口号（对于服务器端）。

2. 建立连接（对于客户端）：客户端调用Socket对象的connect()方法来连接到服务器。

3. 接受连接（对于服务器端）：服务器端调用Socket对象的accept()方法来接受客户端的连接请求，并返回一个新的Socket对象，用于与客户端进行通信。

4. 数据传输：使用Socket对象的输入流和输出流进行数据的发送和接收。客户端和服务器端可以通过输入流从Socket接收数据，通过输出流向Socket发送数据。

5. 关闭连接：通信结束后，客户端和服务器端分别调用Socket对象的close()方法来关闭连接。

Socket编程可以实现各种网络应用，如Web浏览器、邮件客户端、聊天应用、文件传输等。开发者可以根据具体需求选择合适的Socket类型和传输协议（如TCP或UDP），并利用Socket接口提供的方法进行数据交互和网络通信。

- 利用套接字(Socket)开发网络应用程序早已被广泛的采用，以至于成为事实上的标准

- 网络上具有唯一标识的IP地址和端口号组合在一起才能构成唯一能识别的标识符套接字

- 通信的两端都要有Socket，是两台机器间通信的端点

- 网络通信其实就是Socket间的通信

- Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输

- 一般主动发起通信的应用程序属客户端，等待通信请求的为服务端

Socket分类

- 流套接字（stream socket）

> 使用TCP提供可依赖的字节流服务

- 数据报套接字（datagram socket）

> 使用UDP提供“尽力而为”的数据报服务

```java
public Socket(InetAddress address,int port)创建一个流套接字并将其连接到指定 IP 地址的指定端口号
public Socket(String host,int port)创建一个流套接字并将其连接到指定主机上的指定端口号
Socket类的常用方法
public InputStream getInputStream()返回此套接字的输入流。可以用于接收网络消息
public OutputStream getOutputStream()返回此套接字的输出流。可以用于发送网络消息
public InetAddress getInetAddress()此套接字连接到的远程 IP 地址；如果套接字是未连接的，则返回 null。
public InetAddress getLocalAddress()获取套接字绑定的本地地址。 即本端的IP地址
public int getPort()此套接字连接到的远程端口号；如果尚未连接套接字，则返回 0
public int getLocalPort()返回此套接字绑定到的本地端口。 如果尚未绑定套接字，则返回 -1。即本端的端口号
public void close()关闭此套接字。套接字被关闭后，便不可在以后的网络连接中使用（即无法重新连接或重新绑定）
需要创建新的套接字对象。 关闭此套接字也将会关闭该套接字的 InputStream 和OutputStream
public void shutdownInput()如果在套接字上调用 shutdownInput() 后从套接字输入流读取内容，则流将返回 EOF（文件结束符）
即不能在从此套接字的输入流中接收任何数据
public void shutdownOutput()禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列
如果在套接字上调用 shutdownOutput() 后写入套接字输出流，则该流将抛出 IOException。 即不能通过此套接字的输出流发送任何数据
```
