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
	<!-- ex01ok.jsp -->
	<h1>결과</h1>
	<div>
		<div>txt : ${txt}</div>
	</div>
	
	<div>
		<div><a href="/file/resources/files/${filename}" download>filename : ${filename}</a></div>
	</div>
	
	<div>
		<div><a href="/file/download.do?filename=${filename}">filename : ${filename}</a></div>
	</div>
	
	<c:if test="${filetype.startsWith('image')}">
	<div>
		<img src="/file/resources/files/${filename}" style="max-width:700px;">
	</div>
	</c:if>
	
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>






