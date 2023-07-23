# instantclient_11_2客户端中文乱码问题

## 问题描述

instantclient_11_2客户端中文乱码问题 PLSQL Developer 11安装路径

## 问题复现

PLSQL Developer 11或sqlplus中执行sql语句出现????结果数据

![1689140951936](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689140951936.png)

## 解决方案

```sql
select userenv('language') from dual; #结果为:SIMPLIFIED CHINESE_CHINA.ZHS16GBK"
```

### 复制结果

```shell
@echo off
set ORACLE_HOME=D:\tool\DEVELOPMENT\PLSQL Developer 11\instantclient_11_2
set path=%ORACLE_HOME%
set TNS_ADMIN=%ORACLE_HOME%
set NLS_LANG=SIMPLIFIED CHINESE_CHINA.ZHS16GBK
start plsqldev.exe
end:
```

在PLSQL Developer 11安装路径下新建一个bat文件(文件名自取) 如果需要永久设置环境变量,配置如下

```shell
setx ORACLE_HOME "D:\tool\DEVELOPMENT\PLSQL Developer 11\instantclient_11_2"
setx path "%ORACLE_HOME%;%path%"
setx TNS_ADMIN "%ORACLE_HOME%"
setx LD_LIBRARY_PATH "%ORACLE_HOME%"
setx SQLPATH "%ORACLE_HOME%"
setx NLS_LANG "SIMPLIFIED CHINESE_CHINA.ZHS16GBK"
start plsqldev.exe  #可以不写,如果过程出错请使用在文本末端加入pause;后执行暂停操作即可检查
```
