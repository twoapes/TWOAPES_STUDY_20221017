# Windows安装Oracle

## 核心文件

```txt
p13390677_112040_MSWIN-x86-64_1of7.zip
p13390677_112040_MSWIN-x86-64_2of7.zip
jdk-8u241-windows-x64.exe
DirectX修复工具 v3.9.0.0增强版
PLSQL Developer软件
```

## 安装

1.双击setup.exe

2.电脑需要设置C盘共享,也需要关闭360等安全软件,可以安装完毕后关闭共享和打开安全软件

3.检查防火墙是否关闭

4.连接数据库

5.我们通过配置Net Configuration Assistant使得外网或内网其他电脑能够正常访问和使用

`C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Oracle - OraDb11g_home1\配置和移植工具\Net Configuration Assistant`

## 卸载

1.找到安装目录11.2.0.4 卸载数据库

Windows和Linux的卸载方式大同小异,本文主要针对Windows下的卸载,Linux运行deinstall后直接删除Oracle的主目录和环境变量就行了,没什么特殊的操作,因为没有注册表

Windows卸载文件

`C:\app\数据库名称\product\11.2.0\dbhome_1\deinstall\deinstall.bat`

Linux卸载文件

`/home/twoapes/app/twoapes/product/11.2.0/dbhome_1/deinstall/deinstall`

2.显示到下面的内容,然后回车,代表我们使用默认的卸载方式,如果有多个数据库名,那么可以指定只删除指定的数据库

![62c7bf1c3e31a527d938820ba2f0d1bf](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/62c7bf1c3e31a527d938820ba2f0d1bf.png)

3.下面是提升是否确定要删除,中文版本Oracle写"是",如果是英文版Oracle写"yes"或'Y',继续,具体看提示

![c9dbbd32d6103f6e29acb43dc79c5c10](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/c9dbbd32d6103f6e29acb43dc79c5c10.png)

4.看是否存在Oracle相关服务

win+r然后运行services.msc,如果有以下的服务,需要想办法清除,建议使用CCleaner清理

![207e23c2f2692154904e0a94f20d2b1f](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/207e23c2f2692154904e0a94f20d2b1f.png)

5.尝试删除`C:\app`

如果删不掉.重启电脑,再次删除即可

如果上面的步骤不能完整删除,那么使用Universal Installer软件进行卸载`C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Oracle - OraDb11g_home1\Oracle 安装产品\Universal Installer`

除了母节点,其余全部勾选,然后点击删除即可

![18bbc8fb8047b27a843dac934d9679d3](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/18bbc8fb8047b27a843dac934d9679d3.png)
