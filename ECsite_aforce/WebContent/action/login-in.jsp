<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="../css/ecsite.css">
<title>ログイン画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="login">
		<h2 class="loginTitle">Login to SWEETS!!</h2>
		<div class="loginput">
			<form method="POST" action="Login.action">
				<p>
					ログインID：<input type="text" name="login" class="logininput">
				</p>
				<p>
					パスワード：<input type="password" name="password" class="logininput">
				</p>
				<br><br>
				 <input type="submit" value="ログイン" class="button"
					id="loginBtn"><br>
			</form>
			<br><br>
			<a href="top.jsp">TOPに戻る</a> <br>
			<br>
		</div>
	</div>
</body>
</html>