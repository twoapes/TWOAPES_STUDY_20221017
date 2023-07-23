--查询临时表查询
SELECT * FROM dba_tables s WHERE s.temporary = 'Y' ORDER BY s.table_name;
SELECT * FROM user_tables s WHERE s.temporary = 'Y' ORDER BY s.table_name;

-- oracle 临时表空间的增删改查
-- 1,查看临时表空间 (dba_temp_files视图)(v_$tempfile视图)
select tablespace_name,file_name,bytes/1024/1024 file_size,autoextensible from dba_temp_files;
select status,enabled, name, bytes/1024/1024 file_size from v_$tempfile;--sys用户查看

-- 2,缩小临时表空间大小
alter database tempfile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\TELEMT\TEMP01.DBF' resize 100M;

-- 3,扩展临时表空间:
-- 方法一,增大临时文件大小:
SQL> alter database tempfile '/u01/app/oracle/oradata/orcl/temp01.dbf' resize 100m;
-- 方法二,将临时数据文件设为自动扩展:
SQL> alter database tempfile '/u01/app/oracle/oradata/orcl/temp01.dbf' autoextend on next 5m maxsize unlimited;
-- 方法三,向临时表空间中添加数据文件:
SQL> alter tablespace temp add tempfile '/u01/app/oracle/oradata/orcl/temp02.dbf' size 100m;

-- 4,创建临时表空间:
SQL> create temporary tablespace temp1 tempfile '/u01/app/oracle/oradata/orcl/temp11.dbf' size 10M;

-- 5,更改系统的默认临时表空间:
--查询默认临时表空间
select * from database_properties where property_name='DEFAULT_TEMP_TABLESPACE';
--修改默认临时表空间
alter database default temporary tablespace temp1;
-- 所有用户的默认临时表空间都将切换为新的临时表空间:
select username,temporary_tablespace,default_ from dba_users;
--更改某一用户的临时表空间:
alter user scott temporary tablespace temp;

-- 6,删除临时表空间
-- 删除临时表空间的一个数据文件:
SQL> alter database tempfile '/u01/app/oracle/oradata/orcl/temp02.dbf' drop;
-- 删除临时表空间(彻底删除):
SQL> drop tablespace temp1 including contents and datafiles cascade constraints;

-- 7,查看临时表空间的使用情况(GV_$TEMP_SPACE_HEADER视图必须在sys用户下才能查询)
-- GV_$TEMP_SPACE_HEADER视图记录了临时表空间的使用大小与未使用的大小
-- dba_temp_files视图的bytes字段记录的是临时表空间的总大小
SELECT temp_used.tablespace_name,
       total - used as "Free",
       total as "Total",
       round(nvl(total - used, 0) * 100 / total, 3) "Free percent"
FROM (SELECT tablespace_name, SUM(bytes_used) / 1024 / 1024 used
      FROM GV_$TEMP_SPACE_HEADER
      GROUP BY tablespace_name) temp_used,
     (SELECT tablespace_name, SUM(bytes) / 1024 / 1024 total
      FROM dba_temp_files
      GROUP BY tablespace_name) temp_total
WHERE temp_used.tablespace_name = temp_total.tablespace_name

-- 8,查找消耗资源比较的sql语句
Select se.username,
       se.sid,
       su.extents,
       su.blocks * to_number(rtrim(p.value)) as Space,
       tablespace,
       segtype,
       sql_text
from v$sort_usage su, v$parameter p, v$session se, v$sql s
where p.name = 'db_block_size'
  and su.session_addr = se.saddr
  and s.hash_value = su.sqlhash
  and s.address = su.sqladdr
order by se.username, se.sid

-- 9,查看当前临时表空间使用大小与正在占用临时表空间的sql语句
select sess.SID, segtype, blocks * 8 / 1000 "MB", sql_text
from v$sort_usage sort, v$session sess, v$sql sql
where sort.SESSION_ADDR = sess.SADDR
  and sql.ADDRESS = sess.SQL_ADDRESS
order by blocks desc;

-- 10,临时表空间组介绍
-- 1)创建临时表空间组:
create temporary tablespace tempts1 tempfile '/home/oracle/temp1_02.dbf' size 2M tablespace group group1;
create temporary tablespace tempts2 tempfile '/home/oracle/temp2_02.dbf' size 2M tablespace group group2;

-- 2)查询临时表空间组:dba_tablespace_groups视图
select * from dba_tablespace_groups;
GROUP_NAME                     TABLESPACE_NAME
------------------------------ ------------------------------
GROUP1                         TEMPTS1
GROUP2                         TEMPTS2

-- 3)将表空间从一个临时表空间组移动到另外一个临时表空间组:
alter tablespace tempts1 tablespace group GROUP2 ;
select * from dba_tablespace_groups;

GROUP_NAME                     TABLESPACE_NAME
------------------------------ ------------------------------
GROUP2                         TEMPTS1
GROUP2                         TEMPTS2

-- 4)把临时表空间组指定给用户
alter user scott temporary tablespace GROUP2;

-- 5)在数据库级设置临时表空间
alter database <db_name> default temporary tablespace GROUP2;

-- 6)删除临时表空间组 (删除组成临时表空间组的所有临时表空间)
drop tablespace tempts1 including contents and datafiles;
select * from dba_tablespace_groups;
GROUP_NAME                     TABLESPACE_NAME
------------------------------ ------------------------------
GROUP2                         TEMPTS2

drop tablespace tempts2 including contents and datafiles;
select * from dba_tablespace_groups;
GROUP_NAME                     TABLESPACE_NAME

-- 11,对临时表空间进行shrink(11g新增的功能)
--将temp表空间收缩为20M
alter tablespace temp shrink space keep 20M;
--自动将表空间的临时文件缩小到最小可能的大小
ALTER TABLESPACE temp SHRINK TEMPFILE '/u02/oracle/data/lmtemp02.dbf';

-- 临时表空间作用
-- Oracle临时表空间主要用来做查询和存放一些缓冲区数据.临时表空间消耗的主要原因是需要对查询的中间结果进行排序.
-- 重启数据库可以释放临时表空间,如果不能重启实例,而一直保持问题sql语句的执行,temp表空间会一直增长.直到耗尽硬盘空间.
-- 网上有人猜测在磁盘空间的分配上,oracle使用的是贪心算法,如果上次磁盘空间消耗达到1GB,那么临时表空间就是1GB.
-- 也就是说当前临时表空间文件的大小是历史上使用临时表空间最大的大小.

-- 临时表空间的主要作用:
-- 索引create或rebuild;
-- Order by 或 group by;
-- Distinct 操作;
-- Union 或 intersect 或 minus;
-- Sort-merge joins;
-- analyze.