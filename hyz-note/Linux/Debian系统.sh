apt-get install debian-policy  ##Debian政策手册 pdf文件路径 /usr/share/doc/debian-policy/policy.pdf.gz
apt-get install developers-reference ##Debian开发人员参考 pdf文件路径 /usr/share/doc/developers-reference/developers-reference.pdf
apt-get install debmake-doc ##Debian维护者指南 pdf中文版路径  /usr/share/doc/debmake-doc/debmake-doc.zh-cn.pdf
apt-get install maint-guide ##Debian新维护者指南 pdf文件路径 /usr/share/doc/maint-guide/maint-guide.en.pdf
apt-get install packaging-tutorial ##Debian包装介绍 pdf中文繁体字路径 /usr/share/doc/packaging-tutorial/packaging-tutorial.zh_TW.pdf
##intro-i18n 还未完成开发
apt-get install dbconfig-common ##dbconfig常用文档 pdf文件路径 /usr/share/doc/dbconfig-common/dbconfig-common.pdf.gz   包括dbapp-policy.pdf.gz文件

https://www.debian.org/doc/manuals/dbconfig-common/dbconfig-common-design.html


网站详细内容如下

dbconfig-common
Technical reference
Copyright © 2004 sean finney

This document is licensed under the Academic Free License, Version 2.1.

Abstract
This document is a technical reference for developers who are curious regarding how dbconfig-common works. Before reading this document, it's highly recommended that you read the best practices for database applications draft, as the implementation design is based on rationale detailed in that document. If you are a developer looking to use dbconfig-common in your packages, you should read using dbconfig-common in debian packages first, as it will probably contain the information in which you're interested in a more condensed and accessible form.

Global maintainer script includes
/usr/share/dbconfig-common/dpkg
/usr/share/dbconfig-common/dpkg/$script
/usr/share/dbconfig-common/dpkg/$script.$dbtype
For every maintainer script (.config, .postinst, etc) there are hunks of shell code which can be included by package maintainers. This way whatever the "best practices" are deemed to be, the latest version of this package and their scripts will implement it transparently for the packages which use them. For each maintainer script, there is a generic script and a database-specific script. That is, you will find scripts named:

/usr/share/dbconfig-common/dpkg/postinst
/usr/share/dbconfig-common/dpkg/postinst.mysql
These scripts are sourced (not executed), so the lines in the package maintainer scripts should look like this

#!/bin/sh
# postinst maintainer script for foo-mysql

# source debconf stuff
. /usr/share/debconf/confmodule
# source dbconfig-common stuff
. /usr/share/dbconfig-common/dpkg/postinst.mysql
dbc_go foo-mysql "$@"

# ... rest of code ...

Note the arguments passed when sourcing the script.

Per-package database installation code
/usr/share/dbconfig-common/data/$package/install/$dbtype
/usr/share/dbconfig-common/data/$package/install-dbadmin/$dbtype
/usr/share/dbconfig-common/scripts/$package/install/$dbtype
The skeletons for the underlying databases are found under this directory, in per-package subdirectories, underneath which are files specific to each of the individual supported database types. These scripts do not need to include the code necessary for creating database users or the databases themselves (this is taken care of elsewhere), only the data used to create the necessary tables and/or otherwise populate the database is needed here.

Per-package database upgrade code
/usr/share/dbconfig-common/data/$package/upgrade/$dbtype
/usr/share/dbconfig-common/scripts/$package/upgrade/$dbtype
/usr/share/dbconfig-common/data/$package/upgrade/$dbtype/$vers
/usr/share/dbconfig-common/scripts/$package/upgrade/$dbtype/$vers
Upgrades are probably the most complicated part of this common infrastructure. Often in the life of a database application the underlying database needs to be altered in some way. In this implementation, for every file that matches the form


/usr/share/dbconfig-common/data/$package/upgrade/$dbtype/$vers

If $vers is more recent than the most recently configured version of the package (as passed to $2 in the postinst), then they are applied, in sorted order.

Global and per-package configuration
/etc/dbconfig-common/config
/etc/dbconfig-common/$package.conf
Config contains the default global settings to be used during configuration.

$package.conf contains the per-package settings for database applications. These settings are fed into debconf, so whether if debconf is set to non-interactive mode these will be the authoritative values, otherwise they will serve as pre-seeded defaults.

All of these files are in a shell-script include format, such that they can be easily read and written by the common configuration scripts. They're generated and maintained via ucf, so this setup should be fairly friendly to the admin who wants to manually edit the files.