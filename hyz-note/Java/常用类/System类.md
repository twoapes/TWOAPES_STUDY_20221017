# System类

- System类代表系统，系统级的很多属性和控制方法都放置在该类的内部。该类位于java.lang包。

- 由于该类的构造器是private的，所以无法创建该类的对象，也就是无法实例化该类。其内部的成员变量和成员方法都是static的，所以也可以很方便的进行调用。

成员变量

System类内部包含in、out和err三个成员变量，分别代表标准输入流(键盘输入)，标准输出流(显示器)和标准错误输出流(显示器)

成员方法
`native long currentTimeMillis()`

该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数

`void exit(int status)`
该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等

`void gc()`
该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。
`String getProperty(String key)`
该方法的作用是获得系统中属性名为key的属性对应的值

系统中常见的属性名以及属性的作用

如下表所示

![20230720143954](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230720143954.png)

```java
     String javaVersion = System.getProperty("java.version");
        log.info("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        log.info("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        log.info("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        log.info("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        log.info("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        log.info("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        log.info("user的dir:" + userDir);
```

下面是一些Java中常用的System类方法的示例：

1. 打印输出：

```java
System.out.println("Hello, World!");
```

2.获取当前时间的毫秒数：

```java
long currentTimeMillis = System.currentTimeMillis();
System.out.println("当前时间毫秒数: " + currentTimeMillis);
```

3.终止程序的执行：

```java
System.exit(0);
```

4.复制数组：

```java
int[] sourceArray = {1, 2, 3, 4, 5};
int[] destinationArray = new int[sourceArray.length];
System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);
```

5.获取环境变量：

```java
String javaHome = System.getenv("JAVA_HOME");
System.out.println("JAVA_HOME: " + javaHome);
```

6.获取系统属性：

```java
String osName = System.getProperty("os.name");
System.out.println("操作系统: " + osName);
```

7.垃圾回收：

```java
System.gc();
```

8.获取系统换行符：

```java
String newLine = System.lineSeparator();
System.out.println("换行符: " + newLine);
```

这些示例展示了System类的一些常用方法。System类还有其他方法，可根据具体需求进行查阅和使用。
