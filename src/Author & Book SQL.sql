--책관리 sql 스크립트
drop table book;
drop table author;
drop sequence seq_book_id;
drop sequence seq_author_id;

--작가테이블 생성
CREATE TABLE author (
  author_id	NUMBER(10),
  author_name	VARCHAR2(100) 	NOT NULL,
  author_desc	VARCHAR2(500),
  PRIMARY 	KEY(author_id)	
);

--북테이블 생성
CREATE TABLE book (
  book_id	 NUMBER(10),
  title	 VARCHAR2(100) 	NOT NULL,
  pubs	 VARCHAR2(100),
  pub_date	 DATE,
  author_id NUMBER(10),
  PRIMARY 	KEY(book_id),
  CONSTRAINT c_book_fk FOREIGN KEY (author_id)
  REFERENCES author(author_id)
);

--작가 시퀀스
CREATE SEQUENCE seq_author_id
INCREMENT BY 1 
START WITH 1 ;

--책 시퀀스
CREATE SEQUENCE seq_book_id
INCREMENT BY 1 
START WITH 1 ;

--작가 테이터 입력
INSERT INTO author VALUES (seq_author_id.nextval, '이문열', '경북 영양' );
INSERT INTO author VALUES (seq_author_id.nextval, '박경리', '경상남도 통영' );
INSERT INTO author VALUES (seq_author_id.nextval, '유시민', '17대 국회의원' );
INSERT INTO author VALUES (seq_author_id.nextval, '기안84', '기안동에서 산 84년생' );
INSERT INTO author VALUES (seq_author_id.nextval, '강풀', '온라인 만화가 1세대' );
INSERT INTO author VALUES (seq_author_id.nextval, '김영하', '알쓸신잡' );

--북 데이터 입력
INSERT INTO book VALUES (seq_book_id.nextval, '우리들의 일그러진 영웅', '다림', '1998-02-22', 1 );
INSERT INTO book VALUES (seq_book_id.nextval, '삼국지', '민음사', '2002-03-01', 1 );
INSERT INTO book VALUES (seq_book_id.nextval, '토지', '마로니에북스', '2012-08-15', 2 );
INSERT INTO book VALUES (seq_book_id.nextval, '유시민의 글쓰기 특강', '생각의길', '2015-04-01', 3 );
INSERT INTO book VALUES (seq_book_id.nextval, '패션왕', '중앙북스(books)', '2012-02-22', 4 );
INSERT INTO book VALUES (seq_book_id.nextval, '순정만화', '재미주의', '2011-08-03', 5 );
INSERT INTO book VALUES (seq_book_id.nextval, '오직두사람', '문학동네', '2017-05-04', 6 );
INSERT INTO book VALUES (seq_book_id.nextval, '26년', '재미주의', '2012-02-04', 5 );

--커밋
commit;
-----------------------------------------------------------------------------
--여기까지 실행하면 데이타 초기화 됨
-----------------------------------------------------------------------------

--전체리스트 보기
select b.book_id, b.title, b.pubs, b.pub_date, a.author_id, a.author_name, a.author_desc
from book b, author a
where b.author_id = a.author_id;


--강풀데이터 수정
update author
set author_desc = '서울특별시'
where author_id = 5;

-------------------------------------------
책 삭제하기: 작가부터 삭제해야한다.
------------------------------------------
--기안84작가 데이터 삭제
delete from author
where author_id = 4;


--기안84책(패션왕)을 먼저 삭제해야함
delete from book
where book_id = 5;

--작가(기안84)삭제
delete from author
where author_id = 5;



---------------------------------------------------------------
작가를 삭제하면 해당작가를 fk로 가진 책도 같이 삭제하기
---------------------------------------------------------------
--기존 제약사항 삭제
alter table book drop CONSTRAINT c_book_fk;

--새로운 제약사항 추가: 해당하는 FK를 가진 참조행도 삭제
alter table book add(
    CONSTRAINT c_book_fk FOREIGN KEY (author_id)
    REFERENCES author(author_id)
    ON DELETE CASCADE
);

--작가 삭제하기
--이문열(1번)을 삭제하면 이문열(1번)을 참고하고 있는 
--책(1번:우리들의 일그러진 영웅, 2번:삼국지)도 삭제된다.
delete from author
where author_id = 1;


--테이블별 데이타 보기(테스트용)
select  author_id,
        author_name,
        author_desc
from author;

-----------------------------------------------------------------
select * from book;

select  author_id,
        author_name,
        author_desc
from author;

select  book_id,
        title,
        pubs,
        pub_date,
        author_id
from book;

SELECT  b.book_id,
        b.title,
        b.pubs,
        b.pub_date,
        b.author_id,
        a.author_name,
        a.author_desc
FROM book b, author a
where b.author_id = a.author_id;

SELECT
    *
FROM book, author;

commit;