<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>category</title>
	
<style>
	.card-body{width:300px; height:100px}
	#dropdown{margin-bottom:40px}
	#span{margin-left:300px}
	
</style>
<script type="text/javascript" ></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<!-- 페이징 처리 필요.. -->
<jsp:include page="common/header.jsp"/>

<div class="album py-5 bg-light">
<!--큰틀 -->
 <div class="container">
	<!-- 드롭다운 div -->  
    <div id="dropdown">
		<div class="dropdown">
  			<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
		   		카테고리
			</button>
		  	<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				    <li><a class="dropdown-item" href="#">한식</a></li>
				    <li><a class="dropdown-item" href="#">일식</a></li>
				    <li><a class="dropdown-item" href="#">중식</a></li>
			  </ul>
    		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
		   		카테고리상세
    		</button>
			  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				    <li><a class="dropdown-item" href="#">냉면</a></li>
				    <li><a class="dropdown-item" href="#">백반정식</a></li>
				    <li><a class="dropdown-item" href="#">김치찌개</a></li>
			 </ul>
			 <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
				거리순
		     </button>
			  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				    <li><a class="dropdown-item" href="#">거리순</a></li>
				    <li><a class="dropdown-item" href="#">리뷰많은순</a></li>
				    <li><a class="dropdown-item" href="#">별점높은순</a></li>
			 </ul>
		</div>
	</div>
    
	 <!--맛집카테고리별 식당 div -->
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      
        <div class="col">
       	  <!-- 하나의 카드 -->
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            	사진
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>

        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
         <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
            <rect width="100%" height="100%" fill="#55595c">
            </rect>
            	<text x="100%" y="100%" fill="#eceeef" dy=".3em">
            	</text>
            </svg>
            <div class="card-body">
              <p class="card-text"></p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 식당이름 :
                </div>
                <div class="btn-group">
                  별점 :
                </div>
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
        </div>
        
        <!-- 페이징처리 -->
<!-- <nav aria-label="Page navigation example" style="clear:both">
  	  <ul class="pagination">
    	<li class="page-item">
      	<a class="page-link" href="#" aria-label="Previous">
        	<span aria-hidden="true">&laquo;</span>
      	</a>
    	</li>
    	
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
      	<a class="page-link" href="#" aria-label="Next">
        	<span aria-hidden="true">&raquo;</span>
      	</a>
    	</li>
  	 </ul>
</nav>  -->
        
      </div>
    </div>
  </div>


 <jsp:include page="common/footer.jsp"/>
</body>
</html>