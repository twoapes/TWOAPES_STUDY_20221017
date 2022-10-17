# Resource strings

Prefix|Example|Explanation
--|--|--
classpath&#58;|classpath&#58;com&#47;myapp&#47;config.xml|Loaded from the classpath.
file&#58;|file&#58;&#47;&#47;&#47;data&#47;config.xml|Loaded as a URL from the filesystem. See also FileSystemResource Caveats.
https&#58;|https &#58;&#47;&#47;myserver&#47;logo.png|Loaded as a URL.
(none)|&#47;data&#47;config.xml|Depends on the underlying ApplicationContext.
