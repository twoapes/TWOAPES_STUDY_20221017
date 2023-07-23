# Reader

```java
int read()
int read(char [] c)
int read(char [] c, int off, int len)
```

- 要读取字符流，需要使用 FileReader

```java
int read()
读取单个字符。作为整数读取的字符，范围在 0 到 65535 之间 (0x00-0xffff)（2个字节的Unicode码），如果已到达流的末尾，则返回 -1

int read(char[] cbuf)
将字符读入数组。如果已到达流的末尾，则返回 -1。否则返回本次读取的字符数。

int read(char[] cbuf,int off,int len)
将字符读入数组的某一部分。存到数组cbuf中，从off处开始存储，最多读len个字符。如果已到达流的末尾，则返回 -1。否则返回本次读取的字符数。

public void close() throws IOException
关闭此输入流并释放与该流关联的所有系统资源。
```

以下是一个使用`Reader`读取文件内容的示例代码：

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderDemo {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt");

        try (Reader reader = new FileReader(file)) {
            char[] buffer = new char[1024]; // 创建缓冲区
            int charsRead;

            while ((charsRead = reader.read(buffer)) != -1) {
                String data = new String(buffer, 0, charsRead);
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们使用`FileReader`创建一个字符输入流对象来读取指定文件的内容。然后，我们创建了一个字符数组作为缓冲区，用于读取文件数据。`read()`方法被调用来读取数据，并返回实际读取的字符数。如果返回值为-1，表示已读取完文件的所有内容。

我们使用一个循环来重复读取数据，并使用`String`的构造函数将字符数组转换为字符串。最后，我们打印出读取的数据。

与之前的示例一样，我们使用了Java 7引入的try-with-resources语句来自动关闭输入流，以确保在读取完文件后，不论是否发生异常，都会正确关闭输入流以释放资源。

在实际使用中，请将示例中的`"path/to/file.txt"`替换为你实际要读取的文件的路径。同样，为了避免可能的异常情况，建议在实际使用时进行适当的异常处理。
