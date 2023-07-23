# File类的使用

## File 类常用 API 介绍

```java
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class FileDemo {
    /**
     * @param args args
     */
    public static void main(String[] args) throws IOException {
        RafDemo1();
        RafDemo2();
    }

    private static void RafDemo1() {
        // 了解构造函数的情况  查帮助
        File file = new File("E:\\javaio\\imooc");
        //System.out.println(file.exists());
        if (!file.exists())
            file.mkdir(); //file.mkdirs()
        else
            file.delete();
        //是否是一个目录  如果是目录返回true,如果不是目录or目录不存在返回的是false
        System.out.println(file.isDirectory());
        //是否是一个文件
        System.out.println(file.isFile());

        //File file2 = new File("e:\\javaio\\日记1.txt");
        File file2 = new File("e:\\javaio", "日记1.txt");
        if (!file2.exists())
            try {
                file2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        else
            file2.delete();
        //常用的File对象的API
        System.out.println(file);//file.toString()的内容
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
        System.out.println(file.getParentFile().getAbsolutePath());
    }

    private static void RafDemo2() throws IOException {
        File demo = new File("demo");
        if (!demo.exists())
            demo.mkdir();
        File file = new File(demo, "raf.dat");
        if (!file.exists())
            file.createNewFile();

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //指针的位置
        System.out.println(raf.getFilePointer());

        raf.write('A');//只写了一个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');

        int i = 0x7fffffff;
        //用write方法每次只能写一个字节,如果要把i写进去就得写4次
        raf.write(i >>> 24);//高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        //可以直接写一个int
        raf.writeInt(i);

        String s = "中";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);
        System.out.println(raf.length());

        //读文件,必须把指针移到头部
        raf.seek(0);
        //一次性读取,把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);

        System.out.println(Arrays.toString(buf));
        for (byte b : buf) {
            System.out.println(Integer.toHexString(b & 0xff) + " ");
        }
        raf.close();
    }
}
```

## 字节流

### 字节流之文件输入流FileInputStream

```java
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
    /**
     * 读取指定文件内容,按照16进制输出到控制台
     * 并且每输出10个byte换行
     *
     * @param fileName 单字节读取不适合大文件,大文件效率很低
     */
    public static void printHex(String fileName) throws IOException {
        //把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 批量读取,对大文件而言效率高,也是我们最常用的读文件的方式
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];
        /*从in中批量读取字节,放入到buf这个字节数组中,
         * 从第0个位置开始放,最多放buf.length个
         * 返回的是读到的字节的个数
         */
    /*int bytes = in.read(buf,0,buf.length);//一次性读完,说明字节数组足够大
    int j = 1;
    for(int i = 0; i < bytes;i++){
      System.out.print(Integer.toHexString(buf[i] & 0xff)+"  ");
      if(j++%10==0){
        System.out.println();
      }
    }*/
        int bytes = 0;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 文件拷贝,字节批量读取
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();//最好加上
        }
        in.close();
        out.close();

    }

    /**
     * 进行文件的拷贝,利用带缓冲的字节流
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile));
        int c;
        while ((c = bis.read()) != -1) {
            bos.write(c);
            bos.flush();//刷新缓冲区
        }
        bis.close();
        bos.close();
    }

    /**
     * 单字节,不带缓冲进行文件拷贝
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件:" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
            out.flush();
        }
        in.close();
        out.close();
    }

    private void IOUtilTest2() {
        // TODO Auto-generated method stub
        try {
            long start = System.currentTimeMillis();
            //IOUtil.printHexByByteArray("e:\\javaio\\FileUtils.java");
            //IOUtil.printHex("e:\\javaio\\1.mp3");
            IOUtil.printHexByByteArray("e:\\javaio\\1.mp3");
            System.out.println();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void FileOutDemo1() throws IOException {
        // TODO Auto-generated method stub
        //如果该文件不存在,则直接创建,如果存在,删除后创建
        FileOutputStream out = new FileOutputStream("demo/out.dat");
        out.write('A');//写出了'A'的低八位
        out.write('B');//写出了'B'的低八位
        int a = 10;//write只能写八位,那么写一个int需要些4次每次8位
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.printHex("demo/out.dat");
    }

    private void IOUtilTest3() throws IOException {
        // TODO Auto-generated method stub
        try {
            IOUtil.copyFile(new File("e:\\javaio\\imooc.txt"), new File(
                    "e:\\javaio\\imooc1.txt"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
```

