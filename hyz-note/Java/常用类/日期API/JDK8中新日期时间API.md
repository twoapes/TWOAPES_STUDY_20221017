# JDK8中新日期时间API

在JDK 8及以后，Java引入了新的日期时间API，位于`java.time`包中，提供了更强大、更易用的日期和时间处理功能。下面是一些使用新日期时间API的示例：

1.获取当前日期和时间：

```java
import java.time.LocalDateTime;

LocalDateTime currentDateTime = LocalDateTime.now();
System.out.println("当前日期和时间: " + currentDateTime);
```

2.格式化日期和时间：

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

LocalDateTime currentDateTime = LocalDateTime.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String formattedDateTime = currentDateTime.format(formatter);
System.out.println("格式化后的日期和时间: " + formattedDateTime);
```

3.比较日期：

```java
import java.time.LocalDate;

LocalDate date1 = LocalDate.of(2021, 1, 1);
LocalDate date2 = LocalDate.of(2022, 1, 1);

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
import java.time.LocalDate;
import java.time.Period;

LocalDate date = LocalDate.now();
LocalDate newDate = date.plusDays(5); // 添加5天
System.out.println("添加5天后的日期: " + newDate);

// 使用Period添加一段时间
Period period = Period.ofDays(5);
LocalDate newDate2 = date.plus(period);
System.out.println("添加5天后的日期: " + newDate2);
```

5.获取特定时间单位的值：

```java
import java.time.LocalDate;

LocalDate date = LocalDate.now();
int year = date.getYear();
int month = date.getMonthValue();
int day = date.getDayOfMonth();
System.out.println("年份: " + year);
System.out.println("月份: " + month);
System.out.println("日期: " + day);
```

这些示例展示了JDK 8及以后的新日期时间API的一些常见操作。新的日期时间API提供了诸如`LocalDateTime`、`LocalDate`、`Period`、`Duration`等类，用于处理日期、时间、时间段等。它们提供了丰富的方法来执行日期和时间的计算、格式化、比较等操作，而且设计上更加清晰、易用，并且线程安全。推荐在JDK 8及以上版本中使用新的日期时间API。
