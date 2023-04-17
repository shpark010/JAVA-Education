/*
1일차 수업


1. 소프트웨어 다운로드(11g)
https://www.oracle.com/database/technologies/xe=prior-release-downloads.html

2. Oracle 설치 ( SYS , SYSTEM 계정에 대한 암호 설정 : 1004)

3. sqlplus -> 프로그램 제공(CMD) : 단점 GUI 환경 제공하지 않음

4. 별도의 프로그램 접속 Tool
4.1 SqlDeveloper , dbever -> 무료
4.2 토드 , 오렌지 , SqlGate -> 현업에서 사용

5. SqlDeveloper 실행 >> Oracle 서버 접속 >> GUI
5.1 HR 계정 (unlock)
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

5.2 KOSA 계정 생성
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

실습코드

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



DB분야
개발자 (CRUD) -> (insert , select , update , delete) >> DML + DDL(create, alter, drop)

관리자 (DBA) 백업하고 복원 , 네트워크 관리 , 자원관리 , 하드웨어 관리

튜너 : SQL 튜너 (문장) >> 속도 >> index >> 자료구조
      하드웨어(네트어크) 튜너

모델러 : 설계 (PM) -ERD-요구사항 분석 ERD 추출

분석가 (데이터 분석) 석사급 이상 ... 논문 read 가능한 자만 ...

*/

show user;

select * from emp;
select * from dept;
select * from salgrade;
-------------------------------------------------
--1. 사원테이블에서 모든 데이터를 출력하세요
select * from emp;
SELECT * FROM EMP;
SELECT * FROM emp;

--2. 특정 컬럼 데이터 출력하기
select empno, ename, sal from emp;

--3. 가명칭 사용하기 (별칭 : alias)
select empno 사번, ename 이름 
from emp;

select empno "사   번", ename "이   름" 
from emp;

-- 권장 문법(ANSI) >> 표준 문법 >> 구문을 작성하면 (Oracle, Ms-ql, Mysql) 모두 동작
select empno as "사 번" , ename as "이 름" from emp;

-- Oracle 문자열 데이터 엄격하게 대소문자 구별
/*
JAVA : 문자 > 'A' , 문자열 > "AAAA"
ORACLE : 문자열 'A' , "AAAA" , 'ASDFASDFASDF' -> ORACLE은 단일문자가 없고 모두 문자열로 인식한다.
ORACLE : 데이터로 'a'와 'A'는 다르다.
*/

select *
from emp
where ename='king'; --대소문자

select *
from emp
where ename='KING'; --대소문자

/*              순서
select 절        3번
from 절          1번
where 절         2번
*/

--Oracle Query (질의어) : 언어

/*
연산자
JAVA : + 숫자(산술연산) , * 문자열(결합연산)
-----------------------------------------
ORACLE :
결합 연산자 ||
산술 연산자 + {산술연산}

MS-SQL : + (산술, 결합)
*/


select '사원의 이름은' || ename || '입니다' as 사원정보
from emp;

--테이블의 기본 정보 ( 컬럼명, 타입정보)
desc emp;
--ENAME             VARCHAR2(10) 문자열 타입 결합가능 인지

/*
JAVA : class Emp (private int empno, private String ename)
ORACLE : create Table Emp( empno number, ename varchar2(20));
*/

--형변환 (자동) >> 숫자를 문자열로 변환
select empno || ename from emp;

select empno + ename from emp; --01722. 00000 -  "invalid number"

--사장님 ... 우리 회사에 직종이 몇개나 있나?
select job from emp;

--중복 행 제거 키워드 : distinct

select distinct job from emp;
--grouping

--distinct
--재미로
select distinct job , deptno
from emp
order by job;

--Oracle SQL 언어
--JAVA : ( + , - , * , / ) 나머지 %
--ORACLE : ( + , - , * , / ) 나머지 % 는 다른 곳에 사용 ... 함수 mod()
--문자열 패턴 검색 : ename like '%신%'

--사원테이블에서 사원의 급여를 100달러 인상한 결과를 출력하세요
select empno , ename,  sal , sal + 100 as 인상급여 from emp;

--dual 임시 테이블
select 100 + 100 from dual;
select 100 || 100 from dual; --100100
select '100' + 100 from dual; --200 --'100' 숫자형 문자 ex)'123456'
select 'A100' + 100 from dual; --Error

--비교연산자
-- < > <=
--주의
--JAVA : 같다 (==) , 할당 (=) , JavaScript : (== , ===)
--ORACLE : 같다 = 같지않다 !=

--논리연산자 (AND, OR, NOT)
select empno , ename , sal
from emp
where sal >= 2000;

