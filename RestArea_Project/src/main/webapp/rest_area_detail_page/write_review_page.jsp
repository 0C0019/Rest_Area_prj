<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="휴게소 리뷰 작성 페이지"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="icon" href="http://192.168.10.219/jsp_prj/common/favicon/favicon.ico"/>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<style type="text/css">
	#reviewTextarea{
		position: relative;
		margin-bottom: 
	}
	</style>
	<!--jQuery CDN 시작-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js">
	</script>
	<script type="text/javascript">
		$(function () {
			
		});
	</script>
</head>
<body>
	<!-- 리뷰 작성 모달 -->
<div id="reviewModal" class="modal-dialog">
  <div class="modal-content">
    <span class="close" onclick="closeReviewModal()"></span>
    <h2><strong>리뷰 작성</strong></h2>
    <span><h3>별점</h3></span><br/>
    <p>리뷰를 입력해주세요</p>
    <textarea id="reviewTextarea" rows="10" cols="50"></textarea>
    <button class="btn btn-primary" onclick="submitReview()">제출</button>
  </div>
</div>
</body>
</html>