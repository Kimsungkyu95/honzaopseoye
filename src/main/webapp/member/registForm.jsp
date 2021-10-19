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
	let idDuple=true;
	let emailDuple=true;
	let pwdConfirm=false;
	let email = false;
	
	$("#levelTest").click(function() {
		
		if(!email){
			$("#invalid-feedback").html("@를 포함하는 올바른 이메일 형식을 사용해주세요.");
			$("#memberEmail").focus();
			return;
		}  
		
		if(idDuple==true){
			$("#invalid-feedback").html("사용 가능한 아이디를 입력해주세요");
			$("#memberId").focus();
			return;
		}
		
		if(emailDuple==true){
			$("#invalid-feedback").html("사용 가능한 이메일을 입력해주세요");
			$("#memberEmail").focus();
			return;
		}
		
		if(!pwdConfirm){
			$("#invalid-feedback").html("비밀번호를 확인해주세요");
			$("#memberPwdConfirm").focus();
			return;
		}
		
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
		
		//console.log("confirm");
		
		$("#registForm").submit();
		
	});
	
	$("#memberPwdConfirm").keyup(function() {
		let pwd = $("#memberPwd").val();
		//console.log("pwd: " + pwd);
		
		if($(this).val() != pwd){
			$("#pwdConfirmInvalid").html("비밀번호가 일치하지 않습니다.");
			pwdConfirm=false;
		}else{
			$("#pwdConfirmInvalid").html("비밀번호가 일치합니다.");
			pwdConfirm=true;
		}
		
	})
	
	$("#memberId").keyup(function() {
		if($(this).val()==""){
			return;
		}
		//-----------------비동기화통신-----------------------------------
		$.ajax({
			url: "../memberIdCheck", 	// ../ 상위로 한칸 올라가서.. 서블릿 
											//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
			type: "post",				//메소드 방식(get, post, put, delete)
			dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
			data: {id: $(this).val() }, //서버에 보낼 때 파라메터
			success: function(result) { //성공하면 callback 함수	
				//console.log(result);
				$("#idInvalid").text(result);
				if(result === "중복되는 아이디가 존재합니다."){
					idDuple=true;
				}else{
					idDuple=false;
					//console.log("idDuple=false");
				}
							
			},
			error: function(error) { //실패했을 때 함수	
				console.log("Something went wrong."); 	
			}
		});
		//-----------------비동기화통신-----------------------------------
	})
	
	$("#memberEmail").keyup(function() {
		if($(this).val()==""){
			return;
		}

		//console.log(email);
		//console.log($(this).val());
		email = $("#memberEmail").val().includes("@");
		
		if(email){
			$("#emailCheck").text("올바른 이메일 형식입니다.");
			//-----------------비동기화통신-----------------------------------
			$.ajax({
				url: "../memberEmailCheck", 	// ../ 상위로 한칸 올라가서.. 서블릿 
												//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
				type: "post",				//메소드 방식(get, post, put, delete)
				dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
				data: {email: $(this).val() }, //서버에 보낼 때 파라메터
				success: function(result) { //성공하면 callback 함수	
					//console.log(result);
					$("#emailInvalid").text(result);
					if(result === "중복되는 이메일이 존재합니다."){
						emailDuple=true;
					}else{
						emailDuple=false;
						//console.log("emailDuple=false");
					}
								
				},
				error: function(error) { //실패했을 때 함수	
					console.log("Something went wrong."); 	
				}
			});
			//-----------------비동기화통신-----------------------------------
		}else{
			$("#emailCheck").text("@를 포함하는 올바른 이메일 형식을 사용해주세요.");
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
            <div  class="text-muted" id="idInvalid">
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
              <div class=" text-muted" id="pwdConfirmInvalid">
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
              <input type="email" class="form-control" id="memberEmail" placeholder="you@example.com" id="memberEmail" name="memberEmail" >
            </div>
            <div  class="text-muted" id="emailCheck">
            </div>
            <div  class="text-muted" id="emailInvalid">
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