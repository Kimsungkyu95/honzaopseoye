<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>main</title>
<style>
	
</style>
<script type="text/javascript" >

</script>
</head>
<body>
 <jsp:include page="common/header.jsp"/>
 	
 	<main>
  <div class="container py-4">
	
	<h3>카테고리 검색</h3>
    <div class="p-5 mb-4 bg-light border rounded-3">
      <div class="container-fluid py-5">
        <p class="col-md-8 fs-4"></p>
        <button class="btn btn-outline-secondary" type="button">카테고리별 맛집</button>
      </div>
    </div>
 

    <div class="row align-items-md-stretch">
      <div class="col-md-6">
      <h3>추천맛집목록</h3>
        <div class="h-100 p-5 text-white bg-light border rounded-3">
          <img src = "img/삼겹살.jpeg" width="100%"></img>
          <p></p>
          <button class="btn btn-outline-secondary" type="button">맛집 추천</button>
        </div>
      </div>
      <div class="col-md-6">
      <h3>맛집 칼럼</h3>
        <div class="h-100 p-5 bg-light border rounded-3">
          <img src = "img/회.jpeg" width="100%"></img>
          <p></p>
          <button class="btn btn-outline-secondary" type="button">맛집 스토리</button>
        </div>
      </div>
    </div>
    <div class="row align-items-md-stretch">
    </div>
    
    

    <footer class="pt-3 mt-4 text-muted border-top">
      
    </footer>
  </div>
</main>
	<hr>
 <jsp:include page="common/footer.jsp"/>
</body>
</html>