--6.3计算字符在字符串出现的次数
SELECT (length('HELLO HELLO') - length(REPLACE('HELLO HELLO', 'LL', ''))) /
       length('LL') AS h
FROM dual;