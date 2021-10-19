<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>restaurant</title>
<style>
	#map{width:200px; height:200px; float:left; margin-left: 50px;}
	#div1{width:60%}
	#div2{width:40%}
	td{padding:3px}
	#map{width:200px; height:300px; align:center;}
	.a{color:black; text-decoration:none; font-size:18px}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5ca07a49c944c9276cbfe517db8d17c&libraries=services"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>
<script type="text/javascript"></script>
</head>
<body>

<jsp:include page="common/header.jsp"/>

<div class="d-grid gap-2 d-md-block" style="margin:20px 10px; padding-left:100px" id="reviewWish">
  <a href ="${pageContext.request.contextPath}/userStory/userStoryCreate.jsp" class="a"> 
	  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
	  	<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
	  </svg>
	  리뷰쓰기
  </a>
  
  <a href ="#" class="a" style="margin-left:20px">
	  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
	  	<path d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
	  </svg>
	  위시리스트
  </a>
</div>

<div class="row g-5" id="frame">

<div class="col-md-4" id="div1">
      <div class="position-sticky" style="top: 2rem;">
        <div class="p-4 mb-3 bg-light rounded">
          <img src = "img/restaurantImage/.jpeg" width="47%" style="float:left; margin-right:10px"></img>
          <img src = "img/삼겹살.jpeg" width="47%"></img>
        </div>

        <div class="p-4" style="margin-left:100px">
          <h4 class="fst-italic">${restaurant.restaurantName}</h4>
		
          <table class="list-unstyled mb-0">
          	<tbody>
	            <tr>
	            	<td>별점</td>
	            	<td>:</td>
	            	<td>4.3(별모양도 출력)</td>
	            </tr>
	            <tr>
	            	<td>리뷰</td>
	            	<td>:</td>
	            	<td>갯수</td>
	            </tr>
	            <tr>
	            	<td>레벨</td>
	            	<td>:</td>
	            	<td>LV ${restaurant.restaurantLevel}</td>
	            </tr>
            </tbody>
            
           
           
          </table>
        </div>
       <hr>
         <div class="p-4" style="margin-left:100px">
           <table class="list-unstyled mb-0">
           <tbody>
           <tr>
            	<td colspan="3"><h4 class="fst-italic">상세정보</h4></td>
            </tr>
            <tr>
            	<td>주소</td>
            	<td>:</td>
            	<td>${restaurant.restaurantAddr} / ${restaurant.restaurantRoadAddr}</td>
            </tr>
            <tr>
            	<td>전화번호</td>
            	<td>:</td>
            	<td>${restaurant.restaurantPhone}</td>
            </tr>
            <tr>
            	<td>음식종류</td>
            	<td>:</td>
            	<td><%=request.getAttribute("${param.category}") %></td>
            </tr>
            <tr>
            	<td>가격대</td>
            	<td>:</td>
            	<td>2만~3만원대</td>
            </tr>
            <tr>
            	<td>주차</td>
            	<td>:</td>
            	<td>3대</td>
            </tr>
            <tr>
            	<td>영업시간</td>
            	<td>:</td>
            	<td>10:00~22:00</td>
            </tr>
            <tr>
            	<td>메뉴</td>
            	<td>:</td>
            	<td>냉면,된장찌개</td>
            </tr>
             </tbody>
          </table>
         </div>
     <!-- 맛집 지도 -->
     <div class="row align-items-md-stretch">
     
      <div class="col-md-6">
         <div class="h-100 p-5 bg-light border rounded-3">
         <h4>맛집 위치</h4>
          <div id="map"> 
			<script type="text/javascript" >
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${restaurant.restaurantAddr}', function(result, status) {

		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${restaurant.restaurantName}</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
			</script>
		</div>
		
       </div>
      </div>
      <!-- 별점 차트 -->
      <div class="col-md-6">
        <div class="h-100 p-5 bg-light border rounded-3">
          <h4>별점 차트</h4>
          <div style="width:300px; height:300px;">
			<!-- 차트가 그려질 부분 -->
			<canvas id ="myChart"></canvas>
		 </div>
        </div>
      </div>
    </div>
      
      
<script type="text/javascript">
var context = document
	.getElementById('myChart')
	.getContext('2d');
var myChart = new Chart(context, {
	type : 'bar', //차트의 형태
	data : {//차크에 들어갈 데이터
		labels : [
			'1', '2', '3', '4', '5'
		],
		datasets : [
			{ //데이터
				label : 'test1', //차트 제목
				fill :false, //line형태일 때, 선 안쪽을 채우는지 안채우는지 
				data : [
					21,19,25,20,23,26,25 //x축 label에 대응되는 데이터 값
				],
				backgroundColor : [
					//색상
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)',
					'rgba(75, 192, 192, 0.2)',
					'rgba(153, 102, 255, 0.2)',
					'rgba(255, 159, 64, 0.2)'
				],
				borderColor : [
					//경계선 색상
					'rgba(255, 99, 132, 1)',
					'rgba(54, 162, 235, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 159, 64, 1)'
				],
				borderWidth : 1 //경계선 굵기
			}
		]
	},
	option : {
		scales : {
			yAxes : [
				{
					ticks : {
						beginAtZero :true
					}
				}
			]
		}
	}
});
	</script>
  </div>  
</div>
 
    <div class="col-md-8" id="div2">
		      <h2 class="pb-4 mb-4 fst-italic border-bottom">
		        리뷰 
		      </h2>
			<c:choose>
		 		<c:when test="${empty restaurant.reviewList}">
					<h5>리뷰정보가 없습니다</h5>
				</c:when>
			<c:otherwise>
				<c:forEach items="${restaurant.reviewList}" var="review"> 
			     <article class="blog-post">
			        <h4 class="blog-post-title">리뷰제목 / ${review.reviewScore}</h4>
			        <p class="blog-post-meta">${review.reviewRegdate} / 아이디 존재유무?</p>
			        <p>${review.reviewContent}</p>
			        <hr> 
			      </article>
				</c:forEach>
			</c:otherwise>
		      
		 </c:choose> 
		 
 	</div>
 	
</div><!-- 큰틀 끝 -->
<div style="margin-top:10px">
<jsp:include page="common/footer.jsp"/>
</div>
</body>

</html>