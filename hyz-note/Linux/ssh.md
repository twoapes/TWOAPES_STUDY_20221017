# ssh

## 使用java访问ssh

```shell
## /etc/ssh/sshd_config文件
#(openssh版本7.6p1)  /etc/ssh/sshd_config
#添加:
KexAlgorithms +diffie-hellman-group1-sha1
#openssh版本7.9   /etc/ssh/sshd_config
#添加:
KexAlgorithms diffie-hellman-group1-sha1,curve25519-sha256@libssh.org,ecdh-sha2-nistp256,ecdh-sha2-nistp384,ecdh-sha2-nistp521,diffie-hellman-group-exchange-sha256,diffie-hellman-group14-sha1
## 1.6版本jdk如下修改
#修改/etc/ssh/sshd_ _config配置文件,添加jdk1.6支持的加密算法,如下:
Properties config = new Properties();
config.put("StrictHostKeyChecking", "no");
config.put("kex", "diffie-hellman-group1-sha1"); ##新增此行 与/etc/ssh/sshd_config对应
```

## 使用sshd_config

```shell
# 修改配置文件sshd_config
/etc/ssh/sshd_config
# sshd_config内容如下

#...(省略上面)
Port 22 # 22可以修改为任何端口,即可改变ssh的默认端口号
PermitRootLogin no #设置为no即可禁止远程连接root用户,如果需要远程连接设置为yes
#...(省略下面)

service ssh restart ## 重启即可生效
```
