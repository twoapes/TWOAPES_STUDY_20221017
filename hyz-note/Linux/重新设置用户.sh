vim /etc/passwd # 修改用户名 和 用户根目录
#找到要修改用户的配置行,将这行出现的centos 全部改为 ***(根据自己实际情况改变)
vim /etc/shadow # 做法同上
vim /etc/group # 修改用户组,将用户组名改为新用户名,操作类似上步.
mv /home/centos /home/*** # 最后,修改用户根目录名

#设置默认用户登入
vim /etc/gdm/custom.conf

AutomaticLoginEnable=True
AutomaticLogin=root