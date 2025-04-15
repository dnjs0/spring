<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<tiles:insertAttribute name="asset" />
	<style>
		
	</style>
</head>
<body>
	<!-- layout > member.jsp -->
	<main>
		<tiles:insertAttribute name="main_menu" />
		<tiles:insertAttribute name="member_menu" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />
	</main>	
	
	<script>
		
	</script>
</body>
</html>




