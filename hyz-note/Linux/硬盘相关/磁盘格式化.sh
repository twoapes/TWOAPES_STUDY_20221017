#例如需要格式化 /dev/sdb
#还是需要提示下,格式化操作存在很大的风险,执行成功后必定会丢失硬盘所有的数据,包括你收藏的
#小电影啊,小视频啊,音乐啊等等哦,请一定要格式化之前备份
#执行前备份!!!
#执行前备份!!!
#执行前备份!!!
root@twoapes:~# mkfs ##输入mkfs命令后按下两次tab自动显示当前系统支持的硬盘模式
mkfs         mkfs.bfs     mkfs.cramfs  mkfs.exfat   mkfs.ext2    mkfs.ext3    mkfs.ext4    mkfs.fat     mkfs.minix   mkfs.msdos   mkfs.ntfs    mkfs.vfat
例如需要使用mkfs.ext4方式进行格式化,挂载到 /mnt/test目录下
root@twoapes:~# mkdir /mnt/test ##如果此目录还不存在,则创建目录
root@twoapes:~# mkfs.ext4 /dev/sdb
...(执行后会提示是否执行,输入y即可,不分大小写,看到"done"即表示正常的格式化成功)
root@twoapes:~# mount -t ext4 /dev/sdb /mnt/test ##执行挂载命令,没有报错即可