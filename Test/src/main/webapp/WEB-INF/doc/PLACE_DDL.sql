-------------------------------------------------------------------------------
//PLACE TABLE 

-- 테이블 삭제
DROP TABLE PLACE;

-- 테이블 생성
CREATE TABLE PLACE(
    PLACE_NO NUMBER(6) NOT NULL,
    CATEGORY VARCHAR2(10) NOT NULL,
    AREA_NO NUMBER(2) NOT NULL,
    PLACE_NAME VARCHAR2(100) NOT NULL,
    PL_ADDRESS VARCHAR2(4000) NOT NULL,
    PL_PHONE VARCHAR2(30) NOT NULL,
    PL_WEBSITE VARCHAR2(50) NOT NULL,
    GEN_RESERVATION NUMBER(6) DEFAULT 0 NOT NULL,
    RECO_RESERVATION NUMBER(6) DEFAULT 0 NOT NULL
);

-- 제약사항 수정
ALTER TABLE PLACE
ADD CONSTRAINT PLACE_NO_PK PRIMARY KEY(PLACE_NO);

ALTER TABLE PLACE
ADD CONSTRAINT PL_WEBSITE_UK UNIQUE(PL_WEBSITE);

ALTER TABLE PLACE
ADD CONSTRAINT AREA_NO_FK FOREIGN KEY(AREA_NO) REFERENCES AREA (AREA_NO);

-- 시퀀스 삭제
DROP SEQUENCE PLACE_NO_SEQ;

-- 시퀀스 생성
CREATE SEQUENCE PLACE_NO_SEQ
INCREMENT BY 1
START WITH 1;

-- 데이터 삽입
INSERT INTO PLACE
(PLACE_NO, CATEGORY, AREA_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, GEN_RESERVATION, RECO_RESERVATION)
VALUES (PLACE_NO_SEQ.NEXTVAL, '카페', 1, '테누커피', '서울 마포구 연남동 241-89', '050713657553', 'http://instagram.com/tenucoffee' , 0, 0);

INSERT INTO PLACE
(PLACE_NO, CATEGORY, AREA_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, GEN_RESERVATION, RECO_RESERVATION)
VALUES (PLACE_NO_SEQ.NEXTVAL, '카페', 2, '우나나베이크하우스', '경기 고양시 일산서구 호수로838번길 34-17 1층', '050713399338', 'https://www.instagram.com/oohnana_bakehouse' , 0, 0);

-- GEN_RESERVATION 수정
UPDATE PLACE
SET GEN_RESERVATION = GEN_RESERVATION + 1
WHERE PLACE_NO = 1;

-- RECO_RESERVATION 수정

UPDATE PLACE
SET RECO_RESERVATION = RECO_RESERVATION + 1
WHERE PLACE_NO = 2;


-- 데이터 확인
SELECT PLACE_NO, CATEGORY, AREA_NO, PLACE_NAME, PL_ADDRESS, PL_PHONE, PL_WEBSITE, GEN_RESERVATION, RECO_RESERVATION
FROM PLACE;

-- 커밋
COMMIT;
-------------------------------------------------------------------------------