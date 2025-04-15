<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/nnfx-light.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<script src="https://kit.fontawesome.com/7121714adf.js"></script>
	<style>
		#code{
			margin : 1rem;
			border : 1px solid #999;
		}
		#code * {
			font-family : consolas;
		}
	</style>
</head>
<body>
	<!-- view.jsp -->
	<header>
		<h1 class="main">Code</h1>	
	</header>
	
	<h2>View</h2>
	
	<table class="vertical">
		<tr>
			<th>언어</th>
			<td>
				<i class="${dto.category.icon}" style="color:${dto.category.color}"></i>
				${dto.category.name}
			</td><!-- ${dto.language}도 가능 -->
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>코드</th>
			<td><pre id="code"><code class="language-${dto.category.name}"><c:out value="${dto.code}"></c:out></code></pre></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>

	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		hljs.highlightAll();
	</script>
</body>
</html>




