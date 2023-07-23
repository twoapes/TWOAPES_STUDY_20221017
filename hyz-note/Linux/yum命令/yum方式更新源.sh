# 首先备份/etc/yum.repos.d/CentOS-Base.repo
mv /etc/yum.repos.d/CentOS-Base.repo /etc/yum.repos.d/CentOS-Base.repo.backup
# 进入yum源配置文件所在文件夹
cd /etc/yum.repos.d/
# 阿里云为例
centos5:
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-5.repo
centos6:
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-6.repo
centos7:
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo
centos8:
wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-8.repo

cd /etc/yum.repos.d/
sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
# 运行yum makecache生成缓存
yum makecache
# 更新系统
yum -y update
# 安装谷歌浏览器
yum install https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
# 查看安装位置
rpm -qal google-chrome-stable
rpm -qal |grep  google-chrome-stable

#安装谷歌后如果有出现yum不可用,可以如下方式解决
rm -rf /etc/yum.repos.d/google-chrome.repo
yum clean all