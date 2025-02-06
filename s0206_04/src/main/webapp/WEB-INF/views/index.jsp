<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
			<ul><a href="login">로그인</a></ul>
			<ul><a href="member">회원가입</a></ul>
			<ul><a href="logout">로그아웃</a></ul>
			<ul><a href="board">게시판</a></ul>
			<ul><a href="meminfo">회원정보</a></ul>
			<ul><a href="stuinput">학생성적</a></ul>
			<ul><a href="data?bno=10">데이터전달1</a></ul>
			<ul><a href="/data2/100">데이터전달2</a></ul>
			<ul><a href="/data3/1,2,3">데이터전달3</a></ul>
			<ul><a href="/data4">데이터전달-객체(list)</a></ul>
	</body>
</html>