# Java执行方式

接下来我们写一个简单的代码并执行Java源代码文件分析分析,执行过程和结果
首先验证java环境是否正常,cmd命令执行java和javac命令,以保证能正常使用java环境
1.创建一个txt文件,命名为Note.txt,存放在任意位置,例如存放在C&#58;&#92;java目录下

2.更改文件后缀为java,即Note.java

3.写代码

```java
/**
 * @author huyingzhao
 * 2022-01-02 14:01
 * 执行方式
 */
public class Note {
    public static void main(String[] args) {
        System.out.println("欢迎来到二次猿的世界");
    }
}
```

4.执行程序
win10系统 使用win&#43;r输入cmd打开cmd命令
Linux系统 shell界面或远程软件使用shell命令
使用编译器编译文件产生字节码文件 javac Note.java
使用JVM读取字节码文件执行程序 java Note
我们可以形象的把编译器比喻成翻译机,翻译成计算机能理解的信息
我们可以形象的把JVM比喻成工厂,翻译后的信息进行加工打包,最后生成最终产品

5.乱码问题
Win10系统 默认文件是ANSI编码,所以需要编辑器也编辑为ANSI编码,例如Notepad&#43;&#43;编辑器选择编码-使用ANSI编码
Linux系统 默认文件是UTF-8编码,所以需要编辑器也编辑为UTF-8编码,例如notepadqq编辑器选择编码-使用UTF-8编码

6.解读代码
public class Note
public class是固定写法,其中public和class叫关键字,是不能被改变的,Note是类名,必须和文件名一模一样
public static void
public static void也是固定写法,同理,public和static,void都是关键字,不能被改变
main
main是方法名,可以自定义,但不考虑重载情况下方法名不能重复,而且在java中默认main方法固定作为程序的入口,所以main也是固定写法
String&#91;&#93; args
String&#91;&#93;是参数类型,args是参数值,一个参数类型对应一个参数值,所以当前main方法的参数个数只有一个
System.out.println("欢迎来到二次猿的世界");
System.out.println是不能被改变的,是用于输出和打印指定的内容,因此当前要打印的内容为"欢迎来到二次猿的世界"
; 分号用于结束一个完整的Java语句,因此System.out.println("欢迎来到二次猿的世界") 是一个完整的语句

7.Note{...}  main(String&#91;&#93; args){...}
Note{...}  类名后面紧随的"{"作为程序的开始和使用"}"作为程序的结束,类似这种类名后面的完整方括号,我们称为&#42;&#42;类块&#42;&#42;
main(String&#91;&#93; args){...} 方法名后面紧随的"{"作为方法的开始和使用"}"作为方法的结束,类似这种方法名后面的完整方括号,我们称为&#42;&#42;方法块&#42;&#42;

我们当前只要知道以下三点
本例中有且只有一个参数类型和对应的参数值
本例中方法名不会重复,有且只有一个main的方法名作为程序的入口
java区分大小写,关键字都是小写,方法名main固定使用
