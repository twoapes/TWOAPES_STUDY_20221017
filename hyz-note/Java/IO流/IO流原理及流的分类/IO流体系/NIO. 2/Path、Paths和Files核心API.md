# Path、Paths和Files核心API

- 早期的Java只提供了一个File类来访问文件系统，但File类的功能比较有限，所提供的方法性能也不高

- 而且，大多数方法在出错时仅返回失败，并不会提供异常信息

- NIO. 2为了弥补这种不足，引入了Path接口，代表一个平台无关的平台路径，描述了目录结构中文件的位置

- Path可以看成是File类的升级版本，实际引用的资源也可以不存在

```java
import java.io.File;
File file = new File("index.html");
```

```java
import java.nio.file.Path;
import java.nio.file.Paths;
Path path = Paths.get("index.html");
```

同时，NIO.2在java.nio.file包下还提供了Files、Paths工具类，Files包含了大量静态的工具方法来操作文件

Paths则包含了两个返回Path的静态工厂方法

Paths 类提供的静态 get() 方法用来获取 Path 对象

```txt
static Path get(String first, String ... more) :用于将多个字符串串连成路径
static Path get(URI uri): 返回指定uri对应的Path路径
```

```java
String toString() ： 返回调用 Path 对象的字符串表示形式
boolean startsWith(String path) : 判断是否以 path 路径开始
boolean endsWith(String path) : 判断是否以 path 路径结束
boolean isAbsolute() : 判断是否是绝对路径
Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
Path getRoot() ：返回调用 Path 对象的根路径
Path getFileName() : 返回与调用 Path 对象关联的文件名
int getNameCount() : 返回Path 根目录后面元素的数量
Path getName(int idx) : 返回指定索引位置 idx 的路径名称
Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
File toFile(): 将Path转化为File类的对象
```

java.nio.file.Files 用于操作文件或目录的工具类

```java
Path copy(Path src, Path dest, CopyOption ... how) : 文件的复制
Path createDirectory(Path path, FileAttribute<?> ... attr) : 创建一个目录
Path createFile(Path path, FileAttribute<?> ... arr) : 创建一个文件
void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除
Path move(Path src, Path dest, CopyOption...how) : 将 src 移动到 dest 位置
long size(Path path) : 返回 path 指定文件的大小
```

```java
boolean exists(Path path, LinkOption ... opts) : 判断文件是否存在
boolean isDirectory(Path path, LinkOption ... opts) : 判断是否是目录
boolean isRegularFile(Path path, LinkOption ... opts) : 判断是否是文件
boolean isHidden(Path path) : 判断是否是隐藏文件
boolean isReadable(Path path) : 判断文件是否可读
boolean isWritable(Path path) : 判断文件是否可写
boolean notExists(Path path, LinkOption ... opts) : 判断文件是否不存在
```

```java
SeekableByteChannel newByteChannel(Path path, OpenOption...how) : 获取与指定文件的连接，how 指定打开方式。
DirectoryStream<Path> newDirectoryStream(Path path) : 打开 path 指定的目录
InputStream newInputStream(Path path, OpenOption...how):获取 InputStream 对象
OutputStream newOutputStream(Path path, OpenOption...how) : 获取 OutputStream 对象
```

以下是一个使用Java中的Path、Paths和Files核心API的示例代码：

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class PathAndFilesDemo {

    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String targetFilePath = "target.txt";

        // 创建Path对象
        Path sourcePath = Paths.get(sourceFilePath);
        Path targetPath = Paths.get(targetFilePath);

        // 拷贝文件
        copyFile(sourcePath, targetPath);

        // 判断文件是否存在
        boolean fileExists = isFileExists(targetPath);
        System.out.println("目标文件是否存在: " + fileExists);

        // 获取文件大小
        long fileSize = getFileSize(targetPath);
        System.out.println("目标文件大小: " + fileSize + " 字节");

        // 删除文件
        deleteFile(targetPath);
    }

    // 拷贝文件
    public static void copyFile(Path sourcePath, Path targetPath) {
        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("文件拷贝成功！");
        } catch (IOException e) {
            System.out.println("文件拷贝失败！");
            e.printStackTrace();
        }
    }

    // 判断文件是否存在
    public static boolean isFileExists(Path path) {
        return Files.exists(path);
    }

    // 获取文件大小
    public static long getFileSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            System.out.println("获取文件大小失败！");
            e.printStackTrace();
            return -1;
        }
    }

    // 删除文件
    public static void deleteFile(Path path) {
        try {
            Files.deleteIfExists(path);
            System.out.println("文件删除成功！");
        } catch (IOException e) {
            System.out.println("文件删除失败！");
            e.printStackTrace();
        }
    }
}
```

在上述示例中，我们使用了Path、Paths和Files这三个核心API进行文件操作。首先，我们创建了两个Path对象，分别表示源文件和目标文件的路径。

然后，我们使用copyFile方法来拷贝源文件到目标文件。通过调用Files类的copy方法，我们可以方便地进行文件拷贝操作。在这里，我们还使用了StandardCopyOption.REPLACE_EXISTING选项，表示如果目标文件已存在，则替换该文件。

接下来，我们使用isFileExists方法判断目标文件是否存在。Files.exists方法可以用来检查文件是否存在。

然后，我们使用getFileSize方法获取目标文件的大小。通过调用Files.size方法，我们可以获取到文件的大小。

最后，我们使用deleteFile方法删除目标文件。Files.deleteIfExists方法可以用来删除文件，如果文件不存在则不会抛出异常。

这个示例演示了如何使用Path、Paths和Files这些核心API来进行文件的拷贝、判断是否存在、获取文件大小和删除文件等常用操作。请注意，实际应用中可能还需要处理异常、处理目录操作、以及更多其他文件相关的操作。
