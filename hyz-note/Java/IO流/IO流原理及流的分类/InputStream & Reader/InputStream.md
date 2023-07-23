# InputStream

- InputStream 和 Reader 是所有输入流的基类

- FileInputStream从文件系统中的某个文件中获得输入字节

- FileInputStream用于读取非文本数据之类的原始字节流

- 程序中打开的文件IO资源不属于内存里的资源，垃圾回收机制无法回收该资源，所以应该显式关闭文件 IO 资源

```java
int read()
int read(byte[] b)
int read(byte[] b, int off, int len)
```

```java
int read()
从输入流中读取数据的下一个字节。返回 0 到 255 范围内的 int 字节值。如果因为已经到达流末尾而没有可用的字节，则返回值 -1

int read(byte[] b)
从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。如果因为已经到达流末尾而没有可用的字节，则返回值 -1。否则以整数形式返回实际读取的字节数。

int read(byte[] b, int off,int len)
将输入流中最多 len 个数据字节读入 byte 数组。尝试读取 len 个字节，但读取的字节也可能小于该值。以整数形式返回实际读取的字节数。如果因为流位于文件末尾而没有可用的字节，则返回值 -1。

public void close() throws IOException
关闭此输入流并释放与该流关联的所有系统资源
```

以下是一个使用`InputStream`读取文件内容的简单示例代码：

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt");

        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[1024]; // 创建缓冲区
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String data = new String(buffer, 0, bytesRead);
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们使用`FileInputStream`创建了一个输入流对象来读取指定文件的内容。然后，我们创建了一个字节数组作为缓冲区，用于读取文件数据。`read()`方法被调用来读取数据，并返回实际读取的字节数。如果返回值为-1，表示已读取完文件的所有内容。

我们使用一个循环来重复读取数据，并使用`String`的构造函数将字节数组转换为字符串。最后，我们打印出读取的数据。

需要注意的是，示例中使用了Java 7引入的try-with-resources语句来自动关闭输入流。这样可以确保在读取完文件后，不论是否发生异常，都会正确关闭输入流以释放资源。

在实际使用中，请将示例中的`"path/to/file.txt"`替换为你实际要读取的文件的路径。另外，为了避免可能的异常情况，建议在实际使用时进行适当的异常处理。
