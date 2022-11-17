-- oracle
create table STUDENT
(
    ID   NUMBER(20) not null
        primary key,
    NAME VARCHAR2(20),
    AGE  NUMBER(20)
)
/
comment on table STUDENT is 'student table'
/
comment on column STUDENT.ID is 'id'
/

comment on column STUDENT.NAME is 'name'
/

comment on column STUDENT.AGE is 'age'
/



-- mysql
create table STUDENT
(
    ID   int         null comment 'id',
    NAME varchar(20) null comment 'name',
    AGE  int         null comment 'age'
);

create unique index STUDENT_ID_uindex
    on STUDENT (ID);

alter table STUDENT
    add constraint STUDENT_pk
        primary key (ID);
alter table student comment 'student table';



INSERT INTO STUDENT (ID, NAME, AGE) VALUES (1, 'ZhangSan', 18);
INSERT INTO STUDENT (ID, NAME, AGE) VALUES (2, 'LiSI', 22);
/


