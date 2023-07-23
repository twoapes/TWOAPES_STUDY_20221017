1.检索记录
--1.1从表中检索所有行列
SELECT * FROM scott.emp;
--1.2从表中检索部分行
SELECT * FROM scott.emp s WHERE s.deptno = 10;
--1.3查找满足多个条件的行
SELECT *
FROM scott.emp s
WHERE s.deptno = 10 --deptno=10
   OR s.comm IS NOT NULL --或comm不是NULL
   OR s.sal <= 2000 --或sal小于2000
    AND s.deptno = 20; --并且deptno=20
/*1.3.1等同于*/
SELECT *
FROM scott.emp s
WHERE (s.deptno = 10 --deptno=10
    OR s.comm IS NOT NULL) --或comm不是NULL
   OR (s.sal <= 2000 AND s.deptno = 20) --或sal小于2000并且deptno=20
;
/*1.3.2等同于*/
SELECT *
FROM scott.emp s
WHERE (s.deptno = 10 --deptno=10
    OR s.comm IS NOT NULL --或comm不是NULL
          )
UNION
SELECT *
FROM scott.emp s
WHERE (s.sal <= 2000 AND s.deptno = 20) --sal小于2000并且deptno=20
;
/*1.3.3如果用此括号方式,含义就不一样了*/
SELECT *
FROM scott.emp s
WHERE (s.deptno = 10 --deptno=20中存在deptno=10
    OR s.comm IS NOT NULL OR s.sal <= 2000) --或comm不是NULL或sal小于等于2000
  AND s.deptno = 20;
/*1.3.4查看deptno = 20结果,很明显不能满足deptno=10,也不能满足comm不是NULL,
但是满足了sal小于2000存在两条,所以得出1.3.3代码中最终显示结果*/
SELECT * FROM scott.emp s WHERE s.deptno = 20;
--1.4从表中检索部分列
SELECT s.ename, s.deptno, s.sal FROM scott.emp s; --这样可以不用返回多余字段,也可以节约时间
--1.5为列取有意义的名称
SELECT s.sal AS 工资, s.comm AS 奖金 FROM scott.emp s;
--1.6在WHERE子句中引用取别名的列
SELECT *
FROM (SELECT s.sal AS 工资, s.comm AS 奖金 FROM scott.emp s) k
WHERE k.奖金 IS NOT NULL
  AND k.工资 = 1250;
--1.7连接列值s
SELECT s.ename, s.job,
       s.mgr
FROM scott.emp s;
SELECT s.ename || '的工作是' || decode(s.mgr,
                                       NULL,
                                       '董事长',
                                       decode(s.job,
                                              'CLERK',
                                              '员工',
                                              'SALESMAN',
                                              '员工',
                                              'MANAGER',
                                              '员工',
                                              'ANALYST',
                                              '员工')) AS ename_job,
       s.mgr
FROM scott.emp s;
--1.8在select语句中使用条件逻辑
SELECT s.ename,
       s.sal,
       (CASE
            WHEN s.sal <= 2000 THEN
                '所得报酬过低'
            WHEN s.sal >= 4000 THEN
                '所得报酬过高'
            ELSE
                '一般'
           END) AS status --状态
FROM scott.emp s;
--1.9限制返回的行数
SELECT * FROM scott.emp s WHERE rownum <= 5;
--1.10从表中随机返回n条记录
SELECT ename, job
FROM (SELECT s.ename, s.job FROM scott.emp s ORDER BY dbms_random.value()) k
WHERE rownum <= 5;
--1.11查找空值
SELECT *
FROM scott.emp s
WHERE s.comm IS NULL
  AND s.mgr IS NOT NULL;
--1.12将空值转换为实际值
SELECT coalesce(s.comm, 0) AS comm FROM scott.emp s; --从左往右数,遇到第一个非null值,则返回该非null值.
/*等同于
*/
SELECT nvl(s.comm, 0) AS comm FROM scott.emp s; --如果第一个参数为null,则返回第二个参数,反之返回第一个参数
/*第一点区别:nvl只适合于两个参数的,COALESCE适合于多个参数.
第二点区别:COALESCE里的所有参数类型必须保持一致,nvl可以不一致.*/
--1.13按模式搜索
SELECT s.ename, s.job FROM scott.emp s WHERE s.deptno IN (10, 20);
SELECT s.ename, s.job
FROM scott.emp s
WHERE s.deptno IN (10, 20)
  AND (s.ename LIKE '%CLAR%' OR s.ename LIKE '%S');