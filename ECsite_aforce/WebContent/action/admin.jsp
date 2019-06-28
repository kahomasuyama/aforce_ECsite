<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/ecsite.css">
	<title>管理者画面</title>
	<script>
		function checkSubmit() {
			return confirm("商品を追加します、よろしいですか？？");
		}
	</script>

</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="search">
	<p>追加する商品を入力してください</p>
	<form action="Admin.action" method="POST" onSubmit="return checkSubmit()">

		商品名<input type="text" name="newProductName" class="place"><pre style="display:inline-block">  </pre>
		価格<input type="text" name="newPrice" class="place"><pre style="display:inline-block">  </pre>
		価格帯設定 <select name="newPriceRange">
			<option value="300">300円～</option>
			<option value="600">600円～</option>
			<option value="900">900円～</option>
		</select>
		<input type="submit" value="追加" class="button searchBtn">
	</form>
	</div>

	<!-- TODO 写真の設定変更・削除-->
	<form action="AdminRemove.action" method="POST">
	<div class="cartTable">
		<table style="width: 80%; text-align:center;">
			<c:forEach var="product" items="${list}">

				<tr>

					<td>商品${product.id}</td>
					<td style="width:180px;"><img src="image/${product.id}.jpg" height="170" width="100%"></td>
					<td class="tName">${product.name}</td>
					<td class="twidth">￥${product.price}</td>
					<td class="twidth"><input type="submit" value="商品削除" class="button searchBtn"></td>

				</tr>

			</c:forEach>
		</table>
		</div>
	</form>
</body>
</html>