--사번이 7788번이 사원의 사번, 이름, 직종, 입사일을 출력하세요
select empno, ename, job, hiredate
from emp
where empno=7788;

--사원의 이름이 king 사원의 사번, 이름, 급여 정보를 출력하세요
select empno, ename, sal
from emp
where ename='KING';

/*    AND  , OR
 0 0   0     0
 1 0   0     1
 0 1   0     1
 1 1   1     1

*/
--초과 , 미만
--이상 , 이하 (=)

--급여가 2000달러 이상이면서 직종이 manager 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal >= 2000 and job='MANAGER';


--급여가 2000달러 이상이거나 (또는) 직종이 manager 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal >= 2000 or job='MANAGER';

--급여가 2000달러 초과이면서 직종이 manger 인 사원의 모든 정보를 출력하세요
select *
from emp
where sal > 2000 and job='MANAGER';

--오라클 날짜 (DB 서버의 날짜)
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
--현재 접속한 사용자가 쓸 수 있는 날짜의 형식을 YYYY-MM-DD HH24:MI:SS로 변경

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select sysdate from dual;  --2023-04-17 14:36:05
--도구 >> 환경설정 >> 데이터베이스 확장 >> NLS >> 날짜형식 수정 가능

select * from emp;

--날짜 데이터 검색 >> 문자열 검색 처럼 >> '날짜'
select * from emp
where hiredate ='1980-12-17';

select * from emp
where hiredate ='1980.12.17';

select * from emp
where hiredate ='80-12-17'; --현재 날짜 (yyyy--MM--dd)

--사원의 급여가 2000이상이고 4000이하인 모든 사원의 정보 출력
select *
from emp
where sal >= 2000 and sal <= 4000;

--커럼명 between A and B 연산자 (A<= 비교대상 <=B)
select *
from emp
where sal between 2000 and 4000;

--사원의 급여가 2000초과이고 4000미만인 모든 사원의 정보 출력
select *
from emp
where sal > 2000 and sal < 4000;

--부서번호가 10번 또는 20번 또는 30번인 사원의 사번, 이름, 급여, 부서번호를 출력
select empno, ename, sal, deptno
from emp
where deptno=10 or deptno=20 or deptno=30;

-- IN 연산자
select empno, ename, sal, deptno
from emp
where deptno in (10,20,30);

--부서번호가 10번 또는 20번이 아닌 사원의 사번, 이름, 급여, 부서번호를 출력
select empno, ename, sal, deptno
from emp
where deptno != 10 and deptno != 20;

-- NOT IN 연산자 (IN 연산자의 부정)
select empno, ename, sal, deptno
from emp
where deptno not in (10,20);    --where deptno != 10 and deptno != 20;
--POINT : not in >> != and

--ToDay POINT
-- null에 대한 이야기
-- 값이 없다
-- 필요악


create table member (
    userid varchar2(20) not null , --null을 허용하지 않겠다 (필수입력)
    name varchar2(20) not null , --필수입력
    hobby varchar2(50)  --default null 허용 선택입력...
);
desc member;
insert into member(userid, hobby) values('kim','농구');
--ORA-01400: cannot insert NULL into ("KOSA"."MEMBER"."NAME")

insert into member(userid, name) values('hong','홍길동');
commit;
select * from member;
------------------------------------------------------------------------
/*
DB마다 설정
Oracle
insert , update , delete 명령
기본적으로 Query문 실행시 begin tran 구문이 자동 - 개발자는 end(완료, 취소)
오라클은 대기상태 ... 마지막 명령을 기다림 (commit : 실제반영, rollback 취소) 작업완료

Ms-sql
자동 auto-commit
delete from emp; 자동 commit;

begin tran
    delete from emp;
    
    commit , rollback 하지 않는 이상 데이터 처리 안됨.

    commit 했다면 commit한 데이터는 살릴 수 없다.
    
    하지만 backup 했다면 commit 이전 시점 데이터 복원 가능

DB Transaction : 논리적인 작업 단위 (성공, 실패)
OLTP (On-Line Transaction Processing): (웹 환경 : 실시간 데이터 처리) > 트랜잭션
ex) 은행업무 이체
begin tran
    update ... 계좌 -1000
    update ... 동생계좌 +1000
end

OLAP (On-Line Analycial Processing) : (데이터 분석 : 인정기간 데이터 모아서 분석)

*******오라클 에서 insert , update , delete 하면 반드시
******commit , rollback 처리 여부 결정해야 한다.
*/
------------------------------------------------------------------------
--수당(comm) 을 받지 않는 몯는 사원의 정보를 출력하세요.
--실습 데이터 0이 있는데 데이터 받는 것으로 보세요

