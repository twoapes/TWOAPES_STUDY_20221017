#同步时间
ntpdate cn.pool.ntp.org

#date +"%Y-%m-%d %H:%M:%S"

#日期格式字符串列表
%H 小时,24小时制(00~23)
%I 小时,12小时制(01-~12)
%k 小时,24小时制(0~23)
%l 小时,12小时制(1~12)
%M 分钟(00~59)
%p 显示出AM或PM
%r 显示时间,12小时制(hh:mm:ss %p)
%s 从1978年1月1日00 :00:00到目前经历的秒数
%S 显示秒(00~59)
%T 显示时间,24小时制(hh:mm:ss)
%X 显示时间的格式(%H :%M:%S)
%Z 显示时区,日期域(CST)
%a 星期的简称(Sun~Sat)
%A 星期的全称(Sunday~Saturday)
%h,%b 月的简称(Jan~Dec)
%B 月的全称(January~December)
%C 日期和时间(Tue NOV 20 14:12:58 2012)
%d 一个月的第几天(01~31)
%x,%D 日期( mm/dd/yy)
%j 一年的第几天(001~366)
%m 月份(01-12)
%w 一个星期的第几天(0代表星期天)
%W 一年的第几个星期(00-53,星期为第一天)
%y 年的最后两个数字( 1999则是99)
时间同步
ntpdate cn.pool.ntp.org
阿里云linux系统下载链接
ntpdate cn.pool.ntp.org
阿里云
Centos7修改用户名
以root身份登录终端；
找到要修改用户的配置行,将这行出现的centos 全部改为 ***(根据自己实际情况改变)
vim /etc/passwd ##修改用户名 和 用户根目录
vim /etc/shadow ##做法同上
vim /etc/group ##修改用户组,将用户组名改为***,操作类似上步.
mv /home/centos /home/*** ##最后,修改用户根目录名