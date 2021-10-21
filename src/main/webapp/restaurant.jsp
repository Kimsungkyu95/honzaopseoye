<%@page import="java.util.List"%>
<%@page import="dto.ReviewDTO"%>
<%@page import="dto.RestaurantDTO"%>
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
	#locationTitle{margin-left:100px}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a5ca07a49c944c9276cbfe517db8d17c&libraries=services"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>
<script type="text/javascript">
	let json = {dessert:"디저트", fastfood:"패스트푸드", pizza:"피자", chicken:"치킨",
						snack:"분식", meat:"고기", soup:"국밥", nuddle:"국수" , coldnuddle:"냉면", hanjeongsik:"한정식", 
						porkcutlet:"돈까스", lamen :"일본라멘", sushi: "초밥", sashimi:"회", chinese:"중화요리",
						italian:"이탈리안", worldfood:"세계음식", buffef:"뷔페",bar:"술집"
					}
    function inputCategory(categoryDetailsName) {
		var keys = Object.keys(json);  //키를 가져온다.
    	for (var i=0; i<keys.length; i++) {
        	var str ='';
        	var key = keys[i];
        	if(key==categoryDetailsName){
        		document.getElementById('category').innerHTML = json[key];
        	}
        	
        }
    	  

   	}
	
	//리뷰 ajax 등록
	$(function(){
		$('#registerReview').click(function(){
			$.ajax({
                url: "${path}/insertReviewServlet", //서버요청주소
                type: "post", //method방식(get, post, put, delete)
                dataType: "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
                data: { restaurantNo: "${restaurant.restaurantNo}",
                	reviewContent: $('#reviewTextArea').text(),
                	reviewScore: $('#reviewScore').val()
                }, //서버에게 보낼 parameter정보
                success: function (result) {
                    alert(result);             	
                }, //성공했을 때 callback함수
                error: function (err) {
                    alert(err + "발생했어요.");
                } //실패했을 때 callback함수
            }); //ajax 끝
		})
	})
    
</script>

</head>
<body>

<jsp:include page="common/header.jsp"/>

<div class="d-grid gap-2 d-md-block" style="margin:20px 10px; padding-left:100px; height: 40px;" id="reviewWish">
</div>

<div class="row g-5" id="frame">
<div class="col-md-4" id="div1">
      <div class="position-sticky" style="top: 2rem;">
        <div class="p-4 mb-3 rounded">
          <img src="${restaurant.imgList[0]}" width="47%" style="float:left; margin-right:10px"/> 
          <img src="${restaurant.imgList[1]}" width="47%"/>
        </div>

        <div class="p-4" style="margin-left:100px">
          <h4 class="fst-italic">${restaurant.restaurantName}</h4>
		
          <table class="list-unstyled mb-0">
          	<tbody>
	            <tr>
	            	<td>별점</td>
	            	<td>:</td>
	            	<td>
		            	<%
		            		RestaurantDTO restaurantDTO =  (RestaurantDTO)request.getAttribute("restaurant");
		            		List<ReviewDTO> reviewList = restaurantDTO.getReviewList();
		            		int sum = 0;
		            		for(int i=0; i<reviewList.size(); i++){
		            			sum += reviewList.get(i).getReviewScore();
		            		}
		            		double avg=0.0;
		            		avg = (double)sum/reviewList.size();
		            	%>
		            	<%=avg %>
	            	</td>
	            </tr>
	            <tr>
	            	<td>리뷰개수</td>
	            	<td>:</td>
	            	<td>
	            		<%=reviewList.size() %>
	            	</td>
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
            	<td>
            		<div id="category">
            			<script>inputCategory('${restaurant.categoryDetailsName}')</script>
            		</div>
            	</td>
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
          <h4>리뷰쓰기</h4>

			<div class="mb-3 mt-3">
			  <textarea class="form-control" id="reviewTextArea" rows="5"></textarea>
			  <div style="margin-top: 10px;">별점 : <input type="number" min="1" max="5" value="1" id="reviewScore"></div>
			</div>
			<div class="bottom-btn">
	 			<button class="btn btn-primary" id="registerReview">등록</button>
			</div>

        </div>
      </div>
    </div>
      
    
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
			        <h4 class="blog-post-title">별점 : ${review.reviewScore}</h4>
			        <p class="blog-post-meta">${review.reviewRegdate} / 익명</p>
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