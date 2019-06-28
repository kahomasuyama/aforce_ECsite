<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="../js//jquery.bxslider.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" /></script>
	<script src="jquery.bxslider.js"></script>
	<script>
		$(document).ready(function() {
			$('.slider').bxSlider({
				mode:'horizontal'
			});
		});
	</script>
<title>Top</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="slider">
		<img src="image/top2.jpg">
		<img src="image/top1.jpg">
		<img src="image/top3.jpg">
		<img src="image/top4.jpg">
		<img src="image/top5.jpg">
		<img src="image/top6.jpg">
	</div>

</body>
</html>