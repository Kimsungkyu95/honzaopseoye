<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>adminMemberList</title>
    
    <style>
    	h1{text-align:center;}
    	.table{text-align:center}
    	
    </style>
  </head>
  <body>
  <jsp:include page="common/header.jsp"/>

    <h1>님 회원관리</h1>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>


	<div class="h-100 p-5 bg-light border rounded-3">
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col"></th>

		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">회원번호</th>
		      <td>memberNo</td>
		    </tr>
		    <tr>
		      <th scope="row">아이디</th>
		      <td colspan="2"><input type="text" name="id" value=memberName /></td>
		    </tr>
		    <tr>
		      <th scope="row">비밀번호</th>
		      <td colspan="2"><input type="text" name="id" value=memberPwd /></td>
		    </tr>
		    <tr>
		      <th scope="row">이름</th>
		      <td colspan="2"><input type="text" name="id" value=memberName /></td>
		    </tr>
		    <tr>
		      <th scope="row">이메일</th>
		      <td colspan="2"><input type="text" name="id" value=memberEmail /></td>
		    </tr>
		    <tr>
		      <th scope="row">전화번호</th>
		      <td colspan="2"><input type="text" name="id" value=memberPhone /></td>
		    </tr>
		    <tr>
		      <th scope="row">생년월일</th>
		      <td colspan="2"><input type="text" name="id" value=memberBirth /></td>
		    </tr>
		    <tr>
		      <th scope="row">가입일</th>
		      <td colspan="2">memberJoinDate</td>
		    </tr>
		    <tr>
		      <th scope="row">경험치</th>
		      <td colspan="2"><input type="text" name="id" value=memberExp /></td>
		    </tr>
		    <tr>
		      <th scope="row">프로필이미지</th>
		      <td colspan="2">profileImage</td>
		    </tr>
		  </tbody>
		</table>
		
		<button type="submit" class="btn btn-secondary btn-lg">수정하기</button>
		<button type="reset" class="btn btn-secondary btn-lg">취소</button>
		<button type="button" onclick="location.href='adminMemberList.jsp'" class="btn btn-secondary btn-lg">회원관리리스트</button>
		
	</div>

	<footer class="pt-3 mt-4 text-muted border-top">
	</footer>
	 </div>
	</main>
	<hr>
	<jsp:include page="common/footer.jsp"/>
</body>
</html>