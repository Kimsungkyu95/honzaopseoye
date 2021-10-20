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
	/* let songpa=["풍납동","거여동","마천동","방이동","오륜동","오금동","송파동","석촌동","삼전동","가락동",	"문정동","장지동","위례동",	"잠실동"];
	let gangnam=["압구정동","청담동","삼성동","논현동"];
  	let seocho=["서초동","반포동","잠원동"];
  	let yongsan=["용산동","이태원동","한남동","보광동"];
  	let jongno=["익선동","후암동","청운동","팔운동","낙원동"];
  	function findLocation(th, fr){
	  	while(fr.dong.length>1){
		  		fr.dong.options[1] = null;
		  	}
		  	
		  	let arr = new Function('return ' + th.value)();
		  	
			for(i=0; i<arr.length; i++){
				fr.dong.options[fr.dong.length] = new Option(arr[i], arr[i]);
			} */
  	}
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
			  <form name="f"  style="margin-left:4px" action="mainMap/mainMap.jsp" method="get">
			  <select id ="gu" name="gu" onChange = "findLocation(this, form)">
			       <option value="0">--지역구 선택 --</option>
			       <option value="송파구">송파구</option>
				   <option value="강남구">강남구</option>
				   <option value="서초구">서초구</option>
				   <option value="용산구">용산구</option>
				   <option value="종로구">종로구</option>
   			  </select>
			  <select id="food" name="food">
       			   <option value="0">--음식종류--</option>
       			   <option value="디저트">디저트</option>
       			   <option value="패스트푸드">패스트푸드</option>
       			   <option value="피자">피자</option>
       			   <option value="치킨">치킨</option>
       			   <option value="분식">분식</option>
       			   <option value="한식">한식</option>
       			   <option value="일식">일식</option>
       			   <option value="중식">중식</option>
       			   <option value="양식">양식</option>
       			   <option value="뷔페">뷔페</option>
       			  <option value="술집">술집</option>
   			  </select>
   			  </form>
   			 <button class="btn btn-outline-success" id="btn" type="submit" style="height:40px; margin-left:4px">찾기</button>
		</div>
	
		<!-- 지도를  생성할 div 영역  -->
		<script type="text/javascript">
			$(function(){
				$("#btn").click(function() {
					let params = {gu : $("#gu").val(), food:$("#food").val()};
					$("#map").load("mainMap/mainMap.jsp",params);
				});
			});
		</script>
 		<div id="map">
 		
 		
		</div>
		
		

	
	<footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="common/footer.jsp"/>
    </footer>
 
</body>
</html>