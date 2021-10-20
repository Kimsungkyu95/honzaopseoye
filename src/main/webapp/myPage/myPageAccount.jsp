<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- \${pageContext.request.contextPath} = ${pageContext.request.contextPath} <br>
\${path} : ${path} --%>

<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>myPageAccount</title>
    
    <style type="text/css">
    	table{text-align:center;}
    	h1{text-align:center;}
    </style>
    
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	let emailDuple=false;
	let emailFormConfirm=true;
	
	let name = "${memberDto.memberName}";
	let email = "${memberDto.memberEmail}";
	let phone = "${memberDto.memberPhone}";
	var reqBirth = "${memberDto.memberBirth}";
	var dateFormBirth = reqBirth.substring(0, 10);
	
	$("#memberBirth").val(dateFormBirth);
	
	//console.log("dateFormBirth : " + dateFormBirth);
	
	$("#resetForm").click(function() {
		//console.log("name : " + name);
		$("#memberName").val(name);
		$("#memberEmail").val(email);
		$("#memberPhone").val(phone);
		$("#memberBirth").val(dateFormBirth);
	})
	
	$("#memberEmail").keyup(function() {
		if($(this).val()==""){
			return;
		}
		let typedEmail = $(this).val();

		//console.log(email);
		//console.log($(this).val());
		emailFormConfirm = $("#memberEmail").val().includes("@");
		
		if(emailFormConfirm){
			$("#emailCheck").text("올바른 이메일 형식입니다.");
			//-----------------비동기화통신-----------------------------------
			$.ajax({
				url: "${path}/memberEmailCheck", 	// ../ 상위로 한칸 올라가서.. 서블릿 
												//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
				type: "post",				//메소드 방식(get, post, put, delete)
				dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
				data: {email: $(this).val() }, //서버에 보낼 때 파라메터
				success: function(result) { //성공하면 callback 함수	
					//console.log(result);
					$("#emailInvalid").text(result);
					if(result === "중복되는 이메일이 존재합니다."){
						//console.log(typedEmail);
						//console.log(email);
						if(typedEmail != email){
							//console.log("not same");
							$("#emailCheck").text(result);
							emailDuple=true;							
						}
						//console.log("same");
					}else{
						emailDuple=false;
						//console.log("emailDuple=false");
					}
								
				},
				error: function(error) { //실패했을 때 함수	
					console.log(error); 	
				}
			});
			//-----------------비동기화통신-----------------------------------
		}else{
			$("#emailCheck").text("@를 포함하는 올바른 이메일 형식을 사용해주세요.");
		}
	})
	
	$("#updateActual").click(function() {
		if(!emailFormConfirm){
			$("#invailidMsg").text("@를 포함하는 올바른 이메일 형식을 사용해주세요.");
			$("#memberEmail").focus();
			return;
		}
		
		if(emailDuple){
			$("#invailidMsg").text("중복되는 이메일이 존재합니다.");
			$("#memberEmail").focus();
			return;
		}
		
		if($("#memberName").val()==""){
			$("#invailidMsg").text("이름을 입력해주세요.");
			$("#memberName").focus();
			return;
		}
		
		if($("#memberEmail").val()==""){
			$("#invailidMsg").text("이메일을 입력해주세요.");
			$("#memberEmail").focus();
			return;
		}
		
		if($("#memberPhone").val()==""){
			$("#invailidMsg").text("전화번호를 입력해주세요.");
			$("#memberPhone").focus();
			return;
		}
		
		if($("#memberBirth").val()==""){
			$("#invailidMsg").text("생년월일을 선택해주세요.");
			$("#memberBirth").focus();
			return;
		}
		
		$("#updateForm").submit();
		
	})
})
</script>
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

	<h1 class="p-3 mb-2 bg-light text-dark">계정정보</h1>
    
    <div class="p-5 mb-4 bg-light border rounded-3">
    
    <form method="post" action="${pageContext.request.contextPath}/front?key=member&methodName=updateByNo" id="updateForm">
    
    	<input type="hidden" name="memberNo" value="${memberDto.memberNo}">
    	<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">아이디</th>
		      <td>${memberDto.memberID}</td>
		    </tr>
		    <tr>
		      <th scope="row">이름</th>
		      <td><input type="text" id="memberName" name="memberName"  value="${memberDto.memberName}" />
		      </td>
		    </tr>
		    <tr>
		      <th scope="row">이메일</th>
		      <td><input class = "mb-3 "type="text" id="memberEmail" name="memberEmail" value="${memberDto.memberEmail}"/>
		      <div class="text-muted" id="emailCheck"></div>
		      </td>
		    </tr>
		    <tr>
		      <th scope="row">전화번호</th>
		      <td><input type="text" id="memberPhone" name="memberPhone" value="${memberDto.memberPhone}"/></td>
		    </tr>
		    <tr>
		      <th scope="row">생년월일</th>
		      <td><input type="date" id="memberBirth" name="memberBirth"/></td>
		    </tr>
		  </tbody>
		</table>
    	<div class=" mb-3 text-muted" id="invailidMsg"></div>
    	<button type="button" class="btn btn-secondary btn-lg" id="updateActual">수정하기</button>
		<button type="button" id="resetForm" class="btn btn-secondary btn-lg">취소</button>
		<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='${path}/myPage/myPage.jsp'">마이페이지</button>
	</form>
	
    </div>

    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>