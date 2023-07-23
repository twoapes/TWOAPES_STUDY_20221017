--7.1计算平均值
SELECT AVG(s.mgr) FROM scott.emp s;
--7.13计算不包含最大值和最小值的均值
SELECT AVG(sal)
FROM (SELECT sal, MIN(sal) over() AS min_sal, MAX(sal) over() AS max_sal
      FROM scott.emp) x
WHERE sal NOT IN (min_sal, max_sal);