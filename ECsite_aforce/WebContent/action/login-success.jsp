<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p>ようこそ${customer.login}さん、ログインできました！</p>
	</div>
</body>
</html>