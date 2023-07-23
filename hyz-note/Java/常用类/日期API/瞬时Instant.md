# 瞬时Instant

- Instant：时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳。

- 在处理时间和日期的时候，我们通常会想到年,月,日,时,分,秒。然而，这只是时间的一个模型，是面向人类的。第二种通用模型是面向机器的，或者说是连续的。在此模型中，时间线中的一个点表示为一个很大的数，这有利于计算机处理。在UNIX中，这个数从1970年开始，以秒为的单位；同样的，在Java中，也是从1970年开始，但以毫秒为单位。

- java.time包通过值类型Instant提供机器视图，不提供处理人类意义上的时间单位

Instant表示时间线上的一点，而不需要任何上下文信息，例如，时区

概念上讲，它只是简单的表示自1970年1月1日0时0分0秒（UTC）开始的秒数

因为java.time包是基于纳秒计算的，所以Instant的精度可以达到纳秒级。(1 ns = 10-9 s) 1秒 = 1000毫秒 =10^6微秒=10^9纳秒

![20230720150652](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230720150652.png)

时间戳是指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数

![20230720150726](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230720150726.png)

java.time.format.DateTimeFormatter 类：该类提供了三种格式化方法
预定义的标准格式。
如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
本地化相关的格式。
如：ofLocalizedDateTime(FormatStyle.LONG)
自定义的格式。
如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

![20230720150820](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230720150820.png)

## 其它API

- ZoneId：该类中包含了所有的时区信息，一个时区的ID

  如 Europe/Paris

- ZonedDateTime：一个在ISO-8601日历系统时区的日期时间

  如 2007-12-03T10:15:30+01:00 Europe/Paris。

- 其中每个时区都对应着ID，地区ID都为“{区域}/{城市}”的格式

  例如：Asia/Shanghai等

- Clock：使用时区提供对当前即时、日期和时间的访问的时钟。

- 持续时间：Duration，用于计算两个“时间”间隔

- 日期间隔：Period，用于计算两个“日期”间隔

- TemporalAdjuster : 时间校正器。有时我们可能需要获取例如：将日期调整到“下一个工作日”等操作。

- TemporalAdjusters : 该类通过静态方法(firstDayOfXxx()/lastDayOfXxx()/nextXxx())提供了大量的常用TemporalAdjuster 的实现。

![20230720150858](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/20230720150858.png)

`Instant`类是Java 8及以后的日期时间API中表示瞬时点的类，它代表了时间轴上的一个具体时刻，精确到纳秒级别。下面是一些使用`Instant`类的示例：

1.获取当前的瞬时时间：

```java
import java.time.Instant;

Instant currentInstant = Instant.now();
System.out.println("当前瞬时时间: " + currentInstant);
```

2.使用指定的时间戳创建瞬时时间：

```java
import java.time.Instant;

Instant instant = Instant.ofEpochSecond(1622714400); // 2021-06-03 00:00:00 UTC
System.out.println("瞬时时间: " + instant);
```

3.在瞬时时间上进行偏移操作：

```java
import java.time.Instant;
import java.time.temporal.ChronoUnit;

Instant instant = Instant.now();
Instant plusHours = instant.plus(2, ChronoUnit.HOURS);
Instant minusMinutes = instant.minus(30, ChronoUnit.MINUTES);

System.out.println("原始瞬时时间: " + instant);
System.out.println("添加2小时后的瞬时时间: " + plusHours);
System.out.println("减去30分钟后的瞬时时间: " + minusMinutes);
```

4.比较瞬时时间：

```java
import java.time.Instant;

Instant instant1 = Instant.ofEpochSecond(1622714400);
Instant instant2 = Instant.ofEpochSecond(1622800800);

int comparison = instant1.compareTo(instant2);
if (comparison < 0) {
    System.out.println("instant1 在 instant2 之前");
} else if (comparison > 0) {
    System.out.println("instant1 在 instant2 之后");
} else {
    System.out.println("instant1 和 instant2 相同");
}
```

5.获取瞬时时间的时间戳：

```java
import java.time.Instant;

Instant instant = Instant.now();
long timestamp = instant.getEpochSecond();
System.out.println("时间戳: " + timestamp);
```

6.根据时间戳创建瞬时时间：

```java
import java.time.Instant;

long timestamp = 1622714400;
Instant instant = Instant.ofEpochSecond(timestamp);
System.out.println("瞬时时间: " + instant);
```

这些示例展示了使用`Instant`类进行瞬时时间操作的常见用法。`Instant`类提供了一些方法来获取当前时间、创建指定时间的实例、进行偏移操作、比较时间、获取时间戳等。它是一种不可变类，线程安全，并且可以与其他日期时间类进行转换和操作。
