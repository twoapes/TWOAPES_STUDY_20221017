--易读性很差不鼓励使用但是可以知道是存在此方法order by 可以使用别名对字段排序也可用序号但是不推荐使用
SELECT s.empno AS "Employee Number",
       s.ename,
       (500 + s.sal) * 12 AS "Annual Salary"
FROM emp s
ORDER BY 3 DESC;