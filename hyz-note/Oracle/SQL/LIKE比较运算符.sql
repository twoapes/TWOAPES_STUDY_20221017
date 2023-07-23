-- 使用LIKE通配符查询
-- %代表0个或多个字符
-- _代表一个且只能是一个字符
SELECT * FROM emp s WHERE s.job LIKE 'SAL%';--匹配多个字符
SELECT * FROM emp s WHERE s.job LIKE 'CLER_';--匹配一个字符