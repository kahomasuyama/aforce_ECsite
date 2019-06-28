<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"type="text/css" href="../css/ecsite.css">
	<link rel="stylesheet"type="text/css" href="../css/popup.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="loginError">
		<p>ログインIDまたはパスワードが違います</p>
		<br>
		<a href = "login-in.jsp">ログインへ戻る</a>
	</div>
</body>
</html>