### 字节流之数据输入输出流

```java


import java.io.*;

public class DosDemo {
    public static void main(String[] args) throws IOException {
        String file = "demo/dos.dat";
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utf-16be编码写出
        dos.writeChars("中国");
        dos.close();
        IOUtil.printHex(file);
    }

    private static void DisDemo() throws IOException {
        // TODO Auto-generated method stub
        String file = "demo/dos.dat";
        IOUtil.printHex(file);
        DataInputStream dis = new DataInputStream(
                new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);

        dis.close();
    }
}
```

### 字节缓冲流

```java
import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            long start = System.currentTimeMillis();
      /*IOUtil.copyFileByByte(new File("e:\\javaio\\1.mp3"), new File(
          "e:\\javaio\\2.mp3"));*/  //两万多毫秒
      /*IOUtil.copyFileByBuffer(new File("e:\\javaio\\1.mp3"), new File(
          "e:\\javaio\\3.mp3"));//一万多毫秒*/
            IOUtil.copyFile(new File("e:\\javaio\\1.mp3"), new File(
                    "e:\\javaio\\4.mp3"));//7毫秒
            long end = System.currentTimeMillis();
            System.out.println(end - start );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
```

## 字符流

### 字节字符转换流

```java
package com.imooc.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswDemo {
  public static void main(String[] args)throws IOException {
    FileInputStream in = new FileInputStream("e:\\javaio\\imoocutf8.txt");
    InputStreamReader isr = new InputStreamReader(in,"utf-8");//默认项目的编码,操作的时候,要写文件本身的编码格式

    FileOutputStream out = new FileOutputStream("e:\\javaio\\imoocutf81.txt");
    OutputStreamWriter osw = new OutputStreamWriter(out,"utf-8");
    /*int c ;
    while((c = isr.read())!=-1){
      System.out.print((char)c);
    }*/
    char[] buffer = new char[8*1024];
    int c;
    /*批量读取,放入buffer这个字符数组,从第0个位置开始放置,最多放buffer.length个
      返回的是读到的字符的个数
    */
    while(( c = isr.read(buffer,0,buffer.length))!=-1){
      String s = new String(buffer,0,c);
      System.out.print(s);
      osw.write(buffer,0,c);
      osw.flush();
    }
    isr.close();
    osw.close();

  }

}
```

### 字符流之文件读写流

```java
package com.imooc.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
  public static void main(String[] args) throws IOException{
    FileReader fr = new FileReader("e:\\javaio\\imooc.txt");
    FileWriter fw = new FileWriter("e:\\javaio\\imooc2.txt");
    //FileWriter fw = new FileWriter("e:\\javaio\\imooc2.txt",true);
    char[] buffer = new char[2056];
    int c ;
    while((c = fr.read(buffer,0,buffer.length))!=-1){
      fw.write(buffer,0,c);
      fw.flush();
    }
    fr.close();
    fw.close();
  }
}
```

### 字符流的过滤器

```java
package com.imooc.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BrAndBwOrPwDemo {
  public static void main(String[] args) throws IOException{
     //对文件进行读写操作
    BufferedReader br = new BufferedReader(
        new InputStreamReader(
            new FileInputStream("e:\\javaio\\imooc.txt")));
    /*BufferedWriter bw = new BufferedWriter(
        new OutputStreamWriter(
            new FileOutputStream("e:\\javaio\\imooc3.txt")));*/
    PrintWriter pw = new PrintWriter("e:\\javaio\\imooc4.txt");
    //PrintWriter pw1 = new PrintWriter(outputStream,boolean autoFlush);
    String line ;
    while((line = br.readLine())!=null){
      System.out.println(line);//一次读一行,并不能识别换行
      /*bw.write(line);
      //单独写出换行操作
      bw.newLine();//换行操作
      bw.flush();*/
      pw.println(line);
      pw.flush();
    }
    br.close();
    //bw.close();
    pw.close();
  }

}
```

