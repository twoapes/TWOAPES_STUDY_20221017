--4.1插入新记录
SELECT * FROM scott.dept;
INSERT INTO scott.dept
(deptno, total_sal, total_bonus)
VALUES
    (30, 'SALES2', 'CHICAGO');
ROLLBACK; --为不影响数据,后面的都使用ROLLBACK,能执行不报错显示插入个成功一行即代表已成功即可
--4.2插入默认值
INSERT INTO scott.emp (empno, comm) VALUES (0, DEFAULT);
ROLLBACK;
--4.3用NULL值代替默认值
INSERT INTO scott.emp (empno, comm) VALUES (0, NULL);
ROLLBACK;
--4.4从一个表中从另一个表中复制行
INSERT INTO scott.dept
(deptno, dname, loc)
SELECT s.deptno + 40, s.dname, s.loc
FROM scott.dept s
WHERE s.loc IN ('深圳', '广州');
ROLLBACK;
--4.5复制表定义
--复制定义可以不需要数据,使用0=1使其不返回数据
CREATE TABLE bonus_test AS
SELECT * FROM scott.bonus s WHERE 0 = 1;
SELECT * FROM bonus_test;
drop TABLE bonus_test;
--4.6一次向多个表中插入记录
CREATE TABLE dept_east AS --东
SELECT * FROM scott.dept s WHERE 0 = 1;
CREATE TABLE dept_north AS --北
SELECT * FROM scott.dept s WHERE 0 = 1;
CREATE TABLE dept_south AS --南
SELECT * FROM scott.dept s WHERE 0 = 1;
CREATE TABLE dept_west AS --西
SELECT * FROM scott.dept s WHERE 0 = 1;
INSERT ALL WHEN loc IN
                ('上海', '江苏') THEN INTO dept_east
(deptno, dname, loc)
VALUES
    (deptno, dname, loc) WHEN loc = '北京' THEN INTO dept_north
(deptno, dname, loc)
VALUES
    (deptno, dname, loc) WHEN loc IN
                              ('湖南', '深圳', '广州') THEN INTO dept_south
(deptno, dname, loc)
VALUES
    (deptno, dname, loc) ELSE INTO dept_west
(deptno, dname, loc)
VALUES
    (deptno, dname, loc)
SELECT deptno, dname, loc FROM scott.dept;
COMMIT;
SELECT * FROM dept_east; --东
SELECT * FROM dept_south; --南
SELECT * FROM dept_west; --西
SELECT * FROM dept_north; --北
drop TABLE dept_east; --东
drop TABLE dept_south; --南
drop TABLE dept_west; --西
drop TABLE dept_north; --北
--4.7阻止对某几列插入/*创建视图,视图的插入只适用于简单的视图,它实际上会转换插入到原表*/
CREATE OR REPLACE view sqlcook_emp_4_7 AS
SELECT empno, ename, job FROM scott.emp;
SELECT * FROM sqlcook_emp_4_7;
INSERT INTO sqlcook_emp_4_7
(empno, ename, job)
VALUES
    (0, '二次猿', '会计');
ROLLBACK;
--4.8在表中编辑记录
SELECT * FROM scott.emp;
UPDATE scott.emp s SET s.sal = s.sal * 1.1 WHERE s.deptno = 10;
ROLLBACK;
--4.9当对应行存在时更新
SELECT * FROM scott.emp;
SELECT * FROM scott.bonus;
UPDATE scott.emp
SET sal = sal * 1.3
WHERE EXISTS (SELECT s.job FROM scott.bonus s WHERE s.job = job);
ROLLBACK;
--4.10用其他的表中的值更新
SELECT s.empno, s.ename, s.job, s.mgr, s.hiredate, s.sal, s.comm, s.deptno
FROM scott.emp s;
SELECT s.deptno, s.dname, s.loc FROM scott.dept s;
UPDATE (SELECT s.empno,
               s.ename,
               s.deptno AS emp_deptno,
               o.deptno AS deptno,
               s.job    AS job,
               o.dname  AS dname,
               o.loc    AS loc
        FROM scott.emp s
                 JOIN scott.dept o
                      ON s.deptno = o.deptno
        WHERE length(dname) <= 9 --job只能允许九个字符串以内,定义这个条件以便不影响数据更新
)
SET emp_deptno = deptno, job = dname;
ROLLBACK;
--4.11合并记录
CREATE TABLE sqlcook_emp_4_11 AS
SELECT s.deptno, s.empno, s.ename, s.comm
FROM scott.emp s
WHERE s.deptno = 10;
SELECT s.deptno, s.empno, s.ename, s.comm FROM sqlcook_emp_4_11 s;
MERGE INTO sqlcook_emp_4_11 ec
USING (SELECT * FROM scott.emp) emp
ON (ec.empno = emp.empno)
WHEN MATCHED THEN
    UPDATE SET ec.comm = 1000 DELETE WHERE (emp.sal < 2000)
WHEN NOT MATCHED THEN
    INSERT
    (ec.empno, ec.ename, ec.deptno, ec.comm)
    VALUES
        (emp.empno, emp.ename, emp.deptno, emp.comm);
SELECT * FROM sqlcook_emp_4_11;
COMMIT;
SELECT s.deptno, s.empno, s.ename, s.comm FROM scott.emp s;
--4.12从表中删除所有记录
DELETE FROM scott.emp;
ROLLBACK;
--4.13从表中删除指定记录
DELETE FROM scott.emp s WHERE s.deptno = 10;
ROLLBACK;
--4.14删除单个记录
DELETE FROM scott.emp s WHERE s.empno = 2017;
ROLLBACK;
--4.15删除违反参照完整性的记录
DELETE scott.emp s
WHERE EXISTS (SELECT o.deptno FROM scott.dept o WHERE s.deptno = o.deptno);
ROLLBACK;
--4.16删除重复记录
SELECT s.empno, s.job FROM scott.emp s;
SELECT MIN(s.empno), s.job FROM scott.emp s GROUP BY s.job;
DELETE scott.emp s
WHERE s.empno NOT IN (SELECT MIN(s.empno) FROM scott.emp s GROUP BY s.job);
ROLLBACK;
--4.17删除从其他表引用的记录
DELETE scott.emp s
WHERE s.deptno IN (SELECT o.deptno
                   FROM scott.dept o
                   HAVING COUNT(*) = 1
                   GROUP BY o.deptno);
ROLLBACK;