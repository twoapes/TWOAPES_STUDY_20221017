DECLARE
    v_size NUMBER := 0;
    v_avg  NUMBER := 10000;
    i      NUMBER := 0;
BEGIN
    SELECT COUNT(1) n INTO v_size FROM table_name;
    dbms_output.put_line('总数据量为:' || v_size);
    IF MOD(v_size, v_avg) = 0 THEN
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
            DELETE table_name WHERE rownum BETWEEN 1 AND v_avg;
            dbms_output.put_line('已删除 x:' || i);
            COMMIT;
        END LOOP;
END;