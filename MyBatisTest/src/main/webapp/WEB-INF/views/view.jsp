<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- view.jsp -->
	<h1>상세보기</h1>
	
	<table class="vertical">
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>${dto.name}</td>
		</tr>
		
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>
	
	<hr>
	
	<table>
		<c:forEach items="${dto.comments}" var="cdto">
		<tr>
			<td>${cdto.subject}</td>
			<td>${cdto.name}</td>
			<td>${cdto.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




