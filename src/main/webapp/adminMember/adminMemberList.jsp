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
					      <td><a class="" href="${pageContext.request.contextPath}/front?key=member&methodName=deleteByNo&memberNo=${memberDto.memberNo}">삭제</a></td>
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