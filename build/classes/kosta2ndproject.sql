--순서 : 테이블삭제 > 시퀀스삭제 > 테이블생성 > 시퀀스생성 > DML > 레코드검색 > 커밋
--*시퀀스 이름은 통일하려고 모두 '테이블명_SEQ'로 수정했습니다
--------------------------------------------------------------------------------
--테이블 삭제
drop table member CASCADE CONSTRAINTS;
drop table review CASCADE CONSTRAINTS;
drop table story CASCADE CONSTRAINTS;
drop table story_details CASCADE CONSTRAINTS;
drop table story_img CASCADE CONSTRAINTS;

DROP TABLE LEVELUP_EXP CASCADE CONSTRAINTS;
DROP TABLE LEVELGIVE_EXP CASCADE CONSTRAINTS;
DROP TABLE HASHTAG CASCADE CONSTRAINTS;
DROP TABLE HASHTAG_RELATION CASCADE CONSTRAINTS;
DROP TABLE RESTAURANT CASCADE CONSTRAINTS;

drop table restaurant_img CASCADE CONSTRAINTS;
drop table menu CASCADE CONSTRAINTS;
drop table Category CASCADE CONSTRAINTS;
drop table category_details CASCADE CONSTRAINTS;

--------------------------------------------------------------------------------
--시퀀스 삭제
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE REVIEW_SEQ;
DROP SEQUENCE STORY_SEQ;
DROP SEQUENCE STORY_DETAILS_SEQ;
DROP SEQUENCE STORY_IMG_SEQ;

DROP SEQUENCE LEVELUP_EXP_SEQ;
DROP SEQUENCE LEVELGIVE_EXP_SEQ;
DROP SEQUENCE HASHTAG_SEQ;
DROP SEQUENCE HASHTAG_RELATION_SEQ;
DROP SEQUENCE RESTAURANT_SEQ;

drop sequence restaurant_img_seq;
drop sequence menu_seq;
drop sequence category_seq;
drop sequence category_details_seq;

--------------------------------------------------------------------------------
--테이블 생성
-->회원
create table member(
member_no NUMBER not null primary key,
member_id VARCHAR2(50) not null unique,
member_pwd VARCHAR2(50) not null,
member_name VARCHAR2(50) not null,
member_email VARCHAR2(50) not null unique,
member_phone VARCHAR2(50) not null,
member_birth date not null,
member_join_date date DEFAULT SYSDATE,
member_exp NUMBER,
profile_image VARCHAR2(100)
);

-->카테고리
CREATE TABLE Category(
	category_no	number primary key,
	category_name varchar2(30)	not null
);

-->카테고리상세
CREATE TABLE Category_details(
	category_details_no	number primary key,
    category_no number references category(category_no),
	category_details_name varchar2(30) not null
);

-->맛집레벨별경험치량
CREATE TABLE LEVELGIVE_EXP(
    RESTAURANT_LEVEL_NO NUMBER PRIMARY KEY,
    GIVE_EXP NUMBER NOT NULL
);

-->맛집
CREATE TABLE restaurant(
	restaurant_no number primary key,
    category_details_no	number references category_details(category_details_no),
	restaurant_level number references levelgive_exp(restaurant_level_no),
    restaurant_name varchar2(30) not NULL,
	phone varchar2(30) not NULL,
	restaurant_addr varchar2(100) not NULL,
	longitude number not null,
	latitude number not null,
	restaurant_regdate date DEFAULT SYSDATE,
	restaurant_visited number not NULL
);

-->리뷰
create table review(
review_no number not null primary key,
member_no number not null references member(member_no),
restaurant_no number not null references restaurant(restaurant_no),
review_score number not null,
review_content VARCHAR2(200) not null,
review_regdate date DEFAULT SYSDATE
);

-->스토리
create table story(
story_no number not null primary key,
member_no number not null references member(member_no),
story_title VARCHAR2(100) not null,
story_regdate date DEFAULT SYSDATE,
story_visited number not null
);

-->스토리상세
create table story_details(
story_details_no number not null primary key,
restaurant_no number not null references restaurant(restaurant_no),
story_no number not null references story(story_no),
story_content varchar2(1000) not null
);

-->스토리이미지
create table story_img(
story_img_no number not null primary key,
story_details_no number not null references story_details(story_details_no),
story_img varchar2(100) not null 
);

-->레벨업 경험치량
CREATE TABLE LEVELUP_EXP(
    MEMBER_LEVEL NUMBER PRIMARY KEY,
    MIN_EXP NUMBER NOT NULL,
    MAX_EXP NUMBER NOT NULL
);

-->해쉬태그
CREATE TABLE HASHTAG(
    HASHTAG_NO NUMBER PRIMARY KEY,
    HASHTAG_NAME VARCHAR2(30) NOT NULL
);

-->해쉬태그관계
CREATE TABLE HASHTAG_RELATION(
    HASHTAG_RELATION_NO NUMBER PRIMARY KEY,
    HASHTAG_NO NUMBER NOT NULL REFERENCES HASHTAG(HASHTAG_NO),
    RESTAURANT_NO NUMBER NOT NULL REFERENCES RESTAURANT(RESTAURANT_NO)  
);

