<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>myPageWishList</title>
    
    <style>
    	h1{text-align:center;}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	$(function(){
		
	})
	</script>
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

	<h1 class="p-3 mb-2 bg-light text-dark">나의 위시리스트</h1>
	<div class="p-5 mb-4 bg-light border rounded-3">
		<div class="card" style="width:100%;">
		  <div class="card-body">
		  	<c:forEach items="${requestScope.wishList}" var="list">
		  		${wishList.restaurantNo}
		  		
		  		<div class="card mb-3" style="max-width: 540px;">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <img src="${path}/img/삼겹살.jpeg" class="img-fluid rounded-start" alt="...">
				    </div>
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title">프릳츠커피컴퍼니</h5>
				        <p class="card-text">양식 > 파스타 Lv.1 </p>
				        <p class="card-text"><small class="text-muted">서울특별시 서초구 강남대로37길</small></p>
				        <a href="#" class="card-link">상세페이지</a>
		    			<a href="#" class="card-link">길찾기</a>
				      </div>
				    </div>
				  </div>
				</div> 
						
		  	</c:forEach>
		  </div>
		</div>
		<br>
	<div class="col text-center">
	<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='${path}/myPage/myPage.jsp'">마이페이지</button>
	</div>
	</div>
	
    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>