<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style>

</style>
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<script type="text/javascript" >

	function registration() {
		location.href="${pageContext.request.contextPath}/member/registForm.jsp";
	}

</script>
</head>
<body>
 <jsp:include page="common/header.jsp"/>

 
  
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

<main class="container">
  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark text-center">
   <h1 class="display-5 fw-bold">혼자옵서예</h1>
   
    </div>
 </main>
  </div>


<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column text-center">
 
    
    <p class="lead">늘어가는 1인 가구의 증가와 <br>
    혼자 밥먹는게 이제는 당연시 되는 세상,<br> 
    또한 아직 혼자 밥먹는게 어려운 사람들에게<br> 
    혼밥 레벨을 정해주고 레벨에 따른 추천 <b>맛집사이트.</b></p>
    <p class="lead">
    </p>

</div>


 <div class="container col-xxl-8 px-4 py-5">
  <div class="px-4 py-5 my-5 text-center rounded-3 border shadow-lg">
    <img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/img/혼밥.jpg" alt="" >
    <h1 class="display-5 fw-bold">'혼자옵서예'가 무슨뜻이지?</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4"><span class="fst-italic">"혼저옵서예"</span>는 제주어에서 '어서 오세요.'를 뜻합니다. '혼저' 자체가 '어서', '질질 끄는 없이 빠르게'라는 의미가 있으므로 <br><b>'어서 오세요'</b>와 같은 말입니다.<br>혼자 밥먹는 사람들이 두려워하지 말라는 의미에서 '혼자'라는 단어와 결합하여 <b>혼자옵서예.</b>라는 브랜드 명을 만들게 되었습니다.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
      </div>
    </div>
  </div>
 </div>

  <div class="b-example-divider"></div>

  <div class="container col-xxl-8 px-4 py-5">
  <div class="px-4 pt-5 my-5 text-center border-bottom rounded-3 border shadow-lg">
    <h1 class="display-4 fw-bold">서울시 혼밥 플레이스들 추천</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">저희 <b>혼자옵서예</b>는 서울시의 구 > 동 단위로 혼자 먹기 좋은 맛집들을<br>
      또는 혼자 밥먹것에 익숙해진 분들을 위해서 <br>새롭게 시도해볼만한 맛집들을 추천해드리고 있습니다.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
      </div>
    </div>
    <div class="overflow-hidden" style="max-height: 30vh;">
      <div class="container px-5">
        <img src="${pageContext.request.contextPath}/img/seoul_district_map_ko_0.png" class="img-fluid border rounded-3 shadow-lg mb-4" alt="Example image" width="700" height="500" loading="lazy">
      </div>
    </div>
  </div>
</div>

  <div class="b-example-divider"></div>

  <div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5 rounded-3 border shadow-lg">
      <div class="col-10 col-sm-8 col-lg-6">
        <img src="${pageContext.request.contextPath}/img/레벨테스트스샷(임시).PNG" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
      </div>
      <div class="col-lg-6">
        <h1 class="display-5 fw-bold lh-1 mb-3">혼밥하고 레벨업하자!</h1>
        <p class="lead">혼자 밥먹는게 부담스러우세요?<br>
        혹시 고기집에서 눈치 안보고 혼자 밥 먹을만큼 용감하시나요?<br>
        혼자 밥먹고 레벨업을 통해서 <br> 
        더 높은 레벨의 혼밥 플레이스를 즐겨보세요!</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
        </div>
      </div>
    </div>
  </div>


 
  <div class="b-example-divider"></div>

  <div class="bg-dark text-secondary px-4 py-5 text-center">
    <div class="py-5">
      <h1 class="display-5 fw-bold text-white">자신의 레벨이 궁금하시다고요?</h1>
      <div class="col-lg-6 mx-auto">
        <p class="fs-5 mb-4">회원 가입하고 지금 당장 레벨 테스트 하세요!</p>
        <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
          <button type="button" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold" onclick="registration();">회원가입하러 가기!</button>
        </div>
      </div>
    </div>
  </div>

  <div class="b-example-divider mb-0"></div>



 <jsp:include page="common/footer.jsp"/>
</body>
</html>