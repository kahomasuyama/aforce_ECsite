<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<script>
	function checkSubmit() {
		return confirm("注文を確定します、よろしいですか？？");
	}
	function checkDelete(){
		return confirm("カートから選択した商品を削除します、よろしいですか？？");
	}
	</script>
</head>
<body>
	<jsp:include page="header.jsp" />

<c:choose>
	<c:when test="${cart.size()>0}">
		<form action = "OrderComplete.action" method="POST" onSubmit="return checkSubmit()">
			<div class="cartTable">
			<p class="cartTytle">ショッピングカート</p>
			<table>
				<tr style="background-color:#d9d9d9;">
					<td></td>
					<td>商品情報</td>
					<td>数量</td>
					<td>小計</td>
					<td>削除</td>
				</tr>
				<c:set var="totalPrice" value="${0}"></c:set>
				<c:set var="smallPrice" value="${0}"></c:set>
				<c:forEach var="item" items="${cart}">
					<tr>
						<td style="width:250px;"><img src="image/${item.product.id}.jpg" height="150" width="100%"></td>
						<td class="tName">${item.product.name}<br>￥${item.product.price}/個</td>
						<td class="tCount"><p>${item.count}</p></td>
						<c:set var="smallPrice" value="${item.product.price * item.count}"></c:set>
						<td class="twidth"><p>￥${smallPrice}</p></td>
						<td class="twidth"><a href="CartRemove.action?id=${item.product.id}" onClick="return checkDelete();return false">カートから削除</a></td>
					</tr>
					<c:set var="totalPrice" value="${totalPrice + (item.product.price * item.count)}"></c:set>
				</c:forEach>
			</table>
			<br><br>
			<p>合計金額：￥${totalPrice}</p>

			<input type="submit" value="注文確定" class="button searchBtn" name="btn"/>
			</div>
		</form>
			<div class="cartContinue">
				<form action="ProductList.action" method="POST">
					<input type="submit" value="買い物を続ける" class="button searchBtn" />
				</form>
			</div>

		</c:when>
	<c:otherwise>
	<div class="logout">
		<p>カートに商品がありません。</p>
	</div>
	</c:otherwise>
</c:choose>

<p class="pagetop"><a data-scroll href="#">▲</a>	</p>

</body>
</html>