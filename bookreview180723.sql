-- member table
create table member(
id varchar2(20) primary key,
password varchar2(20) not null,
name varchar2(20) not null,
nickname varchar2(20) unique,
phone varchar2(20) not null,
email varchar2(30) not null,
regist_date date default sysdate,
flag_admin varchar2(7) default 'm'
);
-- ���� ������ �߰�
insert into member values(
'admin1', '1234', '������', '������', '010-3333-3333', 'admin1@google.com' ,sysdate, 'admin13'
);


-- board_code table
create table board_code(
board_code varchar2(10) primary key,
board_name varchar2(20) not null unique
);
-- board category �Է�
insert into board_code values('b1001', 'å');
insert into board_code values('b1002', '��ȭ');
insert into board_code values('b1003', '����');


-- book_code table
create table book_code(
bb_code varchar2(10) primary key,
bb_name varchar2(20) not null unique
);
-- book category �Է�
insert into book_code values('bb101', '����');
insert into book_code values('bb102', '�Ҽ�');
insert into book_code values('bb103', '��/������');
insert into book_code values('bb104', '����/�濵');
insert into book_code values('bb105', '�ڱ���');
insert into book_code values('bb106', '�Ƶ�');
insert into book_code values('bb107', '����');
insert into book_code values('bb108', '�ι�');
insert into book_code values('bb109', '����/��ȭ');
insert into book_code values('bb110', '�ܱ���');
insert into book_code values('bb111', '����/��Ȱ');


-- book_board table
create table book_board(
bookb_num number(11) primary key,
writer varchar2(20),
title varchar2(100) not null,
book_name varchar2(30) not null,
bb_code varchar2(10) not null,
content varchar2(1000) not null,
write_date date default sysdate,
bookb_ref number(11),
bookb_seq number(11) default 0,
bookb_level number(11) default 0,
readcount number(11) default 0,
recommend number(11) default 0,
opposite number(11) default 0,
constraint fk_bb_writer foreign key(writer) references member(nickname),
constraint fk_bb_code foreign key(bb_code) references book_code(bb_code)
);
-- book_board_seq
create sequence book_board_seq
nocache;

-- book_comment table
create table book_comment(
bookc_num number(11) primary key,
writer varchar2(20),
bookc_content varchar2(100) not null,
ref_num number(11) not null,
write_date date default sysdate,
bookc_ref number(11),
bookc_seq number(11) default 0,
bookc_level number(11) default 0,
readcount number(11) default 0,
recommend number(11) default 0,
opposite number(11) default 0,
flag_lock number(1) default 0,
constraint fk_bc_writer foreign key(writer) references member(nickname),
constraint fk_ref_bb_num foreign key(ref_num) references book_board(bookb_num)
);
-- book_comment seq
create sequence book_comment_seq
nocache;


-- file table
create table file_tb(
file_num number(11) primary key,
original_name varchar2(20) not null,
real_path varchar2(40) not null unique,
bookb_num number(11) not null,
board_code varchar2(10) not null
);

-- deleted_member table
create table deleted_member(
dm_num number(11) primary key,
id varchar2(20) not null,
password varchar2(20) not null,
name varchar2(20) not null,
nickname varchar2(20) not null,
phone varchar2(20) not null,
email varchar2(30) not null,
regist_date date not null,
flag_admin varchar2(7) not null
);
-- deleted_member seq
create sequence deleted_member_seq
nocache;

commit;
