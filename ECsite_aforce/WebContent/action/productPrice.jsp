<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/ecsite.css">

<!-- スクロールで商品の要素を上移動＆フェードイン -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="jquery.inview.min.js"></script>
<script>
	$(function() {
		$('.list').on('inview',
				function(event, isInView, visiblePartX, visiblePartY) {
					if (isInView) {
						$(this).stop().addClass('mv07');
					} else {
						$(this).stop().removeClass('mv07');
					}
				});
	});
</script>

<!-- スクロールアップ -->
<script src="smooth-scroll.min.js"></script>
<script>
	var scroll = new SmoothScroll('a[href*="#"]');
	$(function() {
		var pagetop = $('.pagetop');
		$(window).scroll(function() {
			if ($(this).scrollTop() > 200) {
				pagetop.fadeIn();
			} else {
				pagetop.fadeOut();
			}
		});
		pagetop.click(function() {
			$('body, html').animate({
				scrollTop : 0
			}, 900);
			return false;
		});
	});
</script>
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="search">

		<p>商品名検索</p>
		<form action="ProductList.action" method="post">
			<input type="text" placeholder="検索ワード" name="keyword" class="place">
			<input type="submit" value="検索" class="searchBtn">
		</form>
		<br>

		<p>価格帯検索</p>
		<form action="ProductListPrice.action" method="POST">
			<select name="priceRange">
				<option value="300">300円～</option>
				<option value="600">600円～</option>
				<option value="900">900円～</option>
			</select> <input type="submit" value="検索" class="searchBtn" />
		</form>
		<br>
		<br>
	</div>

	<hr>

	<table
		style="border-spacing: 10px; display: table; width: 100%; border-collapse: separate; text-align: center;">

		<c:forEach var="product2" items="${list2}">
			<tr style="display: inline-block; width: 30%; text-align: center;"
				class="list table">
				<td><img src="image/${product2.id}.jpg" height="250" width="90%"></td>
				<td>${product2.name}</td>
				<td>￥${product2.price}/個</td>

				<td>
				<p>購入個数：</p>
					<form action="CartAdd.action?id=${product.id}" method="POST">
						<select name="quantity" class="select">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select> <input type="submit" value="カートに追加" class="button searchBtn">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>

	<p class="pagetop">
		<a data-scroll href="#">▲</a>
	</p>
</body>

</html>
