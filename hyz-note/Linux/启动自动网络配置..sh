进入到网卡目录,cd /etc/sysconfig/network-scripts/
找到网卡配置文件,本机是ifcfg-ens33
设置ONBOOT=yes,保存即可.
例如下面的内容:

[twoapes@localhost network-scripts]$ cat ifcfg-ens33
TYPE="Ethernet"
PROXY_METHOD="none"
BROWSER_ONLY="no"
BOOTPROTO="dhcp"
DEFROUTE="yes"
IPV4_FAILURE_FATAL="no"
IPV6INIT="yes"
IPV6_AUTOCONF="yes"
IPV6_DEFROUTE="yes"
IPV6_FAILURE_FATAL="no"
IPV6_ADDR_GEN_MODE="stable-privacy"
NAME="ens33"
UUID="597878f4-c7d8-4801-b6cc-add7b236b739"
DEVICE="ens33"
ONBOOT="yes" #no改成yes
[twoapes@localhost network-scripts]$