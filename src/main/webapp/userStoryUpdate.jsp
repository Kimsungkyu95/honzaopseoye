<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>userStoryCreate</title>

<style type="text/css">
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<main>
		<form action="writerAction" method="post">
			<input type="hidden" name="bdGroup"> <input type="hidden"
				name="bdOrder"> <input type="hidden" name="bdIndent">
			<input type="file" name="file"> 대표 이미지를 선택해주세요. <input
				type="text" name="bdTitle" class="form-control mt-4 mb-2"
				placeholder="제목을 입력해주세요." required>
			<p>
			<form class="">
				<div class="form-group">
					<input type="file" name="file">
					<textarea class="form-control" rows="5" name="bdContent"
						placeholder="사진에 대한 설명을 입력해주세요."></textarea>
					<p><p>
						<button class="btn btn-secondary mb-3">+</button>
						<button class="btn btn-secondary mb-3">ㅡ</button>
			</form>
			<textarea class="form-control" rows="10" name="bdContent"
				placeholder="내용을 입력해주세요." required></textarea>
			</div>
			<button type="submit" class="btn btn-secondary mb-3">수정</button>
		</form>
	</main>
	<hr>
	<jsp:include page="common/footer.jsp" />
</body>
</html>