--当前用户,电脑等使用数据库情况
SELECT b.sid      oracleid,
       b.username oracle用户,
       b.serial#,
       spid       操作系统id,
       paddr,
       sql_text   正在执行的sql,
       b.machine  计算机名
FROM v$process a, v$session b, v$sqlarea c
WHERE a.addr = b.paddr
  AND b.sql_hash_value = c.hash_value
  AND b.username = 'SCOTT';
--实时查看sql使用情况
SELECT a.serial#,
       osuser     电脑登录身份,
       program    发起请求的程序,
       username   登录系统的用户名,
       schemaname,
       b.cpu_time 花费cpu的时间,
       status,
       b.sql_text 执行的sql
FROM v$session a
         LEFT JOIN v$sql b
                   ON a.sql_address = b.address
                       AND a.sql_hash_value = b.hash_value
WHERE a.username = 'SCOTT'
  AND b.sql_text IS NOT NULL
ORDER BY b.cpu_time DESC;
--查询最近执行的sql
SELECT sql_text, last_load_time FROM v$sql;
SELECT sql_text, sql_fulltext, last_active_time FROM v$sqlarea;
SELECT sql_text
FROM v$sql
WHERE hash_value IN
      (SELECT sql_hash_value
       FROM v$session
       WHERE sid IN (SELECT session_id FROM v$locked_object));
--查看游标内的实际执行计划
select * from table(dbms_xplan.display_cursor('sqlid'));
--查看AWR报告中的实际执行计划
select * from table(dbms_xplan.display_awr('sqlid'));
--查看表是否存在统计信息
select table_name, a.last_analyzed, num_rows from user_tables a where a.table_name = 'R_D_OS_TRADE'
order by a.last_analyzed nulls last;