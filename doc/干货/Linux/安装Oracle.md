# 安装Oracle

[官网](https://docs.oracle.com/en/database/)

## 核心文件

p13390677_112040_Linux-x86-64_1of7.zip
p13390677_112040_Linux-x86-64_2of7.zip
jdk-8u241-linux-x64.tar.gz ##解压命令为 tar -xzvf jdk-8u241-linux-x64.tar.gz

## apt-get

```shell
apt-get install numactl
apt-get install libgcc1
apt-get install libgcc1-dbg
apt-get install libdb1-compat
apt-get install glibc-doc
apt-get install glibc-source
apt-get install glibc-doc-reference
apt-get install expat
apt-get install gcc
apt-get install g++
apt-get install make
apt-get install binutils
apt-get install libc6
apt-get install libc6-dev
apt-get install libstdc++6
apt-get install libstdc++-6-dev
apt-get install rpm
apt-get install gawk
apt-get install libaio1
apt-get install elfutils
apt-get install libaio1
apt-get install libaio-dev
apt-get install alien
apt-get install ksh
apt-get install sysstat
apt-get install unixodbc-bin
apt-get install unixodbc-dev
apt-get install coreutils
apt-get install libgcc1
apt-get install libgcc1-dbg
apt-get install libmotif-common
apt-get install pcb-lesstif
apt-get install linux-headers-4.9.0-11-all
```

## yum

```shell
yum -y install libaio libaio.i686 libaio-devel libaio-devel.i686
yum -y install libstdc++ libstdc++l7.i686 libstdc++-devel libstdc++-devel.i686 compat-libstdc++-33 compat-libstdc++-33.i686
yum -y install elfutils-libelf-devel
yum -y install gcc gcc-c++ kernel-devel
```

## jdk配置

```shell
export JAVA_HOME=/home/linux_userName/文档/jdk1.8.0_201
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
```

## oracle配置

```shell
export ORACLE_HOME=/home/linux_userName/app/services_name/product/11.2.0/dbhome_1
export ORACLE_SID=services_name
export PATH=$PATH:$HOME/bin:$ORACLE_HOME/bin
```

## 后续操作

```shell
# 启动oracle安装程序
# (/home/linux_userName/app/services_name/product/11.2.0/dbhome_1下的runInstaller文件)
# ./runInstaller -jreLoc /home/linux_userName/文档/jdk1.8.0_201
# 安装过程
# 解压p13390677_112040_Linux-x86-64_1of7.zip和p13390677_112040_Linux-x86-64_2of7.zip
# 把p13390677_112040_Linux-x86-64_2of7/database/stage/Components移动到p13390677_112040_Linux-x86-64_1of7/database/stage/Components下
# 在可视化界面运行即可 ./p13390677_112040_Linux-x86-64_1of7/database/instarunInstaller.sh
# 安装的过程和windows界面安装方式一模一样,如果有报错查看报错日志即可,前面apt-get install 的补丁齐全,几乎不会有很严重的错误
# 安装时会报以下错误
# centos7安装oracle11G Exception String: Error in invoking target 'agent tclexec' of makefile
#/home/linux_userName/db/oracle/product/11.1.0/db_1/sysman/lib/ins_emagent.mk'错误,解决办法
# 查找下面文件
/home/linux_userName/app/services_name/product/11.2.0/dbhome_1/sysman/lib/ins_emagent.mk
# 找到此行加上'-lnnz11'
$(MK_EMAGENT_NMECTL) -lnnz11
# 安装后执行的两个脚本
/home/linux_userName/app/services_name/product/11.2.0/dbhome_1/root.sh
/home/linux_userName/app/oraInventory/orainstRoot.sh
# 监听文件修改
#(后缀数字可能不一样,这不必纠结,从ORACLE_HOME下找到对应的init.ora.复制到…./dbs/init…ora就好了)
/home/linux_userName/app/username/admin/username/pfile/init.ora.021201901251
cp init.ora.382019102739 /home/linux_userName/app/username/product/11.2.0/dbhome_1/dbs/initusername.ora
#要注意,Linux在安装后内外网的连接使用netca配置时,本机的ip需要是具体地址或localhost,而不是127.0.0.1,Linux不支持127.0.0.1
# 安装后常用操作
# 监听器开启
lsnrctl start
# 监听器状态
lsnrctl status
# 数据库开启
sqlplus /nolog
conn /as sysdba
startup
# 数据库关闭
sqlplus /nolog
conn /as sysdba
shutdown immediate
#监听器关闭
lsnrctl stop
#外网连接
Net Configuration Assistant在Linux中使用netca命令执行并打开
可以参考数据库技术之ORACLE表空间的操作,数据库技术之ORACLE用户的操作及其数据库技术之ORACLE数据泵的操作
```
