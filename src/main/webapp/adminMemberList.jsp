<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>adminMemberList</title>
    
    <style>
    	h1{text-align:center;}
    </style>
  </head>
  <body>
  <jsp:include page="common/header.jsp"/>

    <h1>회원관리</h1>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>


	<div class="h-100 p-5 bg-light border rounded-3">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">회원번호</th>
		      <th scope="col">아이디</th>
		      <th scope="col">이름</th>
		      <th scope="col">가입일</th>
		      <th scope="col">경험치</th>
		    </tr>
		  </thead>
		  
		  
		  
		  <tbody>
		    <tr>
		      <th scope="row">memberNo</th>
		      <!-- id를 가져고 이동 -->
		      <td><a href="adminMemberDetail.jsp">memberId</td>
		      <td>memberName</td>
		      <td>memberJoinDate</td>
		      <td>memberExp</td>
		    </tr>
		  </tbody>
		  
		  
		  
		</table>
	</div>

	<footer class="pt-3 mt-4 text-muted border-top">
	</footer>
	 </div>
	</main>
	<hr>
	<jsp:include page="common/footer.jsp"/>
</body>
</html>