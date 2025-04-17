

--FoodTest > script.sql

create table tblCategory(
    seq number primary key,         --PK
    name varchar2(50) not null,     --카테고리명
    marker varchar2(50) not null    --마커명
);

create table tblFood(
    seq number primary key,                                 --PK
    name varchar2(100) not null,                            --상호명
    description varchar2(1000) not null,                    --소개
    category number not null references tblCategory(seq),   --카테고리(FK)
    lat number not null,                                    --위도
    lng number not null                                     --경도
);

create table tblMenu(
    seq number primary key,                             --PK
    name varchar2(50) not null,                         --메뉴명
    price number not null,                              --가격
    food number not null references tblFood(seq)        --상호명(FK)
);


create sequence seqFood;
create sequence seqMenu;


insert into tblCategory values(1,'한식','favorite.png');
insert into tblCategory values(2,'중식','bar.png');
insert into tblCategory values(3,'일식','restaurant.png');
insert into tblCategory values(4,'뷔페','sea.png');
insert into tblCategory values(5,'카페','bakery.png');