## 对象的序列化和反序列化

### 序列化基本操作

```java
package com.imooc.io;

import java.io.Serializable;

public class Student implements Serializable{
  private String stuno;
  private String stuname;
  //该元素不会进行jvm默认的序列化,也可以自己完成这个元素的序列化
  private transient int stuage;

  public Student(String stuno, String stuname, int stuage) {
    super();
    this.stuno = stuno;
    this.stuname = stuname;
    this.stuage = stuage;
  }

  public String getStuno() {
    return stuno;
  }
  public void setStuno(String stuno) {
    this.stuno = stuno;
  }
  public String getStuname() {
    return stuname;
  }
  public void setStuname(String stuname) {
    this.stuname = stuname;
  }
  public int getStuage() {
    return stuage;
  }
  public void setStuage(int stuage) {
    this.stuage = stuage;
  }
  @Override
  public String toString() {
    return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stuage="
        + stuage + "]";
  }
   private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
     s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
     s.writeInt(stuage);//自己完成stuage的序列化
   }
   private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException{
      s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
      this.stuage = s.readInt();//自己完成stuage的反序列化操作
  }
}
```

```java
package com.imooc.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectSeriaDemo1 {
  public static void main(String[] args) throws Exception{
    String file = "demo/obj.dat";
    //1.对象的序列化
    /*ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream(file));
    Student stu = new Student("10001", "张三", 20);
    oos.writeObject(stu);
    oos.flush();
    oos.close();*/
    ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream(file));
    Student stu = (Student)ois.readObject();
    System.out.println(stu);
    ois.close();

  }
}
```

### transient及ArrayList源码分析

```java
/**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     *             instance is emitted (int), followed by all of its elements
     *             (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException{
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }
```

### 序列化中子父类构造函数问题

```java
package com.imooc.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectSeriaDemo2 {
  public static void main(String[] args) throws Exception{
    /*ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("demo/obj1.dat"));
    Foo2 foo2 = new Foo2();
    oos.writeObject(foo2);
    oos.flush();
    oos.close();*/

    //反序列化是否递归调用父类的构造函数
    /*ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("demo/obj1.dat"));
    Foo2 foo2 = (Foo2)ois.readObject();
    System.out.println(foo2);
    ois.close();*/



    /*ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("demo/obj1.dat"));
    Bar2 bar2 = new Bar2();
    oos.writeObject(bar2);
    oos.flush();
    oos.close();*/

    ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("demo/obj1.dat"));
    Bar2 bar2 = (Bar2)ois.readObject();
    System.out.println(bar2);
    ois.close();



    /*
     * 对子类对象进行反序列化操作时,
     * 如果其父类没有实现序列化接口
     * 那么其父类的构造函数会被调用
     */
  }
}
/*
 *   一个类实现了序列化接口,那么其子类都可以进行序列化
*/
class Foo implements Serializable{
  public Foo(){
    System.out.println("foo...");
  }
}
class Foo1 extends Foo{
  public Foo1(){
    System.out.println("foo1...");
  }
}
class Foo2 extends Foo1{
  public Foo2(){
    System.out.println("foo2...");
  }
}
class Bar{
  public Bar(){
    System.out.println("bar");
  }
}
class Bar1 extends Bar{
  public Bar1(){
    System.out.println("bar1..");
  }
}
class Bar2 extends Bar1 implements Serializable{
  public Bar2(){
    System.out.println("bar2...");
  }
}
```

## 总结

