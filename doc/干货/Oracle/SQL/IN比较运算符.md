# IN比较运算符

IN测试某些值是否在表中出现如果出现就会被记录下来:
顺序不会影响结果
实际上和OR效果一致并不会提高效率
使用NOT IN结果得到相反的逻辑数据
如果我们筛选的值超过2000.那么无法使用IN关键字

```sql
SELECT * FROM emp s WHERE s.job IN ('SALESMAN','CLERK', 'MANAGER');
SELECT * FROM emp s WHERE s.job NOT IN ('SALESMAN','CLERK','MANAGER');
```
