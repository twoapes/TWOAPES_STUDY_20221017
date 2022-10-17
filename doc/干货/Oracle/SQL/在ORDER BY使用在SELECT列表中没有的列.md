# 在ORDER BY使用在SELECT列表中没有的列

```sql
--可以选择某不存在的列升序或降序但很难让别人理解,不推荐使用
SELECT s.ename, s.sal FROM emp s ORDER BY s.empno;
```
