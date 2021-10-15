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
	
    <title>myPageReviewList</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    
	<style>
    	h1{text-align:center;}
    </style>
   	
   	<script type="text/javascript">

   	</script>
   
  </head>
  <body>
    <jsp:include page="../common/header.jsp"/>

	<h1 class="p-3 mb-2 bg-light text-dark">나의 리뷰</h1>
	<div class="p-5 mb-4 bg-light border rounded-3">
    
    	<table border="0" class="table table-bordered">
    		<colgroup>
    			<col style="width:60%">
    		</colgroup>
    		<tbody>
    			<tr>
    				<th scope="row">
    					<div class="card" style="width:100%;">
						  <div class="card-body">
						    <h2 class="card-title">지아니스나폴리</h2>
						    <h4>양식 > 파스타 Lv.1 2021.10.11</h4>
						    
						    
						    <!-- 별점 -->
						    
						    
						    
						    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
						    <p class="card-text">
						    	Some quick example text to build on the card title and make up the bulk of the card's content.<p>
						    	Some quick example text to build on the card title and make up the bulk of the card's content.<p>
						    	Some quick example text to build on the card title and make up the bulk of the card's content.<p>
						    	
						    </p>
						    
						  </div>
						</div>
    				</th>
    				<td>
    					<div class="">
    						<img id="img" src="../img/삼겹살.jpeg" width="100%">
    					</div>
    				</td>
    				
    			</tr>
    		</tbody>
    	</table>
    	
    	<div class="col text-center">
    		<button type="button" class="btn btn-secondary btn-lg">수정</button>
			<button type="button" class="btn btn-secondary btn-lg">삭제</button>
    	</div>
    	 
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