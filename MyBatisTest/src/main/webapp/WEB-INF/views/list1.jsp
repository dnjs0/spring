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
	<!-- list1.jsp -->
	
	<h1>게시판</h1>
	
	<%-- <table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>댓글</th>
		</tr>
		<c:forEach items="${list1}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.subject}</td>
			<td>${dto.name}</td>
			<td>${dto.regdate}</td>
			<td>
				<c:forEach items="${dto.comments}" var="cdto">
				<div>-${cdto.subject}(${cdto.name})</div>
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
	</table> --%>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list1}" var="dto" varStatus="status">
		<tr>
			<td>${dto.seq}</td>
			<td>
				${dto.subject}
				<c:if test="${not empty dto.comments}">
				<button type="button" onclick="showComment('tr${status.count}')">댓글 보기(${dto.comments.size()})</button>
				</c:if>
			</td>
			<td>${dto.name}</td>
			<td>${dto.regdate}</td>
		</tr>
		<c:if test="${not empty dto.comments}">
		<tr style="display: none;" id="tr${status.count}" class="commentTr">
			<td></td>
			<td colspan="3">
				<ul>
					<c:forEach items="${dto.comments}" var="cdto">
					<li>${cdto.subject}(${cdto.name}) ${cdto.regdate}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		</c:if>
		</c:forEach>
	</table>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		function showComment(tr) {
			
			$('.commentTr').hide();
			$('#' + tr).show();
			
		}
	</script>
</body>
</html>




