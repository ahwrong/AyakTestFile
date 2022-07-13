<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mypage" method="post">
	<h3>My Page</h3>
	<a href='<c:url value="/membership/logout" />'>로그아웃</a><br>
	<label>Last Access Time : </label> ${lastAccessTime}
</form>
</body>
</html>