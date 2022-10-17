# Windows安装gradle

```shell
#例如gradle-6.8.3-bin.zip解压到 C:\Program Files\gradle-6.8.3-bin\gradle-6.8.3
#设置变量名 GRADLE_USER_HOME
#设置变量值 C:\Program Files\gradle-6.8.3-bin\gradle-6.8.3
#path下配置变量值 %GRADLE_USER_HOME%\bin\ 即可
#windows下运行 spring-framework主目录下的 gradlew.bat


./gradlew build -–stacktrace
./gradlew :spring-oxm:compileTestJava
./gradlew build
./gradle build --offline

Starting a Gradle Daemon (subsequent builds will be faster)
> Task :help
Welcome to Gradle 6.8.3.
To run a build, run gradlew <task> ...
To see a list of available tasks, run gradlew tasks
To see a list of command-line options, run gradlew --help
To see more detail about a task, run gradlew help --task <task>
For troubleshooting, visit https://help.gradle.org
Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.8.3/userguide/command_line_interface.html#sec:command_line_warnings
BUILD SUCCESSFUL in 47s
1 actionable task: 1 executed
A build scan was not published as you have not authenticated with server 'ge.spring.io'.
请按任意键继续. . .
```
