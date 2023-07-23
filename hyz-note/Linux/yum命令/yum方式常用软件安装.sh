yum -y  install libaio libaio.i686 libaio-devel libaio-devel.i686
yum -y  install libstdc++ libstdc++l7.i686 libstdc++-devel libstdc++-devel.i686 compat-libstdc++-33 compat-libstdc++-33.i686
yum -y  install elfutils-libelf-devel
yum -y  install gcc gcc-c++ kernel-devel
#安装 X11 Forwarding 相关软件
yum install xorg-x11-xauth xorg-x11-fonts-* xorg-x11-font-utils xorg-x11-fonts-Type1 xclock