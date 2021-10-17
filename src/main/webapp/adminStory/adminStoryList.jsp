<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>관리자 쪽 스토리 목록</title>

    <!-- 부트스트랩 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
<style type="text/css">
	#buttons{align-content: center}
	a{text-decoration:none;color:gray;}
</style>
    
    
  </head>
  <body>
 <br>
<div><h2><b style="font-style:italic; margin:30px;">스토리 목록</b>
        <a href="#" style="float:right;margin-right:200px;text-decoration:none;color:gray;font-style:italic;">메인으로</a>
        </h2>
<hr>
<form>
<div class="table-responsive">
        <table class="table table-hover">
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
          <tbody>
            <tr>
              <td>1</td>
              <td>2</td>
              <td><a href="">문득 일본라멘이 땡겨서</a></td>
              <td>2021-10-14</td>
              <td>13</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>2</td>
              <td>3</td>
              <td><a href="">나 혼자 산다 - 고기구워먹기</a></td>
              <td>2021-10-14</td>
              <td>13</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>3</td>
              <td>1</td>
              <td><a href="">비싸지 않고 분위기 좋은 혼밥식당</a></td>
              <td>2021-10-14</td>
              <td>1</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>4</td>
              <td>4</td>
              <td><a href="">치킨집의 혁명</a></td>
              <td>2021-10-14</td>
              <td>15</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>5</td>
              <td>5</td>
              <td><a href="">오늘도 혼자서 냉면을 먹는다</a></td>
              <td>2021-10-14</td>
              <td>100</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>6</td>
              <td>7</td>
              <td><a href="">냉면로드</a></td>
              <td>2021-10-14</td>
              <td>90</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
            <tr>
              <td>7</td>
              <td>6</td>
              <td><a href="">누들로드</a></td>
              <td>2021-10-14</td>
              <td>5</td>
              <td><input type="button" id="delete" value="삭제"></td>
            </tr>
           
          </tbody>
        </table>
      </div>
      
      <div id="buttons" style="float:right; margin-right:100px">
         <input type="text" value="" id="search">
         <input type="button" value="검색">
         
      </div>
      
      
   </form>







    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
    