--7.11求总和的百分比
SELECT (d10 / total) * 100 AS pct
FROM (SELECT DISTINCT deptno,
                      SUM(sal) over() total,
                      SUM(sal) over(PARTITION BY deptno) d10
      FROM scott.emp) x
WHERE deptno = 10; --32.190635451505
SELECT SUM(sal) total FROM scott.emp s WHERE s.deptno = 10; --9625
SELECT SUM(sal) total FROM scott.emp s WHERE s.deptno = 20;
SELECT SUM(sal) total FROM scott.emp s WHERE s.deptno = 30;
SELECT SUM(sal) total FROM scott.emp s WHERE s.deptno = 40;
SELECT SUM(sal) total FROM scott.emp s; --29900