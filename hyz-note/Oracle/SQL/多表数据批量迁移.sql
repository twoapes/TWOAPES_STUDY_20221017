DECLARE
    v_size NUMBER := 0;
    v_avg NUMBER := 10000;
    i NUMBER := 0;
BEGIN
    SELECT COUNT(1) n INTO v_size FROM TABLE_NAME;
    dbms_output.put_line('总数据量为:' || v_size);
    IF mod(v_size , v_avg) = 0 THEN
        v_size := v_size / v_avg;
    ELSE
        IF v_size / v_avg - trunc(v_size / v_avg) > 0 THEN
            v_size := trunc(v_size / v_avg) + 1;
        ELSE
            v_size := trunc(v_size / v_avg);
        END IF;
    END IF;
    dbms_output.put_line('每次执行:' || v_avg || '条');
    FOR i IN 1 .. v_size LOOP
            INSERT INTO TABLE_NAME1
            SELECT *
            FROM (SELECT a.*, rownum rn
                  FROM (SELECT * FROM TABLE_NAME) a
                  WHERE rownum <= i * v_avg)
            WHERE rn >= ((i-1) * v_avg) + 1;
            dbms_output.put_line('已新增 x:' || i);
            COMMIT;
        END LOOP;
END;