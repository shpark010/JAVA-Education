/*
1���� ����


1. ����Ʈ���� �ٿ�ε�(11g)
https://www.oracle.com/database/technologies/xe=prior-release-downloads.html

2. Oracle ��ġ ( SYS , SYSTEM ������ ���� ��ȣ ���� : 1004)

3. sqlplus -> ���α׷� ����(CMD) : ���� GUI ȯ�� �������� ����

4. ������ ���α׷� ���� Tool
4.1 SqlDeveloper , dbever -> ����
4.2 ��� , ������ , SqlGate -> �������� ���

5. SqlDeveloper ���� >> Oracle ���� ���� >> GUI
5.1 HR ���� (unlock)
-- USER SQL
ALTER USER "HR" IDENTIFIED BY "1004" 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ;
-- QUOTAS
ALTER USER "HR" QUOTA UNLIMITED ON "USERS";
-- ROLES
ALTER USER "HR" DEFAULT ROLE "CONNECT","RESOURCE";
-- SYSTEM PRIVILEGES

5.2 KOSA ���� ����
-- USER SQL
CREATE USER "KOSA" IDENTIFIED BY "1004"  
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";
-- QUOTAS
-- ROLES
GRANT "CONNECT" TO "KOSA" WITH ADMIN OPTION;
GRANT "RESOURCE" TO "KOSA" WITH ADMIN OPTION;
ALTER USER "KOSA" DEFAULT ROLE "CONNECT","RESOURCE";
-- SYSTEM PRIVILEGES

�ǽ��ڵ�

CREATE TABLE EMP
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

COMMIT;

CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;



CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;



DB�о�
������ (CRUD) -> (insert , select , update , delete) >> DML + DDL(create, alter, drop)

������ (DBA) ����ϰ� ���� , ��Ʈ��ũ ���� , �ڿ����� , �ϵ���� ����

Ʃ�� : SQL Ʃ�� (����) >> �ӵ� >> index >> �ڷᱸ��
      �ϵ����(��Ʈ��ũ) Ʃ��

�𵨷� : ���� (PM) -ERD-�䱸���� �м� ERD ����

�м��� (������ �м�) ����� �̻� ... �� read ������ �ڸ� ...

*/

show user;

select * from emp;
select * from dept;
select * from salgrade;
-------------------------------------------------
--1. ������̺��� ��� �����͸� ����ϼ���
select * from emp;
SELECT * FROM EMP;
SELECT * FROM emp;

--2. Ư�� �÷� ������ ����ϱ�
select empno, ename, sal from emp;

--3. ����Ī ����ϱ� (��Ī : alias)
select empno ���, ename �̸� 
from emp;

select empno "��   ��", ename "��   ��" 
from emp;

-- ���� ����(ANSI) >> ǥ�� ���� >> ������ �ۼ��ϸ� (Oracle, Ms-ql, Mysql) ��� ����
select empno as "�� ��" , ename as "�� ��" from emp;

-- Oracle ���ڿ� ������ �����ϰ� ��ҹ��� ����
/*
JAVA : ���� > 'A' , ���ڿ� > "AAAA"
ORACLE : ���ڿ� 'A' , "AAAA" , 'ASDFASDFASDF' -> ORACLE�� ���Ϲ��ڰ� ���� ��� ���ڿ��� �ν��Ѵ�.
ORACLE : �����ͷ� 'a'�� 'A'�� �ٸ���.
*/

select *
from emp
where ename='king'; --��ҹ���

select *
from emp
where ename='KING'; --��ҹ���

/*              ����
select ��        3��
from ��          1��
where ��         2��
*/

--Oracle Query (���Ǿ�) : ���

/*
������
JAVA : + ����(�������) , * ���ڿ�(���տ���)
-----------------------------------------
ORACLE :
���� ������ ||
��� ������ + {�������}

MS-SQL : + (���, ����)
*/


select '����� �̸���' || ename || '�Դϴ�' as �������
from emp;

