#下载并且安装
yum -y install subversion
#建立svn库
mkdir -p /data/svn
svnadmin create /data/svn/codelover
#配置
/data/svn/codelovers/conf
##passwd文件
twoapes=123
##authz
[/]
twoapes = rw
##svnserve.config
[general]
anon-access = none #不允许匿名用户访问  如果设置read就是只读
auth-access = write #验证通过允许读写
password-db = passwd #密码配置文件
authz-db = authz #权限配置文件
realm = TWOAPES #仓库名称
##启动
svnserve -dr /data/svn/codelovers --listen-port 8088

##开机启动
vim /etc/sysconfig/svnserve

###输入如下信息
OPTIONS="-dr /data/svn/codelovers --listen-port 8088"
##开启服务
systemctl enable svnserve.service
##重启电脑后查看进程
#reboot  #重启命令,需要注意!!!!,为防止不小心复制,特此注释掉
ps -ef|grep svn