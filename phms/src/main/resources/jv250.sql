DROP TABLE User;
CREATE TABLE User (
	cid			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	Username	VARCHAR(20)		NOT NULL,
	UserBirth   VARCHAR(14)     NOT NULL,
	Userage		INT				NOT NULL,
	Usergender	CHAR(1)			NOT NULL,
	Userphone	VARCHAR(13)		NOT NULL,
	Useremail   VARCHAR(30)     NOT NULL,
	Userid		VARCHAR(16)		NOT NULL,
	Userpw		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1;

SELECT * FROM User;

INSERT INTO User (Username, UserBirth, Userage, Usergender, Userphone, Useremail, Userid, Userpw) 
VALUES ('관우', '901213-1234567', '33', '남', '010-2323-2323','java@naver.com', 'java', '1111');