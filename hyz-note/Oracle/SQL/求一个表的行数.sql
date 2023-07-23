
--7.4求一个表的行数
SELECT COUNT(*) FROM scott.emp; --如果此列所有字段都为NULL,会忽略为NULL的列,9999--7.5求某列值的个数
SELECT COUNT(s.comm) FROM scott.emp s; --如果指定字段的值为NULL,会忽略为NULL的列,9975--7.6生成累计和
SELECT empno,
       sal,
       SUM(sal) over(ORDER BY sal, empno) AS running_totdal1,
       SUM(sal) over(ORDER BY sal) AS running_totdal2
FROM scott.emp
ORDER BY 2;