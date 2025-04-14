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
	<!-- list2.jsp -->
	<h1>게시판</h1>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list2}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td><a href="/mybatis/view.do?seq=${dto.seq}">${dto.subject}</a></td>
			<td>${dto.name}</td>
			<td>${dto.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




