# BETWEEN AND比较运算符

```sql
--BETWEEN AND和NOT BETWEEN AND可以用于日期数字等
SELECT s.empno, s.ename, s.sal
FROM emp s
WHERE s.sal BETWEEN 1500 AND 5000;
SELECT s.empno, s.ename, s.sal, s.hiredate
FROM emp s
WHERE s.hiredate BETWEEN DATE '1981-1-1' AND DATE '1982-5-31';
SELECT s.empno, s.ename, s.sal, s.hiredate
FROM emp s
WHERE s.hiredate NOT BETWEEN DATE '1981-1-1' AND DATE '1982-5-31';
--虽然可以使用NOT BETWEEN AND,但是可能不好把握数据量,会出现性能问题,所以较少使用
SELECT s.empno, s.ename, s.job, s.sal FROM emp s WHERE s.job = 'SALESMAN';

在SQL语句使用日期和字符串
Orace区分字符串大小写字符串和日期使用单引号数字则无需
数字即可使用单引号包裹,也可以不使用单引号包裹,如果使用单引号可以进行模糊查询
```
