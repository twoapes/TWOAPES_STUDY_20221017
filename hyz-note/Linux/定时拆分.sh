#catalina.out为例
#以apache-tomcat-6.0.xx为例,xx代表版本
#进入tomcat根目录
cd /home/tomcat
vim tomcat_ele

/home/tomcat/apache-tomcat-6.0.xx/logs/catalina.out

{
    daily
    rotate 30
    missingok
    copytruncate
    create 644 wyz wyz
    notifempty
    dateext
}

#保存退出,并赋权
chmod 644 tomcat_ele
#进入定时任务编辑,编辑内容如下:
crontab -e
59 23 * * * /usr/sbin/logrotate -vf /home/tomcat/tomcat_ele &>/dev/null
#保存退出,查看是否添加成功
crontab -l
#注意:第一段标红的信息根据which logrotate命令确认后调整,第二段标红的信息为tomcat_ele所在的目录
#每天23点59分,会执行定时任务,按照tomcat轮询日志的配置方式,对catalina.out进行拷贝备份(后缀重命名为当天日期)并清空当前日志,历史日志保留30天记录
