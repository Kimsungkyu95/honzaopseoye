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
    </script>
</head>

<body>
    <jsp:include page="../common/adminHeader.jsp"/>

    <!-- form -->
    <div class="container p-5" id="form-container">
        <form class="shadow-lg p-5" id="restaurantInsert"  name="restaurantInsert" method="post" enctype="multipart/form-data">
            <h3>리뷰 쓰기</h3>
			<div class="mb-3 mt-3">
			  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<div class="bottom-btn">
	 			<button type="submit" class="btn btn-primary">등록</button>
    	        <button type="button" class="btn btn-secondary">취소</button>
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