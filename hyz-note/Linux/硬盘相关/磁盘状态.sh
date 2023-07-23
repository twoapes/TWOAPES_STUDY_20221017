root@twoapes:~# fdisk -l
假设/dev/sdb当前现状是没有挂载,但是已经被系统检测到,因此可以对它格式化或挂载操作,也可以同时进行格式化和挂载操作
Disk /dev/sda: 238.5 GiB, 256060514304 bytes, 500118192 sectors
Disk model: INTEL SSDSC2KW25
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disklabel type: dos
Disk identifier: 0x4e1a640a
Device     Boot  Start       End   Sectors   Size Id Type
/dev/sda1  *      2048    499711    497664   243M 83 Linux
/dev/sda2       501758 500117503 499615746 238.2G  5 Extended
/dev/sda5       501760 500117503 499615744 238.2G 8e Linux LVM
Disk /dev/sdb: 119.2 GiB, 128035676160 bytes, 250069680 sectors
Disk model: KINGSTON RBUSMS1
Units: sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
...(后面的显示省略)