--默认时数字和日期从小到大字符型数据的按ASCII码的次序
SELECT s.empno ,s.ename, s.sal
FROM emp s
WHERE s.sal >= 1500
ORDER BY s.empno; --升序
SELECT s.empno ,s.ename, s.sal
FROM emp s
WHERE s.sal >= 1500
ORDER BY s.empno DESC; --降序
