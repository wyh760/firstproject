-- 15강: article 더미 데이터
-- 17강: article 더미 데이터에서 id 정보를 제거
INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');
-- 22강: article 더미 데이터
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 ㄱㄱ');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 ㄱㄱㄱ');
-- 22강: comment 더미 데이터
---- 4번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '굳 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '쇼생크의 탈출');
---- 5번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '초밥');
---- 6번 게시글의 댓글들
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '유튜브');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '독서');


 -- ID 1번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (1, '스타벅스 왕십리', '토요일 사람 너무많아');

 -- ID 2번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (2, '투썸은 한적해', '한적해서 썰렁해');

 -- ID 3번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (3, '메가커피 불편해', '저가는 좋아 그런데 시끄러워');

 -- ID 4번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (4, '동네카페', '동네 카페 눈치준');

 -- ID 5번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (5, '동네 맛집 김밥...', '동네 맛집 김밥...맛있다는데 신규창업이라서');

 -- ID 6번 데이터
 INSERT INTO TOPICS (ID, TITLE, BODY)
 VALUES (6, '경동시장 카페', '경동시장 카페가야하나');