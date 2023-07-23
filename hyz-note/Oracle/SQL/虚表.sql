--系统常用表语句
SELECT SYSDATE FROM dual; --可将SYSDATE 视为一个其结果为当前日期和时间的函数,在任何可以使用Oracle函数的地方都可以使用Sysdate.也可以将它视为每个表的一个隐藏的列或伪列.
SELECT current_date FROM dual; --报告会话的时区中的系统日期.注:可以设置自己的时区,以区别于数据库的时区.
SELECT systimestamp FROM dual; --报告TIMESTAMP数据类型格式的系统日期.