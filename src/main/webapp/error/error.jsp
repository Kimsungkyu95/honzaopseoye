<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>

 <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.kr/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

 <!-- Custom styles for this template -->
<style type="text/css">
html, body{
	height: 100%;
}

#space{
	height: 30%;
}

#msg{
	height: 50%;
}
</style>
<script type="text/javascript">

</script>
</head>

<body >
 <jsp:include page="../common/header.jsp"/>
  <div id="space" class="bg-dark">
  </div>
 <div class="d-flex text-center text-white bg-dark">
    
<div id="msg" class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">




  
    <h1>ERROR!</h1>
    <p class="lead">${requestScope.errorMsg} </p>
    <p class="lead">
    </p>
    <div class="d-grid gap-2 col-2 mx-auto">
    <a href="javascript:history.back()" class="btn btn-lg btn-secondary text-black fw-bold border-white bg-white">뒤로가기</a>
	</div>
  
</div>

</div>
    
   <div id="space" class="bg-dark">
  </div>
 <jsp:include page="../common/footer.jsp"/>
</body>
</html>