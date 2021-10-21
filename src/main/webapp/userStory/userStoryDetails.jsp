<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>userStoryDetails</title>

<style>
	button a { text-decoration:none } 
</style>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" >

</script>
</head>

<body>
<jsp:include page="../common/header.jsp"/>
<div class="row g-5">
<div class="col-md-4">
      <div class="position-sticky" style="top: 2rem;">
        <div class="p-4 mb-3 bg-light rounded">
        <img src="${path}/img/storySave/${story.storyTitle}/${story.storyImgList[0]}" style="max-width:100%; height:auto; border-radius: 10%;display : block ; margin : auto;">
          <br><p><h4 class="fst-italic" style="text-align: center;">${story.storyTitle }</h4>
          
        </div>

        <div class="p-4">
			<br><p><br>
			<span><b><i>Editor. ${story.memberName }</i></b></span>
			<p><br>
			${story.storyRegdate } | <img src="${path }/img/eyeicon.png" style="width: 20px; height: 20px;">
			<span>${story.storyVisited }</span><p>
			<p><hr>
			<button type="submit" class="btn btn-secondary mb-3">
				<a href="${path}/userStory/userStoryUpdate.jsp?storyNo=${story.storyNo}"  style="color: white;">
				수정</a></button>
        </div>
      </div>
    </div>
    
    <div class="col-md-8" id="div2">
      <article class="blog-post">
      <br>
      
        <h2 class="blog-post-title"><b>${story.restaurantName }</b></h2>
        <c:forEach items="${requestScope.storyImgList }"  var="img">
        <p><p>
        	<img src="${path}/img/storySave/${story.storyTitle}/${img}" style="width:700px; height:500px;">
        </c:forEach>
        
        <div style="width: 600px">
        <p><h5><br>${story.storyContent }</h5></p>
        </div>
        <hr>
      </article>
      <article class="blog-post">
      <br>
             
      </article>
</div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>