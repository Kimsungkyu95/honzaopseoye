<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	#dropdown{margin-top:30px; margin-left:20px;}
	#divSelect{margin-bottom:30px;}
	a:link, a:visited{color:black; text-decoration:none; padding-left:2px;}
	table{background-color:#E6E1FF; border:1px solid #C6BBEF; border-radius:5px;}
	tr td{border:20px solid white; padding-bottom:20px; width:25%;}
  	img {
	    object-fit: cover;
		width: 100%;
		height: 300px;
 	} 
   select{border:1px solid #C6BBEF; color:#3C3B41; border-radius:3px}  
   #btn{height:27px}
   span{font-size:13px}
</style>


<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript">
	
	let dessert=[{eng:"dessert",kor:"디저트"}];
	let fastfood=[{eng:"fastfood",kor:"패스트푸드"}];
	let pizza=[{eng:"pizza",kor:"피자"}];
	let chicken=[{eng:"chicken",kor:"치킨"}];
	let snack=[{eng:"snack",kor:"분식"}];
	let korean=[{eng:"meat",kor:"고기"},{eng:"soup",kor:"국밥"}, {eng:"nuddle",kor:"국수"}, {eng:"coldnuddle",kor:"냉면"}, {eng:"hanjeongsik",kor:"한정식"}];
	let japanese=[{eng:"porkcutlet",kor:"돈까스"}, {eng:"lamen",kor:"일본라멘"}, {eng : "sushi",kor: "초밥"}, {eng: "sashimi",kor:"회"}];
	let chinese=[{eng:"chinese",kor:"중화요리"}];
	let western=[{eng:"italian", kor : "이탈리안"}, {eng : "worldfood", kor : "세계음식"}]
	let buffet=[{eng:"buffef", kor : "뷔페"}];
	let bar=[{eng:"bar", kor : "술집"}];
	
	function categoryChoice(th, fr){
	  	while(fr.categoryDetail.length>1){
	  		fr.categoryDetail.options[1] = null;
	  	}
	  	let arr = new Function('return ' + th.value)();
		for(i=0; i<arr.length; i++){
			fr.categoryDetail.options[fr.categoryDetail.length] = new Option(arr[i].kor, arr[i].eng);
		}
	}
	
	function searchKeyword(fr) {
		if(fr.category.value=="0"){
			alert("카테고리를 선택 하세요.")
			return;
		}
		else if(fr.categoryDetail.value=="0"){
			alert("카테고리상세를 선택 하세요.")
			return;
		}
		fr.submit();
	}
	
</script>
</head>
<body>
<!-- 페이징 처리 필요.. -->

<jsp:include page="common/header.jsp"/>

<!--큰틀 -->
 <div class="container" id="frame">
 
	<!-- 드롭다운 div -->  
    <div id="dropdown">
		<!-- select로 카테고리별 맛집 찾기 -->
		<div id="divSelect">
			  <form name="selectForm"  style="margin-left:4px" method="post" action="${path}/front">
			  <select name="category" onChange = "categoryChoice(this, form)">
			       <option value="0">--카테고리--</option>
				   <option value="dessert">디저트</option>
				   <option value="fastfood">패스트푸드</option>
				   <option value="pizza">피자</option>
				   <option value="chicken">치킨</option>
				   <option value="snack">분식</option>
				   <option value="korean">한식</option>
				   <option value="japanese">일식</option>
				   <option value="chinese">중식</option>
				   <option value="western">양식</option>
				   <option value="buffet">뷔페</option>
				   <option value="bar">술집</option>
   			  </select>
			  <select name="categoryDetail">
       			   <option value="0">--카테고리 상세--</option>
   			  </select>
   			  <select name="option">
       			   <option value="direction">거리순</option>
       			   <option value="alotReview">리뷰많은순</option>
       			   <option value="highRank">별점높은순</option>
   			  </select>
   			  	<span>
					<input type="button" value="검색" onclick="searchKeyword(form)"/> 
			    </span>
   			  </form>
		</div>
	</div>
    
    <c:forEach items="${requestScope.list} " var="restaurantDTO">  
	 <!--맛집카테고리별 식당 div -->
      <div id="list">
	    <table>
			<tr>
				<td>
					   <a href="#">
						<img src="img/삼겹살.jpeg"/>
					   </a>
					   	<br>
					   	<br>레벨
			    </td>
				<td><img src="img/초밥1.jpeg" /><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
				<td><img src="img/회.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
				<td><img src="img/삼겹살.jpeg"/><br>맛집이름, 별점<br>대략위치-대표메뉴</td>
			</tr>
			<tr>
				<td><img src="img/삼겹살.jpeg"/><br>설명1<br>설명2</td>
				<td><img src="img/회.jpeg" /><br>설명1<br>설명2</td>
				<td><img src="img/초밥2.jpg"/><br>설명1<br>설명2</td>
				<td><img src="img/삼겹살.jpeg"/><br>설명1<br>설명2</td>
			</tr>
		 </table>
 		</div>	
 	</c:forEach>
        
</div>


<!--큰 div영역 끝  -->



 <jsp:include page="common/footer.jsp"/>
</body>
</html>