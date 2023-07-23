apt-get install lsof;
lsof -i; #查看当前所有端口
lsof -i:***; #查看当前***指定的端口

在Linux中,端口是用来进行网络通信的虚拟地址。每个进程都可以打开一个或多个端口,以便与网络上的其他进程进行通信。端口号是一个16位数字,范围从0到65535。Linux提供了一些命令和工具,可以用来管理和监控端口。

以下是一些常见的端口操作命令和工具:

1. netstat

netstat是一种非常方便的工具,可以用来查看系统中所有打开的端口、网络连接、进程和路由信息。

使用netstat时,可以使用以下选项:

-a 显示所有连接和侦听端口。
-t 显示所有TCP连接。
-u 显示所有UDP连接。
-l 显示所有当前侦听的端口。
-p 显示每个连接或进程的相关信息。
-n 不使用主机名或服务名称进行转换。

例如:

netstat -a 显示所有打开的端口和侦听端口。

netstat -t 显示所有TCP连接。

netstat -l 显示所有当前侦听的端口。

2.lsof

lsof是一个可以列出系统中所有打开文件和网络连接的工具。这个工具可以用来查看进程使用的文件,以及它们打开的端口。

例如:

lsof -i :80 显示所有正在使用80端口的进程。

lsof -i TCP:80 显示所有使用TCP协议的80端口的进程。

3.ss

ss是一个用于查看Linux系统上当前活动的套接字的工具。它提供更多的信息比netstat和lsof。

例如:

ss -t 显示所有TCP连接。

ss -u 显示所有UDP连接。

4.iptables

iptables是一个用于管理Linux系统中IP数据包过滤器和防火墙的工具。

例如:

iptables -L 显示系统中的所有IP过滤器规则。

iptables -F 清除系统中的所有IP过滤器规则。

iptables -I INPUT -p tcp --dport 22 -j ACCEPT 允许从外部网络连接到22号端口的TCP连接。

5.nc

nc是一个可以在bash脚本中运行的简单的网络工具,它可以在两个网络节点之间进行数据传输。

例如:

nc -l 8080 在本地侦听8080端口。

nc 127.0.0.1 8080 从本地连接到127.0.0.1的8080端口。

以上是一些常见的端口操作命令和工具,用于管理和监控Linux系统中打开的端口。可以通过查看官方文档详细了解每个命令和工具的用法和选项,以便更好地使用它们。

