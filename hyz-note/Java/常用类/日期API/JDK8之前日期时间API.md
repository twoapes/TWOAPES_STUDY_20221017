# JDK8之前日期时间API

## java.lang.System类

System类提供的public static long currentTimeMillis()用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
此方法适于计算时间差
计算世界时间的主要标准有

- UTC(Coordinated Universal Time)

- GMT(Greenwich Mean Time)

- CST(Central Standard Time)

## java.util.Date类

表示特定的瞬间，精确到毫秒

构造器

Date()

使用无参构造器创建的对象可以获取本地当前时间
Date(long date)

## 常用方法

- getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

- toString():把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy
其中： dow 是一周中的某一天 (Sun, Mon, Tue,Wed, Thu, Fri, Sat)，zzz是时间标准。

- 其它很多方法都过时了

### java.text.SimpleDateFormat类

Date类的API不易于国际化，大部分被废弃了，java.text.SimpleDateFormat类是一个不与语言环境有关的方式来格式化和解析日期的具体类
它允许进行格式化：日期->文本、解析：文本->日期

```txt
SimpleDateFormat() 
默认的模式和语言环境创建对象
public SimpleDateFormat(String pattern)
该构造方法可以用参数pattern指定的格式创建一个对象，该对象调用：
public String format(Date date)
方法格式化时间对象date解析
public Date parse(String source)：从给定字符串的开始解析文本，以生成一个日期
```

|字母|日期/格式元素|表示|实例|
|-|-|-|-|
|G|era|时代|AD|
|y|year|年份|2023|
|M|month|月份|Mar|
|d|day|日期|15|
|h|hour (1-12)|小时（12小时制）|3|
|m|minute|分钟|45|
|s|second|秒|30|
|S|fraction of second|秒的分数|567|
|z|time zone|时区|EST, GMT-5, etc.|
|Z|RFC 822 time zone|RFC 822时区|-0500, +0100, etc.|
|a|am/pm marker|上午/下午标记|PM|
|'|literal|字面量|'T'|
|''|escaped quote|转义的引号 ''|''|

```txt
        Date date = new Date(); // 产生一个Date实例
        // 产生一个format格式化的实例
        SimpleDateFormat format = new SimpleDateFormat();
        log.info(format.format(date));// 打印输出默认的格式
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");
        log.info(format2.format(date));
        try {
            // 实例化一个指定的格式对象
            Date date2 = format2.parse("2008年08月08日 星期一 08:08:08");
            // 将指定的日期解析后格式化按指定的格式输出
            log.info(date2.toString());
        } catch (ParseException e) {
            log.error(e.getMessage(),e);
        }
```

## java.util.Calendar(日历)类

Calendar是一个抽象基类，主用用于完成日期字段之间相互操作的功能

- 获取Calendar实例的方法

- 使用Calendar.getInstance()方法

- 调用它的子类GregorianCalendar的构造器

- 一个Calendar的实例是系统时间的抽象表示，通过get(int field)方法来取得想要的时间信息

  比如YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、MINUTE、SECOND

> public void set(int field,int value)
public void add(int field,int amount)
public final Date getTime()
public final void setTime(Date date)

注意
获取月份时
一月是0，二月是1，以此类推，12月是11
获取星期时
周日是1，周二是2 ， 。。。。周六是7

```txt
        Calendar calendar = Calendar.getInstance();
        // 从一个 Calendar 对象中获取Date对象
        Date date = calendar.getTime();
        // 使用给定的 Date 设置此 Calendar 的时间
        date = new Date(234234235235L);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        log.info("当前时间日设置为8后,时间是:" + calendar.getTime());
        calendar.add(Calendar.HOUR, 2);
        log.info("当前时间加2小时后,时间是:" + calendar.getTime());
        calendar.add(Calendar.MONTH, -2);
        log.info("当前日期减2个月后,时间是:" + calendar.getTime());
```

在JDK 8之前，Java的日期时间API主要使用`java.util.Date`和`java.util.Calendar`类来处理日期和时间。下面是一些使用这些类的示例：

1. 获取当前日期和时间：

```java
import java.util.Date;

Date currentDate = new Date();
System.out.println("当前日期和时间: " + currentDate);
```

2.格式化日期和时间：

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

Date currentDate = new Date();
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String formattedDate = dateFormat.format(currentDate);
System.out.println("格式化后的日期和时间: " + formattedDate);
```

3.比较日期：

```java
import java.util.Date;

Date date1 = new Date();
Date date2 = new Date();

int comparison = date1.compareTo(date2);
if (comparison < 0) {
    System.out.println("date1 在 date2 之前");
} else if (comparison > 0) {
    System.out.println("date1 在 date2 之后");
} else {
    System.out.println("date1 和 date2 相同");
}
```

4.添加或减去时间：

```java
import java.util.Calendar;
import java.util.Date;

Calendar calendar = Calendar.getInstance();
calendar.setTime(new Date());
calendar.add(Calendar.DAY_OF_MONTH, 5); // 添加5天
Date newDate = calendar.getTime();
System.out.println("添加5天后的日期: " + newDate);
```

5.获取特定时间单位的值：

```java
import java.util.Calendar;

Calendar calendar = Calendar.getInstance();
calendar.setTime(new Date());
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH) + 1; // 注意：Calendar中的月份从0开始计数，所以要加1
int day = calendar.get(Calendar.DAY_OF_MONTH);
System.out.println("年份: " + year);
System.out.println("月份: " + month);
System.out.println("日期: " + day);
```

这些示例展示了在JDK 8之前使用的Java日期时间API的一些常见操作。然而，需要注意的是，这些API在设计和使用上存在一些问题，例如线程安全性、可变性等。从JDK 8开始，引入了新的日期时间API（`java.time`包）来解决这些问题，并提供了更多功能和灵活性。推荐在JDK 8及以上版本中使用新的日期时间API。
