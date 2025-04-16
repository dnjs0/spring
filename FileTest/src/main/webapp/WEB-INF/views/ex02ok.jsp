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
	<!-- ex02ok.jsp -->
	<h1>결과</h1>
	<div>
		<div>txt : ${txt}</div>
	</div>
	
	<c:forEach items="${attach }" var="item">
	<div>
		<div><a href="/file/resources/files/${item.originalFilename}" download>filename : ${item.originalFilename}</a></div>
	</div>
	</c:forEach>

	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>






