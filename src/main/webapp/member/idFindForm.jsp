<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Find Form</title>
    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.kr/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<style type="text/css">
 .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	var form = window.document.idFindForm;
	
	$("#idFindResult").hide();
	
	$("#idFindButton").click(function() {
		
		if(form.email.value == ""){
			$("#invalid-feedback").html("이메일을 입력해주세요");
			$("#email").focus();
			return;
		}
		
		$("#invalid-feedback").html("");
		$("#idFindResult").show();
	});
})
</script>
<meta name="theme-color" content="#7952b3">

</head>
<body>
 <jsp:include page="../common/header.jsp"/>

<main>
  <div class="container py-4">
    <header class="pb-3 mb-4 border-bottom">
      <p class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">아이디 찾기</span>
      </p>
    </header>

	 <div class="p-5 mb-4 bg-light rounded-3" >
      <div class="container-fluid py-5">
        <p class="col-md-8 fs-4">가입할 때 사용했던 이메일 주소를 입력해주세요.</p>
        <form style="width:500px" id="idFindForm" name="idFindForm">
				<input class="form-control me-2" type="email" placeholder="Email 주소 입력" aria-label="Search"  id="email" name="email">
				<div style="height: 10px"></div>
				<div  class=" mb-3 text-muted" id="invalid-feedback">
              </div>
        <button class="btn btn-primary btn-lg" type="button" id="idFindButton">아이디 조회</button>
			</form>
      </div>
    </div>

    <div class="p-5 mb-4 bg-light rounded-3" id="idFindResult">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">아이디 출력 | 혹은 메일 주소 없음 출력</h1>
        <button class="btn btn-primary btn-lg" type="button">로그인 | 혹은 숨기기</button>
      </div>
    </div>
    <footer class="pt-3 mt-4 text-muted border-top">
      
    </footer>
  </div>
</main>

 <jsp:include page="../common/footer.jsp"/>
</body>
</html>