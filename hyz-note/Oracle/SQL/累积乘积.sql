--7.7生成累乘积
--此函数为0和负数无法正常输出
SELECT s.empno,
       s.ename,
       s.sal,
       exp(SUM(ln(s.sal)) over(ORDER BY s.sal, s.empno)) AS running_prod
FROM scott.emp s
WHERE s.deptno = 10;