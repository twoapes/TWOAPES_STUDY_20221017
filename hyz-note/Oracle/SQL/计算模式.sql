--7.9计算模式
--出现最频繁的数据
SELECT MAX(sal) keep(dense_rank FIRST ORDER BY cnt DESC) sal
FROM (SELECT sal, COUNT(1) cnt
      FROM scott.emp
      WHERE deptno = 10
      GROUP BY sal);