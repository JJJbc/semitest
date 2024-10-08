-------------------------------------------------------------------------------
//AREA TABLE 

-- 테이블 삭제
DROP TABLE EVENT;

-- 테이블 생성
CREATE TABLE EVENT(
    EVENT_NO NUMBER(6) NOT NULL,
    EVENT_NAME VARCHAR2(2000) NOT NULL,
    OPEN_DATE DATE NOT NULL,
    CLOSE_DATE DATE NOT NULL,
    USER_NO NUMBER(6) DEFAULT 1
);

-- 제약사항 수정
ALTER TABLE EVENT
ADD CONSTRAINT EVENT_NO_PK PRIMARY KEY(EVENT_NO);

ALTER TABLE EVENT
ADD CONSTRAINT E_USER_NO_FK FOREIGN KEY(USER_NO) REFERENCES USER_INFO (USER_NO);


-- 시퀀스 삭제
DROP SEQUENCE EVENT_NO_SEQ;

-- 시퀀스 생성
CREATE SEQUENCE EVENT_NO_SEQ
INCREMENT BY 1
START WITH 1;

-- 데이터 삽입

INSERT INTO EVENT(EVENT_NO, EVENT_NAME, OPEN_DATE, CLOSE_DATE) 
VALUES (EVENT_NO_SEQ.NEXTVAL, 'OPEN EVENT', SYSDATE, '9999-12-31');

-- 데이터 확인
SELECT EVENT_NO, EVENT_NAME, OPEN_DATE, CLOSE_DATE, USER_NO
FROM EVENT;

DESC EVENT;


-- 커밋
COMMIT;
-------------------------------------------------------------------------------