-->맛집이미지
CREATE TABLE restaurant_img(
	restaurant_img_no number primary key,
	restaurant_no number REFERENCES restaurant(restaurant_no),
	restaurant_img varchar2(100) not null
);

-->메뉴
CREATE TABLE menu(
	menu_no	number primary key,
    restaurant_no number references restaurant(restaurant_no),
	menu_name varchar2(30) not NULL,
	menu_price number
);



--------------------------------------------------------------------------------
--시퀀스 생성 
CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE REVIEW_SEQ NOCACHE;
CREATE SEQUENCE STORY_SEQ NOCACHE;
CREATE SEQUENCE STORY_DETAILS_SEQ NOCACHE;
CREATE SEQUENCE STORY_IMG_SEQ NOCACHE;

CREATE SEQUENCE LEVELUP_EXP_SEQ NOCACHE;
CREATE SEQUENCE LEVELGIVE_EXP_SEQ NOCACHE;
CREATE SEQUENCE HASHTAG_SEQ NOCACHE;
CREATE SEQUENCE HASHTAG_RELATION_SEQ NOCACHE;
CREATE SEQUENCE RESTAURANT_SEQ NOCACHE;

create sequence restaurant_img_seq nocache;
create sequence menu_seq nocache;
create sequence category_seq nocache;
create sequence category_details_seq nocache;


--------------------------------------------------------------------------------
--DML 
-->회원
insert into member values(MEMBER_SEQ.NEXTVAL, 'park', '1111', '박동원', 'park1@gmail.com', '010-1111-2222', '1990-01-01', sysdate, 100, 'a01.jpg');
insert into member values(MEMBER_SEQ.NEXTVAL, 'kim', '2222', '김민정', 'kim@daum.net', '010-1111-2223', '1995-02-02', sysdate, 150, 'a02.jpg');
insert into member values(MEMBER_SEQ.NEXTVAL, 'son', '3333', '손흥민', 'son@naver.com', '010-1111-2224', '2000-03-03', sysdate, 200, 'a03.png');
insert into member values(MEMBER_SEQ.NEXTVAL, 'choi', '4444', '최현정', 'choi@gmail.com', '010-1111-2225', '2005-04-04', sysdate, 250, 'a04.jpg');
insert into member values(MEMBER_SEQ.NEXTVAL, 'song', '5555', '송아지', 'song@naver.com', '010-1111-2226', '1980-05-05', sysdate, 300, 'a05.png');

-->카테고리
insert into category values(category_seq.nextval, '한식');

-->카테고리상세
insert into category_details values(category_details_seq.nextval, CATEGORY_SEQ.currval, '고기');
insert into category_details values(category_details_seq.nextval, CATEGORY_SEQ.currval, '냉면');

-->맛집레벨경험치량
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 10);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 20);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 30);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 40);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 50);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 60);
INSERT INTO LEVELGIVE_EXP VALUES(LEVELGIVE_EXP_SEQ.NEXTVAL, 70);

-->맛집
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 1, 1, '카페 맛집', '010-1111-1111', '서울시 XX구 XX로 111-11', 23, 120, SYSDATE, 100);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 2, 2, '냉면 맛집', '010-2222-2222', '서울시 XX구 XX로 222-22', 25, 122, SYSDATE, 90);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 1, 3, '중화요리 맛집', '010-3333-3333', '서울시 XX구 XX로 333-33', 28, 125, SYSDATE, 80);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 2, 4, '치킨 맛집', '010-4444-4444', '서울시 XX구 XX로 444-44', 30, 131, SYSDATE, 70);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 1, 5, '고기 맛집', '010-5555-5555', '서울시 XX구 XX로 555-55', 56, 151, SYSDATE, 60);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 2, 6, '뷔페 맛집', '010-6666-6666', '서울시 XX구 XX로 666-66', 13, 143, SYSDATE, 50);
INSERT INTO RESTAURANT VALUES(RESTAURANT_SEQ.NEXTVAL, 1, 7, '술집 맛집', '010-7777-7777', '서울시 XX구 XX로 777-77', 12, 141, SYSDATE, 40);
insert into restaurant values(restaurant_seq.nextval, 2, 1, '해주냉면', '02-424-7192', '서울 송파구 백제고분로7길 8-16', 127.07977463491474, 37.509652351093166, sysdate, 0);

-->리뷰
insert into review values(REVIEW_SEQ.NEXTVAL, 1, 1, 1, '혼자 먹기 어려움', sysdate);
insert into review values(REVIEW_SEQ.NEXTVAL, 2, 2, 2, '혼자 먹기 어렵지 않음', sysdate);
insert into review values(REVIEW_SEQ.NEXTVAL, 3, 3, 3, '혼자 먹기 괜찮음', sysdate);
insert into review values(REVIEW_SEQ.NEXTVAL, 4, 4, 4, '맛있고 혼자 먹기 좋음', sysdate);
insert into review values(REVIEW_SEQ.NEXTVAL, 5, 5, 5, '맛있고 혼자 먹기 매우 좋음', sysdate);

