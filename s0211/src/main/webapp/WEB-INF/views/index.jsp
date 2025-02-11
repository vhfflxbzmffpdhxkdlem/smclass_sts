<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script>
			if("${param.logout}" == "1"){
				alert("로그아웃이 되었습니다.");
				location.href="/";
			}
			if("${param.chkBwrite}" == "1"){
				alert("게시글이 저장되었습니다.")
				location.href="/"
			}
		</script>
	</head>
	<body>
		<h2>메인페이지</h2>
		<div>섹션아이디 : ${session_id}</div>
		<div>섹션이름 : ${session_name}님 환영합니다.</div>
		<ul>
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/board/blist">게시판</a></li>
			<li><a href="/board/bwrite">글쓰기</a></li>
			<li><a href="/board/member">회원가입</a></li>
		</ul>
	</body>
</html>