--ESCAPE定义_为转义操作符从而失去通配符的作用
INSERT INTO emp
(empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES
    ('7399',
     'MA_%RK',
     'CLERK',
     '7902',
     to_date('15-11-2017', 'dd-mm-yyyy'),
     '950',
     NULL,
     '30');
commit;
SELECT * FROM emp s WHERE s.ename LIKE 'MA_/%RK' ESCAPE '/';
delete emp s where s.empno=7399;
commit;