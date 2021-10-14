<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩 101 템플릿</title>

    <!-- 부트스트랩 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
  table{background-color:#E6E1FF; border:1px solid #C6BBEF; border-radius:5px;}
  tr td{border:20px solid white; padding-bottom:20px;}
  img {
  max-width: 100%;
  height: auto;
  display: block;
  } 
  select{border:1px solid #C6BBEF; color:#3C3B41; border-radius:3px}  
</style>
    
  </head>
  <body>



<br>
<h5>&nbsp;&nbsp;&nbsp;원하시는 추천을 해드려요! &nbsp;&nbsp;&nbsp;
 <!--  <ul class="dropdown-menu dropdown-menu-macos mx-0 shadow" style="width: 220px;">
    <li><a class="dropdown-item active" href="#">--선택--</a></li>
    <li><a class="dropdown-item" href="#">혼밥레벨별 맛집</a></li>
    <li><a class="dropdown-item" href="#">많이 검색된 맛집</a></li>
    <li><a class="dropdown-item" href="#">태그로 추천받기</a></li>
  </ul>--> 
<select name="kind">
    <option value="">--선택--</option>
    <option value="level">혼밥레벨별 맛집</option>
    <option value="visited">많이 검색된 맛집</option>
    <option value="tag">태그로 추천받기</option>
</select>
</h5>


<p><p><br>
<span><h3>&nbsp;혼밥레벨별 추천<!-- 혼밥레벨별 추천 --></h3></span>
<p>
<!-- ajax 이용해서 태그별 추천 때, 혼밥레벨별 추천 때에 따라 div 영역에 표시하기 -->
<form><!-- 
<div id="list">&nbsp;&nbsp;<button type="button" class="btn btn-outline-secondary">#분위기</button> 
               <button type="button" class="btn btn-outline-secondary">#감성</button> 
               <button type="button" class="btn btn-outline-secondary">#루프탑</button> 
               <button type="button" class="btn btn-outline-secondary">#포토존</button> 
               <button type="button" class="btn btn-outline-secondary">#향신료</button> 
               <button type="button" class="btn btn-outline-secondary">#국물</button> 
               <button type="button" class="btn btn-outline-secondary">#밥</button>
               <p><p>&nbsp;
               <button type="button" class="btn btn-outline-secondary">#면</button> 
               <button type="button" class="btn btn-outline-secondary">#빵</button> 
               <button type="button" class="btn btn-outline-secondary">#오리</button> 
               <button type="button" class="btn btn-outline-secondary">#닭</button> 
               <button type="button" class="btn btn-outline-secondary">#돼지</button> 
               <button type="button" class="btn btn-outline-secondary">#소</button> 
               <button type="button" class="btn btn-outline-secondary">#치즈</button> 
               <p><p>&nbsp;
               <button type="button" class="btn btn-outline-secondary">#아주매움</button> 
               <button type="button" class="btn btn-outline-secondary">#신라면맵기</button> 
               <button type="button" class="btn btn-outline-secondary">#순한맛</button> 
               <button type="button" class="btn btn-outline-secondary">#얼큰</button> 
               <button type="button" class="btn btn-outline-secondary">#뜨끈</button> 
               <button type="button" class="btn btn-outline-secondary">#맥주와꿀조합</button> 
               <button type="button" class="btn btn-outline-secondary">#만19세이상</button> 
               <button type="button" class="btn btn-outline-secondary">#야식추천</button> 
               <p>           
</div>
 -->

</form>
 <h5>
 <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
  <div class="btn-group btn-group-lg" role="group" aria-label="First group">
    &nbsp;&nbsp;&nbsp;
    <button type="button" class="btn btn-primary">Lv.1 병아리</button>
    <button type="button" class="btn btn-primary">Lv.2 신입</button>
    <button type="button" class="btn btn-primary">Lv.3 도전자</button>
    <button type="button" class="btn btn-primary">Lv.4 경력자</button>
    <button type="button" class="btn btn-primary">Lv.5 능력자</button>
    <button type="button" class="btn btn-primary">Lv.6 전사</button>
    <button type="button" class="btn btn-primary">Lv.7 전능자</button>
  </div>
 </div>

 </h5> 
<p><p>
    <table> <!--javaScript/jQuery로 반복문 : 해당 추천리스트 길이에 따라 테이블 반복문돌리기 -->
		<tr>
			<td><a href=""><img src="img/삼겹살.jpeg"/></a><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="img/삼겹살.jpeg" /><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="img/삼겹살.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="img/삼겹살.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
		</tr>
		<tr>
			<td><img src="img/회.jpeg"/><br>설명1<br>설명2</td>
			<td><img src="img/회.jpeg" /><br>설명1<br>설명2</td>
			<td><img src="img/회.jpeg"/><br>설명1<br>설명2</td>
			<td><img src="img/회.jpeg"/><br>설명1<br>설명2</td>
		</tr>
	</table>
	
	
  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
     <jsp:include page="common/footer.jsp"/>