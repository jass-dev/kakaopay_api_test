-- DB 설계 및 초기 데이터 입력

create table FLEX (
token char(3),
room_id varchar2(20),
request_user_id number,
share_counts number,
total_amount number,
create_date datetime
);

create table FLEX_DETAIL(
token char(3),
claim_id number,
claim_user_id number,
claim_amount number,
request_user_id number,
room_id varchar2(20),
is_claimed varchar2(1),
claim_date datetime
);


create unique index PK_FLEX on FLEX(token, room_id);

create unique index PK_FLEX_DETAIL on FLEX_DETAIL(token, room_id, claim_id);

-- test data sample.

insert into flex
values('aaa', 'r1', 1, 4, 100, sysdate);

insert into flex_detail
values('aaa', 0, -1, 29, 1, 'r1', 'N', sysdate);

insert into flex_detail
values('aaa', 1, -1, 17, 1, 'r1', 'N', sysdate);

insert into flex_detail
values('aaa', 2, -1, 32, 1, 'r1', 'N', sysdate);

insert into flex_detail
values('aaa', 3, 3, 22, 1, 'r1', 'Y', sysdate);

insert into flex
values('bbb', 'r1', 1, 4, 100, sysdate - 10);

insert into flex_detail
values('bbb', 0, -1, 29, 1, 'r1', 'N', sysdate-10);

insert into flex_detail
values('bbb', 1, -1, 17, 1, 'r1', 'N', sysdate-10);

insert into flex_detail
values('bbb', 2, 4, 32, 1, 'r1', 'Y', sysdate-10);

insert into flex_detail
values('bbb', 3, 6, 22, 1, 'r1', 'Y', sysdate-10);