SELECT TABLE_NAME,
       TABLE_COMMENT
From information_schema.tables
WHERE TABLE_SCHEMA = 'STATION'
ORDER BY TABLE_NAME;

SELECT s.TABLE_NAME, o.TABLE_COMMENT, s.COLUMN_NAME, s.COLUMN_COMMENT
From information_schema.COLUMNS s
         join information_schema.tables o
              on s.TABLE_SCHEMA = o.TABLE_SCHEMA
                  and s.TABLE_NAME = o.TABLE_NAME
WHERE s.TABLE_SCHEMA = 'STATION'
ORDER BY TABLE_NAME, s.COLUMN_NAME;