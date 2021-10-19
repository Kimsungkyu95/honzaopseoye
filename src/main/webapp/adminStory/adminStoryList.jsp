<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
  
<!DOCTYPE html>
<html lang="ko">
  <head>
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>관리자 스토리 목록</title>

    <!-- 부트스트랩 -->
    <!--<link href="css/bootstrap.min.css" rel="stylesheet">  --> 

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<style type="text/css">
	#buttons{align-content: center}
	a{text-decoration:none;color:gray;}
	p{align-content:center}
	span{font-size:9pt}
	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script>
$(function(){
	 function selectAll(){
		  $.ajax({
				url: "../adminStorySelectAll", 
				type: "post",
				dataType: "json", 
				success: function(result){
					
					let str="";
                   $.each(result, function(index, item){
                   	str+="<tr>";
                   	str+="<td>No."+item.storyNo+"</td>";
                   	str+="<td>"+item.memberNo+"</td>";
                   	str+="<td>"+item.storyTitle+"</td>";
                   	str+="<td>"+item.storyRegdate+"</td>";
                   	str+="<td>"+item.storyVisited+"</td>";
                   	str+="<td><input type='button' id='"+item.storyNo+"' value='삭제'></td>"; 
                   	str+="</tr>";
                   });

   				
                   $("#tbody").html(str); 
   			
   				
                   
				}, 
				error: function(err){ 
					alert("에러가 발생했어요.");
				}
			});
	   }
	
	selectAll();
	
	$(document).on("click", "[value='삭제']", function(){
		 //alert($(this).attr("id"));
		 if(confirm("정말 삭제하실래요?")){
	
		  $.ajax({
					//속성 : 값 (속성의 순서를 상관없다),
					url: "../adminStoryDelete", //back단의 서버요청주소
					type: "post", //method방식(get,post,put,delete)
					dataType: "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
					data: {no:$(this).attr("id")}, //form을 한 번에 전송해주는 serialize()
					success: function(result){
						if(result==0){
							alert("실패하였습니다."); //등록, 수정일수도 있기때문에
						}else{
							selectAll();
						}
					}, //성공했을때 callback함수(되돌아와서 해야될 기능들)
					error: function(err){ 
						alert("에러가 발생했어요.");
					}
				});//ajax의 끝
		 }
	 });
	
});
</script>    


  </head>
  <body>
 <br>
<div><h2><b style="font-style:italic; margin:30px;">스토리 목록</b>
        <a href="${path}/main.jsp" style="float:right;margin-right:200px;text-decoration:none;color:gray;font-style:italic;">메인으로</a>
        </h2>
</div>

<form>
<div class="table-responsive" id="listTable">
        <table class="table table-hover" style="margin-left: auto; margin-right: auto;">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">회원번호</th>
              <th scope="col">스토리제목</th>
              <th scope="col">등록일</th>
              <th scope="col">조회수</th>
              <th scope="col">스토리관리</th>
            </tr>
          </thead>
         
          <tbody id="tbody">  
          
  </tbody>
</table>
</div>
</form>
<div align=center>
	<div id="buttons" style="float:center; margin-right:100px">
	         <input type="text" value="" id="search">
	         <input type="button" value="검색">
	<span style="font-size:9pt;">&lt;<a href="${path}/front">메인으로 돌아가기</a>&gt;</span></div>
</div>



    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
  </body>
</html>
    