--5.1列出模式中的表
SELECT s.table_name FROM all_tables s WHERE s.owner = 'SCOTT';
--5.2列出表中的列
SELECT s.column_name, s.data_type, s.column_id
FROM all_tab_columns s
WHERE s.owner = 'SCOTT'
  AND s.table_name = 'EMP';
--5.3列出表中的索引列
SELECT s.table_name, s.index_name, s.column_name, s.column_position
FROM all_ind_columns s
WHERE s.table_name = 'EMP'AND s.table_owner = 'SCOTT';
--5.4列出表中的约束
SELECT a.table_name, a.constraint_name, b.column_name, a.constraint_type
FROM all_constraints a
         JOIN all_cons_columns b
              ON a.owner = b.owner
                  AND a.table_name = b.table_name
                  AND a.constraint_name = b.constraint_name
WHERE a.table_name = 'EMP'
  AND a.owner = 'SCOTT';
--5.5列出没有相应索引的外键
SELECT a.table_name,
       a.constraint_name,
       a.column_name,
       c.index_owner,
       c.index_name
FROM all_cons_columns a, all_constraints b, all_ind_columns c
WHERE a.owner = b.owner
  AND a.table_name = b.table_name
  AND a.constraint_name = b.constraint_name
  AND a.owner = c.table_owner(+)
  AND a.table_name = c.table_name(+)
  AND a.column_name = c.column_name(+)
  AND c.index_owner IS NULL
  AND a.owner = 'SCOTT'
  AND a.table_name = 'EMP'
  AND b.constraint_type = 'R';
--5.6使用SQL来生成SQL
SELECT 'select count(*) from ' || s.table_name || ';' FROM user_tables s;
--5.7在ORACLE中描述数据字典视图
SELECT s.column_name, s.comments
FROM dict_columns s
WHERE s.table_name = 'ALL_TAB_COLUMNS';