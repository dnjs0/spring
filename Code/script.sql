-- Code > script.sql

--코드 조각 관리
--1. 코드 조각 테이블(게시물)
--2. 언어 테이블(카테고리)

create table tblLanguage(
    name varchar(100) primary key,      --언어(PK)
    icon varchar(100) not null,         --아이콘
    color varchar(10) not null          --색상
);

insert into tblLanguage values('Java','fa-brands fa-js','#9FB3DF');
insert into tblLanguage values('SQL','fa-solid fa-database','#9EC6F3');
insert into tblLanguage values('HTML','fa-brands fa-html5','#BDDDE4');
insert into tblLanguage values('CSS','fa-brands fa-css','#FFF1D5');
insert into tblLanguage values('JavaScript','fa-brands fa-js','#6F826A');

commit;

create table tblCode(
    seq number primary key,                                         --번호(PK)
    subject varchar2(300) not null,                                 --제목
    code varchar2(2000) not null,                                   --코드
    regdate date default sysdate not null,                          --날짜
    language varchar2(100) not null references tblLanguage(name)    --언어(FK)
);




create sequence seqCode;


select * from tblcode;

select 
    tblCode.*,
    (select icon from tblLanguage where name = tblCode.language) as icon,
    (select color from tblLanguage where name = tblCode.language) as color
from tblCode
    order by seq desc;


select *
from tblCode c
    inner join tblLanguage l
        on c.language = l.name;














