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
		let index = 1;
		
		$("[value=추가]").click(function() {
			let f = "<hr style='color: red; height: 5px;'><input type='file' name='file"+ index++ +"'><input type='button' value='삭제'><input type='text' name='restaurantTitle"+ index++ +"' class='form-control mt-4 mb-2'	placeholder='맛집 이름을 입력해주세요.' required><textarea class='form-control' rows='5' name='photoContent"+ index++ +"' placeholder='사진에 대한 설명을 입력해주세요.''></textarea><p><p>";
						
			$("#photoAdd").append(f);
		});
		
		$(document).on("click","[value=삭제]" ,function() {
			$(this).prev().prev().remove();
			$(this).prev().remove();
			$(this).next().next().remove(); 
			$(this).next().remove();  
			$(this).remove();
		});
	});
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<main>
		<form action="writerAction" method="post">
			<input type="hidden" name="bdGroup"> <input type="hidden"
				name="bdOrder"> <input type="hidden" name="bdIndent">
			<input type="file" name="file"> 대표 이미지를 선택해주세요. <input
				type="text" name="bd	Title" class="form-control mt-4 mb-2"
				placeholder="제목을 입력해주세요." required>
			<p><br><hr style="height: 5px;"><p><br>
			
			<div class="form-group">
				<div id="photoAdd">
				<input type="file" name="file0"><input type="button" value="삭제">
				<input type="text" name="restaurantTitle0" class="form-control mt-4 mb-2"
				placeholder="맛집 이름을 입력해주세요." required>
					<textarea class="form-control" rows="5" name="photoContent0"
						placeholder="사진에 대한 설명을 입력해주세요."></textarea>
					<p>
					<p>
				</div>
				<input type="button" value="추가">
				<textarea class="form-control" rows="10" name="bdContent"
					placeholder="내용을 입력해주세요."></textarea>
			</div>
			<button type="submit" class="btn btn-secondary mb-3">업로드</button>
		</form>
	</main>
	<hr>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>