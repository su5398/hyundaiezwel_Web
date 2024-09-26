DROP TABLE MYBOARD;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(100) NOT NULL,
	MYTITLE VARCHAR2(2000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_MYBOARD
NOCACHE;

SELECT * FROM MYBOARD;

INSERT INTO MYBOARD VALUES(SEQ_MYBOARD.NEXTVAL, '관리자','게시판 테스트','테스트 중입니다.1234567ABCD',CURRENT_DATE);