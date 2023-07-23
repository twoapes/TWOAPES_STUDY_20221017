2.查询结果排序
--2.1以指定的次序返回查询结果
SELECT s.ename, s.job, s.sal
FROM scott.emp s
WHERE s.deptno = 10
ORDER BY s.sal ASC; --升序
SELECT s.ename, s.job, s.sal
FROM scott.emp s
WHERE s.deptno = 10
ORDER BY s.sal DESC; --降序
SELECT s.ename, s.job, s.sal
FROM scott.emp s
WHERE s.deptno = 10
ORDER BY 3 ASC; --可以使用数字,但是不推荐
--2.2按多个字段排序
SELECT s.ename, s.deptno, s.job, s.sal
FROM scott.emp s
WHERE s.deptno = 10
ORDER BY s.deptno, s.sal DESC;
--2.3按子串排序
SELECT s.ename, s.job
FROM scott.emp s
ORDER BY substr(s.job, length(s.job) - 2);
--2.4对字母数字混合的数据排序
SELECT s.ename || ' ' || s.deptno AS data FROM scott.emp s; /*order by hyz_deptno*/
SELECT s.ename || ' ' || s.deptno AS data
FROM scott.emp s
ORDER BY REPLACE(data,
                 REPLACE(translate(data, '0123456789', '######'),
                         '#',
                         ''),
                 '');
SELECT s.ename || ' ' || s.deptno AS data
FROM scott.emp s
ORDER BY regexp_substr(data, '[0-9]+') ASC; /*order by ename*/
SELECT s.ename || ' ' || s.deptno AS data
FROM scott.emp s
ORDER BY REPLACE(translate(data, '0123456789', '######'), '#', '');
SELECT s.ename || ' ' || s.deptno AS data
FROM scott.emp s
ORDER BY regexp_substr(data, '[[:alnum:]]+') ASC;
--2.5处理排序空值
SELECT s.ename,
       s.sal,
       s.comm,
       (CASE
            WHEN s.comm IS NULL THEN
                0
            ELSE
                1
           END) AS is_null
FROM scott.emp s;
--2.6根据数据项的键排序
SELECT s.ename,
       s.sal,
       s.comm,
       (CASE
            WHEN s.comm IS NULL THEN
                s.sal
            ELSE
                s.comm
           END) AS ordered,
       s.*
FROM scott.emp s
ORDER BY ordered;