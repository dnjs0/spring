<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<script src="https://kit.fontawesome.com/7121714adf.js"></script>
	<style>
		
	</style>
</head>
<body>
	<!-- add.jsp -->
	<header>
		<h1 class="main">Code</h1>	
	</header>
	
	<h2>Add</h2>
	<form method="post" action="/code/addok.do">
		<table class="vertical">
			<tr>
				<th>언어</th>
				<td>
					<select name="language">
					<c:forEach items="${clist}" var="ldto">
						<option value="${ldto.name}">${ldto.name}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required class="full"></td>
			</tr>
			<tr>
				<th>코드</th>
				<td><textarea name="code" required class="full"></textarea></td>
			</tr>
		</table>
		<div>
			<button type="submit">쓰기</button>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




