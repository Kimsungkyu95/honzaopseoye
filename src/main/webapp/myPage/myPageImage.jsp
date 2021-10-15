<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


	<title>myPageImage</title>
  </head>
  
  
  
  <body>
    <jsp:include page="../common/header.jsp"/>

	
	<h1 class="p-3 mb-2 bg-light text-dark">나의프로필</h1>
    
    <div class="p-5 mb-4 bg-light border rounded-3">
    
    	<div class="">
    		<h2>프로필 수정</h2>
    		대표 프로필을 수정할 수 있습니다.</p>
    	</div>
    	<table border="0" class="table table-bordered">
    		<colgroup>
    			<col style="width:22%">
    			<col>
    		</colgroup>
    		<tbody>
    			<tr>
    				<th scope="row">
    					<div class="">프로필 사진</div>
    				</th>
    				<td>
    					<div class="">
    						<img id="img" src="../img/humanicon.png" width="100" height="100">
    					</div>
    					<div class="">
    						<button type="button" class="btn btn-outline-warning">사진변경</button>
							<button type="button" class="btn btn-outline-info">삭제</button>
    					</div>
    				</td>
    				
    			</tr>
    		</tbody>
    	</table>
    	
    	<button type="button" class="btn btn-secondary btn-lg">적용</button> 
	    <button type="button" class="btn btn-secondary btn-lg">취소</button>   
    </div>
	


    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

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