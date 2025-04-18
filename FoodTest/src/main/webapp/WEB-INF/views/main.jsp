<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
<style>
	#main {
		margin: 1rem;
		display: grid;
		grid-template-columns: calc(900px - 2rem) 300px;
		grid-template-rows: 400px;
	}
	
	#main #map {
		/* background: tomato; */
		border: 1px solid gray;
		border-radius: 5px;
	}
	
	#main #list {
		/* background: gold; */
		grid-row: 1/3;
		grid-column: 2/3;
	}
	
	#main #list input[type=button] {
		width: 280px;
		display: block;
		margin-bottom: 15px;
	}
	
	#main #list #items {
		margin: 0px;
		width: 280px;
	}
	
	#main #detail {
		/* background: cornflowerblue; */
		
	}
	
	#main #detail #tblMenu td:nth-child(odd) {
		width: 300px;
	}
	
	#main #detail #tblMenu td:nth-child(even) {
		width: 100px;
		text-align: right;
	}
	
	#subMap {
		border: 1px solid gray;
		border-radius: 5px;
		width: 480px;
		height: 300px;
		margin-bottom: 10px;
	}
	
	#subMap+table {
		width: 480px;
	}
	
	#items .item:hover {
		background-color: #EFEFEF;
		cursor: pointer;
	}
	
