CREATE USER MOVIE IDENTIFIED BY MOVIE;
GRANT DBA TO MOVIE;

CONN MOVIE/MOVIE
CREATE SEQUENCE SEQ;
CREATE TABLE THEATER(
	THEATER_NAME VARCHAR2(50),
	CONSTRAINT THEATER_PK PRIMARY KEY(THEATER_NAME)
);

CREATE TABLE MEMBER(
	ID VARCHAR2(50),
	PASSWORD VARCHAR2(50),
	NAME VARCHAR2(50),
	BIRTH VARCHAR2(50),
	GENDER VARCHAR2(50),
	PHONE VARCHAR2(50),
	ADDR VARCHAR2(255),
	EMAIL VARCHAR2(50),
	MY_THEATER VARCHAR2(100),
	REGDATE DATE,
	CONSTRAINT MEMBER_FK FOREIGN KEY(MY_THEATER)
		REFERENCES THEATER(THEATER_NAME),
	CONSTRAINT MEMBER_PK PRIMARY KEY(ID)
);

CREATE TABLE MOVIE(
	FILM_NUMBER VARCHAR2(50),
	FILM_NAME VARCHAR2(50),
	DIRECTOR VARCHAR2(50),
	ACTOR VARCHAR2(255),
	RATE VARCHAR2(50),
	RUNTIME NUMBER,
	PRICE NUMBER,
	COUNTRY VARCHAR2(50),
	GENRE VARCHAR2(50),
	RELEASE_DATE DATE,
	END_DATE DATE,
	STORY VARCHAR2(255),
	CUT VARCHAR2(255),
	TRAILER VARCHAR2(255),
	CONSTRAINT MOVIE_PK PRIMARY KEY(FILM_NUMBER)
);

CREATE TABLE ROOM(
	THEATER_NAME VARCHAR2(50),
	ROOM_NAME VARCHAR2(50),
	A NUMBER,
	B NUMBER,
	C NUMBER,
	D NUMBER,
	E NUMBER,
	F NUMBER,
	G NUMBER,
	H NUMBER,
	I NUMBER,
	J NUMBER,
	CONSTRAINT ROOM_FK FOREIGN KEY(THEATER_NAME)
		REFERENCES THEATER(THEATER_NAME),
	CONSTRAINT ROOM_PK PRIMARY KEY(THEATER_NAME,ROOM_NAME)
);


CREATE TABLE SCHEDULE(
	SEQ NUMBER,
	FILM_NUMBER VARCHAR2(50),
	THEATER_NAME VARCHAR2(50),
	ROOM_NAME VARCHAR2(50),
	SHOW_DATE VARCHAR2(50),
	SHOW_TIME VARCHAR2(50),
	SEAT_STATUS NUMBER,
	CONSTRAINT SCHEDULE_FK FOREIGN KEY(FILM_NUMBER)
		REFERENCES MOVIE(FILM_NUMBER),
	CONSTRAINT SCHEDULE_FK2 FOREIGN KEY(THEATER_NAME,ROOM_NAME)
		REFERENCES ROOM(THEATER_NAME,ROOM_NAME),
	CONSTRAINT SCHEDULE_PK PRIMARY KEY(SEQ)
);

CREATE TABLE SEAT(
	SEQ NUMBER,
	SEAT_NUMBER NUMBER,
	CONSTRAINT SEAT_FK FOREIGN KEY(SEQ)
		REFERENCES SCHEDULE(SEQ),
	CONSTRAINT SEAT_PK PRIMARY KEY(SEQ,SEAT_NUMBER)
);

CREATE TABLE TICKET(
	TICKET_NUMBER VARCHAR2(50),
	ID VARCHAR2(50),
	FILM_NUMBER VARCHAR2(50),
	THEATER_NAME VARCHAR2(50),
	ROOM_NAME VARCHAR2(50),
	TODAY VARCHAR2(50),
	TICKET_DATE VARCHAR2(50),
	START_TIME VARCHAR2(50),
	END_TIME VARCHAR2(50),
	SEAT_NUMBER NUMBER,
	ADULT NUMBER,
	OLD_MAN NUMBER,
	TEENAGER NUMBER,
	PRICE NUMBER,
	CONSTRAINT TICKET_FK FOREIGN KEY(THEATER_NAME,ROOM_NAME)
		REFERENCES ROOM(THEATER_NAME,ROOM_NAME),
	CONSTRAINT TICKET_FK2 FOREIGN KEY(FILM_NUMBER)
		REFERENCES MOVIE(FILM_NUMBER),
	CONSTRAINT TICKET_FK3 FOREIGN KEY(ID)
		REFERENCES MEMBER(ID),
	CONSTRAINT TICKET_PK PRIMARY KEY(TICKET_NUMBER)	
);


