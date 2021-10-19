<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>userStoryDetails</title>

<style></style>

<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" ></script>
</head>

<body>
<jsp:include page="../common/header.jsp"/>
<div class="row g-5">
<div class="col-md-4">
      <div class="position-sticky" style="top: 2rem;">
        <div class="p-4 mb-3 bg-light rounded">
        <img src="../img/초밥2.jpg" style="max-width:100%; height:auto; border-radius: 10%;display : block ; margin : auto;">
          <br><p><h4 class="fst-italic" style="text-align: center;">광진구 초밥 맛집 BEST 5 !!!</h4>
          
        </div>

        <div class="p-4">
          <img src="../img/humanicon.png" style="width: 80px; height: 80px; border-radius: 70%; vertical-align: bottom;">
			<br><p><br>
			<span><b><i>Editor. 김혼자</i></b></span>
			<p><br>
			2021-10-15 | <img src="../img/eyeicon.png" style="width: 20px; height: 20px;">
			<span>조회수</span><p>
			<p><hr>
			<button type="submit" class="btn btn-secondary mb-3"><a href="${pageContext.request.contextPath}/userStory/userStoryUpdate.jsp" style="color: white;">수정</a></button>
        </div>
      </div>
    </div>
    
    <div class="col-md-8" id="div2">
      <article class="blog-post">
      <br>
        <h2 class="blog-post-title"><b>초밥집1</b></h2>
        <img src="../img/초밥1.jpeg">
        <div style="width: 600px">
        <p><br>좋은 리뷰가 많아서 가봤더니 역시 서비스도 너무 좋고 스시가 커서 입안한가득 먹는기분이 너무 좋았어요  맛도 너무맛있고 숙성스시인지  엄청부드러워서 먹기편했습니다  다들 너무 친절하셨어요!! 재방문의사 ×1000000</p>
        </div>
        <hr>
      </article>
      <article class="blog-post">
      <br>
        <h2 class="blog-post-title"><b>초밥집2</b></h2>
        <img src="../img/회.jpeg">
        <div style="width: 600px">
        <p><br>스시만에서부터 먹어보고 참 인상적이었던 권오준 셰프님의 타쿠미 곤 첫 방문. 이날은 런치 오마카세.

스시만이랑 비교했을 때 훨씬 개성 있고 인상적인 스시였다. 숙성되어 맛이 진하고 깊으면서도 이 부분을 네타도 크고 간도 강하게, 샤리도 간을 강하게 하여 본인 스시만의 개성을 남긴 부분이 인상적이었다.

정말 서울 내의 그 수많은 스시야 중에서도 본인만의 강력한 무기와 차별성을 가질 수 있다는 것만으로도 방문해야할만한 이유는 충분하다.</p>
        </div>
        <hr>
      </article>
</div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>