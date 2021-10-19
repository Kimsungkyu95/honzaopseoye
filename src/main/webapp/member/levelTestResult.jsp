<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{color: black;}

</style>
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<script type="text/javascript" >

</script>
</head>
<body>
 <jsp:include page="../common/header.jsp"/>
<div style="height: 312px"></div>

 <div class="container col-xxl-8 px-4 py-5">
  <div class="px-4 py-5 my-5 text-center rounded-3 border shadow-lg">
    <h1 class="display-5 fw-bold">혼자옵서예 가입완료!</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4 "><span class="fst-italic">${name}</span>님의 혼밥 레벨: ${level }</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
      </div>
    </div>
  </div>
 </div>

<div style="height: 312px"></div>
 <jsp:include page="../common/footer.jsp"/>
</body>
</html>