#完成上诉操作后,重启电脑,系统并不会自动挂载 /dev/sdb ,那么可以通过如下方式添加系统启动时自动挂载
#从如下可以看出来,/dev/sda1 系列挂载了一系列分区
root@twoapes:~# cat /etc/fstab
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
/dev/mapper/twoapes--vg-root /               ext4    errors=remount-ro 0       1
# /boot was on /dev/sda1 during installation
UUID=9850cae0-9a37-4bef-b919-2793d5d78fda /boot           ext2    defaults        0       2
/dev/mapper/twoapes--vg-home /home           ext4    defaults        0       2
/dev/mapper/twoapes--vg-tmp /tmp            ext4    defaults        0       2
/dev/mapper/twoapes--vg-var /var            ext4    defaults        0       2
/dev/mapper/twoapes--vg-swap_1 none            swap    sw              0       0
#新增分区,把/dev/sdb加入到系统自动挂载列,默认启动级别2就可以了
#末尾的启动级别没有必要特意去修改,但如果下更改可以按照:
#1必须是系统,2是硬盘,3是u盘等,方式进行级别自定义
#启动级别只要1是系统盘,其他的级别设置不会影响开机启动 但如果配置错误,无关字符等会造成电脑重启后无法开机,只能在主机上输入root用户的密码再次修改此文件至正确格式才能正常启动系统,每次配置完都必须重启电脑,所以配置错误并不会导致系统瘫痪,不必恐慌,只是不能远程操作罢了
/dev/sbd /mnt/test ext4 defaults 0 2 ##新增
root@twoapes:~# vi /etc/fstab
# /etc/fstab: static file system information.
#
# Use 'blkid' to print the universally unique identifier for a
# device; this may be used with UUID= as a more robust way to name devices
# that works even if disks are added and removed. See fstab(5).
#
# <file system> <mount point>   <type>  <options>       <dump>  <pass>
/dev/mapper/twoapes--vg-root /               ext4    errors=remount-ro 0       1
# /boot was on /dev/sda1 during installation
UUID=9850cae0-9a37-4bef-b919-2793d5d78fda /boot           ext2    defaults        0       2
/dev/mapper/twoapes--vg-home /home           ext4    defaults        0       2
/dev/mapper/twoapes--vg-tmp /tmp            ext4    defaults        0       2
/dev/mapper/twoapes--vg-var /var            ext4    defaults        0       2
/dev/mapper/twoapes--vg-swap_1 none            swap    sw              0       0
/dev/sbd  /mnt/test           ext4    defaults        0       2
root@twoapes:~# reboot 执行完毕后需要重启电脑
重启后检查电脑是否正常挂载/mnt/test
root@twoapes:~# ls /mnt/test
lost+found   ##展示系统文件或目录,切勿删除,没有报错即表示已经成功挂载
root@twoapes:~#