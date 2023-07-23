#第一种方法
yum groups install "X Window System" ## 安装界面所需的依赖
yum groups install "MATE Desktop" ## 界面安装
第二种方法
yum groups install "X Window System" ## 安装界面所需的依赖
yum grouplist ## 查看支持哪些图形界面
yum groupinstall "GNOME Desktop" "Graphical Administration Tools" ## 如果包含GNOME,则安装GNOME
缺少X11脚本
yum install -y xorg-x11-server-Xorg xorg-x11-xauth xorg-x11-apps

#无论那种方式都要启动模式设置为图形界面,然后重启