</style>
</head>
<body class="wide">
	<!-- main.jsp -->
	<h1>
		Food <small>Map</small>
	</h1>

	<main id="main">
		<div id="map">지도</div>
		<div id="list">
			<div>
				<input type="button" value="등록하기" data-modal-button="add">
			</div>
			<div id="items" class="list">
				<!-- <div class="item">맥도날드</div> -->
			</div>
		</div>
		<div id="detail">
			<!-- 
			<h2>매장 정보</h2>
			<h3>맥도날드</h3>
			<div>여기는 새우버거가 맛있어요. 꼭 드셔보세요~</div>
			<h4>메뉴(단위: 원)</h4>
			<table id="tblMenu">
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500</td>
					<td>상하이 버거 세트</td>
					<td>7,500</td>
				</tr>
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500</td>
					<td>상하이 버거 세트</td>
					<td>7,500</td>
				</tr>
				<tr>
					<td>상하이 버거 세트</td>
					<td>7,500</td>
					<td></td>
					<td></td>
				</tr>
			</table> 
			-->
		</div>
	</main>

	<!-- 맛집 등록 창 -->
	<div data-modal-window="add" data-modal-title="등록하기">
		<!-- 
		<div>지도</div>
		<div>맛집명</div>
		<div>카테고리</div>
		<div>위치</div> 
		-->
		<div id="subMap"></div>
		<table class="vertical">
			<tr>
				<th>카테고리</th>
				<td><select name="category"></select></td>
			</tr>
			<tr>
				<th>상호명</th>
				<td><input type="text" name="name" required class="full"></td>
			</tr>
			<tr>
				<th>소개</th>
				<td><textarea name="description" required class="full"
						style="height: 100px;"></textarea></td>
			</tr>
			<tr>
				<th>메뉴</th>
				<td><textarea name="menu" required class="full"
						style="height: 100px;"></textarea></td>
			</tr>
		</table>
		<div>
			<button class="ok" data-modal-ok="add" id="btnOk">확인</button>
			<button class="cancel" data-modal-cancel="add">닫기</button>
		</div>

		<!-- 마커 좌표 -->
		<input type="hidden" name="lat" id="lat"> <input type="hidden"
			name="lng" id="lng">
	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=909d6d857bd3d609a81d02972cddd225"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
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
		$('[data-modal-button="add"]').on('click', function() {
		    setTimeout(function() {
		        map2.relayout();
		    }, 100);
		});
		
		//메인 맵에서 사용할 마커
		let m = null;
		
		//등록 맵에서 마커 추가 이벤트
		let m2 = null; //마커
		const markerImages = [];
		let markerImage;
		
		kakao.maps.event.addListener(map2, 'click', evt => {
			
			if (m2 != null) m2.setMap(null); //기존 마커 삭제
			
			const path = '/food/resources/marker/' + markerImage;
			const size = new kakao.maps.Size(48, 48);
			const op = { offset: new kakao.maps.Point(24, 48) };
			const img = new kakao.maps.MarkerImage(path, size, op);
			
			m2 = new kakao.maps.Marker({
				position: evt.latLng,
				image: img
			});
			
			m2.setMap(map2);
			
			//마커 위치 > 히든 태그
			$('#lat').val(evt.latLng.getLat());
			$('#lng').val(evt.latLng.getLng());
			
		});
		
		
		
		
		//메뉴 입력 가이드
		const guideText = `[메뉴명]:[가격]
오무라이스:9,500
냉모밀:8,500
안심까스:12,000`;
		
		$('textarea[name=menu]').attr('placeholder', guideText);
		
		
		
		
		
		//초기화
		
		$.ajax({
			type : 'GET',
			url : 'http://localhost:8090/food/category',
			dataType : 'json',
			success : function(result) {
				
				$(result).each((index, item)=>{
					
					$('select[name=category]').append(`
						<option value="\${item.seq}">\${item.name}</option>		
					`);
					
					//마커 이미지 목록
					markerImages.push(item.marker);
					
				});
				
				markerImage = markerImages[0];
				
			},
			error : function(a, b, c) {
				console.log(a, b, c);
			}
		});
		
		
		
		//맛집 등록 버튼
		$('#btnOk').click(()=>{
			
			
			/* 
			alert(JSON.stringify({
				category: $('select[name=category]').val(),
				name: $('input[name=name]').val(),
				description: $('textarea[name=description]').val(),
				menu: $('textarea[name=menu]').val(),
				lat: $('input[name=lat]').val(),
				lng: $('input[name=lng]').val()
			}));
			
			return;
			*/
			
			
			$.ajax({
				type : 'POST',
				url : 'http://localhost:8090/food/food',
				contentType: 'application/json; charset=UTF-8',
				data: JSON.stringify({
					category: $('select[name=category]').val(),
					name: $('input[name=name]').val(),
					description: $('textarea[name=description]').val(),
					menu: $('textarea[name=menu]').val(),
					lat: $('input[name=lat]').val(),
					lng: $('input[name=lng]').val()
				}),
				dataType : 'json',
				success : function(result) {
					listFood();
				},
				error : function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
		});
				
	
		//카테고리 선택 > 마커 이미지 변경
		$('select[name=category]').change(()=>{
			
			if (m2 != null) {
				const img = new kakao.maps.MarkerImage(
					'/food/resources/marker/' + markerImages[event.target.selectedIndex],
					new kakao.maps.Size(48, 48),
					new kakao.maps.Point(24, 48)
				);
				
				m2.setImage(img);
			} else {
				markerImage = markerImages[event.target.selectedIndex];
			}
			
		});
		
		
		function listFood() {
		
			$.ajax({
				type: 'GET',
				url: '/food/food',
				dataType: 'json',
				success: function(result) {
					//alert(result);
					
					$('#items').html('');
					
					$(result).each((index, item)=>{
						//<div class="item">맥도날드</div>
						
						$('#items').append(`
							<div class="item" onclick="info(\${item.seq})">\${item.name}</div>
						`);
						
					});
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
			
		}
		
		listFood();
		
		
		function info(seq) {
			//alert(seq);
			
			let item = event.target;
			
			$.ajax({
				type : 'GET',
				url : 'http://localhost:8090/food/food/' + seq,
				dataType : 'json',
				success : function(result) {
					
					//console.log(result); //FoodDTO
					
					//마커
					if (m != null) m.setMap(null); //기존 마커 삭제
					
					const path = '/food/resources/marker/' + result.markerImage;
					const size = new kakao.maps.Size(48, 48);
					const op = { offset: new kakao.maps.Point(24, 48) };
					const img = new kakao.maps.MarkerImage(path, size, op);
					
					m = new kakao.maps.Marker({
						position: new kakao.maps.LatLng(result.lat, result.lng),
						image: img
					});
					
					m.setMap(map);
					map.panTo(new kakao.maps.LatLng(result.lat, result.lng));
					
					
					
					$('#items .item').css('background', '#FFF');
					$(item).css('background', '#EFEFEF');
					
					
					$('#detail').html('');
					
					let temp = `
						<h2>매장 정보</h2>
						<h3>\${result.name}</h3>
						<div>\${result.description}</div>
						<h4>메뉴(단위:원)</h4>
						
						<table id="tblMenu">
							<tr>
					`;
					
					$(result.mlist).each((index,item)=>{
						temp += `
								<td>\${item.name}</td>
								<td>\${item.price}</td>
						`;
						if (index % 2 == 1) {
							temp += '</tr><tr>';
						}
					});
					
					if (result.mlist.length % 2 == 1) {
						temp += '<td></td><td></td>';
					}
					
					temp += '</tr></table>';
					
					
					$('#detail').append(temp);
					
				},
				error : function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
		}
		
	</script>
</body>
</html>







