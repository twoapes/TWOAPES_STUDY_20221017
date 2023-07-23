# Win7或Win10系统安装JDK

```shell
第一步 准备好jdk安装软件,并且文件的扩展名需要显示出来
如果没有安装软件,可以访问Oracle官网,需要注册邮箱即可下载
https://www.oracle.com/java/technologies/downloads/
Win7设置方式
我的电脑-属性 "隐藏已知文件类型的扩展名"去除选勾
Win10设置方式
此电脑-查看-文件扩展名-勾选


第二步 先安装软件,例如我们要安装jdk-8u241-windows-x64.exe

jdk代表我们要安装的是JDK的版本,包含jre和java SE
而241代表此版本共计修订了241次
jre的安装可以中断,无需继续安装
安装完后确定完整安装路径为
C:\Program Files\Java\jdk1.8.0_241


第三步 配置环境变量JAVA_HOME

Win7配置方式
我的电脑-高级系统属性-环境变量
Win10配置方式
此电脑-高级系统属性-环境变量
JAVA_HOME:C:\Program Files\Java\jdk1.8.0_241


第四步 配置环境变量PATH

Win7配置方式
%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

Win10配置方式

注意in10是不需要";"间隔

%JAVA_HOME%\bin
%JAVA_HOME%\jre\bin


第五步 JDK1.6及其以上无需配置CLASS_PATH

第六步 验证java

win+r #弹出并输入cmd运行
java #只要命令正常执行即可
javac #只要命令正常执行即可
java -version #查看jdk版本

注意:jdk11和jdk12 安装后默认是没有jre,如果需要可使用以下命令手动生成jre
#定位到JDK主目录后执行
bin\jlink.exe --module-path jmods --add-modules java.desktop --output jre
```
