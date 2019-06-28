<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="../css/ecsite.css">
<!-- スクロールアップ -->
<script src="smooth-scroll.min.js"></script>
<script>
var scroll = new SmoothScroll('a[href*="#"]');
$(function() {
	  var pagetop = $('.pagetop');
	  $(window).scroll(function () {
	  if ($(this).scrollTop() > 200) {
	    pagetop.fadeIn();
	  } else {
	    pagetop.fadeOut();
	  }
	  });
	  pagetop.click(function () {
	    $('body, html').animate({ scrollTop: 0 }, 900);
	    return false;
	  });
	});
</script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<div class="cartTable">
	<h2>購入が完了しました、お買い上げありがとうございました！</h2>
	<hr>
<br>
	<p>購入した商品はこちらの通りです</p>

	<table
		style="width: 65%; text-align:center;">
		<tr style="background-color:#d9d9d9;">
			<td></td>
			<td>商品情報</td>
			<td>数量</td>
			<td>小計</td>
		</tr>
		<c:set var="totalPrice" value="${0}"></c:set>
		<c:set var="smallPrice" value="${0}"></c:set>
		<c:forEach var="item" items="${cart}">
			<tr>
				<td style="width:250px;"><img src="image/${item.product.id}.jpg" height="150" width="100%"></td>
				<td>${item.product.name}<br>￥${item.product.price}/個</td>
				<td><p>${item.count}</p> </td>
				<c:set var="smallPrice" value="${item.product.price * item.count}"></c:set>
				<td class="twidth"><p>￥${smallPrice}</p></td>
			</tr>
			<c:set var="totalPrice" value="${totalPrice + (item.product.price * item.count)}"></c:set>
		</c:forEach>
	</table>
	<p>合計金額：${totalPrice}円</p>
	<form action="Return.action" method="POST">
		<input type="submit" value="TOPへ" class="button searchBtn">
	</form>
	</div>
	<p class="pagetop"><a data-scroll href="#">▲</a>	</p>
</body>
</html>