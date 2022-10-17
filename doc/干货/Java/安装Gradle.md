# 安装Gradle

```shell
wget https://downloads.gradle-dn.com/distributions/gradle-6.8.3-bin.zip
解压gradle-6.8.3-bin.zip,移动到 /usr/lib/jvm/gradle-6.8.3
1.在目录/etc/profile.d下,创建gradle.sh
export GRADLE_HOME=/usr/lib/jvm/gradle-6.8.3
export PATH=${GRADLE_HOME}/bin:${PATH}
2.chmod +x /etc/profile.d/gradle.sh
3.source /etc/profile.d/gradle.sh
4.gradle -v #验证gradle
```
