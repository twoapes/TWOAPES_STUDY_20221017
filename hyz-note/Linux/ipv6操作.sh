##/etc/sysctl.conf 文件添加
net.ipv6.conf.all.disable_ipv6 = 1;
net.ipv6.conf.default.disable_ipv6 = 1;
sysctl -p;
#或执行以下命令
sysctl -w net.ipv6.conf.all.disable_ipv6=1;
sysctl -w net.ipv6.conf.default.disable_ipv6=1;
# 添加下面两行内容到/etc/modprobe.conf
alias net-pf-10 off;
alias ipv6 off;