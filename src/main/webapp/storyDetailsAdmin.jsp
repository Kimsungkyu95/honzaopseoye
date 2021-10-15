<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>관리자용 스토리상세 검색</title>

    <!-- 부트스트랩 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
tr td{border: 6px white solid; color:#878984;}
span{font-size:15;text-align:center;color:#878984}
.left{margin-left:50px; margin-top:50px; margin-right:80px; float:right; }
img{height:200px; width:300px; margin-right:20px; margin-bottom:20px}
    
</style>
    
  </head>
  <body>
 <br>
<div><h2><b style="font-style:italic; margin:30px;">스토리 상세</b>
        <a href="#" style="float:right;margin-right:200px;text-decoration:none;color:gray;font-style:italic;">메인으로</a>
        </h2>
<hr>
  
 <table class="left">
	 <tr>
	 	<td><img src="img/삼겹살.jpeg"></td>
	 	<td><img src="img/초밥1.jpeg"></td>
	 </tr>
	 <tr>
	 	<td><img src="img/초밥2.jpg"></td>
	 	<td><img src="img/초밥1.jpeg"></td>
	 </tr>
 </table>
  
  <form>
  <div style="float:right; width:800px; margin:56px">
  	<div class="h-100 p-5 bg-light border rounded-3">
          <h2><b>스토리 제목</b></h2>
          <!-- 글번호, 회원번호, 조회수, 등록일 -->
          <h6>#1 | <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-fill" viewBox="0 0 16 16">
  <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0z"/>
  <path d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8zm8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
</svg> 90 <p>
          회원번호 : 3 | 등록일 : 2022-11-21<span style="float:right">by.작성자이름</span></h6>
          <hr>
          <br><br>
          <h4>
         
          <p>
          
          가을엔 테라스에서 계절을 온몸으로 만끽하며 맛있는 브런치를 먹어줘야 제맛! 성수동의 핫플, 성수연방에 새로 자리한 브런치 카페 메이플탑 입니다.

메이플탑은 미국 남부식 브런치를 맛볼 수 있는 곳인데요. 교포인 대표님이 미국에서 먹던 그 맛을 한국에서도 느끼고 싶어 이곳을 오픈하게 되었다고 해요.

알고 보니 메이플탑에서는 코로나19로 어려운 소상공인들과 함께 win-win할 수 있게 다양한 곳에서 공급받은 재료로 풍성한 브런치 메뉴를 선보이고 있더라고요.

베이컨과 햄은 존쿡델리미트, 풀드포크는 라이너스바베큐, 훈제연어는 세스크멘슬, 그래놀라는 그라놀로지 등 등 식재료별로 믿을 수 있는 곳을 통해 재료를 수급받고 있답니다.

모던하면서도 어딘가 레트로한 느낌이 묻어나는 인테리어가 인상적인데요. 요즘같이 선선한 날씨에는  테라스에서 브런치를 즐기기에 좋을 것 같더라구요.

반려견 동반도 가능하다고 하니, 댕댕이와 함께 여유로운 브런치를 즐기러 오기에도 딱! 

망고걸의 한 줄 평
: "브렉퍼스트 샤퀴테리로 찐 미국 바이브!"
          </p>
          <br><br>
          </h4>
          <hr><p>
          <b>admin key</b> <input type="text" name="adminKey" style="width:100px"><br><br>
          <button class="btn btn-outline-secondary" type="button">삭제하시겠습니까?</button>
          <button class="btn btn-outline-secondary" type="button">돌아가기</button>
        </div>
  
  
  </div>
  </form>
 <p>
 
  

    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
  