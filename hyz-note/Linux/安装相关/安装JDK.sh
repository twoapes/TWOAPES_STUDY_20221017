第一步 如果/usr/lib/下没有java目录,则创建一个
cd /usr/lib
mkdir java
cd /usr/lib/java/


第二步 移动jdk-8u241-linux-x64.tar.gz至/usr/lib/java/目录下,然后重命名为jdk1.8.0_241.tar.gz
cd
mv jdk-8u241-linux-x64.tar.gz /usr/lib/java/ #移动到java目录
cd /usr/lib/java/
mv jdk-8u241-linux-x64.tar.gz jdk1.8.0_241.tar.gz # 重命名


第三步 如果没有tar软件,那么先安装
yum install -y tar

第四步 解压
tar -zxvf jdk1.8.0_241.tar.gz

第五步 如果没有vim编辑器,则先安装
yum install -y vim


第六步 编辑器编辑环境变量
vim /etc/profile

# 新增如下内容
export JAVA_HOME=/usr/lib/java/jdk1.8.0_241
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH


第七步 执行source命令,使得当前环境起效
source /etc/profile

第八步 验证java
java
javac
java -version #正常输出版本号,以及上面两个语句不会提示无效命令即可