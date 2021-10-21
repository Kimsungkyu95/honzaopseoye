<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!-- 관리자인지 체크해서 아니면 error페이지로 이동 -->
<%
	String user = (String)session.getAttribute("loginId");
	if(user == null || !user.equals("admin")) {
	//에러페이지로 이동
		request.setAttribute("errorMsg", "관리자만 접근할 수 있는 페이지 입니다.");
		request.getRequestDispatcher("../error/error.jsp").forward(request, response);
	}
%> 
 
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>스토리 목록 - 관리자</title>

    <!-- 부트스트랩 -->
    <!--<link href="css/bootstrap.min.css" rel="stylesheet">  --> 

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<style type="text/css">
        th, td {
           text-align: center;
           vertical-align: middle;
        }
        form {
            display: flex;
            justify-content: center;
        }
        
        table a {
        	text-decoration: none;
        }
        
        .active {
        	pointer-events: none; 
        }

	
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script>
$(function(){
	
	selectAll();
	
	
	 function selectAll(){
		  $.ajax({
				url: "../adminStorySelectAll", 
				type: "post",
				dataType: "json", 
				success: function(result){
					
					let str="";
                   $.each(result, function(index, item){
                   	str+="<tr>";
                   	str+="<td><b>"+item.storyNo+"</td>";
                   	str+="<td>"+item.memberNo+"</td>";
                   	str+="<td><a href='${path}/front?key=userStory&methodName=selectByStoryNo&storyNo="+item.storyNo+"'>"+item.storyTitle+"</a></td>";
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
	

	
	$(document).on("click", "[value='삭제']", function(){
		// alert($(this).attr("id"));
		 if(confirm("정말 삭제하실래요?")){
		  $.ajax({
					url: "../adminStoryDelete",
					type: "post", 
					dataType: "text",
					data: {no:$(this).attr("id")},
					success: function(result){
						if(result==0){
							alert("실패하였습니다.");
						}else{
							selectAll();
						}
					},
					error: function(err){ 
						alert("에러가 발생했어요.");
					}
				});//ajax의 끝
		 }
	 });
	
	
	$(document).on("click", ".btn", function(){
		//alert($(".form-control").val()); 검색어 값
		//alert($(".form-select").val()); 셀렉 값
		
		 $.ajax({
				url: "../selectByOption",
				type: "post", 
				dataType: "json",
				data: {
					value:$(".form-control").val(), 
					option:$(".form-select").val()
					},
				success: function(result){
					let str="";
                $.each(result, function(index, item){
                	str+="<tr>";
                	str+="<td><b>"+item.storyNo+"</td>";
                	str+="<td>"+item.memberNo+"</td>";
                	str+="<td><a href='${path}/front?key=userStory&methodName=selectByStoryNo&storyNo="+item.storyNo+"'>"+item.storyTitle+"</a></td>";
                	str+="<td>"+item.storyRegdate+"</td>";
                	str+="<td>"+item.storyVisited+"</td>";
                	str+="<td><input type='button' id='"+item.storyNo+"' value='삭제'></td>"; 
                	str+="</tr>";
                });
                str+="<div><hr><a href='${path}/adminStory/adminStoryList.jsp'>리스트로 돌아가기</a></div>";
                $("#tbody").html(str); 
                
					
				},
				error: function(err){ 
					alert("에러");
					selectAll();
				}
			});//ajax의 끝
		
	 });
	
	
	
});
</script>    


  </head>
  <body>
  <jsp:include page="../common/adminHeader.jsp"/>
 
    
     <div class="container mt-5 shadow-lg">
        <form class="row g-3 rounded p-2">
            <div class="col-auto">  
                <select class="form-select col-auto" aria-label="Default select example" name="selectKey">
                    <option value="selectByStoryTitle">스토리제목</option>
                    <option value="selectByMemberNo">회원번호</option>
                </select>
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" placeholder="검색어를 입력하세요" name="selectValue">
            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

<form>

    <div class="container bg-light pt-4 pb-3 px-5 mt-4 rounded shadow-lg" id="listTable">
        <h2>스토리 관리</h2>
        <table class="table">
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





    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
  </body>
</html>
    
    