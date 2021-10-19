<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- jqGrid -->

    <link rel="stylesheet" href="../jqGrid/css/jquery-ui.css">
    <link rel="stylesheet" href="../jqGrid/css/ui.jqgrid.css">

    <script src="../jqGrid/js/jquery-1.7.2.min.js"></script>
    <script src="../jqGrid/js/i18n/grid.locale-kr.js"></script>
    <script src="../jqGrid/js/jquery.jqGrid.min.js"></script>
    <script src="../jqGrid/js/grid.common.js"></script>
    <script src="../jqGrid/js/grid.formedit.js"></script>
    <script src="../jqGrid/js/jqDnR.js"></script>
    <script src="../jqGrid/js/jqModal.js"></script>

    <title>Hello, world!</title>
    <style>
        #grid-container {
            display: flex;
            justify-content: center;
        }

        form {
            display: flex;
            justify-content: center;
        }
        th, td {
            text-align: center;
            vertical-align: middle;
        }

    </style>
    <script>
    
        $(function(){
        	function selectAll(){
        		$.ajax({
     				url: "${pageContext.request.contextPath}/adminRestaurantList", //서버요청주소
     				type: "post", //method방식(get, post, put, delete)
     				dataType: "json", //서버가 응답해주는 데이터의 type(text, html, xml, json)
     				//data: //서버에게 보낼 parameter정보
     				success: function(result){
     					console.log(result);
     					$('#jqGrid').jqGrid({
     		                width: 1200,
     		                datatype: "local",
     		                data: result,
     		                colNames:['맛집번호','맛집이름', '전화번호', '주소', '대카테고리', '소카테고리', '등록일', '조회수'],
     		                colModel:[
     		                    {name:'restaurantNo', width:60}, //name은 서버로부터 넘어오는 데이터 명이다.
     		                    {name:'restaurantName', width:90},
     		                    {name:'phone', width:100},
     		                    {name:'restaurantAddr', width:80},
     		                    {name:'category', width:150, align:"right"},
     		                    {name:'categoryDetails', width:80, align:"right"},
     		                    {name:'regDate', width:80, align:"right"},
     		                    {name:'visited', width:80, align:"right"}
     		                ],
     		                rowNum: 5,
     		                pager: '#jqGridPager',
     		                caption: "맛집 목록 테이블",
     		                jsonReader : {
     		                	repeatitems : false,
     		                }
     		            }) //jqGrid끝 
     		            $('#jqGrid').jqGrid('navGrid', '#jqGridPager',{
     		            	edit : true,
     		            	add : true,
     		            	del : true,
     		            	search : true
     		            })
     					
     				}, //성공했을 때 callback함수
     				error: function(err){
     					alert(err + "발생했어요.");
     				} //실패했을 때 callback함수
     			}); //ajax 끝
        	}
        	
        	$('#printjqGrid').click(selectAll);
	        
        	//행선택시
        	$('#selectRow').click(function(){
        		var selRowId = $('#jqGrid').jqGrid('getGridParam', 'selrow');
        		var selRowData = $('#jqGrid').jqGrid('getRowData', selRowId);
        		console.log(selRowId);
        		console.log(selRowData);
        	})
        })
        
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
        <form class="row g-3 rounded p-2">
            <div class="col-auto">  
                <select class="form-select col-auto" aria-label="Default select example">
                    <option selected>검색옵션</option>
                    <option value="restaurantName">맛집이름</option>
                    <option value="categoryDetailsName">카테고리명</option>
                    <option value="restaurantAddr">주소</option>
                </select>
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">Password</label>
                <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">검색</button>
            </div>
        </form>
    </div>

    <div class="container mt-5 p-5" id="grid-container">
        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>
    
    <button id="printjqGrid">jqGrid 출력</button>
	<button id="selectRow">행 선택</button>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>

</html>