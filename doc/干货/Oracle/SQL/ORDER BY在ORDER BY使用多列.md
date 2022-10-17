# ORDER BY在ORDER BY使用多列

```sql
--可以选择某列升序或降序
SELECT s.empno, s.ename, s.sal
FROM emp s
ORDER BY s.empno DESC, s.ename, s.sal DESC;
```
