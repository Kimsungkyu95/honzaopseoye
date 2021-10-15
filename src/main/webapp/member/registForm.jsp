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
		
		if(form.memberId.value == ""){
			$("#invalid-feedback").html("아이디를 입력해주세요");
			$("#memberId").focus();
			//console.log("111");
			return;
		}
		
		if(form.memberPwd.value == ""){
			$("#invalid-feedback").html("비밀번호를 입력해주세요");
			$("#memberPwd").focus();
			//console.log("111");
			return;
		}
		
		if(form.memberName.value == ""){
			$("#invalid-feedback").html("이름을 입력해주세요");
			$("#memberName").focus();
			//console.log("111");
			return;
		}
		
		if(form.memberEmail.value == ""){
			$("#invalid-feedback").html("이메일을 입력해주세요");
			$("#memberEmail").focus();
			//console.log("111");
			return;
		}
		
		if(form.memberPhone.value == ""){
			$("#invalid-feedback").html("전화번호를 입력해주세요");
			$("#memberPhone").focus();
			//console.log("111");
			return;
		}
		
		if(form.memberBirth.value == ""){
			$("#invalid-feedback").html("생년월일을 입력해주세요");
			$("#memberBirth").focus();
			//console.log("111");
			return;
		}
		
		console.log("confirm");
		
		$("#registForm").submit();
		
	});
	
	$("#memberPwdConfirm").keyup(function() {
		let pwd = $("#memberPwd").val();
		//console.log("pwd: " + pwd);
		
		if($(this).val() != pwd){
			$("#pwdConfirmInvalid").html("비밀번호가 일치하지 않습니다.");
		}else{
			$("#pwdConfirmInvalid").html("비밀번호가 일치합니다.");
			
		}
		
	})
	
});

</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
 
 
<div class="b-example-divider" style="height: 60px"></div>
 
<div class="container" style="width: 700px">
	<div class=" p-4 pe-lg-30 col-md-0 col-lg-0   pb-0 pt-lg-10 rounded-3 shadow-lg">
        <h4 class="">회원 가입</h4>
        <form name="registForm" id="registForm" method="post" action="${pageContext.request.contextPath}/member/levelTest.jsp">
          
            <div class="col-100">
              <label for="memberId" class="form-label">ID <span class="text-muted"></span></label>
              <input type="text" class="form-control" id="memberId" name="memberId" >
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberPwd" class="form-label">Password <span class="text-muted"></span></label>
              <input type="password" class="form-control" id="memberPwd" name="memberPwd"> 
            </div>
            
  		<div style="height: 10px"></div>
  		
  		<div class="col-100">
              <label for="memberPwdConfirm" class="form-label">Password Confirm <span class="text-muted"></span></label>
              <input type="password" class="form-control" id="memberPwdConfirm">
              <p>
              <div class=" mb-3" id="pwdConfirmInvalid">
              </div>
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberName" class="form-label">Name <span class="text-muted"></span></label>
              <input type="text" class="form-control" id="memberName" placeholder="김아무개" name="memberName">
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberEmail" class="form-label">Email <span class="text-muted"></span></label>
              <input type="email" class="form-control" id="memberEmail" placeholder="you@example.com" name="memberEmail" >
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberPhone" class="form-label">Phone Numebr <span class="text-muted"></span></label>
              <input type="tel" class="form-control" id="memberPhone" placeholder="000-0000-0000" name="memberPhone">
            </div>
            
  		<div style="height: 30px"></div>
  		
  		<div class="col-100">
              <label for="memberBirth" class="form-label">Birth <span class="text-muted"></span></label>
              <input type="date" class="form-control" id="memberBirth" name="memberBirth">
            </div>
            
              <div  class=" mb-3 text-muted" id="invalid-feedback">
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