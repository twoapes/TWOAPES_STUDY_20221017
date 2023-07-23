--查询表空间文件位置
SELECT * FROM dba_data_files;
--1G=1024MB
--1M=1024KB
--1K=1024Bytes
--1M=11048576Bytes
--1G=1024*11048576Bytes=11313741824Bytes
SELECT a.tablespace_name "表空间名",
       total "表空间大小",
       free "表空间剩余大小",
       (total - free) "表空间使用大小",
       total / (1024 * 1024 * 1024) "表空间大小(G)",
       free / (1024 * 1024 * 1024) "表空间剩余大小(G)",
       (total - free) / (1024 * 1024 * 1024) "表空间使用大小(G)",
       round((total - free) / total, 4) * 100 "使用率 %"
FROM (SELECT tablespace_name, SUM(bytes) free
      FROM dba_free_space
      GROUP BY tablespace_name) a,
     (SELECT tablespace_name, SUM(bytes) total
      FROM dba_data_files
      GROUP BY tablespace_name) b
WHERE a.tablespace_name = b.tablespace_name;


--彻底删除表空间操作
alter database datafile 'D:\APP\user_name\ORADATA\user_name\user_name02.DBF' offline drop;
DROP TABLESPACE user_name INCLUDING CONTENTS AND DATAFILES;

--使用表空间情况
SELECT SUM(bytes) / (1024 * 1024) AS free_space, tablespace_name
FROM dba_free_space
GROUP BY tablespace_name;
SELECT a.tablespace_name,
       a.bytes total,
       b.bytes used,
       c.bytes free,
       (b.bytes * 100) / a.bytes "% USED ",
       (c.bytes * 100) / a.bytes "% FREE "
FROM sys.sm$ts_avail a, sys.sm$ts_used b, sys.sm$ts_free c
WHERE a.tablespace_name = b.tablespace_name
  AND a.tablespace_name = c.tablespace_name; --表空间下,表,索引等使用情况
select t.segment_name, t.segment_type, sum(t.bytes / 1024 / 1024) "占用空间(M)"
from dba_segments t
where t.segment_name in  (select table_name from user_tables)
group by OWNER, t.segment_name, t.segment_type;
SELECT t.segment_name, SUM(t.bytes / 1024 / 1024)
FROM user_segments t
GROUP BY t.segment_name
ORDER BY SUM(t.bytes / 1024 / 1024) DESC
--查询表空间状态操作
SELECT a.tablespace_name,
       filenum,
       total "TOTAL (MB)",
       f.free "FREE (MB)",
       to_char(round(free * 100 / total, 2), '990.00') "FREE%",
       to_char(round((total - free) * 100 / total, 2), '990.00') "USED%",
       round(maxsizes, 2) "MAX (MB)"
FROM (SELECT tablespace_name,
             COUNT(file_id) filenum,
             SUM(bytes / (1024 * 1024)) total,
             SUM(maxbytes) / 1024 / 1024 maxsizes
      FROM dba_data_files
      GROUP BY tablespace_name) a,
     (SELECT tablespace_name, round(SUM(bytes / (1024 * 1024))) free
      FROM dba_free_space
      GROUP BY tablespace_name) f
WHERE a.tablespace_name = f.tablespace_name;
SELECT ceil(max_block * block_size / 1024)
FROM (SELECT MAX(block_id) max_block
      FROM dba_extents
      WHERE file_id IN (SELECT file_id
                        FROM dba_data_files d
                        WHERE d.tablespace_name = 'USERS')) m,
     (SELECT VALUE / 1024 block_size
      FROM v$parameter
      WHERE NAME = 'db_block_size') b;
CREATE directory dump_name AS 'E:';
--创建一个新的临时表空间
CREATE TEMPORARY TABLESPACE tablespacetempname TEMPFILE 'D:\tableSpaceFile\TEMP01.dbf' SIZE 1024M
    AUTOEXTEND  ON NEXT 100M MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL ;
--删除用户
drop user username cascade;
--将当前用户的临时表空间切换到新建的临时表空间上
ALTER USER username TEMPORARY TABLESPACE tablespacetempname;
select name from v$tempfile;
--删除表空间
DROP TABLESPACE tablespaceName INCLUDING CONTENTS AND DATAFILES;
--重命名表空间
alter tablespace TEST tablespaceName to username;
--清理表空间操作(回收站清空):
purge tablespace tablespace_name; --用于清空表空间的recycle bin
purge tablespace tablespace_name USER user_name; --清空指定表空间的recycle bin中指定用户的对象
purge recyclebin; --删除当前用户的recycle bin中的对象
purge dba_recyclebin; --删除所有用户的recycle bin中的对象,该命令要sysdba权限
drop TABLE table_name purge; --删除对象并且不放在recycle bin中,即永久的删除,不能用flashback恢复.
purge INDEX recycle_bin_object_name; -- 当想释放recycle bin的空间,又想能恢复表时,可以通过释放该对象的index所占用的空间来缓解空间压力. 因为索引是可以重建的.
