--查询非临时表(实体表) 查询
SELECT * FROM dba_tables s WHERE s.temporary = 'N' ORDER BY s.table_name;
SELECT * FROM user_tables s WHERE s.temporary = 'N' ORDER BY s.table_name;
--查询当前用户下所有的非分区表
SELECT *
FROM dba_tables s
WHERE s.temporary = 'N'
  AND s.partitioned = 'NO'
ORDER BY s.table_name;
SELECT *
FROM user_tables s
WHERE s.temporary = 'N'
  AND s.partitioned = 'NO'
ORDER BY s.table_name;
--查询当前用户下所有的表属性
--num_rows值来源于统计分析,如果统计分析之后某表数据插入或删除,此统计就不准确了,需要重新统计分析后才准确
SELECT s.owner           AS 用户,
       s.table_name      AS 表名,
       s.num_rows        AS "表的数据量",
       s.tablespace_name AS 所在的表空间
FROM dba_tables s;
SELECT s.table_name      AS 表名,
       s.num_rows        AS "表的数据量",
       s.tablespace_name AS 所在的表空间
FROM user_tables s;
--查询指定数据库的表创建语句(但是不能超过100条, rownum <= 100条件不能去除):
SELECT dbms_metadata.get_ddl('TABLE', table_name, USER)
FROM user_tables s
--WHERE s.tablespace_name = 'tablespace_name'
WHERE rownum <= 100;