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
<body class="wide">
	<!-- result.jsp -->
	<h1>결과</h1>
	
	<div>result: ${result}</div>
	
	<div>dto: ${dto}</div>
	
	<div>names: ${names}</div>
	
	<div>list: ${list}</div>
	
	<hr>
	
	<table>
		<c:forEach items="${list}" var="adto">
		<tr>
			<td>${adto.seq}</td>
			<td>${adto.name}</td>
			<td>${adto.age}</td>
			<td>${adto.address}</td>
			<td>${adto.gender}</td>
			<td>${adto.info.seq}</td>
			<td>${adto.info.school}</td>
			<td>${adto.info.country}</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<table>
		<c:forEach items="${alist}" var="adto">
		<tr>
			<!-- javax.el.PropertyNotFoundException: [seq] 특성이 [com.test.mybatis.model.AddressMemoDTO] 유형에 없습니다. -->
			<td>${adto.addrseq}</td>
			<td>${adto.name}</td>
			<td>${adto.age}</td>
			<td>${adto.address}</td>
			<td>${adto.gender}</td>
			<td>${adto.mseq}</td>
			<td>${adto.memo}</td>
			<td>${adto.regdate}</td>
			<td>${adto.aseq}</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<table>
		<c:forEach items="${blist}" var="adto">
		<tr>
			<td>${adto.seq}</td>
			<td>${adto.name}</td>
			<td>${adto.age}</td>
			<td>${adto.address}</td>
			<td>${adto.gender}</td>
			<td>
				<ul>
					<c:forEach items="${adto.memo}" var="mdto">
						<li>${mdto.memo}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




