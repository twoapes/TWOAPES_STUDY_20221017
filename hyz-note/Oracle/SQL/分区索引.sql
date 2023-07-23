--查询分区索引
SELECT s.owner, s.table_name, o.index_name, s.*
FROM dba_tables s
         JOIN dba_indexes o
              ON s.owner = o.owner
                  AND s.table_name = o.table_name
                  AND s.partitioned = o.partitioned
WHERE s.partitioned = o.partitioned
  AND s.temporary = o.temporary
  AND o.partitioned = 'YES'
  AND s.temporary = 'N';
SELECT s.table_name, o.index_name, s.*
FROM user_tables s
         JOIN user_indexes o
              ON s.table_name = o.table_name
                  AND s.partitioned = o.partitioned
WHERE s.partitioned = o.partitioned
  AND s.temporary = o.temporary
  AND o.partitioned = 'YES'
  AND s.temporary = 'N';