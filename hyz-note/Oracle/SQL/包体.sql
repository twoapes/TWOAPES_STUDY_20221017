--查询包体
SELECT s.owner, s.name, s.text, s.line
FROM all_source s
WHERE TYPE = 'PACKAGE BODY';
SELECT s.name, s.text, s.line
FROM user_source s
WHERE TYPE = 'PACKAGE BODY';