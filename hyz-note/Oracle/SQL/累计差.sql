--7.8计算累计差
SELECT ename,
       sal,
       SUM((CASE
                WHEN rn = 1 THEN
                    sal
                ELSE
                    -sal
           END)) over(ORDER BY sal, empno) AS running_diff
FROM (SELECT empno,
             ename,
             sal,
             row_number() over(ORDER BY sal, empno) AS rn
      FROM scott.emp
      WHERE deptno = 10) x;