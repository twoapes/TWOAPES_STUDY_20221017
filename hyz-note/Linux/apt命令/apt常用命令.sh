apt-cache search xxx ## 搜索包
apt-get install xxx ## 安装包
dpkg -s xxx ## 检查包
apt-get update ## 更新软件源索引
apt-get upgrade xxx ## 将软件升级到最新版本
apt-get remove xxx ## 卸载软件(删除软件包)
apt-get --reinstall install xxx ##重新安装软件
apt list --installed ##已安装的包
## 以下两个命令不建议使用,但需要知道,一般用于清理冲突软件,尽可能选择更新方式重新安装冲突软件
## apt-get autoremove xxx ## 自动卸载软件但保留其配置文件,卸载操作必须谨慎,如果软件冲突尽量选择更新,而不是卸载,不然会把相关的软件都一起卸载
## apt-get autoremove --purge xxx ##自动卸载软件其删除其配置文件,卸载操作必须谨慎,如果软件冲突尽量选择更新,而不是卸载,不然会把相关的软件都一起卸载