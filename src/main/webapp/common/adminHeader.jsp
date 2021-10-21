<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a:hover{
		filter: brightness(50%);
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
                        <a class="nav-link text-dark" href="${path}/front?key=member&methodName=selectMemberList">고객관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="${path}/front?key=adminRestaurant&methodName=pagingSelect">맛집관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="${path}/front?key=adminMember&methodName=pagingSelectReview">리뷰관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="${path}/adminStory/adminStoryList.jsp">스토리관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="${path}/main.jsp">메인으로</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <a class="nav-link text-dark" href="${path}/front?key=member&methodName=logout">로그아웃</a>
                </span>
            </div>
        </div>
    </nav>
</body>
</html>