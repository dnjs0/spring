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
	<!-- ex02.jsp -->
	<h1>파일 업로드 <small>다중 파일, multiple</small></h1>
	
	<form method="post" action="/file/ex02ok.do" enctype="multipart/form-data">
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
		<button>보내기</button>
	</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
		$('form').submit(()=>{
			//페이지 이동 취소, 전송 취소
			//event.preventDefault();
			
			//첨부 파일들
			//alert($('input[name=attach]')[0].files.length);
			
			let totalSize = 0;
			
			Array.from($('input[name=attach]')[0].files).forEach(file=>{
				//alert(file.name);
				
				//파일을 1개씩 유효성 검사
				if(checkFile(file.name, file.size)){
					event.preventDefault();
					return false;
				}
				
				totalSize += file.size;
				
			});
			
			if(totalSize > 52428800){
				alert('총 파일 크기의 합이 50MB 이하만 가능합니다.');
				event.preventDefault();
				return false;
			}
			
			
		});
		
		
		
		
		//전송 진행 함수
		function checkFile(filename, filesize){
			
			const maxsize = 10485768; //10MB
			const regex = /(.*?)\.(exe|sh)$/gi; //test.exe, test.sh인 애들 찾는것(실행파일)
			//실행파일을 못올라가게 하는 용도
			
			if(filesize > maxsize){
				alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
				return true;
			}
			if(regex.test(filename)){
				alert('해당 파일은 업로드가 불가능합니다.');
				return true;
			}
			
			return false; //if문 둘다 안걸리면 문제없는 파일
			
		}
	
	</script>
</body>
</html>






