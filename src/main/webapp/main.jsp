<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>main</title>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5ca07a49c944c9276cbfe517db8d17c&libraries=services"></script>
<script  src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$(".mouseOver").mouseover(function(){
			$(this).css("opacity", "0.3");
		});
		$(".mouseOver").mouseout(function(){
			$(this).css("opacity", "1");
		});
	})
	
	let 송파구 = ["풍납동","거여동","마천동","방이동","오륜동"	,"오금동","송파동","석촌동","삼전동","가락동"	,"문정동","장지동","잠실동"];
	function findLocation(th, fr){
	  	while(fr.dong.length>1){
	  		fr.dong.options[1] = null;
	  	}
	  	let arr = new Function('return ' + th.value)();
		for(i=0; i<arr.length; i++){
			fr.dong.options[fr.dong.length] = new Option(arr[i], arr[i]);
		}
	}
	/* 
	function searchKeyword(fr) {
		if(fr.gu.value=="0"){
			alert("구를 선택 하세요.")
			return;
		}
		else if(fr.dong.value=="0"){
			alert("동을 선택 하세요.")
			return;
		} */
		
		/* fr.submit(); */
	
</script>

<style>
	.p-5 mb-4 bg-light border rounded-3{float:left}
	#frame{width:900px;}
	#map{width:450px; height:450px; float:left; margin-left: 50px;}
	#divSelect{margin-top:150px; display:flex; justify-content:center; width:500px}
	h4{text-align:center;}
	a:link, a:visited{color:black; text-decoration:none; padding-left:2px}
	.col-md-6{height:300px; position: relative;}
	.col-md-6 .text{position:absolute; top:200px; left:185px}
	.text{color:white; padding: 5px 10px; text-align: center; top: 50%;
	left: 50%; transform: translate( -30%, -70% );}
	
	select{height:40px}
	
</style>
</head>
<body>

 <jsp:include page="common/header.jsp"/>
 	
	<main >
 	  <!--메인 맛집 부분 div -->
	  <div class="container py-5" style="float:left" id="frame">
	  
		<!-- 카테고리 div -->
		<h4><a href="${path}/userCategory/categoryByRestaurant.jsp">카테고리별 검색</a></h4>
	    <div class="p-4 mb-4 bg-light border rounded-3" style="height:300px">
	     
	        <span><img class ="mouseOver" src = "img/한식.jpeg" style="width:32%; height:100%; margin-right:5px"></span>
	        <span><img class ="mouseOver" src = "img/디저트.png" style="width:32%; height:100%; margin-right:5px"></span>
	        <span><img class ="mouseOver" src = "img/스테이크.jpeg" style="width:32%; height:100%"></span>
	      
	    </div>
	 
		<!-- 추천맛집 div -->
	    <div class="row align-items-md-stretch">
	      <div class="col-md-6" preserveAspectRatio="xMidYMid slice">
	      <h4><a href="${path}/recommend/recommendList.jsp">추천 맛집 목록</a></h4>
	              <img class ="mouseOver" src = "img/삼겹살.jpeg" style="width:99%; height:100%">
	      		  <div class="text">
      					<a href="${path}/recommend/recommendList.jsp"><h4 style="color:white">추천맛집</h4></a>
    			  </div>
	      </div>
	      
	      <!-- 맛집스토리 div -->
	      <div class="col-md-6">
	      <h4><a href="${path}/userStory/userStoryList.jsp">맛집 스토리 목록</a></h4>
	          <img class ="mouseOver" src = "img/회.jpeg" style="width:99%; height:100%">
	          <div class="text" style="margin:0px">
      				<a href="${path}/userStory/userStoryList.jsp"><h4 style="color:white">맛집 스토리</h4></a>
    		 </div>
	      </div>
	      
	    </div>
	   </div> <!-- 메인맛집부분 div끝  -->
	   
	</main>
	
		<!-- select로 위치 찾기 -->
		<div class="text-center" id="divSelect">
			  <form name="f"  style="margin-left:4px" method="post" action="${path}/front">
				  	<input type="hidden" name="key" value="userRestaurant">
				    <input type="hidden" name="methodName" value="selectByGu">
				  <select name="gu" onChange = "findLocation(this, form)">
				       <option value="0">--지역구 선택 --</option>
				       <option value="송파구">송파구</option>
					   <option value="강남구">강남구</option>
					   <option value="서초구">서초구</option>
					   <option value="용산구">용산구</option>
					   <option value="종로구">종로구</option>
	   			  </select>
				  <select name="dong">
	       			   <option value="0">--동 선택--</option>
	   			  </select>
	   			  <span>
	   			 	 <button class="btn btn-outline-success"  type="submit" style="height:40px; margin-left:4px">찾기</button>
	   			 </span>
   			 </form>
		</div>
	
		<!-- 지도를  생성할 div 영역  -->
		<script type="text/javascript">
			$(function(){
				$("#btn").click(function() {
					//let params = {gu : $("#gu").val(), food:$("#food").val()};
					$("#map").load("mainMap/multiMarker.jsp");
				}); 
			});
		</script>
 		<div id="map">
 			<script>
			 			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			 		    mapOption = { 
			 		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			 		        level: 6 // 지도의 확대 레벨 
			 		    }; 
			
			 		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			 		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
			 		if (navigator.geolocation) {
			 		    
			 		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
			 		    navigator.geolocation.getCurrentPosition(function(position) {
			 		        
			 		        var lat = position.coords.latitude, // 위도
			 		            lon = position.coords.longitude; // 경도
			 		        
			 		        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
			 		            message = '<div style="padding:5px;">현재위치</div>'; // 인포윈도우에 표시될 내용입니다
			 		        
			 		        // 마커와 인포윈도우를 표시합니다
			 		        displayMarker(locPosition, message);
			 		            
			 		      });
			 		    
			 		} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
			 		    
			 		    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
			 		        message = 'geolocation을 사용할수 없어요..'
			 		        
			 		    displayMarker(locPosition, message);
			 		}
			
			 		// 지도에 마커와 인포윈도우를 표시하는 함수입니다
			 		function displayMarker(locPosition, message) {
			
			 		    // 마커를 생성합니다
			 		    var marker = new kakao.maps.Marker({  
			 		        map: map, 
			 		        position: locPosition
			 		    }); 
			 		    
			 		    var iwContent = message, // 인포윈도우에 표시할 내용
			 		        iwRemoveable = true;
			
			 		    // 인포윈도우를 생성합니다
			 		    var infowindow = new kakao.maps.InfoWindow({
			 		        content : iwContent,
			 		        removable : iwRemoveable
			 		    });
			 		    
			 		    // 인포윈도우를 마커위에 표시합니다 
			 		    infowindow.open(map, marker);
			 		    
			 		    // 지도 중심좌표를 접속위치로 변경합니다
			 		    map.setCenter(locPosition);      
			 		}    
 			</script>
 		
		</div>
		
		

	
	<footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="common/footer.jsp"/>
    </footer>
 
</body>
</html>