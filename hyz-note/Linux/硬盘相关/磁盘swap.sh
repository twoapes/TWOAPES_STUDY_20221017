开机启动后自动挂载swap方式和第三步的系统自动挂载硬盘方法一致
mkdir /opt/swap ##创建swap文件夹,以/opt/目录为例,可以自定义其他目录
dd if=/dev/zero of=/opt/swap/swapfile bs=1024 count=5242880 ##创建初始化swap的空间大小,本例为5G 要注意:1GB=1024KB
mkswap /opt/swap/swapfile ##转换成swap文件
swapon /opt/swap/swapfile ##挂载
##swapoff /opt/swap/swapfile ##卸载,本例只执行挂载
free -h ##查看分区大小