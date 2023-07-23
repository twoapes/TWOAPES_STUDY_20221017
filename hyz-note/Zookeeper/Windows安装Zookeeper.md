# Windows安装Zookeeper

第一步：
[zookeeper下载地址](https://archive.apache.org/dist/zookeeper/),我下载的是3.4.6,大家最好不要下载3.5.x的版本,那是内测的,其它的版本大家随意！

(1)：下载完成后直接解压到你想要的目录

(2)：接下大家需要更改目录 conf 里的一个配置文件zoo_sample.cfg 将其重命名为zoo.cfg,因为,启动zooKeeper时会加载改配置文件,但是加载的是conf/zoo.cfg,所以zoo_sample.cfg是官方给的一个示例配置文件自己需要更改！(当然大家如果担心会出问题,可备份),

(3)：前面说过,zookeeper会加载conf/zoo.cfg,所以我们需要打开该文件,配置我们需要的内容！我这里就说几个重点的,其它无关紧要的我就不说了：

|参数|说明|
|--|--|
dataDir=/tmp/zookeeper|dataDir表示zookpeeper保存数据的位置,所以我改为 dataDir=../data  表示在和conf同级的目录下的data文件夹里面！
clientPort=2181|clientPort表示连接zooKeeper的端口号,这里我使用默认的端口号！

(4)：接下来就可以启动zooKeeper了,进入zooKeeperde 安装目录下的bin目录下启动zkServer.cmd出现如下界面

(5)：为了方便大家测试,zookeeper也给了大家一个一个客户端测试,任然还在zooKeeperde 安装目录下的bin目录下启动

(6)：zookeeper安装完成！
