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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, world!</title>
    <style>
        #form-container {
            display: flex;
            justify-content: center;
        }
        form{
            width: 700px;
        }
        .bottom-btn{
            text-align: center;
        }
    </style>
    <script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"></script>

    <script>
        $(function () {
            //카테고리 설정
            dessert = [{eng:"dessert", kor : "디저트"}];
            fastfood = [{eng:"fastfood", kor: "패스트푸드"}];
            pizza = [{eng:"pizza", kor: "피자"}]
            chicken = [{eng:"chicken", kor: "치킨"}]
            snack = [{eng:"snack", kor: "분식"}]
            korean = [{eng:"meat", kor: "고기"}, {eng:"soup", kor:"국밥"}, {eng:"nuddle", kor:"국수"}, {eng:"coldnuddle", kor:"냉면"}, {eng:"hanjeongsik", kor:"한정식"}]
            japanese = [{eng:"porkcutlet", kor: "돈까스"}, {eng:"lamen", kor:"라멘"}, {eng:"sushi", kor:"초밥"}, {eng:"sashimi", kor:"회"}]
            chinese = [{eng:"chinese", kor:"중화요리"}]
            western = [{eng:"italian", kor : "이탈리안"}, {eng : "worldfood", kor : "세계음식"}]
            buffet = [{eng:"buffet", kor:"뷔페"}]
            bar = [{eng:"bar", kor:"술집"}]
			
            //second-category 변경
            function setSecondCategory(){
            	let str = `<option selected value="0">-상세카테고리선택-</option>`;
                if ($('#first-category').val() != 0) {
                    let secondList = new Function("return " + $('#first-category').val())();
                    for (item of secondList) {
                        str += `<option value=` + item.eng + `>`+ item.kor +`</option>`;
                    }
                }
                $('#second-category').empty().html(str);    	
            }
            
            //first-category 넣기
            $('#first-category').val("${requestScope.restaurantDTO.categoryName}");
            setSecondCategory()
            
            
            //first카테고리 change 일어날때
            $('#first-category').change(setSecondCategory)

            //경,위도 api
            function getCoordinate(jibunAddress) {
                //daum 지역 검색 api 이용
                $.ajax({
                    url: "https://dapi.kakao.com/v2/local/search/keyword.json", //서버요청주소
                    type: "get", //method방식(get, post, put, delete)
                    dataType: "json", //서버가 응답해주는 데이터의 type(text, html, xml, json)
                    data: { query: jibunAddress }, //서버에게 보낼 parameter정보
                    beforeSend: function (xhr) { //요청 헤더 추가
                        xhr.setRequestHeader('Authorization', "KakaoAK 9928b38057b1c51974e1664c4910ed86");
                    },
                    success: function (result) {
                        let jsonObjcet = result.documents[0];
                        $('#longitude').val(jsonObjcet.x); //경도
                        $('#latitude').val(jsonObjcet.y); //위도

                    }, //성공했을 때 callback함수

                    error: function (err) {
                        alert(err + "발생했어요.");
                    } //실패했을 때 callback함수
                }); //ajax 끝
            }

            //우편번호 찾기
            $('#find-addr').click(
                //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
                function() {
                    new daum.Postcode({
                        oncomplete: function (data) {
                            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    
                            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                            var roadAddr = data.roadAddress; // 도로명 주소 변수
                            var extraRoadAddr = ''; // 참고 항목 변수
    
                            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                extraRoadAddr += data.bname;
                            }
                            // 건물명이 있고, 공동주택일 경우 추가한다.
                            if (data.buildingName !== '' && data.apartment === 'Y') {
                                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                            }
                            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                            if (extraRoadAddr !== '') {
                                extraRoadAddr = ' (' + extraRoadAddr + ')';
                            }
    
                            // 우편번호와 주소 정보를 해당 필드에 넣는다.
                            document.getElementById('sample4_postcode').value = data.zonecode;
                            document.getElementById("sample4_roadAddress").value = roadAddr;
                            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

                            //경,위도 api 호출함수 호출
                            getCoordinate(data.jibunAddress);
                        }
                    }).open();
                }
            ) //우편번호 찾기 끝
			
            
            
            //해시태그 추가
            $('#hashTagAppendBtn').click(function(){   	
            	$('#hashTag').clone().insertBefore('#hashTagAppendBtn');
            })
            
            //해시태그 삭제
            $('#hashTagRemoveBtn').click(function(){
            	if($('select[name=hashTag]').length == 1){
            		return;
            	}
            	$(this).prev().prev().remove();
            })
            
            
            //메뉴 추가
            $('#menuAppendBtn').click(function(){
                $(this).before(
                    `<div class="row mt-3 menu-box">
                        <div class="col">
                            <input type="text" class="form-control" name="menuName">
                        </div>
                        <div class="col">   
                            <input type="text" class="form-control" name="menuPrice">
                        </div>
                    </div>`
                );
            })
            //메뉴 삭제
            $('#menuRemoveBtn').click(function(){
                if($('.menu-box').length == 1){
                    return;
                }
                $(this).prev().prev().remove();
            })

          //빈칸없는지 검증
            function sumbitCheck(){
            	console.log("123")
            	if($('#restaurant-name').val() == ""){
            		alert("맛집 이름을 입력해주세요.");
            		$('#restaurant-name').focus();
            		return false;
            	}
            	if($('#first-category').val() == "0"){
            		alert("카테고리를 선택해주세요.");
            		$('#first-category').focus();
            		return false;
            	}
            	if($('#second-category').val() == "0"){
            		alert("상세카테고리를 선택해주세요.");
            		$('#second-category').focus();
            		return false;
            	}
            	if($('#level').val() == "" || parseInt($('#level').val()) < 1 || parseInt($('#level').val()) > 7){
            		alert("올바른 레벨값을 입력해주세요");
            		$('#level').focus();
            		return false;
            	}
            	if($('#sample4_roadAddress').val() == ""){
            		alert("도로명 주소를 입력해주세요");
            		$('#sample4_roadAddress').focus();
            		return false;
            	}
            	if($('#sample4_jibunAddress').val() == ""){
            		alert("주소를 입력해주세요");
            		$('#sample4_jibunAddress').focus();
            		return false;
            	}
            	if($('#longitude').val() == ""){
            		alert("경도를 입력해주세요");
            		$('#longitude').focus();
            		return false;
            	}
            	if($('#latitude').val() == ""){
            		alert("위도를 입력해주세요");
            		$('#latitude').focus();
            		return false;
            	}   
            	
            	return true;
            	
            }
            
            $("#restaurantUpdate").submit(function(){
            	//빈칸 없는지 검증
            	if(!sumbitCheck()){
	            	return false;           		
            	}
            	
            	let firstCategory = $("#first-category").val();
            	let secondCategory = $("#second-category").val();
            	let restaurantName = $("#restaurant-name").val();
            	
            	document.restaurantUpdate.action  = "${path}/front?key=adminRestaurant&methodName=update&firstCategory="+firstCategory+"&secondCategory="+secondCategory+"&restaurantName="+restaurantName;
            })
            
        })//ready
    </script>
