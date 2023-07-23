apt-get install gnome -y #apt-get方式安装
systemctl set-default graphical.target #设置成图形模式
vim /etc/gdm3/daemon.conf #在 security 下面添加 AllowRoot=true
vim /etc/pam.d/gdm-password #注释掉这一行 #auth required pam_succeed_if.so user != root quiet_success
reboot