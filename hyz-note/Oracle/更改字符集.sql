[twoapes@twoapes ~]$ sqlplus sys/1 as sysdba
SQL*Plus: Release 11.2.0.4.0 Production on Wed Sep 2 23:24:05 2020
Copyright (c) 1982, 2013, Oracle.  All rights reserved.
Connected to:
Oracle Database 11g Release 11.2.0.4.0 - 64bit Production
SQL> shutdown immediate
Database closed.
Database dismounted.
ORACLE instance shut down.
SQL> startup mount
ORACLE instance started.
Total System Global Area 2405122048 bytes
Fixed Size                  2255592 bytes
Variable Size             603981080 bytes
Database Buffers         1778384896 bytes
Redo Buffers               20500480 bytes
Database mounted.
SQL> alter system enable restricted session;
System altered.
SQL> alter system set job_queue_processes=0;
System altered.
SQL> alter system set aq_tm_processes=0;
System altered.
SQL> alter database open;
Database altered.
SQL> alter database character set internal_use utf8;
Database altered.
SQL> shutdown immediate
Database closed.
Database dismounted.
ORACLE instance shut down.
SQL> startup
ORACLE instance started.
Total System Global Area 2405122048 bytes
Fixed Size                  2255592 bytes
Variable Size             603981080 bytes
Database Buffers         1778384896 bytes
Redo Buffers               20500480 bytes
Database mounted.
Database opened.
SQL> select userenv('language') from dual;
## USERENV('LANGUAGE')
AMERICAN_AMERICA.UTF8
SQL>