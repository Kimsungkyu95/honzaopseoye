<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>    

    <!-- Bootstrap core CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">



    <style>
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
      
     
html {
  height: 100%;
}

.loginForm {
  height: 100%;
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  /* background-color: #f5f5f5; */
}


.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
    </style>

<style type="text/css">

</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function registration() {
	location.href="${pageContext.request.contextPath}/member/registForm.jsp";
}
$(function() {
	var form = window.document.loginFormActual;
	
	$("#idFind").click(function() {
		location.href="${pageContext.request.contextPath}/member/idFindForm.jsp";
	});
	
	
	$("#pwdFind").click(function() {
		location.href="${pageContext.request.contextPath}/member/pwdFindForm.jsp";
	});
	
	$("#login").click(function() {
		
		//console.log("id: " + form.memberId.value);
		
		if((form.memberId.value == "") || (form.memberPwd.value == "")){
			$("#validation").html("아이디와 비밀번호를 입력해주세요");
			//console.log("111");
		}
		document.getElementById("loginFormActual").submit();
	})
})
</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
 
 
<div style="height: 200px"></div>

<div class="loginForm">
<main class="form-signin shadow-lg">
  <form method="post" action="${pageContext.request.contextPath}/front?key=member&methodName=login" name="loginFormActual" id="loginFormActual">
    
    <h1 class="h3 mb-3 fw-normal">로그인 정보</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="ID" name="memberId" id="memberId">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="memberPwd">
      <label for="floatingPassword">비밀번호</label>
    </div>
	
	<!-- 
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" name="remember-me" value="remember-me"> 로그인 상태 유지
      </label>
    </div>
    -->
    
    
    <div class=" mb-3 text-muted" id="validation">
         
    </div>
    <button class="w-100 btn btn-lg btn-primary h3" type="button" id="login">로그인</button>
    <button type="button" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold w-100 h3" onclick="registration();">회원가입</button>
    <div class="text-center h3">
	<button type="button" class="btn btn-secondary btn-sm" id="idFind">아이디 찾기</button>
	<button type="button" class="btn btn-secondary btn-sm" id="pwdFind">비번 찾기</button>
	</div>
	
        
    
  </form>
</main>
</div >
<div style="height: 200px"></div>

 <jsp:include page="../common/footer.jsp"/>
</body>
</html>