<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터 전달</title>
		<style>
			h2{text-align:center;}
			table,th,td{border:1px solid black;border-collapse:collapse;}
			table{text-align:center; width:1000px; margin:10px auto;}
			th,td{height:40px;}
		</style>
	</head>
	<body>
		<h2>데이터 전달</h2>
		<table>
			<colgroup>
				<col width="50%">
				<col width="*%">
			</colgroup>
			<tr>
				<th>data3</th>
				<th>제목</th>
			</tr>
			<tr>
				<td>${bno }</td>
				<td></td>
			</tr>
		</table>
		<div><a href="/">메인페이지</a></div>
	</body>
</html>