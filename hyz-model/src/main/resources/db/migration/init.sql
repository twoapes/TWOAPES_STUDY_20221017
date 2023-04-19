-- oracle
create table STUDENT
(
    ID   NUMBER(20) not null primary key,
    NAME VARCHAR2(20),
    AGE  NUMBER(20)
)
comment on table STUDENT is 'student table'
comment on column STUDENT.ID is 'id'
comment on column STUDENT.NAME is 'name'
comment on column STUDENT.AGE is 'age'
/

-- mysql
create table STUDENT
(
    ID   int         null comment 'id',
    NAME varchar(20) null comment 'name',
    AGE  int         null comment 'age'
);

create unique index STUDENT_ID_INDEX on STUDENT (ID);
alter table STUDENT add constraint STUDENT_PK primary key (ID);
alter table STUDENT comment 'student table';
insert into STUDENT (ID, NAME, AGE) values (1, 'ZhangSan', 18);
insert into STUDENT (ID, NAME, AGE) values (2, 'LiSI', 22);


