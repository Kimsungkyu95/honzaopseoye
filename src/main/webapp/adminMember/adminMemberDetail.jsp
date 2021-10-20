<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>adminMemberList</title>
    
    <style>
    	h1{text-align:center;}
    	.table{text-align:center}
    	
    </style>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	$(function() {
		let idDuple=false;
		
		let emailDuple=false;
		let emailFormConfirm=true;
		
		let id = "${memberDto.memberID}";
		let password = "${memberDto.memberPwd}";
		let name = "${memberDto.memberName}";
		let email = "${memberDto.memberEmail}";
		let phone = "${memberDto.memberPhone}";
		let exp = "${memberDto.memberExp}";
		
		var reqBirth = "${memberDto.memberBirth}";
		var dateFormBirth = reqBirth.substring(0, 10);
		
		var reqJoin = "${memberDto.memberJoinDate}";
		var dateFormJoinDate = reqJoin.substring(0, 10);
		
		$("#memberBirth").val(dateFormBirth);
		$("#memberJoinDate").val(dateFormJoinDate);
		//console.log("dateFormBirth : " + dateFormBirth);
		//console.log("dateFormJoinDate : " + dateFormJoinDate);
		
		$("#resetForm").click(function() {
			console.log("id : " + id);
			console.log("password : " + password);
			console.log("name : " + name);
			console.log("email : " + email);
			console.log("phone : " + phone);
			console.log("exp : " + exp);
			console.log("dateFormJoinDate : " + dateFormJoinDate);
			console.log("dateFormBirth : " + dateFormBirth);
			$("#memberID").val(id);
			$("#memberPwd").val(password);
			$("#memberName").val(name);
			$("#memberEmail").val(email);
			$("#memberPhone").val(phone);
			$("#memberExp").val(exp);
			$("#memberJoinDate").val(dateFormJoinDate);
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
		
		
		//id비동기화 통신
		$("#memberID").keyup(function() {
			if($(this).val()==""){
				return;
			}
			let typedId = $(this).val();
	
			//console.log(email);
			//console.log($(this).val());

			//-----------------비동기화통신-----------------------------------
			$.ajax({
				url: "${path}/memberIdCheck", 	// ../ 상위로 한칸 올라가서.. 서블릿 
												//이게 폴더 밑에 있으니까 루트로 갈려면 한칸 올라가야됨.
				type: "post",				//메소드 방식(get, post, put, delete)
				dataType: "text",			//서버가 응답해주는 데이터의 타입(text-생략시 기본-, html, xml, json)
				data: {id: $(this).val() }, //서버에 보낼 때 파라메터
				success: function(result) { //성공하면 callback 함수	
					console.log(result);
					$("#idInvalid").text(result);
					if(result === "중복되는 아이디가 존재합니다."){
						//console.log(typedId);
						//console.log(id);
						if(typedId != id){
							//console.log("not same");
							$("#idCheck").text(result);
							idDuple=true;							
						}
						//console.log("same");
					}else{
						idDuple=false;
						console.log("idDuple=false");
					}
								
				},
				error: function(error) { //실패했을 때 함수	
					console.log(error); 	
				}
			});
			//-----------------비동기화통신-----------------------------------
	
				
	
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
			
			if(idDuple){
				$("#invailidMsg").text("중복되는 아이디가 존재합니다.");
				$("#memberID").focus();
				return;
			}
			
			if($("#memberID").val()==""){
				$("#invailidMsg").text("아이디를 입력해주세요.");
				$("#memberID").focus();
				return;
			}
			
			if($("#memberPwd").val()==""){
				$("#invailidMsg").text("비밀번호를 입력해주세요.");
				$("#memberPwd").focus();
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
			
			if($("#memberExp").val()==""){
				$("#invailidMsg").text("경험치를 입력해주세요.");
				$("#memberExp").focus();
				return;
			}
			
			if($("#memberBirth").val()==""){
				$("#invailidMsg").text("생년월일을 선택해주세요.");
				$("#memberBirth").focus();
				return;
			}
			
			if($("#memberJoinDate").val()==""){
				$("#invailidMsg").text("가입일을 선택해주세요.");
				$("#memberJoinDate").focus();
				return;
			}
			
			$("#updateForm").submit();
			
		})
	})
	</script>
    
    
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand text-dark" href="#">Admin Page</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">고객관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">맛집관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">리뷰관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">차트분석</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <a class="nav-link text-dark" href="#">로그아웃</a>
                </span>
            </div>
        </div>
    </nav>

	<div class="container bg-light pt-4 pb-3 px-5 mt-4 rounded shadow-lg">
		<h1><a>${memberDto.memberName}</a>님 회원관리</h1>
		<form method="post" action="${pageContext.request.contextPath}/front?key=member&methodName=updateByNoForAdmin" id="updateForm">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col"></th>
	
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">회원번호</th>
			      <td>${memberDto.memberNo}</td>
			    </tr>
			    <tr>
			      <th scope="row">아이디</th>
			      <td colspan="2"><input type="text" id="memberID" name="memberID" value=${memberDto.memberID} /></td>
			    </tr>
			    <tr>
			      <th scope="row">비밀번호</th>
			      <td colspan="2"><input type="text" id="memberPwd" name="memberPwd" value=${memberDto.memberPwd} /></td>
			    </tr>
			    <tr>
			      <th scope="row">이름</th>
			      <td colspan="2"><input type="text" id="memberName" name="memberName" value=${memberDto.memberName} /></td>
			    </tr>
			    <tr>
			      <th scope="row">이메일</th>
			      <td colspan="2"><input type="text" id="memberEmail" name="memberEmail" value=${memberDto.memberEmail} /></td>
			    </tr>
			    <tr>
			      <th scope="row">전화번호</th>
			      <td colspan="2"><input type="text" id="memberPhone" name="memberPhone" value=${memberDto.memberPhone} /></td>
			    </tr>
			    <tr>
			      <th scope="row">생년월일</th>
			      <td colspan="2"><input type="date" id="memberBirth" name="memberBirth" value=${memberDto.memberBirth} /></td>
			    </tr>
			    <tr>
			      <th scope="row">가입일</th>
			      <td colspan="2"><input type="date" id="memberJoinDate" name="memberJoinDate" value=${memberDto.memberJoinDate}/></td>
			    </tr>
			    <tr>
			      <th scope="row">경험치</th>
			      <td colspan="2"><input type="text" id="memberExp" name="memberExp" value=${memberDto.memberExp} /></td>
			    </tr>
			    <%-- <tr>
			      <th scope="row">프로필이미지</th>
			      <td colspan="2">${memberDto.profileImage}</td>
			    </tr> --%>
			  </tbody>
			</table>
		
		</form>
		<div class="col text-center">
			<button type="button" class="btn btn-secondary btn-lg" id="updateActual">수정하기</button>
			<button type="button" id="resetForm" class="btn btn-secondary btn-lg">취소</button>
			<button type="button" class="btn btn-secondary btn-lg" onclick="location.href='${path}/myPage/myPage.jsp'">마이페이지</button>
		</div>
	</div>

	<footer class="pt-3 mt-4 text-muted border-top">
	</footer>
	 </div>
	</main>
	<hr>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>