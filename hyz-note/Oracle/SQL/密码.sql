--查看密码到期时间
SELECT *
FROM dba_profiles
WHERE profile = 'DEFAULT'
  AND resource_name = 'PASSWORD_LIFE_TIME'
--去除密码到期
ALTER profile DEFAULT LIMIT password_life_time unlimited;