--���̺��� �⺻ ���� ( �÷���, Ÿ������)
desc emp;
--ENAME             VARCHAR2(10) ���ڿ� Ÿ�� ���հ��� ����

/*
JAVA : class Emp (private int empno, private String ename)
ORACLE : create Table Emp( empno number, ename varchar2(20));
*/

--����ȯ (�ڵ�) >> ���ڸ� ���ڿ��� ��ȯ
select empno || ename from emp;

select empno + ename from emp; --01722. 00000 -  "invalid number"

--����� ... �츮 ȸ�翡 ������ ��� �ֳ�?
select job from emp;

--�ߺ� �� ���� Ű���� : distinct

select distinct job from emp;
--grouping

--distinct
--��̷�
select distinct job , deptno
from emp
order by job;

--Oracle SQL ���
--JAVA : ( + , - , * , / ) ������ %
--ORACLE : ( + , - , * , / ) ������ % �� �ٸ� ���� ��� ... �Լ� mod()
--���ڿ� ���� �˻� : ename like '%��%'

--������̺��� ����� �޿��� 100�޷� �λ��� ����� ����ϼ���
select empno , ename,  sal , sal + 100 as �λ�޿� from emp;

--dual �ӽ� ���̺�
select 100 + 100 from dual;
select 100 || 100 from dual; --100100
select '100' + 100 from dual; --200 --'100' ������ ���� ex)'123456'
select 'A100' + 100 from dual; --Error

--�񱳿�����
-- < > <=
--����
--JAVA : ���� (==) , �Ҵ� (=) , JavaScript : (== , ===)
--ORACLE : ���� = �����ʴ� !=

--�������� (AND, OR, NOT)
select empno , ename , sal
from emp
where sal >= 2000;

--����� 7788���� ����� ���, �̸�, ����, �Ի����� ����ϼ���
select empno, ename, job, hiredate
from emp
where empno=7788;

--����� �̸��� king ����� ���, �̸�, �޿� ������ ����ϼ���
select empno, ename, sal
from emp
where ename='KING';

/*    AND  , OR
 0 0   0     0
 1 0   0     1
 0 1   0     1
 1 1   1     1

*/
--�ʰ� , �̸�
--�̻� , ���� (=)

--�޿��� 2000�޷� �̻��̸鼭 ������ manager �� ����� ��� ������ ����ϼ���
select *
from emp
where sal >= 2000 and job='MANAGER';


--�޿��� 2000�޷� �̻��̰ų� (�Ǵ�) ������ manager �� ����� ��� ������ ����ϼ���
select *
from emp
where sal >= 2000 or job='MANAGER';

--�޿��� 2000�޷� �ʰ��̸鼭 ������ manger �� ����� ��� ������ ����ϼ���
select *
from emp
where sal > 2000 and job='MANAGER';

--����Ŭ ��¥ (DB ������ ��¥)
--sysdate
select sysdate from dual;
--23/04/17

select * from nls_session_parameters;
/*
NLS_LANGUAGE	    KOREAN
NLS_DATE_FORMAT	    RR/MM/DD
NLS_DATE_LANGUAGE   KOREAN
NLS_TIME_FORMAT	    HH24:MI:SSXFF
*/
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
--���� ������ ����ڰ� �� �� �ִ� ��¥�� ������ YYYY-MM-DD HH24:MI:SS�� ����

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select sysdate from dual;  --2023-04-17 14:36:05
--���� >> ȯ�漳�� >> �����ͺ��̽� Ȯ�� >> NLS >> ��¥���� ���� ����

select * from emp;

--��¥ ������ �˻� >> ���ڿ� �˻� ó�� >> '��¥'
select * from emp
where hiredate ='1980-12-17';

select * from emp
where hiredate ='1980.12.17';

select * from emp
where hiredate ='80-12-17'; --���� ��¥ (yyyy--MM--dd)

--����� �޿��� 2000�̻��̰� 4000������ ��� ����� ���� ���
select *
from emp
where sal >= 2000 and sal <= 4000;