INSERT INTO THEATER VALUES('강남');
INSERT INTO THEATER VALUES('영등포');
INSERT INTO THEATER VALUES('구로');
INSERT INTO THEATER VALUES('마포');
INSERT INTO THEATER VALUES('동서울');
INSERT INTO THEATER VALUES('동수원');
INSERT INTO THEATER VALUES('부천');
INSERT INTO THEATER VALUES('수원');
INSERT INTO THEATER VALUES('군자');
INSERT INTO THEATER VALUES('신도림');
INSERT INTO THEATER VALUES('용산');
INSERT INTO THEATER VALUES('인천');
INSERT INTO THEATER VALUES('대전');
INSERT INTO THEATER VALUES('해운대');
INSERT INTO THEATER VALUES('제주');

INSERT INTO MEMBER VALUES('choa','1','초아','90','여','010-1111-1111','서울특별시 강남구','choa@naver.com',null,sysdate);
INSERT INTO MEMBER VALUES('hong','1','홍길동','44','남','010-2222-2222','서울특별시 동작구','hong@naver.com',null,sysdate-5);
INSERT INTO MEMBER VALUES('yeon','1','태연','90','여','010-3333-3333','서울특별시 마포구','yeon@naver.com',null,sysdate-20);
INSERT INTO MEMBER VALUES('bang','1','이방원','37','남','010-4444-4444','수원시 권선구','bang@naver.com',null,sysdate-150);
INSERT INTO MEMBER VALUES('kim','1','김유신','55','남','010-5555-5555','서울특별시 구로구','kim@naver.com',null,sysdate-120);
INSERT INTO MEMBER VALUES('jiwoo','1','지우','88','남','010-6666-6666','수원시 팔달구','jiwoo@naver.com',null,sysdate-35);
INSERT INTO MEMBER VALUES('lux','1','럭스','78','여','010-7777-7777','수원시 호매실동','lux@naver.com',null,sysdate-27);
INSERT INTO MEMBER VALUES('talon','1','탈론','94','남','010-8888-8888','부산시 해운대','talon@naver.com',null,sysdate-15);
INSERT INTO MEMBER VALUES('zed','1','제드','90','남','010-9999-9999','부천시 원미구','zed@daum.net',null,sysdate);
INSERT INTO MEMBER VALUES('shen','1','쉔','86','남','010-1010-1010','서울특별시 강서구','shen@daum.net',null,sysdate);
INSERT INTO MEMBER VALUES('jonadan','1','조나단','80','남','010-1101-1101','서울특별시 강남구','jonadan@daum.net',null,sysdate-10);
INSERT INTO MEMBER VALUES('jane','1','제인','90','여','010-1212-1212','서울특별시 강남구','jane@nate.com',null,sysdate-10);
INSERT INTO MEMBER VALUES('iu','1','아이유','90','여','010-1313-1313','인천시 연수구','iu@nate.com',null,sysdate-25);
INSERT INTO MEMBER VALUES('rise','1','라이즈','98','남','010-1414-1414','인천시 남동구','rise@lycos.com',null,sysdate-40);
INSERT INTO MEMBER VALUES('fortune','1','미스포츈','93','여','010-1515-1515','인천시 남동구','fortune@lycos.com',null,sysdate-30);

INSERT INTO MOVIE VALUES('A001','내부자들','우민호','이병헌, 조승우, 백윤식','청소년 관람불가',130,10000,'한국','범죄, 드라마','2015/11/18','2015/12/18',null,null,null);
INSERT INTO MOVIE VALUES('A002','이터널 선샤인','미셸 공드리','짐 캐리, 케이트 윈슬렛, 커스틴 던스트, 마크 러팔로, 일라이저 우드','15세 이상',107,10000,'미국','로맨스, 멜로','2015/11/05','2015/12/05',null,null,null);
INSERT INTO MOVIE VALUES('A003','검은 사제들','장재현','김윤석, 강동원, 박소담','15세 이상',108,10000,'한국','미스터리, 드라마','2015/11/05','2015/12/05',null,null,null);
INSERT INTO MOVIE VALUES('A004','열정같은소리하고있네','정기훈','정재영, 박보영, 오달수, 진경, 배성우, 류현경, 류덕환, 윤균상','15세 이상',106,10000,'한국','드라마','2015/11/25','2015/12/25',null,null,null);
INSERT INTO MOVIE VALUES('A005','괴물의 아이','호소다 마모루','야쿠쇼 코지, 미야자키 아오이, 소메타니 쇼타, 히로세 스즈, 오이즈미 요, 릴리 프랭키','12세 이상',119,10000,'일본','애니메이션, 어드벤처, 환타지','2015/11/25','2015/12/25',null,null,null);
INSERT INTO MOVIE VALUES('A006','도리화가','이종필','류승룡, 배수지, 송새벽, 김남길, 이동휘, 안재홍','12세 이상',109,10000,'한국','드라마','2015/11/25','2015/12/25',null,null,null);
INSERT INTO MOVIE VALUES('A007','헝거게임:더 파이널','프랜시스 로렌스','제니퍼 로렌스, 조쉬 허처슨, 리암 헴스워드, 니탈리 도머, 줄리안 무어, 필립 세이무어 호프만, 릴리 라베','15세 이상',137,10000,'미국','액션, 환타지','2015/11/18','2015/12/18',null,null,null);
INSERT INTO MOVIE VALUES('A008','크림슨 피크','길예르모 델 토로','톰 히들스턴, 제시카 차스테인, 미아 와시코브스카','청소년 관람불가',119,10000,'미국','스릴러, 환타지','2015/11/25','2015/12/25',null,null,null);
INSERT INTO MOVIE VALUES('A009','007 스펙터','샘 멘데스','다니엘 크레이그, 레아 세이두, 크리스토프 왈츠, 모니카 벨루치','15세 이상',148,10000,'미국, 영국','스릴러, 환타지','2015/11/11','2015/12/11',null,null,null);
INSERT INTO MOVIE VALUES('A010','프리덤','피터 코센스','쿠바 구딩 주니어, 베르나르드 포처, 윌리암 새들러','12세 이상',95,10000,'미국','드라마','2015/11/19','2015/12/19',null,null,null);

