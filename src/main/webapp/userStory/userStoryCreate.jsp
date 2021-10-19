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
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#storyForm").submit(function(){
			let storyTitle = $('[name=storyTitle]').val();
			document.getElementById('storyForm').action = '../front?key=userStory&methodName=insert&storyTitle=' + storyTitle;
		})
	});
</script>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<main>
		<form action="#" method="post" id="storyForm">
			<input type="text" name="storyTitle" class="form-control mt-4 mb-2"
				placeholder="제목을 입력해주세요." required>
			<p><br><hr style="height: 5px; color: red;"><p><br>
			
			<div class="form-group">
				<div id="photoAdd" class="shadow-lg">
				<input type="file" name="storyPhoto" multiple>
				<input type="text" name="restaurantName" class="form-control mt-4 mb-2"
				placeholder="맛집 이름을 입력해주세요." required>
				<textarea class="form-control" rows="10" name="storyContent"
					placeholder="내용을 입력해주세요." required></textarea>
				</div>
			</div>
			<input type=password name="password"
				placeholder="비밀번호를 입력해주세요." required>
			<button type="submit" class="btn btn-secondary mb-3">업로드</button>
		</form>
	</main>
	<hr>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>