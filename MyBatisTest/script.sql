-- spring
drop table tbladdress;
delete from tbladdress;


create table tblAddress (
    seq number primary key,
    name varchar2(30) not null,
    age number not null,
    address varchar2(100) not null,
    gender char(1) not null
);

drop sequence seqAddress;
create sequence seqAddress;

insert into tblAddress values (seqAddress.nextVal, '홍길동', 20, '서울시', 'm');

delete from tblAddress where seq < 9;

select * from tblAddress order by seq desc;

commit;

insert into tblAddress values (seqAddress.nextVal, '가가가', 20, '서울시 강남구', 'f');
insert into tblAddress values (seqAddress.nextVal, '나나나', 13, '서울시 강남구 역삼동 한독빌딩 8층', 'm');
insert into tblAddress values (seqAddress.nextVal, '다다다', 33, '서울시 강남구 역삼동 한독빌딩 8층', 'f');

insert all
into tblAddress values (seqAddress.nextVal, '가가가', 20, '서울시 강남구', 'f')
into tblAddress values (seqAddress.nextVal, '나나나', 13, '서울시 강남구 역삼동 한독빌딩 8층', 'm')
into tblAddress values (seqAddress.nextVal, '다다다', 33, '서울시 강남구 역삼동 한독빌딩 8층', 'f')
select * from dual;


insert into tblAddress (seq, name, age, address, gender)
select seqAddress.nextVal, '가가가', 20, '서울시 강남구', 'f' from dual
union all
select seqAddress.nextVal, '나나나', 20, '서울시 강남구', 'f' from dual
union all
select seqAddress.nextVal, '다다다', 20, '서울시 강남구', 'f' from dual;


select seqAddress.nextVal from dual;

insert into tblAddress values (seqAddress.nextVal, '강아지', 3, '서울시 강남구 역삼동 한독빌딩 8층', 'm');
insert into tblAddress values (seqAddress.nextVal, '고양이', 2, '서울시 강남구 역삼동 한독빌딩 3층', 'f');
insert into tblAddress values (seqAddress.nextVal, '병아리', 1, '서울시 강남구 역삼동 한독빌딩 2층', 'f');
insert into tblAddress values (seqAddress.nextVal, '사자', 7, '서울시 강남구 대치동', 'm');
insert into tblAddress values (seqAddress.nextVal, '호랑이', 6, '서울시 강남구 압구정동', 'f');
insert into tblAddress values (seqAddress.nextVal, '비둘기', 3, '서울시 강동구 천호동', 'f');
insert into tblAddress values (seqAddress.nextVal, '타조', 4, '서울시 강동구 암사동', 'm');
insert into tblAddress values (seqAddress.nextVal, '햄스터', 1, '서울시 강북구 우이동', 'm');
insert into tblAddress values (seqAddress.nextVal, '낙타', 5, '서울시 강북구 번동', 'm');
insert into tblAddress values (seqAddress.nextVal, '독수리', 3, '서울시 강북구 미아동', 'm');








create table tblUser (
    seq number primary key,
    name varchar2(30) not null
);

create sequence seqUser;

create table tblDetail (
    seq number primary key,
    email varchar2(100) not null,
    user_seq number not null references tblUser(seq)
);

create sequence seqDetail;





select * from tblUser;



drop table tblinfo;
select * from tblinfo;
select * from tblmemo;

create table tblInfo (
	seq number,
	school varchar2(100) not null,
	country varchar2(100) not null,
	
	constraint info_pk primary key(seq),
	constraint info_kf foreign key(seq) references tblAddress(seq) 
);

insert into tblInfo values (1, '강남 동물학교', '대한민국');
insert into tblInfo values (2, '강남 동물학교', '대한민국');
insert into tblInfo values (3, '뉴욕 아카데미', '미국');
insert into tblInfo values (4, '동경 훈련원', '일본');
insert into tblInfo values (5, '베이징 훈련소', '중국');

create table tblMemo (
	seq number primary key,
	memo varchar2(500) not null,
	regdate date default sysdate not null,
	aseq number not null references tblAddress(seq) 
);

drop sequence seqMemo;
create sequence seqMemo;

insert into tblMemo values (seqMemo.nextVal, '안녕하세요.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '날씨가 조금 흐려요.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '월요일입니다.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '스프링 공부하고 있어요.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '벌써 배가 고파요.', default, 1);
insert into tblMemo values (seqMemo.nextVal, '오늘도 열심히 낮잠 중', default, 2);
insert into tblMemo values (seqMemo.nextVal, '집사야 밥내놔라!', default, 2);
insert into tblMemo values (seqMemo.nextVal, '삐약삐약', default, 3);
insert into tblMemo values (seqMemo.nextVal, '구구', default, 6);
insert into tblMemo values (seqMemo.nextVal, '하늘을 날다.', default, 9);
insert into tblMemo values (seqMemo.nextVal, '집이 좁아요.', default, 8);


commit;


select * from tblMemo;
select * from tbladdress;
select * from tblinfo;

select * from tblAddress a inner join tblInfo i on a.seq=i.seq;
select * from tblAddress a left outer join tblInfo i on a.seq=i.seq;

select * from tblAddress a
    left outer join tblMemo m
        on a.seq=m.aseq;
        
        
-- 게시판(게시물+ 댓글)
create table tblBoard(
    seq number primary key,                 -- 글번호(PK)
    subject varchar2(100) not null,         -- 제목
    name varchar2(30) not null,             -- 작성자
    regdate date default sysdate not null   -- 작성일
);

insert into tblBoard values(1, '게시판입니다', '홍길동',default);
insert into tblBoard values(2, 'MyBatis 수업 예제입니다.', '홍길동',default);
insert into tblBoard values(3, '쿼리가 이상해여', '홍길동',default);
insert into tblBoard values(4, '조인 결과를 받아오는 방법', '홍길동',default);
insert into tblBoard values(5, '월요일이라니', '홍길동',default);

create table tblComment(
    seq number primary key,                         -- 댓글번호(PK)
    subject varchar2(100) not null,                 -- 댓글
    name varchar2(30) not null,                     -- 작성자
    regdate date default sysdate not null,          -- 작성일
    bseq number not null references tblBoard(seq)   -- 부모글(FK)
);

insert into tblComment values(1, '에러좀 봐주세요','아무개',default,1);
insert into tblComment values(2, '컴파일 오류나요','아무개',default,1);
insert into tblComment values(3, '소스 공유좀 부탁합니다.','아무개',default,1);

insert into tblComment values(4, '성공했습니다!','아무개',default,2);
insert into tblComment values(5, '소스 공유합니다~','아무개',default,2);

insert into tblComment values(6, '코드 수정했습니다.~','아무개',default,4);









