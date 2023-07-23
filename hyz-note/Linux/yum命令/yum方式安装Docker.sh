#更新
yum update -y
#卸载
yum remove docker  docker-common docker-selinux docker-engine
#环境
yum install -y yum-utils device-mapper-persistent-data lvm2
yum list docker-ce --showduplicates | sort -r
## 安装  
yum install docker-ce-17.12.0.ce
yum install docker-ce-18.03.1.ce -y
#设置源
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
#开机启动
systemctl start docker
systemctl enable docker
#版本验证
docker version