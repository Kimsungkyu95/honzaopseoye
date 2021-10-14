<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<!-- Bootstrap CSS -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function levelTest() {
	location.href="${pageContext.request.contextPath}/#";
}


</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>

<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading text-center">
			<h1>회원 정보를 입력해주세요. </h1>
			
			</div>
			<div class="panel-body shadow-lg">
				<form name="myform">
					<div class="form-group">
						<label for="memberId"><h3>아이디</h3> </label>
						<input id="memberId" name="memberId" class="form-control" type="text" data-validation="required">
						<span id="error_id" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="memberPassword"><h3>비밀번호</h3> </label>
						<input id="memberPassword" name="memberPassword" class="form-control" type="password" >
						<span id="error_lastname" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="memberName"><h3>이름</h3> </label>
						<input id="memberName" name="memberName"  class="form-control" type="text" >
						<span id="error_name" class="text-danger"></span>
					</div>
						<div class="form-group">
						<label for="memberEmail"><h3>이메일</h3> </label>
						<input id="memberEmail" name="memberEmail"  class="form-control" type="email" data-validation="email" >
						<span id="error_email" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="memberPhone"><h3>전화번호</h3> </label>
						<input type="text" id="memberPhone" name="memberPhone" class="form-control" >
						<span id="error_phone" class="text-danger"></span>
					</div>
					<div class="form-group">
						<label for="memberBirth"><h3>생년월일</h3> </label>
						<input type="date" name="memberBirth" id="memberBirth" class="form-control">
						<span id="error_birth" class="text-danger"></span>
					</div>		
					<div class="text-center">
						<button type="submit" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold" onclick="levelTest();">혼밥레벨 테스트</button>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>

 <jsp:include page="../common/footer.jsp"/>
</body>
</html>