</head>

<body>
    <jsp:include page="../common/adminHeader.jsp"/>

    <!-- form -->
    <div class="container p-5" id="form-container">
        <form class="shadow-lg p-5" id="restaurantUpdate"  name="restaurantUpdate" method="post" enctype="multipart/form-data">
            <h2>맛집 상세정보 / 수정</h2>
            <input type="hidden" name="restaurantNo" value="${restaurantDTO.restaurantNo}">
            <div class="mb-3 mt-4">
                <label class="form-label">맛집 이름</label>
                <input type="text" class="form-control" name="restaurantName" id="restaurant-name" value="${restaurantDTO.restaurantName}">
            </div>
            <div class="mb-3">
                <label class="form-label">카테고리</label>
                <div class="row">
                    <div class="col">
                        <select class="form-select" id="first-category" name="firstCategory">
                            <option selected value="0">-카테고리선택-</option>
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
                    </div>
                    <div class="col">
                        <select class="form-select" id="second-category" name="secondCategory">
                            <option selected value="0">-상세카테고리선택-</option>
                        </select>
                    </div>

                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">레벨</label>
                <input type="number" class="form-control" min="1" max="7" value="${restaurantDTO.restaurantLevel}" name="level" id="level">
            </div>
            <div class="mb-3">
                <label class="form-label">전화번호</label>
                <input type="text" class="form-control" placeholder="000-0000-0000" name="phone" id="phone" value="${restaurantDTO.restaurantPhone}"> 
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">주소</label>
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="sample4_postcode" placeholder="우편번호" name="zipCode">
                    </div>
                    <div class="col">
                        <input type="button" id="find-addr" class="btn btn-primary" value="우편번호 찾기">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <input type="text" class="form-control" id="sample4_roadAddress" placeholder="도로명주소" name="roadAddress" value="${restaurantDTO.restaurantRoadAddr}">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="sample4_jibunAddress" placeholder="지번주소" name="jibunAddress" value="${restaurantDTO.restaurantAddr}">
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">경도</label>
                <input type="text" class="form-control" id="longitude" name="longitude" value="${restaurantDTO.restaurantLongitude}">
            </div>
            <div class="mb-3">
                <label class="form-label">위도</label>
                <input type="text" class="form-control" id="latitude" name="latitude" value="${restaurantDTO.restaurantLatitude}">
            </div>
            <div class="mb-3">
                <label class="form-label">맛집 사진 업로드</label>
                <input class="form-control" type="file" multiple name="photos">
            </div>
            <div class="mb-3">
                <label class="form-label">#해시태그</label>

               	<c:choose>
               		<c:when test="${empty restaurantDTO.hashTagName}">
                		<select class="form-select mb-3" id="hashTag" name="hashTag">
		                    <option selected value="0">-해시태그 선택-</option>
                			<c:forEach items="${hashTagList}" var="hashTag">
                				<option value="${hashTag}">${hashTag}</option>
                			</c:forEach>		                            
		                </select>
               		</c:when>
               		<c:otherwise>
               			<c:forEach items="${restaurantDTO.hashTagName}" var="restaurantTag">
               				<select class="form-select mb-3" id="hashTag" name="hashTag">
			                    <option selected value="0">-해시태그 선택-</option>
	                			<c:forEach items="${hashTagList}" var="hashTag">
	                				<option value="${hashTag}" <c:if test="${restaurantTag == hashTag}">selected</c:if> >${hashTag}</option> <!-- 추가할때마다 selected 되어있음 -->
	                			</c:forEach>		                            
		                	</select>
               			</c:forEach>
               		</c:otherwise>
               	</c:choose>
               

                <button type="button" class="btn btn-sm btn-primary" id="hashTagAppendBtn">추가</button>
                <button type="button" class="btn btn-sm btn-danger" id="hashTagRemoveBtn">빼기</button>
            </div>
            <div class="mb-3" >
                <label class="form-label">메뉴 추가</label>
                <c:choose>
                	<c:when test="${empty restaurantDTO.menuList}">
		                <div class="row menu-box">
		                    <div class="col">
		                        <div class="form-text">메뉴이름</div>
		                        <input type="text" class="form-control" name="menuName">
		                    </div>
		                    <div class="col">
		                        <div class="form-text">가격</div>
		                        <input type="text" class="form-control" name="menuPrice">
		                    </div>
		                </div> 		
                	</c:when>
                	<c:otherwise>
                		<c:forEach items="${restaurantDTO.menuList}" var="menuDTO">
                			<div class="row menu-box">
			                    <div class="col">
			                        <div class="form-text">메뉴이름</div>
			                        <input type="text" class="form-control" name="menuName" value="${menuDTO.menuName}">
			                    </div>
			                    <div class="col">
			                        <div class="form-text">가격</div>
			                        <input type="text" class="form-control" name="menuPrice" value="${menuDTO.menuPrice}">
			                    </div>
		                	</div>
                		</c:forEach>
                	</c:otherwise>
                	
                </c:choose>
                <button type="button" class="btn btn-sm btn-primary mt-3" id="menuAppendBtn">추가</button>
                <button type="button" class="btn btn-sm btn-danger mt-3" id="menuRemoveBtn">빼기</button>
            </div>
            <div class="bottom-btn">
                <button type="submit" class="btn btn-primary">수정</button>
                <button type="button" class="btn btn-secondary" onclick="history.back()">취소</button>
            </div>
        </form>

    </div>
 

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    <!-- 우편번호 api-->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</body>

</html>