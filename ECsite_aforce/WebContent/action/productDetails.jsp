<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="../css/ecsite.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div>
		<img src="image/${product.id}.jpg" height="250" width="90%">
		${product.name}
		${product.price}円
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
	</div>
</body>
</html>