--3.1记录集的叠加
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno = 10
UNION ALL --并集,不去除重复
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s;
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno = 10
UNION --并集,去除重复
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s;
SELECT s.ename, s.sal, s.comm, s.deptno FROM scott.emp s;
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno = 10
INTERSECT --交集
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s;
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno = 10
MINUS --差集,如果没有数据则表示没有差异,本例加条件人为制造差异
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno != 10;
--3.2组合相关的行
SELECT e.ename, d.loc, e.*, d.*
FROM scott.emp e, scott.dept d
WHERE e.deptno = d.deptno --防止笛卡儿积
  AND e.deptno = 10;
/*等同于*/
SELECT e.ename, d.loc, e.*, d.*
FROM scott.emp e
         JOIN scott.dept d
              ON e.deptno = d.deptno --防止笛卡儿积
                  AND e.deptno = 10;
--3.3在两个表中查找共同行
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
WHERE s.deptno = 10
INTERSECT --交集
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s;
/*等同于*/
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s
         JOIN scott.emp o
              ON s.empno = o.empno
                  AND s.ename = o.ename
                  AND s.job = o.job
WHERE s.deptno = 10;
--3.4从一个表中查找另一个表没有的值
CREATE OR REPLACE view sqlcook_emp_3_4 AS
SELECT s.ename, s.sal, s.comm, s.deptno + 1 AS deptno
FROM scott.emp s
WHERE s.deptno = 10;
SELECT s.ename, s.sal, s.comm, s.deptno AS deptno
FROM sqlcook_emp_3_4 s
WHERE s.deptno = 11
MINUS --差集
SELECT s.ename, s.sal, s.comm, s.deptno
FROM scott.emp s;
/*等同于*/
SELECT s.ename, s.sal, s.comm, s.deptno AS deptno
FROM sqlcook_emp_3_4 s
WHERE s.deptno = 11
  AND NOT EXISTS
    (SELECT t.deptno FROM scott.emp t WHERE s.deptno = t.deptno);
--3.5在一个表中查找与其他表不匹配的记录
SELECT * FROM scott.emp;
SELECT *
FROM scott.dept d
         JOIN scott.emp e
              ON d.deptno = e.deptno(+)
                  AND e.deptno IS NULL;
--3.6向查询中增加联接而不影响其他联接
SELECT e.*, d.*
FROM scott.dept d
         LEFT JOIN scott.emp e
                   ON e.deptno = d.deptno;
--3.7检测两个表中是否有相同的数据
CREATE OR REPLACE view sqlcook_emp_3_6 AS
SELECT *
FROM scott.emp s
WHERE s.deptno != 10
UNION ALL
SELECT *
FROM scott.emp s
WHERE s.ename = 'MILLER';
(
    SELECT s.empno,
           s.ename,
           s.job,
           s.mgr,
           s.hiredate,
           s.sal,
           s.comm,
           s.deptno,
           COUNT(*) AS n
    FROM scott.emp s
    GROUP BY s.empno,
             s.ename,
             s.job,
             s.mgr,
             s.hiredate,
             s.sal,
             s.comm,
             s.deptno
    MINUS
    SELECT s.empno,
           s.ename,
           s.job,
           s.mgr,
           s.hiredate,
           s.sal,
           s.comm,
           s.deptno,
           COUNT(*) AS n
    FROM sqlcook_emp_3_6 s
    GROUP BY s.empno,
             s.ename,
             s.job,
             s.mgr,
             s.hiredate,
             s.sal,
             s.comm,
             s.deptno)
UNION (SELECT s.empno,
              s.ename,
              s.job,
              s.mgr,
              s.hiredate,
              s.sal,
              s.comm,
              s.deptno,
              COUNT(*) AS n
       FROM sqlcook_emp_3_6 s
       GROUP BY s.empno,
                s.ename,
                s.job,
                s.mgr,
                s.hiredate,
                s.sal,
                s.comm,
                s.deptno
       MINUS
       SELECT s.empno,
              s.ename,
              s.job,
              s.mgr,
              s.hiredate,
              s.sal,
              s.comm,
              s.deptno,
              COUNT(*) AS n
       FROM scott.emp s
       GROUP BY s.empno,
                s.ename,
                s.job,
                s.mgr,
                s.hiredate,
                s.sal,
                s.comm,
                s.deptno);
--3.8识别和消除笛卡儿积
SELECT e.ename, d.loc
FROM scott.emp e
         JOIN scott.dept d
              ON e.deptno = d.deptno
                  AND e.deptno = 10;
--3.9聚集和联接
CREATE OR REPLACE view sqlcook_emp_3_9 AS
SELECT s.empno,
       s.hiredate AS received,
       (CASE
            WHEN s.sal <= 800 THEN
                1
            WHEN s.sal BETWEEN 801 AND 1999 THEN
                2
            WHEN s.sal BETWEEN 2000 AND 5000 THEN
                3
            ELSE
                4
           END) AS TYPE
FROM scott.emp s;
SELECT DISTINCT deptno, total_sal, total_bonus
FROM (SELECT e.empno,
             e.ename,
             SUM(DISTINCT e.sal) over(PARTITION BY deptno) AS total_sal,
             e.deptno,
             SUM(e.sal * (CASE
                              WHEN eb.type = 1 THEN
                                  0.1
                              WHEN eb.type = 2 THEN
                                  0.2
                              WHEN eb.type = 3 THEN
                                  0.3
                              ELSE
                                  0.4
                 END)) over(PARTITION BY deptno) AS total_bonus
      FROM scott.emp e
               JOIN sqlcook_emp_3_9 eb
                    ON e.empno = eb.empno
                        AND e.deptno = 10) x; --1614898SELECT SUM(DISTINCT s.sal) AS total_sal FROM scott.emp s WHERE s.deptno = 10; --1614898--3.10聚集和外联接
SELECT DISTINCT deptno, total_sal, total_bonus
FROM (SELECT e.empno,
             e.ename,
             SUM(DISTINCT e.sal) over(PARTITION BY deptno) AS total_sal,
             e.deptno,
             SUM(e.sal * (CASE
                              WHEN eb.type = 1 THEN
                                  0.1
                              WHEN eb.type = 2 THEN
                                  0.2
                              WHEN eb.type = 3 THEN
                                  0.3
                              ELSE
                                  0.4
                 END)) over(PARTITION BY deptno) AS total_bonus
      FROM scott.emp e
               JOIN sqlcook_emp_3_9 eb
                    ON e.empno = eb.empno(+)
                        AND e.deptno = 10) x; --1614898
--3.11从多个表中返回丢失的数据
SELECT d.deptno, d.dname, e.ename, e.deptno
FROM scott.dept d
         JOIN scott.emp e
              ON d.deptno = e.deptno(+)
                  AND e.deptno IS NULL
UNION
SELECT d.deptno, d.dname, e.ename, e.deptno
FROM scott.dept d
         JOIN scott.emp e
              ON d.deptno(+) = e.deptno
                  AND e.deptno IS NULL;
--3.12在运算和比较时使用NULL值
SELECT s.ename, s.comm, coalesce(s.comm, 0) AS comm
FROM scott.emp s
WHERE coalesce(s.comm, 0) <
      (SELECT comm FROM scott.emp WHERE ename = 'MARTIN');