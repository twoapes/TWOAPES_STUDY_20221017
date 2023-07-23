# Writer

因为字符流直接以字符作为操作单位，所以Writer可以用字符串来替换字符数组，即以String 对象作为参数

```txt
void write(String str);
void write(String str, int off, int len);
```

要写出字符流，需要使用 FileWriter

```java
void write(int c)
写入单个字符。要写入的字符包含在给定整数值的 16 个低位中，16 高位被忽略。 即写入0 到 65535 之间的Unicode码。

void write(char[] cbuf)
写入字符数组。

void write(char[] cbuf,int off,int len)
写入字符数组的某一部分。从off开始，写入len个字符

void write(String str)
写入字符串。

void write(String str,int off,int len)
写入字符串的某一部分。

void flush()
刷新该流的缓冲，则立即将它们写入预期目标。

public void close() throws IOException
关闭此输出流并释放与该流关联的所有系统资源
```

以下是一个使用`Writer`写入文件内容的示例代码：

```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt");

        try (Writer writer = new FileWriter(file)) {
            String data = "Hello, World!";
            
            writer.write(data);

            System.out.println("数据已写入文件！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们使用`FileWriter`创建一个字符输出流对象，用于向指定文件中写入内容。然后，我们将字符串`"Hello, World!"`使用`write()`方法写入输出流。

最后，我们打印一条消息表示数据已成功写入文件。

同样，我们使用了Java 7引入的try-with-resources语句来自动关闭输出流，以确保在写入完文件后，不论是否发生异常，都会正确关闭输出流以释放资源。

在实际使用中，请将示例中的`"path/to/file.txt"`替换为你实际要写入的文件的路径。同样，为了避免可能的异常情况，建议在实际使用时进行适当的异常处理。
