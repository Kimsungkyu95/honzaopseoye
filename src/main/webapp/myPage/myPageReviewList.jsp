<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
    <title>myPageReviewList</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    
	<style>
    	h1{text-align:center;}
    </style>
   	
   	<script type="text/javascript">

   	</script>
   
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

	<h1 class="p-3 mb-2 bg-light text-dark">나의 리뷰</h1>
	<div class="p-5 mb-4 bg-light border rounded-3">
	 	<c:forEach items="${requestScope.list}" var="dto">
	 		<div class="card w-100">
			  <div class="card-body">
			    <h5 class="card-title">${dto.restaurantNo} &#60;${dto.restaurantName}&#62;</h5>
			    <a>레스토랑 레벨 : ${dto.restaurantLevel}</a>
			    <p class="card-text">내가 준 별점 : ${dto.reviewScore}</p>
			    <a>${dto.reviewRegdate}</a>
			    <p class="card-text">${dto.reviewContent}</p>
			    <a href="#" class="btn btn-primary">상세보기</a>
			  </div>
			</div>
	 	</c:forEach>
    </div>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    
    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>