<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>게시판</title>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/notice_list.css">
		<style>
			a{text-decoration:none; color:ingerit;}
		</style>
		<script>
		const searchBtn = () =>{
			var searchW = $(".searchW").val().trim(); // 앞뒤공백제거
			
			if(searchW.length<1){
				alert("검색어를 입력하셔야 검색이 가능합니다.")
				$(".searchW").val(""); // input에 데이터 지우기
				$(".searchW").focus();
				return;
			}
			alert("검색을 진행합니다.");
			searchFrm.submit();
		}
		</script>
	</head>
	<body>
	
	</body>
</html>