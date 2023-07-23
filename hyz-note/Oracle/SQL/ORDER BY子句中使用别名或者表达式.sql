--别名比表达式更容易理解
--不使用别名
SELECT s.empno AS "Employee Number",
       s.ename,
       (500 + s.sal) * 12 AS "Annual Salary"
FROM emp s
ORDER BY (500 + s.sal) * 12 DESC;
--使用别名
SELECT s.empno AS "Employee Number",
       s.ename,
       (500 + s.sal) * 12 AS "Annual Salary"
FROM emp s
ORDER BY "Annual Salary" DESC;