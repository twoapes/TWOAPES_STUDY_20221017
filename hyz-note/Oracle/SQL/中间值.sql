--7.10计算中间值
SELECT median(sal) FROM scott.emp WHERE deptno = 20;
SELECT percentile_cont(0.5) within GROUP(ORDER BY sal)
FROM scott.emp
WHERE deptno = 20;
SELECT sal FROM scott.emp WHERE deptno = 20 ORDER BY sal;