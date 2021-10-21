<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
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
<script src="js/jquery-3.6.0.min.js"></script>
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
	let 송파구 = ["오금동","석촌동","삼전동","문정동","장지동","잠실동"];
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
	      <h4><a href="${path}/front?key=userStory&methodName=selectAll">맛집 스토리 목록</a></h4>
	          <img class ="mouseOver" src = "img/회.jpeg" style="width:99%; height:100%">
	          <div class="text" style="margin:0px">
      				<a href="${path}/front?key=userStory&methodName=selectAll"><h4 style="color:white">맛집 스토리</h4></a>
    		 </div>
	      </div>
	      
	    </div>
	   </div> <!-- 메인맛집부분 div끝  -->
	   
	</main>
	
		<!-- select로 위치 찾기 -->
		<div class="text-center" id="divSelect">
			  <form name="f"  style="margin-left:4px" method="get" action="${path}/front">
				  	<input type="hidden" name="key" value="userRestaurant">
				    <input type="hidden" name="methodName" value="selectByGu">
				  <select name="gu" onChange = "findLocation(this, form)" id="gu">
				       <option value="0">--지역구 선택 --</option>
				       <option value="송파구">송파구</option>
					   <option value="강남구">강남구</option>
					   <option value="서초구">서초구</option>
					   <option value="용산구">용산구</option>
					   <option value="종로구">종로구</option>
	   			  </select>
				  <select name="dong" id="dong">
	       			   <option value="0">--동 선택--</option>
	   			  </select>
	   			  <span>
	   			 	 <button class="btn btn-outline-success"  id ="btn"  type="submit" style="height:40px; margin-left:4px">찾기</button>
	   			 </span>
   			 </form>
		</div>
		
		<div id="map" style="width:450px; height:450px;">
				<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
				    mapOption = { 
				        center: new kakao.maps.LatLng(37.508841, 127.100017), // 지도의 중심좌표
				        level: 8 // 지도의 확대 레벨
				    };
				
				var reName = new Array();
				var lat = new Array();
				var lng = new Array();
				<c:forEach items="${requestScope.list}" var="restaurant" varStatus="state">
					reName.push("${restaurant.restaurantName}"); 
					lat.push("${restaurant.restaurantLatitude}");
					lng.push("${restaurant.restaurantLongitude}");
				</c:forEach>
				for ( var i = 0; i < reName.length; i++) {
					 	console.log(reName[i])
					 	console.log(lat[i])
					 	console.log(lng[i])
				} 
				var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
				// 마커 이미지의 이미지 주소입니다
				var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
				for (var i = 0; i < reName.length; i ++) {
				    
				    // 마커 이미지의 이미지 크기 입니다
				    var imageSize = new kakao.maps.Size(24, 35); 
				    
				    // 마커 이미지를 생성합니다    
				    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
				    
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position:  new kakao.maps.LatLng(lat[i], lng[i]), // 마커를 표시할 위치
				        title : reName[i], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				        image : markerImage // 마커 이미지 
				    });
				}
				</script>
		</div>
 		
		
	<footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="common/footer.jsp"/>
    </footer>
 
</body>
</html>