# RandomAccessFile类

- RandomAccessFile 声明在java.io包下，但直接继承于java.lang.Object类。并且它实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也可以写

- RandomAccessFile 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意地方来读、写文件

- 支持只访问文件的部分内容

- 可以向已存在的文件后追加内容

- RandomAccessFile 对象包含一个记录指针，用以标示当前读写处的位置

- RandomAccessFile 类对象可以自由移动记录指针

```txt
long getFilePointer()：获取文件记录指针的当前位置
void seek(long pos)：将文件记录指针定位到 pos 位置
```

```txt
public RandomAccessFile(File file, String mode)
public RandomAccessFile(String name, String mode)
```

```txt
创建 RandomAccessFile类实例需要指定一个mode参数，该参数指定RandomAccessFile的访问模式
r: 以只读方式打开
rw：打开以便读取和写入
rwd:打开以便读取和写入；同步文件内容的更新
rws:打开以便读取和写入；同步文件内容和元数据的更新
```

如果模式为只读r

则不会创建文件，而是会去读取一个已经存在的文件，如果读取的文件不存在则会出现异常

如果模式为rw读写。如果文件不存在则会去创建文件，如果存在则不会创建

我们可以用RandomAccessFile这个类，来实现一个多线程断点下载的功能，用过下载工具的朋友们都知道，下载前都会建立两个临时文件，一个是与被下载文件大小相同的空文件，另一个是记录文件指针的位置文件，每次暂停的时候，都会保存上一次的指针，然后断点下载的时候，会继续从上一次的地方下载，从而实现断点下载或上传的功能

要实现断点下载或上传的功能，您可以使用`RandomAccessFile`类的随机访问特性来进行文件的分片读写。下面是一个示例，演示了如何使用断点下载的方式读取远程文件的部分内容并保存到本地：

```java
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResumeDownloadDemo {

    public static void main(String[] args) {
        String remoteFileUrl = "http://example.com/file.txt";
        String localFilePath = "downloaded_file.txt";

        // 下载文件
        resumeDownload(remoteFileUrl, localFilePath);
    }

    public static void resumeDownload(String remoteFileUrl, String localFilePath) {
        int bufferSize = 1024; // 缓冲区大小
        int startByte = 0; // 断点续传的起始字节位置

        try {
            // 创建URL对象，并打开HTTP连接
            URL url = new URL(remoteFileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Range", "bytes=" + startByte + "-");

            // 获取文件总长度
            int fileSize = connection.getContentLength();
            System.out.println("文件总大小：" + fileSize + " 字节");

            // 创建RandomAccessFile，指定本地文件路径和模式为"rw"
            RandomAccessFile file = new RandomAccessFile(localFilePath, "rw");

            // 将文件指针移动到断点续传的位置
            file.seek(startByte);

            // 读取远程文件并写入本地文件
            try (InputStream inputStream = connection.getInputStream()) {
                byte[] buffer = new byte[bufferSize];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    file.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("文件下载完成！");
        } catch (IOException e) {
            System.out.println("文件下载失败！");
            e.printStackTrace();
        }
    }
}
```

在这个示例中，我们通过指定HTTP头字段"Range"来实现断点下载。首先，我们创建了一个`URL`对象，并打开HTTP连接。然后，设置请求方法为GET，并设置"Range"字段的值为起始字节位置。这样，服务器将返回指定位置之后的文件内容。

通过`getContentLength()`方法获取到文件的总长度，用于显示下载进度和计算剩余字节数。

接下来，我们创建一个`RandomAccessFile`对象，指定本地文件路径和模式为"rw"（读写模式）。使用`seek()`方法将文件指针移动到断点续传的位置。

然后，通过获取HTTP连接的输入流来读取远程文件的内容，并将其写入本地文件。这里使用了一个缓冲区来提高读写效率。

在示例的主方法中，我们指定了远程文件的URL和本地文件的路径，然后调用`resumeDownload`方法进行断点下载。

请注意，在实际应用中，您可能还需要添加更多的错误处理和进度显示逻辑，以及上传时的分片上传处理。此外，还需要考虑文件的续传逻辑，即当下载或

上传中断时，如何记录已传输的字节数以便下次继续传输。
