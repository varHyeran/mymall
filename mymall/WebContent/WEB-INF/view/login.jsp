<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 폼</h1>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="loginPw"></td>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<a href = "${pageContext.request.contextPath}/addMember">회원가입</a> 
	
</body>
</html>