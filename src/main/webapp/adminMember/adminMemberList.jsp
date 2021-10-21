<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>adminMemberList</title>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	$(function(){
		//form value 고정
		
		//삭제버튼클릭시
		$('.deleteBtn').click(function(){
			console.log($(this).val());
			let memberNo = $(this).val();
			if(confirm("해당 회원을 정말로 삭제하시겠습니까?")){
    			$.ajax({
                    url: "${path}/adminMemberDelete", //서버요청주소
                    type: "post", //method방식(get, post, put, delete)
                    dataType: "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
                    data: {memberNo:memberNo}, //서버에게 보낼 parameter정보
                    success: function (result) {
                        alert(result);
                        location.reload();
                       	
                    }, //성공했을 때 callback함수
                    error: function (err) {
                        alert(err + "발생했어요.");
                    } //실패했을 때 callback함수
                }); //ajax 끝				
			}
		})
		
	})
	</script>
    
    <style>
    	th, td {
            text-align: center;
            vertical-align: middle;
        }
        form {
            display: flex;
            justify-content: center;
        }
    </style>
  </head>
  <body>
  	<jsp:include page="../common/adminHeader.jsp"/>

	<div class="container bg-light pt-4 pb-3 px-5 mt-4 rounded shadow-lg">
        <h2>회원 목록</h2>
        <table class="table">
            <thead>
                <tr>
			      <th scope="col">회원번호</th>
			      <th scope="col">아이디</th>
			      <th scope="col">이름</th>
			      <th scope="col">경험치</th>
			      <th scope="col">삭제</th>
			    </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.list}" var="memberDto">
			  		<tbody>
					    <tr>
					      <td>${memberDto.memberNo}</td>
					      <td><a href="${pageContext.request.contextPath}/front?key=member&methodName=selectMemberByNoForAdmin&memberNo=${memberDto.memberNo}">${memberDto.memberID}</a></td>
					      <td>${memberDto.memberName}</td>
					      <td>${memberDto.memberExp}</td>
					      <td><button type="button" class="btn btn-primary btn-sm deleteBtn" value="${memberDto.memberNo}">삭제</button>
					    </tr>
				  	</tbody>
			 	</c:forEach>
            </tbody>
        </table>
    </div>
    <nav aria-label="Page navigation example" class="mt-4">
        <ul class="pagination" style="justify-content: center;">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</body>
</html>