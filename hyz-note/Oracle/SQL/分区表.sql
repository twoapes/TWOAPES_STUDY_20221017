--查询当前用户下所有的分区表
SELECT *
FROM dba_tables s
WHERE s.temporary = 'N'
  AND s.partitioned = 'YES'
ORDER BY s.table_name;
SELECT *
FROM user_tables s
WHERE s.temporary = 'N'
  AND s.partitioned = 'YES'
ORDER BY s.table_name;

SELECT a.table_owner,a.table_name, a.partition_name, a.* FROM dba_tab_partitions a
SELECT a.table_name, a.partition_name, a.* FROM user_tab_partitions a