--Ŀ���� between A and B ������ (A<= �񱳴�� <=B)
select *
from emp
where sal between 2000 and 4000;

--����� �޿��� 2000�ʰ��̰� 4000�̸��� ��� ����� ���� ���
select *
from emp
where sal > 2000 and sal < 4000;

--�μ���ȣ�� 10�� �Ǵ� 20�� �Ǵ� 30���� ����� ���, �̸�, �޿�, �μ���ȣ�� ���
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;

-- IN ������
select empno, ename, sal, deptno
from emp
where deptno in (10,20,30);

--�μ���ȣ�� 10�� �Ǵ� 20���� �ƴ� ����� ���, �̸�, �޿�, �μ���ȣ�� ���
select empno, ename, sal, deptno
from emp
where deptno != 10 and deptno != 20;

-- NOT IN ������ (IN �������� ����)
select empno, ename, sal, deptno
from emp
where deptno not in (10,20);    --where deptno != 10 and deptno != 20;
--POINT : not in >> != and

--ToDay POINT
-- null�� ���� �̾߱�
-- ���� ����
-- �ʿ��


create table member (
    userid varchar2(20) not null , --null�� ������� �ʰڴ� (�ʼ��Է�)
    name varchar2(20) not null , --�ʼ��Է�
    hobby varchar2(50)  --default null ��� �����Է�...
);
desc member;
insert into member(userid, hobby) values('kim','��');
--ORA-01400: cannot insert NULL into ("KOSA"."MEMBER"."NAME")

insert into member(userid, name) values('hong','ȫ�浿');
commit;
select * from member;
------------------------------------------------------------------------
/*
DB���� ����
Oracle
insert , update , delete ���
�⺻������ Query�� ����� begin tran ������ �ڵ� - �����ڴ� end(�Ϸ�, ���)
����Ŭ�� ������ ... ������ ����� ��ٸ� (commit : �����ݿ�, rollback ���) �۾��Ϸ�

Ms-sql
�ڵ� auto-commit
delete from emp; �ڵ� commit;

begin tran
    delete from emp;
    
    commit , rollback ���� �ʴ� �̻� ������ ó�� �ȵ�.

    commit �ߴٸ� commit�� �����ʹ� �츱 �� ����.
    
    ������ backup �ߴٸ� commit ���� ���� ������ ���� ����

DB Transaction : ������ �۾� ���� (����, ����)
OLTP (On-Line Transaction Processing): (�� ȯ�� : �ǽð� ������ ó��) > Ʈ�����
ex) ������� ��ü
begin tran
    update ... ���� -1000
    update ... �������� +1000
end

OLAP (On-Line Analycial Processing) : (������ �м� : �����Ⱓ ������ ��Ƽ� �м�)

*******����Ŭ ���� insert , update , delete �ϸ� �ݵ��
******commit , rollback ó�� ���� �����ؾ� �Ѵ�.
*/
------------------------------------------------------------------------
--����(comm) �� ���� �ʴ� ���� ����� ������ ����ϼ���.
--�ǽ� ������ 0�� �ִµ� ������ �޴� ������ ������

--comm �÷��� �����Ͱ� null�ΰ͸�
select *
from emp
where comm = null; --null�� =�� ���� �� ����.

select *
from emp
where comm is null;
--dkarl ( null�� �񱳴� is null )

--comm�� �޴� ����� (comm�÷��� �����Ͱ� null�� �ƴѰ�)
select *
from emp
where comm is not null;

--������̺��� ��� , �̸� , �޿� , ���� , �ѱ޿�(�޿� + ����)�� ����ϼ���
select empno , ename , sal , comm , sal + comm as �ѱ޿�
from emp;

/*
null �̶� �༮
1. null ���� ��� ���� ����� null ex) null+100 = null
2. null �̶� �༮�� ����... �Լ� > nvl(), nvl2()

����
nvl(�÷���, ��ü��) >> ġȯ

Tip)
Mysql > null > IFNULL() > select ifnull(null,'')
MS-sql > null > Convert() >
*/

