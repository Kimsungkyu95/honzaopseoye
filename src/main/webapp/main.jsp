<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>main</title>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5ca07a49c944c9276cbfe517db8d17c"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script></script>
<style>
	.p-5 mb-4 bg-light border rounded-3{float:left}
	#frame{width:900px;}
	#map{width:450px; height:450px; float:left; margin-left: 50px;}
	#divSelect{margin-top:150px; display:flex; justify-content:center; width:500px}
	h4{text-align:center;}
	
</style>
</head>
<body>
 <jsp:include page="common/header.jsp"/>
 	
	<main >
 	
	  <div class="container py-5" style="float:left" id="frame">
		
		<h4>카테고리 검색</h4>
	    <div class="p-5 mb-4 bg-light border rounded-3">
	      <div class="container-fluid py-5">
	        <p class="col-md-6 fs-4"></p>
	        <button class="btn btn-outline-secondary" type="button">카테고리별 맛집</button>
	      </div>
	    </div>
	 
	
	    <div class="row align-items-md-stretch">
	      <div class="col-md-6">
	      <h4>추천맛집목록</h4>
	        <div class="h-100 p-5 text-white bg-light border rounded-3">
	          <img src = "img/삼겹살.jpeg" width="100%"></img>
	          <p></p>
	          <button class="btn btn-outline-secondary" type="button">맛집 추천</button>
	        </div>
	      </div>
	      
	      <div class="col-md-6">
	      <h4>맛집 칼럼</h4>
	        <div class="h-100 p-5 bg-light border rounded-3">
	          <img src = "img/회.jpeg" width="100%"></img>
	          <p></p>
	          <button class="btn btn-outline-secondary" type="button">맛집 스토리</button>
	        </div>
	      </div>
	    </div>
	    <div class="row align-items-md-stretch">
	    </div>
	  </div>
  
	</main>

		<div class="text-center" id="divSelect">
			  <h4 style="margin-top:10px">서울특별시 </h4>
			  <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" style="width:150px">
				  <option selected>~구</option>
				  <option value="1">강남구</option>
				  <option value="2">용산구</option>
				  <option value="3">송파구</option>
				</select>
			  <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" style="width:150px">
				  <option selected>~동</option>
				  <option value="1">청담동</option>
				  <option value="2">압구정동</option>
				  <option value="3">삼성동</option>
				</select>
		</div>
	
		
		<div id="map"> <!-- 지도를  생성할 div 영역  -->
			<script type="text/javascript" >
				var container = document.getElementById('map'); // 지도를 표시할 div 
				var options = {
					center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level: 3 // 지도의 확대 레벨
				};
			
				var map = new kakao.maps.Map(container, options); // 지도를 생성합니다
				
				// 마커가 표시될 위치입니다 
				var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 
			
				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
			   	 position: markerPosition
				});
		
				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);
			</script>
		</div>
		

	
	<footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="common/footer.jsp"/>
    </footer>
 
</body>
</html>