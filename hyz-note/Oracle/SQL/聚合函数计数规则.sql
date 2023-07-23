--coalesce和nvl会忽略NULL值不计数
SELECT AVG(coalesce(comm, 0)) AS avg_comm FROM scott.emp WHERE deptno = 30; --366.666666666667
SELECT AVG(nvl(comm, 0)) AS avg_comm FROM scott.emp WHERE deptno = 30; --当存在comm为null则为0,所以加起来为366.666666666667
SELECT AVG(nvl(comm, 1)) AS avg_comm FROM scott.emp WHERE deptno = 30; --当存在comm为null则为1,所以加起来为367
SELECT AVG(comm) AS avg_comm FROM scott.emp WHERE deptno = 30; --550