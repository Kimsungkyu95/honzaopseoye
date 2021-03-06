<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


	<title>myPageImage</title>
	
	<style>
    	h1{text-align:center;}
    </style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	let pi = "${profileImage}";
	let id = "${id}"
	let tmpFileName="";
	//console.log("id:"+ id);
	
	$("#fileActual").on('change', function() {
		let file = $(this).val();
		 ext = file.split('.').pop().toLowerCase(); //확장자
         //배열에 추출한 확장자가 존재하는지 체크
         if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
             $(this).val(""); //폼 초기화
             window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
         }else{
        	 //var profileImage = document.getElementById("profileImage").files[0];
        	 var profileImage = $('#fileActual')[0].files[0];
        	 //console.log(profileImage.name);
        	 tmpFileName=profileImage.name;
        	 
        	 file = $('#fileActual').prop("files")[0];
             blobURL = window.URL.createObjectURL(file);
             $('#profileImage').attr('src', blobURL);
         }
	})
	
	$("#deleteImgBtn").click(function() {
		$("#profileImage").attr('src', "${path}/img/profileImages/${profileImage}");
	})
	
	$("#sendIt").click(function() {
		/* let form = document.getElementById("imgForm");
		console.log("form : "+form);
		let fileName = form.fileActual;
		console.log("fileName : "+fileName); */
		
		$("#imgForm").submit();
	})
	
	
})

</script>
  </head>
  
  
  
  <body>
    <jsp:include page="../common/header.jsp"/>

	
	<h1 class="p-3 mb-2 bg-light text-dark">프로필변경</h1>
    
    <div class="p-5 mb-4 bg-light border rounded-3">
    
    	<div class="">
    		<h2>프로필 사진</h2>
    		<p>대표 프로필을 수정할 수 있습니다.</p>
    	</div>
    	<table class="table table-bordered">
    		<colgroup>
    			<col style="width:22%">
    			<col>
    		</colgroup>
    		<tbody>
    			<tr>
    			<c:if test="${empty profileImage}">
    				<th scope="row">
    					<div class=""><img alt="profile image" id="profileImage" src="${path}/img/profileImages/humanicon.png" style="height: 225px"></div>
    				</th>
    			</c:if> 	
    			<c:if test="${not empty profileImage}">
    				<th scope="row">
    					<div class=""><img alt="profile image" id="profileImage" src="${path}/img/profileImages/${profileImage}" style="height: 225px"></div>
    				</th>
    			</c:if>
    				<td>
    					<div class="">
    						<img id="img" src="${path}/img/profileImages/humanicon.png" width="100" height="100">
    					</div>
    					<div class="">
    						<form method="post"  action="${path}/front?key=member&methodName=updateProfileImageById" enctype="multipart/form-data" id="imgForm">
    						<input type="hidden" name="memberId" value="${id}">
							  파일첨부:<input type="file"  name="file" id="fileActual"><p>
							  <!-- 
							  <input type="submit" class="btn btn-outline-warning" value="사진변경"/>
							   -->
							  <button type="reset" class="btn btn-outline-info" id="deleteImgBtn">삭제</button>
							</form>
							
    					</div>
    				</td>
    				
    			</tr>
    		</tbody>
    	</table>
    	
    	<button type="button" class="btn btn-secondary btn-lg" id="sendIt">적용</button> 
	    <button type="button" class="btn btn-secondary btn-lg" onclick="location.href='${path}/myPage/myPage.jsp'">취소</button>   
    </div>
	


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <!--  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	-->
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->

    <footer class="pt-3 mt-4 text-muted border-top" style="clear:both">
      <jsp:include page="../common/footer.jsp"/>
    </footer>
  </body>
</html>