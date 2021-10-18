<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PWD Find Form</title>
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
	var form = window.document.pwdFindForm;
	$("#pwdFindResult").hide();
	
	$("#pwdFindButton").click(function() {

		if(form.id.value == ""){
			$("#invalid-feedback").html("아이디를 입력해주세요");
			$("#id").focus();
			return;
		}
		
		if(form.email.value == ""){
			$("#invalid-feedback").html("이메일을 입력해주세요");
			$("#email").focus();
			return;
		}
		
		//-----------------비동기화통신-----------------------------------
		$.ajax({
			url: "../memberSelectPwdByIdEmail", 	// ../ 상위로 한칸 올라가서.. 서블릿 
											//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
			type: "post",				//메소드 방식(get, post, put, delete)
			dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
			data: {id: $("#id").val(), email: $("#email").val() }, //서버에 보낼 때 파라메터
			success: function(result) { //성공하면 callback 함수	
				//console.log(result);
				let print = "회원님의 비밀번호는 " + result + " 입니다.";
			
				if(result=="failed"){
					console.log("true");
					$("#loginButton").hide();
					print="해당 아이디와 이메일이 일치하는 회원정보를 찾을 수 없습니다.";
					$("#id").focus();
				}
			
				$("#loginButton").show();
				$("#result").text(print);
			
				$("#invalid-feedback").html("");
				$("#pwdFindResult").show();
							
			},
			error: function(error) { //실패했을 때 함수	
				console.log("Something went wrong."); 	
			}
		});
		//-----------------비동기화통신-----------------------------------
	});
	
	$("#loginButton").click(function() {
		$(location).attr('href','${pageContext.request.contextPath}/member/loginForm.jsp');
	})
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
        <span class="fs-4">비밀번호 찾기</span>
      </p>
    </header>
    
    <div class="p-5 mb-4 bg-light rounded-3" >
      <div class="container-fluid py-5">
        <p class="col-md-8 fs-4">아이디와 가입할 때 사용했던 이메일 주소를 입력해주세요.</p>
        <form style="width:500px" id="pwdFindForm" name="pwdFindForm">
				<input class="form-control me-2" type="text" placeholder="ID 입력" id="id" name="id">
				<div style="height: 10px"></div>
				<input class="form-control me-2" type="email" placeholder="Email 주소 입력" id="email" name="email">
				<div style="height: 10px"></div>
				<div  class=" mb-3 text-muted" id="invalid-feedback">
              </div>
        <button class="btn btn-primary btn-lg" type="button" id="pwdFindButton">비밀번호 조회</button>
			</form>
      </div>
    </div>

    <div class="p-5 mb-4 bg-light rounded-3" id="pwdFindResult">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold" id="result"></h1>
        <button class="btn btn-primary btn-lg" id="loginButton" type="button">로그인</button>
      </div>
    </div>
    

    <footer class="pt-3 mt-4 text-muted border-top">
     
    </footer>
  </div>
</main>

 <jsp:include page="../common/footer.jsp"/>
</body>
</html>