-->스토리
insert into story values(STORY_SEQ.NEXTVAL, 1, '라멘집', sysdate, 0);
insert into story values(STORY_SEQ.NEXTVAL, 2, '국밥집', sysdate, 0);
insert into story values(STORY_SEQ.NEXTVAL, 3, '초밥집', sysdate, 0);
insert into story values(STORY_SEQ.NEXTVAL, 4, '고깃집', sysdate, 0);
insert into story values(STORY_SEQ.NEXTVAL, 5, '백반집', sysdate, 0);

-->스토리상세
insert into story_details values(STORY_DETAILS_SEQ.NEXTVAL, 1, 1, '내용1');
insert into story_details values(STORY_DETAILS_SEQ.NEXTVAL, 2, 2, '내용2');
insert into story_details values(STORY_DETAILS_SEQ.NEXTVAL, 3, 3, '내용3');
insert into story_details values(STORY_DETAILS_SEQ.NEXTVAL, 4, 4, '내용4');
insert into story_details values(STORY_DETAILS_SEQ.NEXTVAL, 5, 5, '내용5');

-->스토리이미지
insert into story_img values(STORY_IMG_SEQ.NEXTVAL, 1, 'img01.jpg');
insert into story_img values(STORY_IMG_SEQ.NEXTVAL, 2, 'img02.jpg');
insert into story_img values(STORY_IMG_SEQ.NEXTVAL, 3, 'img03.jpg');
insert into story_img values(STORY_IMG_SEQ.NEXTVAL, 4, 'img04.jpg');
insert into story_img values(STORY_IMG_SEQ.NEXTVAL, 5, 'img05.jpg');

-->레벨업경험치량
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 0, 9);
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 10, 49);
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 50, 99);
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 100, 199);
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 350, 549);
INSERT INTO LEVELUP_EXP VALUES(LEVELUP_EXP_SEQ.NEXTVAL, 550, 1000);

-->해쉬태그
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '전망');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '분식집');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '분위기');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '루프탑');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '존맛');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '돼지고기');
INSERT INTO HASHTAG VALUES(HASHTAG_SEQ.NEXTVAL, '혼밥');

-->해쉬태그관계
INSERT INTO HASHTAG_RELATION VALUES(HASHTAG_RELATION_SEQ.NEXTVAL, 1, 4);
INSERT INTO HASHTAG_RELATION VALUES(HASHTAG_RELATION_SEQ.NEXTVAL, 5, 6);
INSERT INTO HASHTAG_RELATION VALUES(HASHTAG_RELATION_SEQ.NEXTVAL, 7, 3);
INSERT INTO HASHTAG_RELATION VALUES(HASHTAG_RELATION_SEQ.NEXTVAL, 6, 5);

-->맛집이미지
insert into restaurant_img values(restaurant_img_seq.nextval, 1, '해주냉면1.jpg');
insert into restaurant_img values(restaurant_img_seq.nextval, 1, '해주냉면2.jpg');
insert into restaurant_img values(restaurant_img_seq.nextval, 1, '해주냉면3.jpg');

-->메뉴
insert into menu values(menu_seq.nextval, 1, '물냉면', 7000);
insert into menu values(menu_seq.nextval, 1, '비빔냉면', 7000);


--------------------------------------------------------------------------------
--레코드 검색
SELECT * FROM member;
SELECT * FROM review;
SELECT * FROM story;
SELECT * FROM story_details;
SELECT * FROM story_img;

SELECT * FROM LEVELUP_EXP;
SELECT * FROM LEVELGIVE_EXP;
SELECT * FROM HASHTAG;
SELECT * FROM HASHTAG_RELATION;
SELECT * FROM RESTAURANT;

select * from restaurant_img;
select * from menu;
select * from category;
select * from category_details;

select c.category_no, c.category_name, cd.category_details_no, cd.category_details_name from category c join category_details cd on c.category_no = cd.category_no;
select * from restaurant natural join menu;
select * from restaurant join restaurant_img on restaurant.restaurant_no = restaurant_img.restaurant_no;


--------------------------------------------------------------------------------
--커밋 
commit;


--------------------------------------------------------------------------------
--회원 기능
--로그인
select member_id, member_name from member where member_id = 'park' and member_pwd='1111'

--회원가입
insert into member (member_no, member_id, member_pwd, member_name, member_email, member_phone, member_birth, member_join_date, member_exp) values(MEMBER_SEQ.NEXTVAL, 'rhg201', '1111', '류홍걸', 'rhg201@gmail.com', '010-1111-2222', '1990-01-01', sysdate, 100);
insert into member (member_no, member_id, member_pwd, member_name, member_email, member_phone, member_birth, member_join_date, member_exp) values(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, sysdate, 0);

--아이디 찾기
select member_id from member where member_email='park1@gmail.com'
select member_id from member where member_email=?

--이메일 중복 체크
select member_email from member where member_email='park';

--
select member_level from levelup_exp where (30>=min_exp) and (30<=max_exp)