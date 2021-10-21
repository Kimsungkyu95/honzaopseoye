<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>header</title>
<style>
	nav{height:60px}
	svg{padding-bottom:2px}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light"  style="background-color: #adb5bd";>
	<div class="container-fluid" style="">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/main.jsp">
		<!-- 홈아이콘 -->
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-emoji-smile" viewBox="0 0 16 16">
			  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			  <path d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM7 6.5C7 7.328 6.552 8 6 8s-1-.672-1-1.5S5.448 5 6 5s1 .672 1 1.5zm4 0c0 .828-.448 1.5-1 1.5s-1-.672-1-1.5S9.448 5 10 5s1 .672 1 1.5z"/>
			</svg>
				혼자옵서예
		</a>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				
				<!-- 로그인 -->
				<c:if test="${empty loginId}">
					
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm.jsp">LogIn</a>
					</li>
					
				 </c:if>
				 <!-- 로그아웃 -->
				<c:if test="${not empty loginId}">
					<!-- 마이페이지 -->
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/myPage/myPage.jsp">MyPage</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/front?key=member&methodName=logout">LogOut</a>
					</li>
					<!-- 위시리스트 -->
					<%-- <li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/myPage/myPageWishList.jsp">WishList</a>
					</li> --%>
				 </c:if>
				
				<!-- 스토리 -->
				<li class="nav-item">
					<a class="nav-link" href="${path}/front?key=userStory&methodName=selectAll">Story</a>
				</li>
				
			   
			</ul>
			
			<!-- 검색창 -->
			<c:if test="${loginId == 'admin'}">
				<button type="button" class="btn btn-dark" onclick="location.href='${path}/front?key=member&methodName=selectMemberList'">관리자페이지로</button>	
			</c:if>
			
		</div>
	</div>
</nav>

</body>
</html>