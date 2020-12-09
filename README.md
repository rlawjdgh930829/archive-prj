## 소개
게임 발매에 대한 정보를 자유롭게 공유할 수 있는 게시판입니다.

## 기능
 - 회원가입, 로그인을 할 수 있습니다.
 - 글쓰기, 글수정, 글삭제를 할 수 있습니다.
 - Summernote를 적용하였습니다.

## 개발환경
 - STS 3.9.13
 - Apache 8.5
 - Mysql 5.7

## 시작방법
1. 프로젝트를 클론합니다.
2. 데이터베이스에 테이블을 생성합니다.
```
create table member (
    memberNo int(20) primary key,
    memberId varchar(20) not null,
    memberPwd varchar(20) not null,
    memberEmail varchar(40) not null
);

create table category (
    categoryNo int(20) primary key,
    categoryName varchar(20) not null
);

create table board (
    boardNo int(20) primary key,
    boardTitle varchar(100) not null,
    boardContent varchar(4000) not null,
    boardDate varchar(30) not null,
    boardViewCount int(20) not null,
    categoryNo int(20) not null,
    memberNo int(20) not null,
    foreign key(categoryNo) references category(categoryNo),
    foreign key(memberNo) references member(memberNo) on delete cascade
);
```
3. src/main/resources/MysqlDB.properties의 내용을 자신의 DB정보로 변경합니다.

## 스크린샷
<img src="https://user-images.githubusercontent.com/50824326/101132696-c2e1f480-364a-11eb-8d76-fb8f2191994c.png" width="50%" height="50%"/>

<img src="https://user-images.githubusercontent.com/50824326/101133378-fa04d580-364b-11eb-8718-52e4af611801.png" width="50%" height="50%"/>

<img src="https://user-images.githubusercontent.com/50824326/101133632-74355a00-364c-11eb-991c-37163a9a0c7f.png" width="50%" height="50%"/>

<img src="https://user-images.githubusercontent.com/50824326/101133675-8dd6a180-364c-11eb-9e18-1017a0aa3bf8.png" width="50%" height="50%"/>

<img src="https://user-images.githubusercontent.com/50824326/101133711-a050db00-364c-11eb-8c4c-87fbce8e684d.png" width="50%" height="50%"/>
