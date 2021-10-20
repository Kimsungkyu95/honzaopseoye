<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>myPagePassword</title>
    
    <style>
    	h1{text-align:center;}
    	.centerContainer{
    		text-align:middle;
    		width:1000px;
    		margin: 0 auto;
    	}
    </style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	
	let loginId = "${loginId}";
	
	let oldPwd="";
	let newPwd = "";
	let newPwdConfirm ="";
	
	let oldPwdActual="";
	
	let newEqualsOld=false;
	let newEqualsConfirm=false;
	
	let oldConfirm=false;
	
	$("#originalPwd").keyup(function() {
		oldPwd = $(this).val();
		
		if(oldPwd==""){
			return;
		}
		
		//-----------------비동기화통신-----------------------------------
		$.ajax({
			url: "${path}/memberSelectPwdById", 	// ../ 상위로 한칸 올라가서.. 서블릿 
											//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
			type: "post",				//메소드 방식(get, post, put, delete)
			dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
			data: {id: loginId }, //서버에 보낼 때 파라메터
			success: function(result) { //성공하면 callback 함수	
				//console.log("result : " + result);
				oldPwdActual=result;
				
				if(result == oldPwd){
					//console.log("same");
					oldConfirm=true;
					$("#invailidMsg").text("");
				}else{
					//console.log("not same");
					$("#invailidMsg").text("기존의 비밀번호를 확인해주세요.");
					oldConfirm=false;
				}
							
			},
			error: function(error) { //실패했을 때 함수	
				console.log(error); 	
			}
		});
		//-----------------비동기화통신-----------------------------------
	})
	
	$("#newPwd").keyup(function() {
		if(oldPwdActual==""){
			$("#invailidMsg").text("기존 비밀번호를 먼저 입력해주세요.");
			$(this).val("");
			$("#originalPwd").focus();
			return;
			
		}else{
			newPwd = $(this).val();
			if(newPwd==""){
				$("#invailidMsg").text("새로운 비밀번호를 확인해주세요.");
				return;
			}else if(oldPwdActual == newPwd){
				$("#invailidMsg").text("이전 비밀번호와 다른 비밀번호를 입력해주세요.");
				newEqualsOld=true;
				return;
			}else{
				$("#invailidMsg").text("");
				newEqualsOld=false;
				return;			
			}
		}
		
		
	})
	
	$("#newPwdConfirm").keyup(function() {
		if(oldPwdActual==""){
			$("#invailidMsg").text("기존 비밀번호를 먼저 입력해주세요.");
			$(this).val("");
			$("#originalPwd").focus();
			return;
			
		}else{
			newPwdConfirm = $(this).val();
			if(newPwdConfirm==""){
				return;
			}
			
			if(newPwd == newPwdConfirm){
				$("#invailidMsg").text("입력하신 새 비밀번호가 일치합니다.");
				newEqualsConfirm=true;
			}else{
				$("#invailidMsg").text("입력하신 새 비밀번호가 일치하지 않습니다.");
				newEqualsConfirm=false;
			}
		}
	})
	
	$("#resetBtn").click(function() {
		$("#originalPwd").val("");
		$("#newPwd").val("");
		$("#newPwdConfirm").val("");
		
		$("#invailidMsg").text("");
		
		oldPwd="";
		newPwd = "";
		newPwdConfirm ="";
	})
	
	$("#sendIt").click(function() {
		if(oldPwd==""){
			$("#invailidMsg").text("이전 비밀번호를 입력해주세요.");
			$("#originalPwd").focus();
			return;
		}
		
		if(newPwd==""){
			$("#invailidMsg").text("새 비밀번호를 입력해주세요.");
			$("#newPwd").focus();
			return;
		}

		if(newPwdConfirm==""){
			$("#invailidMsg").text("새 비밀번호를 확인해주세요.");
			$("#newPwdConfirm").focus();
			return;
		}
		
		if(!newEqualsConfirm){
			$("#invailidMsg").text("입력하신 새 비밀번호가 일치하지 않습니다.");
			$("#newPwdConfirm").focus();
			return;
		}
		
		if(newEqualsOld){
			$("#invailidMsg").text("이전 비밀번호와 다른 비밀번호를 입력해주세요.");
			$("#newPwd").focus();
			return;
		}
		
		if(!oldConfirm){
			$("#invailidMsg").text("기존의 비밀번호를 확인해주세요.");
			$("#originalPwd").focus();
			return;
		}
		
		//console.log("SEND IT");
		$("#pwdUpdateForm").submit();
		
	})
	
})
</script>
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>
	
	<h1 class="p-3 mb-2 bg-light text-dark">비밀번호 변경</h1>
	<div class="p-5 mb-4 bg-light border rounded-3">
		
		<form method="post" action="${pageContext.request.contextPath}/front?key=member&methodName=updatePwdByNo" id="pwdUpdateForm">
		    <h1 class="h3 mb-3 fw-normal">현재비밀번호와 새로운 비밀번호를 입력해주세요.</h1>
			<input type="hidden" name="memberNo" value="${loginId}">
			<p class="centerContainer" >
			안전한 비밀번호로 내정보를 보호하세요
			다른 사이트/아이디에서 사용한 적 없는 비밀번호
			이전에 사용한 적 없는 비밀번호
			가 안전합니다. 
			</p>
			
		    <div class="form-floating">
		      <input type="password" class="form-control" id="originalPwd" name="originalPwd">
		      <label for="floatingInput">현재 비밀번호</label>
		    </div>
		    <div class="form-floating">
		      <input type="password" class="form-control" id="newPwd" name="newPwd"  placeholder="Password">
		      <label for="floatingPassword">새 비밀번호</label>
		    </div>
		    <div class="form-floating">
		      <input type="password" class="form-control" id="newPwdConfirm" name="newPwdConfirm" placeholder="Password">
		      <label for="floatingPassword">새 비밀번호 확인</label>
		    </div>
		    <p>
		    <div class="text-muted" id="invailidMsg"></div>
		    <p>
	
		    <div class="d-grid gap-2">
			  <button class="btn btn-primary" type="button" id="sendIt">확인</button>
			  <button class="btn btn-primary" type="button" id="resetBtn">취소</button>
			</div>
			<!--  
		    <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
		    -->
		  </form>
	</div>
	
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <!-- 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 	-->
 	
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    
    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>