INSERT INTO ROOM VALUES('강남','1관',16,16,16,16,16,16,16,16,16,16);
INSERT INTO ROOM VALUES('강남','2관',16,16,16,16,16,16,16,16,16,0);
INSERT INTO ROOM VALUES('강남','3관',16,16,16,16,16,16,16,16,16,0);
INSERT INTO ROOM VALUES('강남','4관',12,16,16,16,16,16,16,16,16,0);
INSERT INTO ROOM VALUES('강남','5관',12,16,16,16,16,16,16,16,0,0);

INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/18','09:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/18','12:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/18','15:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/18','18:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/18','21:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/18','09:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/18','12:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/18','15:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/18','18:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/18','21:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/18','09:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/18','12:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/18','15:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/18','18:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/18','21:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/18','08:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/18','11:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A005','강남','4관','2015/11/18','14:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A006','강남','4관','2015/11/18','17:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/18','20:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/18','10:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A008','강남','5관','2015/11/18','13:20',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/18','15:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A009','강남','5관','2015/11/18','19:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A010','강남','5관','2015/11/18','23:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/19','09:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/19','12:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/19','15:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/19','18:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/19','21:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/19','09:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/19','12:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/19','15:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/19','18:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/19','21:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/19','09:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/19','12:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/19','15:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/19','18:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/19','21:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/19','08:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/19','11:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A005','강남','4관','2015/11/19','14:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A006','강남','4관','2015/11/19','17:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/19','20:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/19','10:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A008','강남','5관','2015/11/19','13:20',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/19','15:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A009','강남','5관','2015/11/19','19:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A010','강남','5관','2015/11/19','23:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/20','09:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/20','12:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/20','15:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/20','18:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/20','21:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/20','09:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/20','12:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/20','15:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/20','18:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/20','21:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/20','09:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/20','12:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/20','15:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/20','18:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/20','21:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/20','08:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/20','11:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A005','강남','4관','2015/11/20','14:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A006','강남','4관','2015/11/20','17:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/20','20:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/20','10:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A008','강남','5관','2015/11/20','13:20',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/20','15:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A009','강남','5관','2015/11/20','19:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A010','강남','5관','2015/11/20','23:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/21','09:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/21','12:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/21','15:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/21','18:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/21','21:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/21','09:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/21','12:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/21','15:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/21','18:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/21','21:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/21','09:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/21','12:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/21','15:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/21','18:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/21','21:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/21','08:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/21','11:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A005','강남','4관','2015/11/21','14:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A006','강남','4관','2015/11/21','17:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/21','20:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/21','10:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A008','강남','5관','2015/11/21','13:20',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/21','15:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A009','강남','5관','2015/11/21','19:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A010','강남','5관','2015/11/21','23:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/22','09:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/22','12:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/22','15:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/22','18:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A001','강남','1관','2015/11/22','21:00',160);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/22','09:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/22','12:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/22','15:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/22','18:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A002','강남','2관','2015/11/22','21:20',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/22','09:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/22','12:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/22','15:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/22','18:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A003','강남','3관','2015/11/22','21:40',144);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/22','08:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/22','11:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A005','강남','4관','2015/11/22','14:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A006','강남','4관','2015/11/22','17:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A004','강남','4관','2015/11/22','20:40',140);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/22','10:00',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A008','강남','5관','2015/11/22','13:20',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A007','강남','5관','2015/11/22','15:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A009','강남','5관','2015/11/22','19:40',124);
INSERT INTO SCHEDULE VALUES(SEQ.NEXTVAL,'A010','강남','5관','2015/11/22','23:00',124);

