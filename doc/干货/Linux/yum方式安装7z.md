# yum方式安装7z

```shell

#先安装wget
yum -y install wget

#下载7z的压缩包
wget https://sourceforge.net/projects/p7zip/files/p7zip/16.02/p7zip_16.02_src_all.tar.bz2

#安装bzip
yum install -y bzip2

#解压压缩包
tar -jxvf p7zip_16.02_src_all.tar.bz2

#进入解压的压缩包目录
cd p7zip_16.02

#安装gcc和gcc+
yum install gcc
yum install gcc-c++

#执行编译安装
make
make install

#安装成功后输出信息
./install.sh /usr/local/bin /usr/local/lib/p7zip /usr/local/man /usr/local/share/doc/p7zip
- installing /usr/local/bin/7za
- installing /usr/local/man/man1/7z.1
- installing /usr/local/man/man1/7za.1
- installing /usr/local/man/man1/7zr.1
- installing /usr/local/share/doc/p7zip/README
- installing /usr/local/share/doc/p7zip/ChangeLog
- installing HTML help in /usr/local/share/doc/p7zip/DOC

#解压7z文件的命令
7za x ***.7z
```
