# OutputStream

```java
void write(int b/int c);
void write(byte[] b/char[] cbuf);
void write(byte[] b/char[] buff, int off, int len);
void flush();
void close(); 需要先刷新，再关闭此流
```

FileOutputStream 从文件系统中的某个文件中获得输出字节

FileOutputStream用于写出非文本数据之类的原始字节流

```java
void write(int b)
将指定的字节写入此输出流。write 的常规协定是：向输出流写入一个字节。要写入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。 即写入0~255范围的。

void write(byte[] b)
将 b.length 个字节从指定的 byte 数组写入此输出流。write(b) 的常规协定是：应该与调用 write(b, 0, b.length) 的效果完全相同。

void write(byte[] b,int off,int len)
将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。

public void flush()throws IOException
刷新此输出流并强制写出所有缓冲的输出字节，调用此方法指示应将这些字节立即写入它们预期的目标。

public void close() throws IOException
关闭此输出流并释放与该流关联的所有系统资源
```

以下是一个使用`FileOutputStream`写入文件内容的简单示例代码：

```java
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt");

        try (OutputStream outputStream = new FileOutputStream(file)) {
            String data = "Hello, World!";
            byte[] bytes = data.getBytes(); // 将字符串转换为字节数组

            outputStream.write(bytes);

            System.out.println("数据已写入文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们使用`FileOutputStream`创建一个输出流对象，用于向指定文件中写入内容。然后，我们将字符串`"Hello, World!"`转换为字节数组，并使用`write()`方法将字节数组写入输出流。

最后，我们打印一条消息表示数据已成功写入文件。

同样，我们使用了Java 7引入的try-with-resources语句来自动关闭输出流，以确保在写入完文件后，不论是否发生异常，都会正确关闭输出流以释放资源。

在实际使用中，请将示例中的`"path/to/file.txt"`替换为你实际要写入的文件的路径。同样，为了避免可能的异常情况，建议在实际使用时进行适当的异常处理。
