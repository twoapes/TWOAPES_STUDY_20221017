--获得当年实际天数
SELECT add_months(trunc(SYSDATE, 'YYYY'), 12) - trunc(SYSDATE, 'YYYY') days
FROM dual;