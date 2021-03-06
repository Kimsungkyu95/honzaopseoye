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

    <title>myPageLevel</title>
    
    <style>
    	h1{text-align:center;}
    	h3{text-align:center;}
    </style>   
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    
    
    <h1 class="p-3 mb-2 bg-light text-dark">나의 레벨</h1>
    
    <div class="p-5 mb-4 bg-light border rounded-3">
    	<a></a>
    	
    	<!-- 게이지바 -->
    	<div class="progress">
		  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: ${(levelExp.memberExp-levelExp.minExp) / (levelExp.maxExp-levelExp.minExp) * 100}%"></div>
		</div>
    	<br>
    	<br>
    	<h3>현재 레벨 : <a>${levelExp.memberLevel}</a></h3>
    	<h3>다음 레벨까지 남은 경험치 : <a>${levelExp.maxExp - levelExp.memberExp}Exp</a></h3>
    	<br>
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