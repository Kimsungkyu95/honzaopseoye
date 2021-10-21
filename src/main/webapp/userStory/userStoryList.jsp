<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>userStoryList</title>


<style type="text/css">
	button a { text-decoration:none }
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
 <main>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">Today's Story</h1>
        <p class="lead text-muted">당신의 스토리를 올려보세요.</p>
        <p>
          <a href="${pageContext.request.contextPath}/userStory/userStoryCreate.jsp" class="btn btn-primary my-2">Story Create</a>
        </p>
      </div>
    </div>
  </section>

  <div class="album py-5 bg-light">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
              
        <c:choose>
        	<c:when test="${empty requestScope.list}">
        		등록된 스토리가 없습니다. 
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${requestScope.list}" var="story" varStatus="state">
								<div class="col">
									<div class="card shadow-sm">
         							<img src="${path}/img/storySave/${story.storyTitle}/${story.storyImgList[0]}" style="width:100%; height:250px;"/> 

										<div class="card-body">
											<h3>${story.storyTitle}</h3>
											<p class="card-text">${story.memberId}</p>
											<div class="">
												<div class="btn-group">
													<button type="button" class="btn btn-sm btn-outline-secondary">
														<a href="${path}/front?key=userStory&methodName=selectByStoryNo&storyNo=${story.storyNo}" style="color: gray;"> 
														스토리 보러 »</a>
													</button>
												</div>
												<img src="${path}/img/eyeicon.png" style="width: 18px; height: 18px;">
												<span>조회 수 : ${story.storyVisited }</span>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
        	</c:otherwise>
        </c:choose>
        
      </div>
    </div>
  </div>

</main>
		<hr>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>