UPDATE MOVIE SET STORY='A001S' WHERE FILM_NUMBER='A001';
UPDATE MOVIE SET STORY='A002S' WHERE FILM_NUMBER='A002';
UPDATE MOVIE SET STORY='A003S' WHERE FILM_NUMBER='A003';
UPDATE MOVIE SET STORY='A004S' WHERE FILM_NUMBER='A004';
UPDATE MOVIE SET STORY='A005S' WHERE FILM_NUMBER='A005';
UPDATE MOVIE SET STORY='A006S' WHERE FILM_NUMBER='A006';
UPDATE MOVIE SET STORY='A007S' WHERE FILM_NUMBER='A007';
UPDATE MOVIE SET STORY='A008S' WHERE FILM_NUMBER='A008';
UPDATE MOVIE SET STORY='A009S' WHERE FILM_NUMBER='A009';
UPDATE MOVIE SET STORY='A010S' WHERE FILM_NUMBER='A010';

UPDATE MOVIE SET CUT='A001/A0011/A0012/A0013/A0014/A0015/A0016/A0017' WHERE FILM_NUMBER='A001';
UPDATE MOVIE SET CUT='A002/A0021/A0022/A0023/A0024/A0025/A0026' WHERE FILM_NUMBER='A002';
UPDATE MOVIE SET CUT='A003/A0031/A0032/A0033/A0034/A0035/A0036/A0037/A0038/A0039' WHERE FILM_NUMBER='A003';
UPDATE MOVIE SET CUT='A004/A0041/A0042/A0043/A0044/A0045/A0046/A0047/A0048/A0049' WHERE FILM_NUMBER='A004';
UPDATE MOVIE SET CUT='A005/A0051/A0052/A0053/A0054/A0055/A0056' WHERE FILM_NUMBER='A005';
UPDATE MOVIE SET CUT='A006/A0061/A0062/A0063/A0064/A0065/A0066/A0067/A0068' WHERE FILM_NUMBER='A006';
UPDATE MOVIE SET CUT='A007/A0071/A0072/A0073/A0074/A0075' WHERE FILM_NUMBER='A007';
UPDATE MOVIE SET CUT='A008/A0081/A0082/A0083/A0084/A0085/A0086/A0087/A0088/A0089' WHERE FILM_NUMBER='A008';
UPDATE MOVIE SET CUT='A009/A0091/A0092/A0093/A0094/A0095/A0096/A0097/A0098/A0099/A00910/A00911' WHERE FILM_NUMBER='A009';
UPDATE MOVIE SET CUT='A010/A0101/A0102/A0103/A0104/A0105/A0106' WHERE FILM_NUMBER='A010';

UPDATE MOVIE SET TRAILER='PjAxHoauiTs/BKO8Zl5DR5Q/UZy8aopPmwE' WHERE FILM_NUMBER='A001';
UPDATE MOVIE SET TRAILER='Zyzop2nzR4k/EHhHewjBCb4/yE-f1alkq9I' WHERE FILM_NUMBER='A002';
UPDATE MOVIE SET TRAILER='_Mq89LG2gfw/TJeM0pD-vus/B0D9Gg8PI6s' WHERE FILM_NUMBER='A003';
UPDATE MOVIE SET TRAILER='gZZin4RKaXw/WThABv8Kq1w/BzctMGVtnQA' WHERE FILM_NUMBER='A004';
UPDATE MOVIE SET TRAILER='wo7X8NwnZAw/dOXRB9JiydQ/NF6wZOR2CCU' WHERE FILM_NUMBER='A005';
UPDATE MOVIE SET TRAILER='u7YshVJx23A/MM_RRIhRpPg/gxAwcS_ErAY' WHERE FILM_NUMBER='A006';
UPDATE MOVIE SET TRAILER='_hCceaMeHOE/x-8VXx5I0gg/uRnetgm_jUA' WHERE FILM_NUMBER='A007';
UPDATE MOVIE SET TRAILER='i_WNdO0EsdE/mU20xVCPi2o/hPAxmoUXu_k' WHERE FILM_NUMBER='A008';
UPDATE MOVIE SET TRAILER='FKWCV61We7I/5GrThQMuPK0/-wT76eIL5mo' WHERE FILM_NUMBER='A009';
UPDATE MOVIE SET TRAILER='fvIzZ9qezV8/foMNxnyfLFU/vQFU-UKfEvE' WHERE FILM_NUMBER='A010';

COMMIT;