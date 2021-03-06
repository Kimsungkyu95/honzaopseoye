<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Level Test</title>

    <!-- Bootstrap core CSS -->
	<link href="https://getbootstrap.kr/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.kr/docs/5.1/examples/list-groups/list-groups.css" rel="stylesheet">

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

<script src="../js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#Q1-2").hide();
	$("#Q2").hide();
	$("#Q3").hide();
	$("#Q4").hide();
	$("#Q5").hide();
	$("#Q6").hide();
	$("#Q7").hide();	
	
	//Q1-1
	$("#Q1-1_Yes").click(function() {
		//location.href="#";
		
		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "1")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	$("#Q1-1_No").click(function() {
		$("#Q1-1").hide();
		$("#Q1-2").show();
	});
	
	//Q1-2
	$("#Q1-2_Yes").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "1")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	$("#Q1-2_No").click(function() {
		$("#Q1-2").hide();
		$("#Q2").show();
	});

	//Q2
	$("#Q2_Yes").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "2")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	$("#Q2_No").click(function() {
		$("#Q2").hide();
		$("#Q3").show();
	});

	//Q3
	$("#Q3_Yes").click(function() {
		$("#Q3").hide();
		$("#Q4").show();

	});
	
	$("#Q3_No").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "3")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	//Q4
	$("#Q4_Yes").click(function() {
		$("#Q4").hide();
		$("#Q5").show();
	});
	
	$("#Q4_No").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "3")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});

	//Q5
	$("#Q5_Yes").click(function() {
		$("#Q5").hide();
		$("#Q6").show();
	});
	
	$("#Q5_No").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "4")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});

	//Q6
	$("#Q6_Yes").click(function() {
		$("#Q6").hide();
		$("#Q7").show();
	});
	
	$("#Q6_No").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "5")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	//Q7
	$("#Q7_Yes").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "7")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
	
	$("#Q7_No").click(function() {

		$("<input />").attr("type", "hidden")
	          .attr("name", "memberLevel")
	          .attr("value", "6")
	          .appendTo("#actualRegistration");
		
		$("#actualRegistration").submit();
	});
})
</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
	
<div class="b-example-divider" style="height: 360px">
</div>

<form method="post" action="${pageContext.request.contextPath}/front?key=member&methodName=insert" id="actualRegistration">
<input type="hidden" name="memberId" value="${param.memberId}">
<input type="hidden" name="memberPwd" value="${param.memberPwd}">
<input type="hidden" name="memberName" value="${param.memberName}">
<input type="hidden" name="memberEmail" value="${param.memberEmail}">
<input type="hidden" name="memberPhone" value="${param.memberPhone}">
<input type="hidden" name="memberBirth" value="${param.memberBirth}">
<%-- ${param.memberLevel} --%>
</form>

<!-- Q1-1 -->	
<div class="list-group" id="Q1-1">
<h4 class="text-center"><b>????????? ??????(3?????????)??????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q1-1_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q1-1_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No (????????????)</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q1-2 -->	
<div class="list-group" id="Q1-2">
<h4 class="text-center"><b>?????? ?????? ????????????????????? ???????????????. </b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true"  id="Q1-2_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true"  id="Q1-2_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No (????????????)</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q2 -->	
<div class="list-group" id="Q2">
<h4 class="text-center"><b>?????? ???????????? ????????? ????????? <br>????????? ?????? ?????????. </b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true"  id="Q2_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q2_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No (????????????)</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q3 -->	
<div class="list-group" id="Q3">
<h4 class="text-center"><b>??? ?????? ????????? ???????????? ??????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q3_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes (????????????)</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q3_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No </h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q4 -->	
<div class="list-group" id="Q4">
<h4 class="text-center"><b>????????? ?????? ????????? ?????? ???????????????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q4_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes (????????????)</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q4_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q5 -->	
<div class="list-group" id="Q5">
<h4 class="text-center"><b>?????? ?????? ???????????? ?????? ???????????? ?????????.<br>??? ????????? ????????? ??????????????????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q5_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes (????????????)</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q5_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q6 -->	
<div class="list-group" id="Q6">
<h4 class="text-center"><b>?????? ?????? ?????? ?????? ??????????????? ??????<br>????????? ?????? ?????? ??? ??????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q6_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes (????????????)</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q6_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>

<!-- Q7 -->	
<div class="list-group" id="Q7">
<h4 class="text-center"><b>?????? ?????? ???????????? ????????? ????????????.</b></h4>
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q7_Yes">
     <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">Yes</h6>
      </div>
    </div>
  </a>
  
  <a class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true" id="Q7_No">
    <div class="d-flex gap-2 w-100 justify-content-between">
      <div>
        <h6 class="mb-0">No</h6>
      </div>
    </div>
  </a>
  
  <div style="height: 70px"></div>
  
</div>



<div class="b-example-divider" style="height: 360px"></div>
	
 <jsp:include page="../common/footer.jsp"/>
</body>
</html>