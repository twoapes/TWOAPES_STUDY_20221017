# Centos安装Redis

```shell
1.去官网下载redis到服务器上,https://redis.io/
2.解压-编译和安装
#解压
tar -zxf redis-7.0.2.tar.gz
#编译
make
#安装
make install PREFIX=/usr/lib/redis-7.0.10 #不填默认到/usr/local/bin
#环境变量
REDIS_HOME=/usr/lib/redis-7.0.10
PATH=$PATH:$REDIS_HOME/bin

source /etc/prfoile
#启动
redis-server /usr/lib/redis-7.0.10/redis.conf
#停止
redis-cli shutdown

#测试
redis-cli
set name potato
get name
#设开机置自启
cd /usr/lib/systemd/system
vim redis.service

[Unit]
Description=redis-server
After=network.target

[Service]
Type=forking

ExecStart=/usr/lib/redis-7.0.10/bin/redis-server /usr/lib/redis-7.0.10/redis.conf
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

## redis.conf

```txt
#设置后台启动,如果不是后台启动,每次推出redis就关闭了
daemonize yes
#开启密码保护,注释则不需要密码
requirepass 密码
#设置端口号
port 端口号
#允许访问的ip,改为0.0.0.0就是所有ip均可
bind 127.0.0.1 -::1
bind 0.0.0.0
```

## 服务控制

```txt
#重载系统服务
systemctl daemon-reload
#设置开机自启
systemctl enable redis.service
#取消开机自启
systemctl disable redis.service
#启动服务
systemctl start redis.service
#停止服务
systemctl stop redis.service
#查看服务状态
systemctl status redis.service
```
