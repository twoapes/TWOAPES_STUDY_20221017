-- 限制所选择的数据行
-- WHERE子句在FROM子句之后:
-- WHERE其后紧跟限制条件
-- 条件由列名字符串算术表达式常量和比较运算符组成
-- WHERE子句不能使用别名 
SELECT s.empno ,s.ename ,s.sal FROM emp s WHERE s.sal >= 1500;
SELECT *
FROM scott.emp s
WHERE s.deptno = 10 --deptno=10
   OR s.comm IS NOT NULL --或comm不是NULL
   OR s.sal <= 2000 --或sal小于2000
    AND s.deptno = 20; --并且deptno=20
/*等同于*/
SELECT *
FROM emp s
WHERE (s.deptno = 10 --deptno=10
    OR s.comm IS NOT NULL) --或comm不是NULL
   OR (s.sal <= 2000 AND s.deptno = 20) --或sal小于2000并且deptno=20
;
/*等同于*/
SELECT *
FROM emp s
WHERE (s.deptno = 10 --deptno=10
    OR s.comm IS NOT NULL --或comm不是NULL
          )
UNION
SELECT *
FROM emp s
WHERE (s.sal <= 2000 AND s.deptno = 20) --sal小于2000并且deptno=20
;
--所以在使用条件语句时尽可能使用括号包裹,这样自己更好理解逻辑