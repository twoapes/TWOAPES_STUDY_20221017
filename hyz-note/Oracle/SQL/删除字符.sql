--6.4从字符串中删除不需要的字符
--'a'起到占位符.无实际意义
SELECT ename,
       REPLACE(translate(ename, 'AEIOU', 'a'), 'a') AS stripped1,
       sal,
       REPLACE(sal, 0, '') AS stripped2
FROM scott.emp;
SELECT REPLACE(translate('EAECOUUUU', 'AEIOU', 'a'), 'a') AS stripped1
FROM dual;