# tomcat进程管理

```shell
#tomcat的linux查看日志
tail -f catalina.out

#查看进程
ps -ef |grep tomcat
ps -ef |grep java

#杀死进程
kill -9 xxx

#tomcat启动
#第一种启动方式
./tomcat/bin/startup.sh
#第二种启动方式
sh tomcat/bin/startup.sh

#tomcat结束
#第一种结束方式
./tomcat/bin/shutdown.sh
#第二种结束方式
sh tomcat/bin/shutdown.sh

#查看端口
netstat -ano
```
