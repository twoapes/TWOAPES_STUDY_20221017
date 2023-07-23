# InetAddress类

- Internet上的主机有两种方式表示地址

域名(hostName)

> `www.atguigu.com`

IP 地址(hostAddress)

> `202.108.35.210`

InetAddress类主要表示IP地址，两个子类

> `Inet4Address,Inet6Address`

InetAddress类对象含有一个Internet主机地址的域名和IP地址

> `www.atguigu.com和202.108.35.210`

域名解析

> 域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器(DNS)负责将域名转化成IP地址，这样才能和主机建立连接

下面是一个简单的使用`InetAddress`类的示例代码：

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本机的 InetAddress 对象
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("本机的主机名：" + localHost.getHostName());
            System.out.println("本机的IP地址：" + localHost.getHostAddress());

            // 根据域名获取 InetAddress 对象
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google的主机名：" + google.getHostName());
            System.out.println("Google的IP地址：" + google.getHostAddress());

            // 根据IP地址获取 InetAddress 对象
            InetAddress byAddress = InetAddress.getByAddress(new byte[]{74, 125, (byte) 227, (byte) 1});
            System.out.println("IP地址为74.125.227.1的主机名：" + byAddress.getHostName());
            System.out.println("IP地址为74.125.227.1的域名：" + byAddress.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

运行上述代码，将会输出本机的主机名、IP地址，以及指定域名（这里是`www.google.com`）和指定IP地址（这里是`74.125.227.1`）的主机名和IP地址。

注意，在运行时需要确保网络连接正常，且域名和IP地址能够正确解析。另外，`InetAddress`类还提供了其他方法，例如获取主机的所有IP地址、判断是否可达等。可以根据具体需求进行进一步的探索和使用。
