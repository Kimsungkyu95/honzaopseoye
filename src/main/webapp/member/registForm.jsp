<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>

    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.kr/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">
.container {
  max-width: 60px;
}
</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

$(function() {
	var form = window.document.registForm;
	
	$("#levelTest").click(function() {
		
		if((form.memberId.value == "") || (form.pwdFind.value == "")){
			$("#validation").html("아이디와 비밀번호를 입력해주세요");
			//console.log("111");
		}
		
		$("#registForm").submit();
		
	}); 
});

</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
 
 
<div class="b-example-divider" style="height: 60px"></div>
 
<div class="container" style="width: 700px">
	<div class=" p-4 pe-lg-30 col-md-0 col-lg-0   pb-0 pt-lg-10 rounded-3 shadow-lg">
        <h4 class="">회원 가입</h4>
        <form id="registForm" method="post" action="${pageContext.request.contextPath}/member/levelTest.jsp">
          
            <div class="col-100">
              <label for="memberId" class="form-label">ID <span class="text-muted"></span></label>
              <input type="text" class="form-control" id="memberId" name="memberId" >
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberPwd" class="form-label">Password <span class="text-muted"></span></label>
              <input type="password" class="form-control" id="memberPwd" name="memberPwd"> 
              <div class="invalid-feedback">
              </div>
            </div>
            
  		<div style="height: 10px"></div>
  		
  		<div class="col-100">
              <label for="memberPwdConfirm" class="form-label">Password Confirm <span class="text-muted"></span></label>
              <input type="password" class="form-control" id="memberPwdConfirm">
              <div class="invalid-feedback">
                비밀번호가 일치하지 않습니다.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberName" class="form-label">Name <span class="text-muted"></span></label>
              <input type="text" class="form-control" id="memberName" placeholder="김아무개" name="memberName">
              <div class="invalid-feedback">
                성함을 입력해주세요.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberEmail" class="form-label">Email <span class="text-muted"></span></label>
              <input type="email" class="form-control" id="memberEmail" placeholder="you@example.com" name="memberEmail">
              <div class="invalid-feedback">
                이메일 주소를 입력해주세요.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberPhone" class="form-label">Phone Numebr <span class="text-muted"></span></label>
              <input type="tel" class="form-control" id="memberPhone" placeholder="000-0000-0000" name="memberPhone">
              <div class="invalid-feedback">
                전화번호를 입력해주세요.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberBirth" class="form-label">Birth <span class="text-muted"></span></label>
              <input type="date" class="form-control" id="memberBirth" name="memberBirth">
              <div class="invalid-feedback">
                생일을 입력해주세요.
              </div>
            </div>
            
  		<div style="height: 30px"></div>
			
		  <div class="text-center">
		   <button class="w-80 btn btn-primary btn-lg" type="button" id="levelTest">레벨 테스트 하러가기!</button>
		  </div>	
         
          
  		<div style="height: 70px"></div>
        </form>
      </div>
      
</div>

<div class="b-example-divider" style="height: 60px"></div>
      
 <jsp:include page="../common/footer.jsp"/>
</body>
</html>