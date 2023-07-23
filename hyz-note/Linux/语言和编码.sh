apt-get install locales ## 安装必备的语言包,以便使用locale-gen命令随时安装
vim /etc/locale.gen ## 系统语言包,也可以使用命令 dpkg-reconfigure locales
vim /etc/default/locale ## 系统编码文件
## 更改默认系统编码
LANG="en_US.UTF-8"
LANGUAGE="en_US:en"
## 最后一步,安装设置好的语言
locale-gen en_US.UTF-8
## 检查语言设置项是否有报错
locale ##如果执行后有报错,一般是上面安装包没有安装,使用命令locale-gen安装即可