select empno , ename , sal , comm , sal + nvl(comm,0) as �ѱ޿�
from emp;

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual;
select comm , nvl(comm, 111111) from emp;
select nvl(null,'hello world') from dual;

--����� �޿��� 1000�̻��̰� ������ ���� �ʴ� ����� ���, �̸�, ����, �޿�, ������ ����ϼ���
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and nvl(comm,0)=0;

--���ڿ� �˻�
--�ּҰ˻� >> ���� >> ���� �ܾ �ִ� ��� �ּҰ� ������ ��
--Like ���ڿ� ���ϰ˻�
--���ϵ�ī�� ( %(����) , _(�ѹ���) )

select *
from emp
where ename like '%A%';

select *
from emp
where ename like 'A%'; --A�� �����ϴ� ����

select *
from emp
where ename like '%E'; --E�� ������ ����

select *
from emp
where ename like '%LL%';

select *
from emp
where ename like '%A%A%'; --A�� �ΰ�

select *
from emp
where ename like '_A%'; --�ι�° ���ڴ� A�̰� ...


--����ǥ���� regexp_like()
select * from emp where regexp_like (ename,'[A-C]');
--���� (����ǥ���� 5�� �����) ���� ī�信 �ø��� �ϱ�

--������ �����ϱ�
--order by �÷��� : ���� , ���� , ��¥ ���� ����
--�������� : asc : ������ : default
--�������� : desc : ������
--����(�˰���) >> ����� ���� ��� �۾�(cost)

select *
from emp
order by sal; --default order by sal asc

select *
from emp
order by sal desc;

--�Ի����� ���� ���� ������ �����ؼ� ��� , �̸� , �޿� , �Ի��� ���
--���� �ֱٿ� �Ի��� ������
select empno , ename , sal , hiredate
from emp
order by hiredate desc;

/*         ����
select��    3��
from��      1��
where��     2��
order by��  4��
*/

--�ؼ��غ���
--emp���� ������ 'Manager'�� ����� ���, �̸�, �޿�, ����, �Ի����� �Ի����� ���� ������ ��� 
select empno , ename , sal , job , hiredate
from emp
where job='Manager'
order by hiredate desc;

--�ؼ��غ���
--emp ���� ������ �μ���ȣ�� �����̸����� ���� �������� �����ϰ� �μ���ȣ�� �������� ������ ���� ��� 
select job, deptno
from emp
order by job asc , deptno desc; --�߿� (�亯�� �Խ��� ... ���) >> grouping
--order by �÷��� asc , �÷��� asc , ...

--������
--������(union) : ���̺�� ���̺��� �����͸� ��ġ�� �� (�ߺ��� ����)
--������(union all) : ���̺�� ���̺��� �����͸� ��ġ�� �� (�ߺ��� ���)

create table uta(name varchar2(20));
insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');
commit;

create table ut(name varchar2(20));
insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');
commit;

select * from uta;
select * from ut;

select * from ut
union
select * from uta;
--ut ���� uta �ı����� ����� �� (�ߺ� ������ ����)

select * from ut
union all
select * from uta;
--ut ���� uta �ı����� ����� �� (�ߺ� ������ ���� �ȵ�)

--union
--1. [����]�Ǵ� [�÷�]�� [Ÿ��]�� ���� �ؾ� �Ѵ�.

select empno , ename from emp --���� , ���ڿ�
union
select dname , deptno from dept; --���ڿ� , ����

select empno , ename from emp --���� , ���ڿ�
union
select deptno , dname from dept; --���� , ���ڿ�
--���� ���߿� subquery�� ����ؼ� ���� ���̺�...
select *
from (
    select empno , ename from emp
    union
    select deptno , dname from dept
    ) m
order by m.empno desc; --in-line view

--2. [����]�Ǵ� [�÷�]�� [����]�� ���� �ؾ� �Ѵ�.
-- �ʿ�� (null) �÷��� ��ü
select empno , ename , job , sal from emp
union
select deptno , dname , loc , null from dept;