```txt
java.io.File类用于表示文件（目录）
File类只用于表示文件（目录）的信息（名称、大小等）,不能用于文件内容的访问

RandomAccessFile java提供的对文件内容的访问,既可以读文件,也可以写文件。
RandomAccessFile支持随机访问文件,可以访问文件的任意位置

(1)java文件模型
  在硬盘上的文件是byte byte byte存储的,是数据的集合
(2)打开文件
  有两种模式"rw"(读写)  "r"（只读)
  RandomAccessFile raf = new RandomeAccessFile(file,"rw")
  文件指针,打开文件时指针在开头 pointer = 0;
(3) 写方法
    raf.write(int)--->只写一个字节（后8位),同时指针指向下一个位置,准备再次写入
(4)读方法
   int b = raf.read()--->读一个字节
（5）文件读写完成以后一定要关闭（Oracle官方说明）



序列化与基本类型序列化
1）将类型int 转换成4byte或将其他数据类型转换成byte的过程叫序列化
     数据---->n byte
2)反序列化
    将n个byte 转换成一个数据的过程
    nbyte ---> 数据
3)RandomAccessFile提供基本类型的读写方法,可以将基本类型数据
   序列化到文件或者将文件内容反序列化为数据
IO流(输入流、输出流)
字节流、字符流
1.字节流
1)InputStream、OutputStream
    InputStream抽象了应用程序读取数据的方式
    OutputStream抽象了应用程序写出数据的方式
 2)EOF = End   读到-1就读到结尾
3)输入流基本方法
   int  b = in.read();读取一个字节无符号填充到int低八位.-1是 EOF
   in.read(byte[] buf)
   in.read(byte[] buf,int start,int size)
4)输出流基本方法
  out.write(int b)  写出一个byte到流,b的低8位
  out.write(byte[] buf)将buf字节数组都写入到流
  out.write(byte[] buf,int start,int size)

5)FileInputStream--->具体实现了在文件上读取数据
6)FileOutputStream 实现了向文件中写出byte数据的方法
7)DataOutputStream/DataInputStream
    对"流"功能的扩展,可以更加方面的读取int,long,字符等类型数据
   DataOutputStream
        writeInt()/writeDouble()/writeUTF()

8)BufferedInputStream&BufferedOutputStream
这两个流类位IO提供了带缓冲区的操作,一般打开文件进行写入
或读取操作时,都会加上缓冲,这种流模式提高了IO的性能
从应用程序中把输入放入文件,相当于将一缸水倒入到另一个缸中:
FileOutputStream--->write()方法相当于一滴一滴地把水“转移”过去
DataOutputStream-->writeXxx()方法会方便一些,相当于一瓢一瓢把水“转移”过去
BufferedOutputStream--->write方法更方便,相当于一飘一瓢先放入桶中,再从桶中倒入到另一个缸中,性能提高了



2.字符流
1) 编码问题
2)认识文本和文本文件
java的文本(char)是16位无符号整数,是字符的unicode编码（双字节编码)
文件是byte byte byte ...的数据序列
文本文件是文本(char)序列按照某种编码方案(utf-8,utf-16be,gbk)序列化为byte的存储结果
3)字符流(Reader Writer)---->操作的是文本文本文件
字符的处理,一次处理一个字符
字符的底层任然是基本的字节序列
字符流的基本实现
   InputStreamReader   完成byte流解析为char流,按照编码解析
   OutputStreamWriter  提供char流到byte流,按照编码处理

   FileReader/FileWriter
字符流的过滤器
   BufferedReader   ---->readLine 一次读一行
   BufferedWriter/PrintWriter   ---->写一行



3.对象的序列化,反序列化
1)对象序列化,就是将Object转换成byte序列,反之叫对象的反序列化
2)序列化流(ObjectOutputStream),是过滤流----writeObject
   反序列化流(ObjectInputStream)---readObject

3)序列化接口(Serializable)
   对象必须实现序列化接口 ,才能进行序列化,否则将出现异常
   这个接口,没有任何方法,只是一个标准

4) transient关键字
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException
  private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException

   分析ArrayList源码中序列化和反序列化的问题

5)序列化中 子类和父类构造函数的调用问题
```
