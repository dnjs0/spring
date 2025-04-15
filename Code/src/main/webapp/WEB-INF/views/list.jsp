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
		#list th:nth-child(1){width:140px;}
		#list th:nth-child(2){width:auto;}
		#list th:nth-child(3){width:180px;}
		#list td:nth-child(1),#list td:nth-child(3){text-align:center;}
	</style>
</head>
<body>
	<!-- list.jsp -->
	<header>
		<h1 class="main">Code</h1>	
	</header>
	
	<h2>List</h2>
	
	<table id="list">
		<tr>
			<th>언어</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="cdto">	
		<tr>
			<td >
				<i class="${cdto.category.icon}" style="color:${cdto.category.color};"></i>
				${cdto.language}
			</td>
			<td><a href="/code/view.do?seq=${cdto.seq}">${cdto.subject}</a></td>
			<td>${cdto.regdate}</td>
		</tr>	
		</c:forEach>
	</table>
	<div>
		<button type="button" onclick="location.href='/code/add.do';">쓰기</button>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




