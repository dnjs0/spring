<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		#main{
			margin : 1rem;
			display : grid;
			grid-template-columns: calc(900px - 2rem) 300px; 
			grid-template-rows : 500px;
		}
		#main #map{
			/* background : tomato; */
			border : 1px solid gray;
			border-radius : 5px;
		}
		#main #list{
			/* background : gold; */
			grid-row:1/3;
			grid-column:2/3;
		}
		#main #list input[type=button]{
			width : 280px;
			display:block;
			margin-bottom:20px;
		}
		
		#main #list #items{
			margin : 0px;
			width : 280px;
		}
		
		#main #detail{
			/* background : cornflowerblue; */
		}
		
		
		#main #detail #tblMenu td:nth-child(odd){
			width : 300px;
		}
		#main #detail #tblMenu td:nth-child(even){
			width : 100px;	
			text-align : right;
		}
		
		
		#subMap{
			border : 1px solid gray;
			border-radius : 5px;
			width:480px;
			height:300px;
			margin-bottom : 5px;
		}
		
		#subMap + table{
			width : 480px;
		}
		
	</style>
</head>
<body class="wide">
	<!-- main.jsp -->
	<h1>Food <small>Map</small></h1>
	<main id="main">
		<div id="map">지도</div>
		<div id="list">
			<div><input type="button" value="등록하기" data-modal-button="add"></div>
			<div id="items" class="list">
				<div class="item">맥도날도</div>
				<div class="item">롯데리아</div>
				<div class="item">왕돈까스</div>
			</div>
		</div>
		<div id="detail">
			<h2>매장 정보</h2>
			<h3>맥도날도</h3>
			<div>여기는 새우버거가 맛있어요. 꼭 드셔보세요</div>
			<h4>메뉴(단위 : 원)</h4>
			<table id="tblMenu">
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500원</td>
					<td>고구마튀김</td>
					<td>3,000원</td>
				</tr>
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500원</td>
					<td>고구마튀김</td>
					<td>3,000원</td>
				</tr>
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500원</td>
					<td>고구마튀김</td>
					<td>3,000원</td>
				</tr>
			</table>
		</div>
		
		<!-- 맛집 등록 모달 창 -->
		<div data-modal-window="add" data-modal-title="등록하기" >
			<div id="subMap"></div>
			<table class="vertical">
				<tr>
					<th>카테고리</th>
					<td><select name="category"></select></td>
				</tr>
				<tr>
					<th>상호명</th>
					<td><input type="text" name="name"	required class="full"></td>
				</tr>
				<tr>
					<th>소개</th>
					<td><textarea name="description" required class="full" style="height:100px;"></textarea></td>
				</tr>
				<tr>
					<th>메뉴</th>
					<td><textarea name="menu" required class="full" style="height:100px;"></textarea></td>
				</tr>
			</table>
			<div>
				<button id = "btnOK" class="ok" data-modal-ok="add">확인</button>
				<button class="cancel" data-modal-cancel="add">닫기</button>
			</div>
			
			<!-- 마커좌표 -->
			<input type="hidden" name="lat" id="lat">
			<input type="hidden" name="lng" id="lng">
			
		</div>
		
	</main>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=909d6d857bd3d609a81d02972cddd225"></script>
	<script>
		const container = document.getElementById('map');
		
		const options = {
			center: new kakao.maps.LatLng(37.499314, 127.033192),
			level: 3
		};
	
		const map = new kakao.maps.Map(container, options);
		
		
		
		
		
		
		const container2 = document.getElementById('subMap');
		
		const options2 = {
			center: new kakao.maps.LatLng(37.499314, 127.033192),
			level: 3
		};
	
		const map2 = new kakao.maps.Map(container2, options2);

		//팝업 지도 잘 보이게 처리
		$('[data-modal-button="add"]').on('click',function(){
			setTimeout(function(){
				map2.relayout();
			},100);
		});
		
		
		//지도에 핑 찍기
		let m2 = null; //마커 변수
		kakao.maps.event.addListener(map2, 'click', evt =>{
			
			if(m2 != null) m2.setMap(null); // 기존 마커 삭제
			
			const path = '/food/resources/marker/bakery.png';
			const size = new kakao.maps.Size(48,48);
			const op = {offset : new kakao.maps.Point(24,48)};
			const img = new kakao.maps.MarkerImage(path,size,op);
			
			m2 = new kakao.maps.Marker({
				position : evt.latLng,
				image : img
			});
			
			m2.setMap(map2);
			
			//마커위치 > 히든태그
			$('#lat').val(evt.latLng.getLat());
			$('#lng').val(evt.latLng.getLng());
			 
		});
		
		
		
		
		
		
		//메뉴 입력 가이드
		const guideText = `메뉴명 :  가격
오무라이스 : 9,500
돈까스 : 7,900
냉모밀 : 8,500`;
		
		$('textarea[name=menu]').attr('placeholder',guideText);
		
		
		
		//초기화
		$.ajax({
			type : 'GET',
			url : 'http://localhost:8090/food/category',
			dataType : 'json',
			success : function(result) {
				$(result).each((index, item) =>{
					$('select[name=category]').append(`
						<option value="\${item.seq}">\${item.name}</option>		
					`);
				});
			},
			error : function(a, b, c) {
				console.log(a, b, c);
			}
		});
		
		
		//맛집 등록 버튼
		$('#btnOK').click(()=>{
			$.ajax({
				type : 'POST',
				url : 'http://localhost:8090/food/food',
				contentType = 'application/json; charset=UTF-8',	//주는거
				data : JSON.stringify({								//주는거
					category : $('select[name=category]').val(),
					name : $('input[name=name]').val(),
					description : $('textarea[name=description]').val(),
					menu : $('textarea[name=description]').val(),
					lat : $('input[name=lat]').val(),
					lng : $('input[name=lng]').val()
				}),			
				dataType : 'json',	//받는거
				success : function(result) {
					
				},
				error : function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
		});
		
		
		
	</script>
</body>
</html>






