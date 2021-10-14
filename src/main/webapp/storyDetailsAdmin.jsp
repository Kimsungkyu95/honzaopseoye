<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>관리자용 스토리상세 검색</title>

    <!-- 부트스트랩 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
tr td{border: 6px white solid; color:#878984}
span{font-size:15;text-align:center;}
    
    
</style>
    
  </head>
  <body>
  
  <p>
  
  <table align="center" cellpadding="5" cellspacing="2" width="900" style="background-color:#EFEBFF">
    <tr>
        <td height="20" colspan="4" bgcolor="#EFEBFF">
            <p><font color="#878984"><b>
             제목</b></font></p>
        </td>
    </tr>
    <tr>
        <td  width="100" height="20" >
            <p><b><span>글번호</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span><b>${elec.modelNum}</b></span>
        </td>
    </tr>
    <tr>
        <td  width="100" height="20" >
            <p><b><span>등록일</span></b></p>
        </td>
        <td width="300" height="20">
        	<span><b>${requestScope.elec.writeday}</b></span>
        </td>
        <td width="100" height="20" >
			<p><b><span>조회수</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span></span>${requestScope.elec.readnum}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p><b><span>작성자</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span><b>${requestScope.elec.modelName}</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p><b><span>내용</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span><b><pre>${requestScope.elec.description}</pre></b></span></td>
    </tr>
    
    <tr>
    <td width="100" height="20">
           <p><b><span>비밀번호</span></b></p>
        </td>
        
    <form name="requestForm" method="post" action="${path}/front">
        <td height="20" colspan="3" align="left" valign="middle">
				<input type=password name="password" value="">		
		</td>
    </tr>
    
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<!-- 핵심 -->
				<input type="hidden" name="modelNum" value="${elec.modelNum}">
				<input type="hidden" name="key" value="elec">
				<input type="hidden" name="methodName">
				
				<input type=button value="돌아가기" onClick="sendBack()">
				<input type=button value="삭제하기" onClick="sendDelete()">
    </form>
			
		</td>
    </tr>
</table>
  
  










    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
     <jsp:include page="common/footer.jsp"/>