<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="meminfo" method="post">
			<label>아이디</label>
			<input type="text" name="id"><br/>
			<label>패스워드</label>
			<input type="text" name="pw"><br/>
			<label>이름</label>
			<input type="text" name="name"><br/>
			<label>전화번호</label>
			<input type="text" name="tel"><br/>
			<label>성별</label><br/>
			<input type="radio" id="man" value="man" name="gender">
			<label>남자</label>
			<input type="radio" id="woman" value="woman"  name="gender">
			<label>여자</label><br/>
			<label>취미</label><br/>
			<input type="checkbox" name="hobby" value="게임" id="game">
			<label>게임</label>
			<input type="checkbox" name="hobby" value="골프" id="golf">
			<label>골프</label>
			<input type="checkbox" name="hobby" value="수영" id="swim">
			<label>수영</label>
			<input type="checkbox" name="hobby" value="조깅" id="run">
			<label>조깅</label>
			<input type="checkbox" name="hobby" value="독서" id="book">
			<label>독서</label><br/>
			<input type="submit" value="회원가입"><br/>
		</form>
		<div><a href="/">메인페이지</a></div>
	</body>
</html>