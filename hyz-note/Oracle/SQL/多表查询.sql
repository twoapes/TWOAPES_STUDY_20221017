--查看主键外键,索引等
SELECT t.table_name  AS 表名,
       t.column_name AS 表字段,
       co.comments   AS 表备注,
       t.data_type   AS 字段类型,
       t.data_length AS 字段长度,
       c.comments    AS 字段备注
FROM user_tab_columns t
         JOIN user_col_comments c
              ON t.table_name = c.table_name
                  AND c.column_name = t.column_name
         JOIN user_tab_comments co
              ON co.table_name = t.table_name;
SELECT au.table_name AS 表名,
       cu.column_name AS 字段名,
       au.owner AS 用户,
       cu.constraint_name AS 约束名称,
       decode(au.constraint_type,
              'C',
              '普通字段',
              'P',
              '主键',
              'U',
              '唯一约束',
              'R',
              '外键') AS 约束类型
FROM user_constraints au
         JOIN user_cons_columns cu
              ON au.table_name = cu.table_name;

--综合查询
SELECT 用户,
       索引名称,
       字段名称,
       字段类型,
       字段长度,
       字段备注,
       约束名称,
       约束对应的字段名,
       约束类型,
       表名,
       表备注,
       所属表空间
FROM (
         --所有非约束表
         SELECT NULL               AS 用户,
                NULL               AS 索引名称,
                t.column_name      AS 字段名称,
                t.data_type        AS 字段类型,
                t.data_length      AS 字段长度,
                c.comments         AS 字段备注,
                NULL               AS 约束名称,
                NULL               AS 约束对应的字段名,
                NULL               AS 约束类型,
                t.table_name       AS 表名,
                co.comments        AS 表备注,
                ut.tablespace_name AS 所属表空间
         FROM user_tab_columns t
                  JOIN user_col_comments c
                       ON t.table_name = c.table_name
                           AND t.column_name = c.column_name
                  JOIN user_tab_comments co
                       ON co.table_name = t.table_name
                  JOIN user_tables ut
                       ON ut.table_name = t.table_name
         UNION
         --所有约束表
         SELECT au.owner AS 用户,
                au.index_name AS 索引名称,
                t.column_name AS 字段名称,
                t.data_type AS 字段类型,
                t.data_length AS 字段长度,
                c.comments AS 字段备注,
                au.constraint_name AS 约束名称,
                cu.column_name AS 约束对应的字段名,
                decode(au.constraint_type,
                       'C',
                       '普通字段',
                       'P',
                       '主键',
                       'U',
                       '唯一约束',
                       'R',
                       '外键') AS 约束类型,
                t.table_name AS 表名,
                co.comments AS 表备注,
                ut.tablespace_name AS 所属表空间
         FROM user_tab_columns t
                  JOIN user_col_comments c
                       ON t.table_name = c.table_name
                           AND t.column_name = c.column_name
                  JOIN user_tab_comments co
                       ON co.table_name = t.table_name
                  JOIN user_constraints au
                       ON au.table_name = t.table_name
                  JOIN user_cons_columns cu
                       ON cu.constraint_name = au.constraint_name
                  JOIN user_tables ut
                       ON ut.table_name = t.table_name) k;