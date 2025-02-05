<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지1</title>
	</head>
	<body>
		<h2>메인페이지1</h2>
		<c:if test="${session_id == null}">
			<div>session_id : 세션아이디가 없습니다.</div>
		</c:if>
		<c:if test="${session_id != null}">
			<div>session_id : ${session_id}</div>
		</c:if>
		<ul><a href="login">로그인</a></ul>
		<ul><a href="logout">로그아웃</a></ul>
	</body>
</html>