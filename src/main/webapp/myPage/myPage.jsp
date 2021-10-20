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
	
	<script type="text/javascript" >
	</script>
	
    <title>myPage</title>
    <style>
    	h1{text-align:center;}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	let id = "${loginId}";
	console.log("text");
	console.log("id : "+id);
})
</script>
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <!-- 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 -->
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    
    <h1 class="p-3 mb-2 bg-light text-dark">마이페이지</h1>
    
	<div class="row row-cols-1 row-cols-md-2 g-4">

	
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">계정정보</h5>
        <p class="card-text">
        	중요 내용을 알려드릴 때 사용하는 연락처 정보입니다.
        	<br>
        	수정화면에서 확인가능합니다.
        </p>
       <!--  <button type="button" onclick="location.href='myPageAccount.jsp'" class="btn btn-secondary btn-lg">수정</button> -->
       <a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=selectMemberByID&memberID=${loginId}">수정하기</a>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">프로필 변경</h5>
        <p class="card-text">
        	나를 표현하는 프로필 정보입니다. <br>
			수정화면에서 프로필 사진을 변경하세요.        
        </p>
        <!-- <button type="button" onclick="location.href='myPageImage.jsp'" class="btn btn-secondary btn-lg">수정</button> -->
       <a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=selectProfileImageById&memberID=${loginId}">수정하기</a>
        
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">비밀번호 변경</h5>
        <p class="card-text">
        	로그인시 사용하는 비밀번호를 변경합니다.<br>
        	개인정보를 안전하게 보호하세요.        
        </p>
        <a class="nav-link" href="${pageContext.request.contextPath}/myPage/myPagePassword.jsp">확인하기</a>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">나의 레벨</h5>
        <p class="card-text">
        	현재 나의경험치와 레벨을 확인하세요<br>
    		다음 레벨까지의 남음 경험치를 확인해보세요.			
        </p>
        <a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=selectExpById&memberID=${loginId}">확인하기</a>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">나의 리뷰</h5>
        <p class="card-text">
        	내가 작성한 리뷰들을 관리할 수 있습니다. 
        	<br>
        	조회, 수정, 삭제가 가능합니다.
        </p>
        <a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=selectReviewList&memberID=${loginId}">리뷰보기</a>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">위시리스트</h5>
        <p class="card-text">
        	내가 저장한 위시리스트를 관리할 수 있습니다.  
        	<br>
        	조회, 수정, 삭제가 가능합니다.  	
        </p>
        <button type="button" onclick="location.href='myPageWishList.jsp'" class="btn btn-secondary btn-lg">WISHLIST</button> 
      </div>
    </div>
  </div>
  
  <a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=selectMemberList">유저관리자페이지</a>
  

 
  
</div>
    
    
    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>