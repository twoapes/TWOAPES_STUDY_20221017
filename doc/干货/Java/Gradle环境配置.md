# Gradle环境配置

## 源代码地址

```xml
https://github.com/spring-projects/spring-boot
https://github.com/spring-projects/spring-framework.git
```

阿里云仓库

```gradle
//sesstings.gradle 阿里云仓库
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url 'https://maven.aliyun.com/repository/public' }
        maven { url 'https://repo.spring.io/plugins-release' }
    }
}
```

build.gradle阿里云仓库

```gradle
//通过官网 https://maven.aliyun.com/mvn/guide 便知 jcenter和central已合并因此如下配置即可
repositories {
    //maven { url 'https://maven.aliyun.com/nexus/content/groups/public' }
    //maven { url 'https://maven.aliyun.com/nexus/content/repositories/jcenter' }
    mavenCentral()
    maven { url 'https://maven.aliyun.com/repository/public' }
    maven { url "https://repo.spring.io/libs-spring-framework-build" }
}
```

阿里云部分仓库地址

```gradle
maven { url "https://maven.aliyun.com/repository/central" }
maven { url "https://maven.aliyun.com/repository/public" }
maven { url "https://maven.aliyun.com/repository/google" }
maven { url "https://maven.aliyun.com/repository/gradle-plugin" }
maven { url "https://maven.aliyun.com/repository/spring" }
maven { url "https://maven.aliyun.com/repository/spring-plugin" }
maven { url "https://maven.aliyun.com/repository/central" }
//注释部分需要根据实际情况选择版本然后去除注释
//force是否冲突和上面的仓库设置有关
configurations.all {
    resolutionStrategy {
        failOnVersionConflict()
        //force 'net.bytebuddy:byte-buddy:1.10.20'
        //force 'net.bytebuddy:byte-buddy-agent:1.10.20'
        //force 'org.jboss.logging:jboss-logging:3.4.1.Final'
        //force 'org.objenesis:objenesis:3.1'
        //force 'org.springframework:spring-beans:5.3.7-SNAPSHOT'
        //force 'org.springframework:spring-core:5.3.7-SNAPSHOT'
        //force 'org.springframework:spring-tx:5.3.7-SNAPSHOT'
        //force 'com.fasterxml:classmate:1.5.1'
        //force 'org.apache.httpcomponents.core5:httpcore5:5.0.3'
        //force 'org.wildfly.common:wildfly-common:1.5.2.Final'
        //force 'org.jboss.threads:jboss-threads:3.1.0.Final'
        //force 'com.squareup.okio:okio:1.14.0'
        //force 'commons-codec:commons-codec:1.13'
        //force 'org.apache.httpcomponents:httpcore:4.4.13'
        //force 'org.codehaus.woodstox:stax2-api:4.2.1'
        //force 'com.google.guava:guava:12.0'
        //force 'commons-collections:commons-collections:3.2'
        cacheChangingModulesFor 0, "seconds"
        cacheDynamicVersionsFor 0, "seconds"
    }
}

//gradle.properties jvm设置
org.gradle.jvmargs=-Xmx2048M
//kotlin-coroutines.gradle 工具可能要求canBeResolved设置而true

configurations {
    classesOnlyElements {
        canBeConsumed = true
        canBeResolved = true
    }
}
```

pom.xml

```xml
<properties>
    <!-- 解决文件拷贝时的编码 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <!-- 解决编译时中文乱码-->
    <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
    <java.version>11</java.version>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

## 使用gradle

```shell
spring-boot\gradle\wrapper
spring-framework\gradle\wrapper
项目目录下都含有 gradle-wrapper.properties 文件
linux下建议使用本地文件 即 distributionUrl=dists/gradle-6.8.3-all.zip
windows下可以使用网址 即 distributionUrl=https\://services.gradle.org/distributions/gradle-6.8.3-bin.zip
wget https://downloads.gradle-dn.com/distributions/gradle-6.8.3-all.zip
也可以wget后使用 distributionUrl=http\://services.gradle.org/distributions/gradle-6.8.3-all.zip
项目目录下也都有.settings目录含有 org.eclipse.buildship.core.prefs 文件
需要设置jdk安装的目录,我们以linux安装到 /usr/lib/jvm/java-11-openjdk-amd64 为例
java.home=/usr/lib/jvm/java-11-openjdk-amd64
```
