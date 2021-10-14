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
<script type="text/javascript">

</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
 
 
<div style="height: 200px"></div>

<div class="loginForm">
<main class="form-signin shadow-lg">
  <form>
    
    <h1 class="h3 mb-3 fw-normal">로그인 정보</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="ID">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">비밀번호</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> 로그인 상태 유지
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
    <div class="text-center h3">
	<button type="button" class="btn btn-secondary btn-sm">아이디 찾기</button>
	<button type="button" class="btn btn-secondary btn-sm">비번 찾기</button>
	</div>
    <p class="mt-5 mb-3 text-muted">©혼자옵서예</p>
  </form>
</main>
</div >
<div style="height: 200px"></div>

 <jsp:include page="../common/footer.jsp"/>
</body>
</html>