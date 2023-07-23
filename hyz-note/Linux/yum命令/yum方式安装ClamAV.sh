#适用于Centos7
#下载安装
yum install epel-release
#验证安装
yum repolist
 #验证结果含有以下字样代表成功
epel/x86_64 Extra Packages for Enterprise Linux 7 - x86_64
#安装ClamAV
yum install clamav-server clamav-data clamav-update clamav-filesystem clamav clamav-scanner-systemd clamav-devel clamav-lib clamav-server-systemd -y
#在两个配置文件/etc/freshclam.conf和/etc/clamd.d/scan.conf中移除"Example"字符
sed -i -e "s/^Example/#Example/" /etc/freshclam.conf
sed -i -e "s/^Example/#Example/" /etc/clamd.d/scan.conf
#更新病毒库(本质执行文件:/etc/cron.d/clamav-update)
freshclam
#开启病毒库自动更新
/etc/sysconfig/freshclam
## This option accepts two special values:
## 'disabled-warn' ... disables the automatic freshclam update and
## gives out a warning
## 'disabled' ... disables the automatic freshclam silently
# FRESHCLAM_DELAY=
### !!!!! REMOVE ME !!!!!!
### REMOVE ME: By default, the freshclam update is disabled to avoid
### REMOVE ME: network access without prior activation
FRESHCLAM_DELAY=disabled-warn #删除此行
#将文件/etc/clam.d/scan.conf中的这一行前面的注释符号去掉
#LocalSocket /var/run/clamd.scan/clamd.sock
#配置开机启动
systemctl enable clamd@scan
ln -s '/usr/lib/systemd/system/clamd@scan.service' '/etc/systemd/system/multi-user.target.wants/clamd@scan.service'
#启动并检查服务状态
systemctl start clamd@scan
systemctl status clamd@scan
#如果在手动更新病毒库的时候遇到错误
#Update failed. Your network may be down or none of the mirrors listed in freshclam.conf is working.
#此时就要删除掉旧的镜像地址文件
rm -f /var/lib/clamav/mirrors.dat
#然后更新病毒库
freshclam
# 查杀毒
clamscan -r -i /usr  --remove  -l /var/log/clamscan.log #查询/usr下所有的文件,有危险就直接清除
## # 查杀结果说明 SCAN SUMMARY -----------
Known viruses: 8901458  #病毒库中包含的病毒种类数
Engine version: 0.102.4 #引擎版本
Scanned directories: 2529 #扫描目录数
Scanned files: 5733  #扫描文件数
Infected files: 2   #被感染文件数
Data scanned: 18538.88 MB #总的扫描字节数
Data read: 5426157.04 MB (ratio 0.00:1)
Time: 1331.954 sec (22 m 11 s) #花费的总时间


clamscan -r -i /usr  --remove  -l /var/log/clamscan.log #杀毒
