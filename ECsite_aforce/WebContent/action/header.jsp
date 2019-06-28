<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet"type="text/css" href="../css/ecsite.css">
	<!-- animate -->
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	<title>Insert title here</title>
</head>
<body>
	<header>
		<h1 class="animated slideInDown">SWEETS</h1>

		<form method="POST" action="GoLogin.action" class="header-buttons">
			<input type="submit" value="ログイン" onclick="goLoginAction();"
				class="button h-button" id="login" />
		</form>

		<form method="POST" action="Logout.action" class="header-buttons">
			<input type="submit" value="ログアウト" onclick="LogoutAction();"
				class="button h-button" id="logout" />
		</form>

		<form method="POST" action="ProductList.action" class="header-buttons">
			<input type="submit" value="商品一覧" onclick="goProductListAction();"
				class="button h-button" id="product" />
		</form>

		<form method="POST" action="CartAdd.action" class="header-buttons">
			<input type="submit" value="カート" onclick="goCartAction();"
				class="button h-button" id="cart" />
		</form>
	</header>
</body>
</html>