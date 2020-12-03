## 게임 발매정보 공유 사이트
게임 발매에 대한 정보를 자유롭게 공유할 수 있는 게시판입니다.

## 기능
 - 회원가입, 로그인을 할 수 있습니다.
 - 글쓰기, 글수정, 글삭제를 할 수 있습니다.
 - Summernote를 적용하였습니다.

## 개발환경
 - STS 3.9.13
 - Apache 8.5
 - Oracle 11g

## 시작방법
1. 프로젝트를 클론합니다.
2. 데이터베이스에 테이블을 생성합니다.
```
create table member (
    memberNo number(20) primary key,
    memberId varchar2(20) not null,
    memberPwd varchar2(20) not null,
    memberEmail varchar2(40) not null
);

create table category (
    categoryNo number(20) primary key,
    categoryName varchar2(20) not null
);

create table board (
    boardNo number(20) primary key,
    boardTitle varchar2(100) not null,
    boardContent varchar2(4000) not null,
    boardDate varchar2(30) not null,
    boardViewCount number(20) not null,
    categoryNo number(20) not null,
    memberNo number(20) not null,
    foreign key(categoryNo) references category(categoryNo),
    foreign key(memberNo) references member(memberNo) on delete cascade
);
```
3. src/main/resources/dp.properties의 내용을 자신의 DB정보로 변경합니다.

## 스크린샷
