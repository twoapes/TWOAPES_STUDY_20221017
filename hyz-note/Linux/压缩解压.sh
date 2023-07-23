文件或目录的压缩(会减少体积)或打包(不会减少体积) 不同类型的解压方式

## 安装插件的方式

```shell
apt-get install p7zip
7z x xx.7z ##解压命令 7z x
```


## 无需插件方式

```shell
#源文件:代表文件或目录
#目录:指定目录
zip -r  源文件  directory ## zip格式压缩
unzip *.zip ## zip格式解压
gzip 源文件 ## gz格式压缩(不保留源文件)
gzip -c 源文件 ## gz格式压缩(保留源文件)
gzip -r 目录 ## gz格式压缩(压缩目录下所有的子文件,不包括目录)
gzpi -d *.gz ## gz格式解压
gunzip  *.gz ## gz格式解压
bzip2  源文件 ## bz格式压缩(不保留源文件)
bzip2 -k 源文件 ## bz格式压缩(保留源文件)
bunzip2 -d *.bz ## bz格式解压(不保留压缩文件)
bunzip2  -k  *.bz  ## bz格式解压(保留压缩文件)
tar -cvf *.tar 源文件 ## tar格式打包
tar -xvf *.tar ## tar格式解打包
-c:打包
-v:显示过程
-f:指定打包后的文件名
-x:解打包
.tar.gz压缩格式  其实.tar.gz是先打包*.tar格式,在压缩为*.gz格式
tar –xzf *.tar.gz ##tar.gz格式解压
tar –xzf *.tgz ##tgz格式解压
.tar.bz2压缩格式  其实.tar.bz2是先打包*.tar格式,在压缩为*.bz2格式
tar –xjf *.tar.bz2 ##tar.bz2格式解压
unzip -O CP936 xxx.zip ##zip防止乱码,注意O,CP都是大写
```


在Linux系统中,压缩解压命令是非常重要的命令,用于将文件或目录压缩成一个压缩文件或者将压缩文件解压缩回原始格式。

1.gzip命令

gzip命令常用于压缩单个文件,其语法如下:

```shell
gzip [选项] 文件名
```


选项:-d:用于解压缩；-v:显示压缩/解压缩的详细信息；-c:将压缩数据输出到标准输出。

例如,将文件test.txt压缩成test.txt.gz文件:

```shell
gzip test.txt
```


2.tar命令

tar命令是Linux系统中最常用的压缩命令,它可以将多个文件或目录压缩成一个文件,并且支持不同的压缩格式。其基本语法如下:

```shell
tar [选项] 文件名
```


选项:-c:压缩文件；-x:解压缩文件；-v:显示详细信息；-f:指定文件名。

例如,将目录test中所有文件和子目录都压缩成test.tar文件:

```shell
tar -cvf test.tar test
```


3.bzip2命令

bzip2命令是在gzip命令基础上发展而来的一种压缩命令,其压缩比比gzip命令更高。其基本语法如下:

```shell
bzip2 [选项] 文件名
```


选项:-d:解压缩；-v:显示详细信息。

例如,将文件test.txt压缩成test.txt.bz2文件:

```shell
bzip2 test.txt
```


4.zip和unzip命令

zip和unzip命令是在Windows系统中广泛使用的压缩命令,但在Linux系统中同样可以使用。zip命令用于将多个文件或目录压缩成一个zip格式的文件,而unzip命令则用于解压缩zip格式的文件。其基本语法如下:

```shell
zip [选项] 文件名
unzip [选项] 文件名
```


选项:-r:递归地压缩/解压缩子目录中的所有文件。

例如,将目录test压缩成test.zip文件:

```shell
zip -r test.zip test
```


5.rar和unrar命令

rar和unrar命令是在压缩比和压缩速度方面比其他压缩命令更优秀的一种压缩命令,但需要安装rar软件包。其基本语法如下:

```shell
rar [选项] 文件名
unrar [选项] 文件名
```


选项:-e:解压缩；-r:递归地压缩/解压缩子目录中的所有文件。

例如,将目录test压缩成test.rar文件:

```shell
rar -r test.rar test
```


以上就是Linux常用的压缩解压命令的详细说明,通过这些命令可以轻松地进行文件的压缩和解压缩。对于使用Linux系统的用户来说,熟练掌握这些命令非常重要。

