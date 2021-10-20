<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, world!</title>
    <style>
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
        
        .pagenation {
        	position:relative;
        }
        .registerBtn {
        	position: absolute;
        	top: 0px;
        	right: 0px;
        }

    </style>
    <script src="${path}/js/jquery-3.6.0.min.js"></script>
    <script>
    	$(function(){
    		//form value 고정
    		$('select[name=selectKey]').val('${requestScope.selectKey}');
    		$('input[name=selectValue]').val('${requestScope.selectValue}');
    		
    		//삭제버튼클릭시
    		$('.deleteBtn').click(function(){
    			console.log($(this).val());
    			let restaurantNo = $(this).val();
    			let restaurantName = $(this).closest('tr').find('.restaurantName').text();
    			let categoryName = $(this).closest('tr').find('.categoryName').text();
    			let categoryDetailsName = $(this).closest('tr').find('.categoryDetailsName').text();
    			if(confirm("맛집의 리뷰, 메뉴, 사진도 함께 사라집니다. 정말로 삭제하시겠습니까?")){
	    			$.ajax({
	                    url: "${path}/deleteRestaurantServlet", //서버요청주소
	                    type: "post", //method방식(get, post, put, delete)
	                    dataType: "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
	                    data: { restaurantNo: restaurantNo,
	                    		restaurantName: restaurantName,
	                    		categoryName: categoryName,
	                    		categoryDetailsName: categoryDetailsName
	                    }, //서버에게 보낼 parameter정보
	                    success: function (result) {
	                        alert(result);
	                        location.reload();
	                       	
	                    }, //성공했을 때 callback함수
	                    error: function (err) {
	                        alert(err + "발생했어요.");
	                    } //실패했을 때 callback함수
	                }); //ajax 끝				
    			}
    		})
    		
    		//현재페이지 atag 눌리지 않게
    		$('.disable').removeAttr("href");
    		
    	}) //jquery 끝
    </script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand text-dark" href="#">Admin Page</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">고객관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">맛집관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">리뷰관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-dark" href="#">차트분석</a>
                    </li>
                </ul>
                <span class="navbar-text">
                    <a class="nav-link text-dark" href="#">로그아웃</a>
                </span>
            </div>
        </div>
    </nav>

    <div class="container mt-5 shadow-lg">
        <form class="row g-3 rounded p-2" action="${path}/front" method="get" >
            <input type="hidden" name="key" value="adminRestaurant">
            <input type="hidden" name="methodName" value="pagingSelect">     
            <div class="col-auto">  
                <select class="form-select col-auto" aria-label="Default select example" name="selectKey">
                    <option value="restaurantName" selected>맛집이름</option>
                    <option value="restaurantAddr">주소</option>
                    <option value="categoryName">카테고리</option>
                </select>
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" placeholder="검색어를 입력하세요" name="selectValue">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

    <div class="container bg-light pt-4 pb-3 px-5 mt-4 rounded shadow-lg">
        <h2>맛집 목록</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">맛집이름</th>
                    <th scope="col">카테고리</th>
                    <th scope="col">상세카테고리</th>
                    <th scope="col">주소</th>
                    <th scope="col">등록일</th>
                    <th scope="col">레벨</th>
                    <th scope="col">조회수</th>
                    <th scope="col">삭제</th>
                </tr>
            </thead>
            <tbody>
            	<c:choose>
	            	<c:when test="${empty requestScope.restaurantList}">
	            	<tr><td colspan="8">검색된 맛집이 없습니다</td></tr>
	            	</c:when>
            	
            	<c:otherwise>  
            	<c:forEach items="${requestScope.restaurantList}" var="restaurantDTO" varStatus="status">       	
	                <tr>
	                    <th scope="row">${restaurantDTO.restaurantNo}</th>
	                    <td><a href="${path}/front?key=adminRestaurant&methodName=selectByRestaurantNo&restaurantNo=${restaurantDTO.restaurantNo}" class="restaurantName">${restaurantDTO.restaurantName}</a></td>
	                    <td class="categoryName">${restaurantDTO.categoryName}</td>
	                    <td class="categoryDetailsName">${restaurantDTO.categoryDetailsName}</td>
	                    <td>${restaurantDTO.restaurantAddr}</td> 
	                    <fmt:parseDate value="${restaurantDTO.restaurantRegDate}" var="parseDateValue" pattern="yyyy-MM-dd HH:mm:ss"/>                   
	                    <td><fmt:formatDate value="${parseDateValue}" pattern="yyyy-MM-dd"/></td>
	                    <td>${restaurantDTO.restaurantLevel}</td>
	                    <td>${restaurantDTO.restaurantVisited}</td>
	                    <td>
	                        <button type="button" class="btn btn-primary btn-sm deleteBtn" value="${restaurantDTO.restaurantNo}">삭제</button>
	                    </td>
	                </tr>
            	</c:forEach>      	
            	</c:otherwise>
            	</c:choose>
            </tbody>
        </table>
    </div>
    
    <!-- 페이징 처리 -->
    <jsp:useBean class="paging.PageCnt" id="p"/>
    <c:set var="doneLoop" value="false"/>
	<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2   0, (2-1)%2    1 , (3-1)%2  0 -->
	<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 0 -->
    
    <div class="container">
	    <nav aria-label="Page navigation example" class="mt-4 pagenation">
	        <ul class="pagination" style="justify-content: center;">
	        
	        	<c:if test="${(startPage-p.blockcount) > 0}">
		            <li class="page-item"><a class="page-link" href="${path}/front?key=adminRestaurant&methodName=pagingSelect&pageNo=${startPage-1}&selectKey=${requestScope.selectKey}&selectValue=${requestScope.selectValue}">Previous</a></li>    	
	        	</c:if>
	        	<c:forEach var="i" begin="${startPage}" end="${startPage + p.blockcount - 1}">
		            <c:if test="${i > p.pageCnt}">
		            	<c:set var="doneLoop" value="true"/>
		            </c:if>
		            <c:if test="${not doneLoop}">
			            <li class="page-item ${i == pageNo ? 'active' : ''}"><a class="page-link" href="${path}/front?key=adminRestaurant&methodName=pagingSelect&pageNo=${i}&selectKey=${requestScope.selectKey}&selectValue=${requestScope.selectValue}">${i}</a></li>	            
		            </c:if> 	
	        	</c:forEach>
	            <c:if test="${(startPage+p.blockcount) <= p.pageCnt}">
		            <li class="page-item"><a class="page-link" href="${path}/front?key=adminRestaurant&methodName=pagingSelect&pageNo=${startPage+p.blockcount}&selectKey=${requestScope.selectKey}&selectValue=${requestScope.selectValue}">Next</a></li>
	            
	            </c:if>
	        </ul>
	        <button class="btn btn-secondary registerBtn" onclick="location.href='${path}/adminRestaurant/registerRestaurant.html'">맛집 등록</button>
	    </nav>    
    </div>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>