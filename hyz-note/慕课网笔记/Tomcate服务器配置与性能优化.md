# Tomcat服务配置与性能优化

## Tomcat简介

● Apache软件基金会

● 开源软件

● 中小型应用服务器

### Tomcate原理

![1689145238215](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689145238215.png)

```txt
Server服务器:监听端口和运行停止命令,管理Service服务
Service:管理服务
Connector:外部和内部的连接器
Contatiner:servicenet生命周期,调用方法处理逻辑
Jasper:解析引擎,jsp和编译java文件
Naming:匿名服务
Session:持久化操作
Loging:日志操作
JMX:javase中的规范,远程监控jvm运行状况
```

### Connector组件

接收客户端连接

加工处理客户端请求

### Contatiner组件

所有的子容器的父接口

负责链设计模式

![1689145285806](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689145285806.png)

```txt
engine:管理多个站点
Host:代表一个站点,虚拟主机
Context:相当于一个程序,即war包
Wrapper:相当于servicenet
```

```txt
apache-tomcat-6.0.53\webapps
这个目录下有多少个目录就代表有多少个站点
```

### Server处理HTTP请求

![1689145337894](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689145337894.png)

自上而下,包含子容器

## Tomcate环境安装

### Tomcat运行环境

搭建运行基础环境(JDK1.8)

安装Tomcate服务器(Win,Linux)

### Linux运行环境

搭建运行基础环境(JDK1.8)

安装Tomcate服务器(Win,Linux)

## Tomcat常用配置项修改

### 配置端口号

范围:1-65535

1-1024被系统或第三方软件占用

service.xml解析

shutdown端口:发送关闭服务的端口

http端口:建立http请求的端口

ajp端口:和其他http连接

以上三个端口都不能重复和冲突

### 修改内存

内存模型

加强读取速度和内存占用,防止异常

堆类存:存储类,即实例化的对象

栈内存:局部参数,参数等

静态内存区:常量,静态变量,元数据(属性)

OutOfMemoryErrory:Java heap space异常

一般jvm默认内存为系统的

最小六十四分之一

最大四分之一

例如: 8g 最小 128m 最大 2048m

OutOfMemoryErrory:PermGen space异常

静态内存区满

1.8以后不存在此异常

StackOverflowError异常:栈移除,一般程序死循环或溢出导致

配置catalina

```shell
#server 虚拟机运行模式 默认是client
#Xms jvm初始大小物理内存1/64
#Xmx jvm最大值 一般取物理内存的1/2
#MetaspaceSize 初始空间大小,默认21m
#MaxMetaspaceSize 最大空间大小,无上限
JAVA_OPTS="-server -Xms1024m -Xmx2048m -XX:PermSize=256m -XX:MaxPermSize=512m"
```

### 热部署

什么是热部署

如何配置热部署

1.项目放置webapps

改动jsp等文件,服务无需重启

2.server配置项目路径

```xml
#debug 值越大日志越详细
#docBase 项目相对路径
#path 项目文件名
#reloadable 自动加载或新增class文件
<Context debug="0" docBase="xxx" path="/xxx" reloadable="true"/>
```

3.Catalina下创建xml文件

apache-tomcat-6.0.53\conf\Catalina\localhost

demo2文件

这种方式不识别path参数

```xml
<Context docBase="xxx" reloadable="true"/>
```

### 数据连接池与数据源

什么是连接池

如何配置数据源

参考官网即可

```xml
https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html
<Resource name="jdbc/TestDB"
          auth="Container"
          type="javax.sql.DataSource"
          factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
          testWhileIdle="true"
          testOnBorrow="true"
          testOnReturn="false"
          validationQuery="SELECT 1"
          validationInterval="30000"
          timeBetweenEvictionRunsMillis="30000"
          maxActive="100"
          minIdle="10"
          maxWait="10000"
          initialSize="10"
          removeAbandonedTimeout="60"
          removeAbandoned="true"
          logAbandoned="true"
          minEvictableIdleTimeMillis="30000"
          jmxEnabled="true"
          jdbcInterceptors="org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;
            org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer"
          username="root"
          password="password"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/mysql"/>
```

## web管理

### Tomcat实现web管理

管理界面功能简述

使用tomcat管理界面发布项目

## Tomcate安全配置

初始化配置

### 关闭服务器端口

使用telnet命令后如果使用shutdown则会引发安全问题

所以改变service.xml更改shudown命令信息即可

```xml
<!-- <Server port="8005" shutdown="SHUTDOWN"> 
默认使用shutdown命令关闭tomcat,以下方式更改为exit命令
-->
<Server port="8005" shutdown="EXIT">
```

### 隐藏版本信息

修改版本号

防止攻击

```shell
#lib包下的catalina.jar
#catalina.jar\org\apache\catalina\util
#ServerInfo.properties文件控制版本
#例如如下内容
server.info=Apache Tomcat/6.0.53 ##版本号
server.number=6.0.53.0
server.built=Apr 2 2017 07:25:00 UTC
```

### 禁用Tomcat管理页面

防止黑客使用管理界面,猜密码等

ROOT给个空目录

### 自定义错误页面

配置web.xml即可

```xml
<!-- error-code 对应错误代码下修改访问目录即可 -->
<error-page>
    <error-code>404</error-code>
    <location>/WEB-INF/jsp/errors/error.jsp</location>
</error-page>
<error-page>
    <error-code>500</error-code>
    <location>/WEB-INF/jsp/errors/error.jsp</location>
</error-page>
<error-page>
    <error-code>414</error-code>
    <location>/WEB-INF/jsp/errors/error.jsp</location>
</error-page>
<error-page>
    <error-code>505</error-code>
    <location>/WEB-INF/jsp/errors/error.jsp</location>
</error-page>
<error-page>
    <error-code>400</error-code>
    <location>/WEB-INF/jsp/errors/error.jsp</location>
</error-page>
```

### AJP端口管理

Tomcat和AJP通讯的时候使用

```xml
<!-- 更改端口或不使用的情况下注释掉即可 -->
 <Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
```

### 启动cookie的HttpOnly

增强cookie的安全性

保存在客户端的纯文本文件

常应用在离线状态

session出现之前是使用的cookie解决离线的问题

XSS-跨站脚本攻击

```xml
#apache-tomcat-6.0.53\conf
<Context useHttpOnly="true">
```

### 安全规范

账号管理,认证授权

共享,无关账号

口令密码

## Tomcat性能优化

缓存优化(nginx,gzip)

运行模式

BIO:tomcat7以下默认模式

NIO:基于缓存区,非阻塞的I/O

APR:tomcat7及以上默认模式
