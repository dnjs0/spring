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
	<!-- ex01.jsp -->
	<h1>회원 가입</h1>
	<form method="POST" action="/regex/ex01ok">
	<table class="vertical">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="txtid" id="txtid" required pattern="[A-Za-z_][A-Za-z0-9_]{3,11}"></td>
		</tr>
		<tr>
			<th>암호</th>
			<td></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="txtname" id="txtname" required pattern="[가-힣]{2,5}"></td>
		</tr>
	</table>
	<div>
		<button type="submit">가입하기</button>
	</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		$('form').submit(()=>{
			
			if (invalidate()) {
				alert('올바르지 않은 아이디');
				event.preventDefault();
				return false;
			}
			
			//전송
			
		});
		
		function invalidate() {
			
			const id = $('#txtid').val();
			
			//자바스크립트 정규식 객체
			//const regex = new RegEx('^[A-Za-z_][A-Za-z0-9_]{3,11}$');
			const regex = /^[A-Za-z_][A-Za-z0-9_]{3,11}$/; //Pattern
			
			//- test()
			//- exec()
			//- match()
			//- replace()
			//- split()
			
			if (regex.test(id)) {
				return false;
			}
			
			return true;			
		}
	
	</script>
</body>
</html>




