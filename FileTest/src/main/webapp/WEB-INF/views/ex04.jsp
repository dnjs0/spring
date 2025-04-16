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
	<!-- ex04.jsp -->
	<h1>파일 업로드 <small>다중 파일, ajax</small></h1>
	
	<form >
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach" multiple></td>
		</tr>
	</table>
	<div>
		<button type="button">보내기</button>
	</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
		$('button[type=button]').click(()=>{
			
			//Ajax 파일 업로드 > FormData 객체 사용
			const formData = new FormData();	// name = 홍길동&age=20
			const files = $('input[name=attach]')[0].files;
			
			for(let i=0; i<files.length; i++){
				formData.append('attach', files[i]);
			}
			
			formData.append('txt', $('input[name=txt]').val());
			
			$.ajax({
				type : 'POST',
				url : '/file/ex04ok.do',
				data : formData,
				processData : false,	//이것 두개 false해야 사진 넘어감
				contentType : false,
				success : function(result){
					
				},
				error : function(a,b,c){
					console.log(a,b,c);
				}
			});
			
		});
	
	</script>
</body>
</html>






