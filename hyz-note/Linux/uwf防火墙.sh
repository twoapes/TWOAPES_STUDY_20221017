#debian系统
ufw status;
ufw disable;
#ufw不是系统的软件.可以随时卸载
apt-get autoremove ufw;
apt-get purge ufw
#iptables只可停用,不能卸载,为了系统正常运行禁止卸载,所以不收纳卸载的命令
chkconfig iptables off;