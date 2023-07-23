# Centos8安装MySQL

查看linux版本后确定下载需要的对应mysql

![https://secure2.wostatic.cn/static/sno77TevLpic3j2EfQrvvb/image.png?auth_key=1684854826-7U3JpBXSneZY6Ts4nYj3vN-0-f4e13f4a1693ff2c7a2253b082a59c82](https://secure2.wostatic.cn/static/sno77TevLpic3j2EfQrvvb/image.png?auth_key=1684854826-7U3JpBXSneZY6Ts4nYj3vN-0-f4e13f4a1693ff2c7a2253b082a59c82)

![https://secure2.wostatic.cn/static/mqr2L3x6QCphSjSJhkjQVj/image.png?auth_key=1684854826-3j4fEFQ5MtTjeRbaFFNPBQ-0-d59f98a2f8da27510b16e70a010f35d2](https://secure2.wostatic.cn/static/mqr2L3x6QCphSjSJhkjQVj/image.png?auth_key=1684854826-3j4fEFQ5MtTjeRbaFFNPBQ-0-d59f98a2f8da27510b16e70a010f35d2)

```xml
wget https://repo.mysql.com//mysql80-community-release-el8-5.noarch.rpm
```

```shell
#安装MySQL Yum Repository
yum install mysql80-community-release-el8-5.noarch.rpm
#检查是否安装成功
yum repolist enabled | grep "mysql.*-community.*"
#禁用系统默认MySQL模块
yum module disable mysql
#开始安装MySQL
yum install mysql-community-server
#启动mysql
systemctl start mysqld
#查看状态
systemctl status mysqld
#设置开机启动
systemctl enable mysqld
#获取管理员密码
grep 'temporary password' /var/log/mysqld.log
2023-04-16T13:41:38.897855Z 6 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: Utljy--lp4!Z
#修改密码
mysql -uroot -p
ALTER USER 'root'@'localhost' IDENTIFIED WITH MYSQL_NATIVE_PASSWORD BY 'QQqq1234.';

#将host改为’%',代表任意的IP地址都可以连接访问
select host,user from mysql.user;

update mysql.user set host = '%' where user = 'root';
flush privileges;
#关闭防火墙
systemctl stop firewalld

#/etc/my.cnf文件
vim /etc/my.cnf
[mysqld]
port=端口号
lower-case-table-names=1 #表名不区分大小写

#创建用户
create user 'twoapes'@'%' identified by 'QQqq1234.';
flush privileges;
#给用户授权
## 这里的all privileges 可换成select,insert,update,delete,drop,create等
grant all privileges on *.* to twoapes@"%" with grant option; 
```
