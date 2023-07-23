#1,使用passwd命令锁定与解锁账号
$ passwd -l 用户名 ## 锁定
$ passwd -S 用户名 ## 查看状态
$ passwd -u 用户名 ## 解锁
#2,使用usermod命令锁定与解锁账号
$ usermod -L 用户名 ## 锁定
$ passwd -S 用户名 ## 查看状态
$ usermod -U 用户名 ## 解锁
#CentOS 7 休眠系统
$ systemctl suspend ## 待机
$ systemctl poweroff ## 关机(退出系统并停止电源)
$ systemctl reboot ## 重启
$ systemctl hibernate ## 休眠
$ systemctl hybrid-sleep ## 混合休眠模式(同时休眠到硬盘并待机)