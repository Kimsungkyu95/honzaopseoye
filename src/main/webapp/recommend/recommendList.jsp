<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <!-- jQuery추가 -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

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
  tr td{border:20px solid white; padding-bottom:20px; width:25%;}
  img {
	    object-fit: cover;
		width: 100%;
		height: 300px;
  } 
  select{border:1px solid #C6BBEF; color:#3C3B41; border-radius:3px}  
 
  
</style>

<script>
    $(function(){
	  $("select[name=kind]").change(function(){
		  
		  let param=$(this).val();
		  let str="<br><h4>&nbsp;&nbsp;"
		  let comment="&nbsp;&nbsp;조회수가 높은 리스트입니다"
		  str+=param+"</h4>"
		  let myLevel="현재 나의 레벨은";
		  let tagList="&nbsp;&nbsp;&nbsp;";
		  let tags=['분위기', '감성', '루프탑','포토존', '향신료', '국물', '밥', '면', 
				  '빵', '오리', '닭', '돼지', '소', '치즈', '아주매움', '신라면맵기', '순한맛',
				  '얼큰', '뜨끈','맥주와꿀조합','만19세이상', '야식추천','간단하게', '든든하게',
				  '속편한', '수제', '유기농', '반려동물동반가능', '브런치', '다이어트', '채식',
				  '비건', '집밥', '공간넓음', '교통좋음', '주차가능', '조용함', '신나는분위기',
				  '시끌벅적', '노래빵빵', '아기자기'];
		  
		  //레벨 선택 바
		  let levelBar="<div class='btn-toolbar' role='toolbar' aria-label='Toolbar with button groups'>"
		  levelBar+="<div class='btn-group btn-group-lg' role='group' aria-label='First group'>&nbsp;&nbsp;&nbsp;"
		  levelBar+="<button type='button' value='1' class='btn btn-primary' data-bs-toggle='tooltip' data-bs-placement='top' title='처음이신가요?'>Lv.1 병아리</button>"
		  levelBar+="<button type='button' value='2' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='신입'>Lv.2 신입</button>"
		  levelBar+="<button type='button' value='3' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='도전해보세요'>Lv.3 도전자</button>"
		  levelBar+="<button type='button' value='4' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='혼밥이 크게 어렵지 않다면'>Lv.4 경력자</button>"
		  levelBar+="<button type='button' value='5' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='먹고 싶은 혼밥 메뉴를 탐험해보세요'>Lv.5 능력자</button>"
		  levelBar+="<button type='button' value='6' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='개척하세요'>Lv.6 전사</button>"
		  levelBar+="<button type='button' value='7' class='btn btn-primary'data-bs-toggle='tooltip' data-bs-placement='top' title='끝판왕'>Lv.7 전능자</button></div></div>"
		  
		  $("#display2").empty();
		  $("#display3").empty();
		  $("#display4").empty();
		  $("#display5").empty();
		  
		  if(param == "혼밥레벨별 맛집"){
			  str+="<h5>&nbsp;&nbsp;&nbsp;"+myLevel+"</h5>"
		      $("#display1").html(str);
			  $("#display2").html(levelBar);
			  
			  //해당 레벨을 클릭했을때 아래 레벨에 해당하는 추천목록 띄우기
			  
				 $("button").click(function(){
					 for(let i=1;i<=7;i++){
						if($(this).val()==i){
						   	alert(i);
						}//if
				      }//for
				 });

			  
		  }else if(param =="태그별 추천"){

			//태그 반복문 돌리기
			  $.each(tags, function(index, item){			  
			 	  tagList+='<button type="button" value="'+index+'" class="btn btn-outline-secondary">#'
				  tagList+=item+'</button> '; 
			 	  if(index == 9 || index == 18 || index == 27)
				  	  tagList+='<p><p>&nbsp;&nbsp;&nbsp;';
	          });
			
			  
			  $("#display1").html(str);
			  $("#display3").html(tagList);
			  
			//해당 태그를 클릭했을때 태그에 해당하는 추천목록 아래에 띄우기
			
				for(let i=0;i<=tags.length;i++){
				     $("button").click(function(){
						if($(this).val() == i){
						    alert(i);
					    }
					 });
				  }
			  
			  
			  
		  }else{
			  
			  $("#display1").html(str);
			  if(param == "많이 검색된 맛집"){
			      $("#display4").html(comment);
			  }
		  }
	 });
	  
	  
	 
});

</script>


    
    
</head>
<body>

<br>
<h5>&nbsp;&nbsp;&nbsp;원하시는 추천을 해드려요! &nbsp;&nbsp;&nbsp;

<select name="kind">
    <option value="후회없는 디폴트 맛집">--선택--</option>
    <option value="혼밥레벨별 맛집">혼밥레벨별 맛집</option>
    <option value="많이 검색된 맛집">많이 검색된 맛집</option>
    <option value="태그별 추천">태그로 추천받기</option>
</select>
</h5>


<p><p><br>
<div id="display1"> </div>
<p>

 <h5>
 <div id="display2"></div>
 <div id="display3"></div>
 <div id="display4"></div>  
 </h5> 

<p><p>

    <div id="display5"><h4><br>&nbsp;&nbsp;후회없는 디폴트 맛집</h4></div>
    
 <div id="table"> 
    <table> <!--해당 추천리스트 길이에 따라 테이블 반복문돌리기 -->
		<tr>
			<td><a href=""><img src="../img/삼겹살.jpeg"/></a><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="../img/초밥1.jpeg" /><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="../img/회.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			<td><img src="../img/삼겹살.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
		</tr>
		<tr>
			<td><img src="../img/삼겹살.jpeg"/><br>설명1<br>설명2</td>
			<td><img src="../img/회.jpeg" /><br>설명1<br>설명2</td>
			<td><img src="../img/초밥2.jpg"/><br>설명1<br>설명2</td>
			<td><img src="../img/삼겹살.jpeg"/><br>설명1<br>설명2</td>
		</tr>
	</table>
 </div>	

	
  <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
     <jsp:include page="../common/footer.jsp"/>