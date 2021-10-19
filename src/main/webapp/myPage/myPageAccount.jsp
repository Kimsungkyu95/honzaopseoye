<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath} <br>
\${path} : ${path}

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>myPageAccount</title>
    
    <style type="text/css">
    	table{text-align:center;}
    	h1{text-align:center;}
    </style>
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

	<h1 class="p-3 mb-2 bg-light text-dark">계정정보</h1>
    
    <div class="p-5 mb-4 bg-light border rounded-3">
    
    	<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">아이디</th>
		      <td>${memberDto.memberID }</td>
		    </tr>
		    <tr>
		      <th scope="row">이름</th>
		      <td><input type="text" name="id" value=${memberDto.memberName} /></td>
		    </tr>
		    <tr>
		      <th scope="row">이메일</th>
		      <td><input type="text" name="id" value=${memberDto.memberEmail} /></td>
		    </tr>
		    <tr>
		      <th scope="row">전화번호</th>
		      <td><input type="text" name="id" value=${memberDto.memberPhone } /></td>
		    </tr>
		    <tr>
		      <th scope="row">생년월일</th>
		      <td><input type="text" name="id" value=${memberDto.memberBirth } /></td>
		    </tr>
		  </tbody>
		</table>
    	
    	<button type="submit" class="btn btn-secondary btn-lg">수정하기</button>
		<button type="reset" class="btn btn-secondary btn-lg">취소</button>
		<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='myPage.jsp'">마이페이지</button>

	
    </div>




    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>