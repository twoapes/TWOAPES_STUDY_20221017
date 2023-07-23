# 软件包

## 编辑/etc/apt/sources.list文件, 在文件最前面添加以下条目(操作前请做好相应备份)
## 163 (国内使用,例如阿里云,腾讯云等)
deb http://mirrors.163.com/debian/ jessie main non-free contrib
deb http://mirrors.163.com/debian/ jessie-updates main non-free contrib
deb http://mirrors.163.com/debian/ jessie-backports main non-free contrib
deb-src http://mirrors.163.com/debian/ jessie main non-free contrib
deb-src http://mirrors.163.com/debian/ jessie-updates main non-free contrib
deb-src http://mirrors.163.com/debian/ jessie-backports main non-free contrib
deb http://mirrors.163.com/debian-security/ jessie/updates main non-free contrib
deb-src http://mirrors.163.com/debian-security/ jessie/updates main non-free contrib
# 其他源参考
## 修改成清华源:
deb https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch main non-free contrib
deb https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch-updates main non-free contrib
deb https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch-backports main non-free contrib
deb-src https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch main non-free contrib
deb-src https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch-updates main non-free contrib
deb-src https://mirrors.tuna.tsinghua.edu.cn/debian/ stretch-backports main non-free contrib
deb https://mirrors.tuna.tsinghua.edu.cn/debian-security/ stretch/updates main non-free contrib
deb-src https://mirrors.tuna.tsinghua.edu.cn/debian-security/ stretch/updates main non-free contrib
## 修改成科大源:
deb http://mirrors.ustc.edu.cn/debian/ stretch main non-free contrib
deb http://mirrors.ustc.edu.cn/debian/ stretch-updates main non-free contrib
deb http://mirrors.ustc.edu.cn/debian/ stretch-backports main non-free contrib
deb-src http://mirrors.ustc.edu.cn/debian/ stretch main non-free contrib
deb-src http://mirrors.ustc.edu.cn/debian/ stretch-updates main non-free contrib
deb-src http://mirrors.ustc.edu.cn/debian/ stretch-backports main non-free contrib
deb http://mirrors.ustc.edu.cn/debian-security/ stretch/updates main non-free contrib
deb-src http://mirrors.ustc.edu.cn/debian-security/ stretch/updates main non-free contrib
## 修改成华为源(华为云推荐使用):
deb https://mirrors.huaweicloud.com/debian/ buster main non-free contrib
deb-src https://mirrors.huaweicloud.com/debian/ buster main non-free contrib
deb https://mirrors.huaweicloud.com/debian/ buster-updates main non-free contrib
deb-src https://mirrors.huaweicloud.com/debian/ buster-updates main non-free contrib
deb https://mirrors.huaweicloud.com/debian/ buster-proposed-updates main non-free contrib
deb-src https://mirrors.huaweicloud.com/debian/ buster-proposed-updates main non-free contrib
deb https://mirrors.huaweicloud.com/debian/ buster-backports main non-free contrib
deb-src https://mirrors.huaweicloud.com/debian/ buster-backports main non-free contrib
deb https://mirrors.huaweicloud.com/debian-security buster/updates main non-free contrib
deb-src https://mirrors.huaweicloud.com/debian-security buster/updates main non-free contrib
