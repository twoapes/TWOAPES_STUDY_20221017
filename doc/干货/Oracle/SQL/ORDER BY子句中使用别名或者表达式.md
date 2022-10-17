# ORDER BY子句中使用别名或者表达式

别名比表达式更容易理解

```sql
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
```