--comm 컬럼의 데이터가 null인것만
select *
from emp
where comm = null; --null은 =로 비교할 수 없다.

select *
from emp
where comm is null;
--dkarl ( null의 비교는 is null )

--comm을 받는 사원들 (comm컬럼의 데이터가 null이 아닌것)
select *
from emp
where comm is not null;

--사원테이블에서 사번 , 이름 , 급여 , 수당 , 총급여(급여 + 수당)을 출력하세요
select empno , ename , sal , comm , sal + comm as 총급여
from emp;

/*
null 이란 녀석
1. null 과의 모든 연산 결과는 null ex) null+100 = null
2. null 이란 녀석을 위해... 함수 > nvl(), nvl2()

사용법
nvl(컬럼명, 대체값) >> 치환

Tip)
Mysql > null > IFNULL() > select ifnull(null,'')
MS-sql > null > Convert() >
*/

select empno , ename , sal , comm , sal + nvl(comm,0) as 총급여
from emp;

select 1000 + null from dual;
select 1000 + nvl(null,0) from dual;
select comm , nvl(comm, 111111) from emp;
select nvl(null,'hello world') from dual;

--사원의 급여가 1000이상이고 수당을 받지 않는 사원의 사번, 이름, 직종, 급여, 수당을 출력하세요
select empno, ename, job, sal, comm
from emp
where sal >= 1000 and nvl(comm,0)=0;

--문자열 검색
--주소검색 >> 역삼 >> 역삼 단어가 있는 모든 주소가 나오는 것
--Like 문자열 패턴검색
--와일드카드 ( %(모든것) , _(한문자) )

select *
from emp
where ename like '%A%';

select *
from emp
where ename like 'A%'; --A로 시작하는 모든것

select *
from emp
where ename like '%E'; --E로 끝나는 모든것

select *
from emp
where ename like '%LL%';

select *
from emp
where ename like '%A%A%'; --A가 두개

select *
from emp
where ename like '_A%'; --두번째 글자는 A이고 ...


--정규표현식 regexp_like()
select * from emp where regexp_like (ename,'[A-C]');
--과제 (정규표현식 5개 만들기) 추후 카페에 올리면 하기

--데이터 정렬하기
--order by 컬럼명 : 문자 , 숫자 , 날짜 정렬 가능
--오름차순 : asc : 낮은순 : default
--내림차순 : desc : 높은순
--정렬(알고리즘) >> 비용이 많이 드는 작업(cost)

select *
from emp
order by sal; --default order by sal asc

select *
from emp
order by sal desc;

--입사일이 가장 늦은 순으로 정렬해서 사번 , 이름 , 급여 , 입사일 출력
--가장 최근에 입사한 순으로
select empno , ename , sal , hiredate
from emp
order by hiredate desc;

/*         순서
select절    3번
from절      1번
where절     2번
order by절  4번
*/

--해석해보기
--emp에서 직업이 'Manager'인 사원의 사번, 이름, 급여, 직업, 입사일을 입사일이 늦은 순으로 출력 
select empno , ename , sal , job , hiredate
from emp
where job='Manager'
order by hiredate desc;

--해석해보기
--emp 에서 직업과 부서번호를 직업이름으로 먼저 오름차순 정렬하고 부서번호로 내림차순 정렬한 값을 출력 
select job, deptno
from emp
order by job asc , deptno desc; --중요 (답변형 게시판 ... 사용) >> grouping
--order by 컬럼명 asc , 컬럼명 asc , ...

--연산자
--합집합(union) : 테이블과 테이블의 데이터를 합치는 것 (중복값 배제)
--합집합(union all) : 테이블과 테이블의 데이터를 합치는 것 (중복값 허용)

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
--ut 집에 uta 식구들이 놀러가는 것 (중복 데이터 제거)

select * from ut
union all
select * from uta;
--ut 집에 uta 식구들이 놀러가는 것 (중복 데이터 제거 안됨)

--union
--1. [대응]되는 [컬럼]의 [타입]이 동일 해야 한다.

select empno , ename from emp --숫자 , 문자열
union
select dname , deptno from dept; --문자열 , 숫자

select empno , ename from emp --숫자 , 문자열
union
select deptno , dname from dept; --숫자 , 문자열
--순서 나중에 subquery를 사용해서 가상 테이블...
select *
from (
    select empno , ename from emp
    union
    select deptno , dname from dept
    ) m
order by m.empno desc; --in-line view

--2. [대응]되는 [컬럼]의 [개수]가 동일 해야 한다.
-- 필요악 (null) 컬럼의 대체
select empno , ename , job , sal from emp
union
select deptno , dname , loc , null from dept;









