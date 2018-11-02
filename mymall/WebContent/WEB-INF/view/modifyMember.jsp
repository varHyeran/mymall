<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>modifyMember</h1>
	<form action="${pageContext.request.contextPath}/modifyMember" method="post">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input type="text" name="modifyId" readonly>${member.id}</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="modifyPw">${member.pw}</td>
			</tr>
			<tr>
				<th>LEVEL</th>
				<td><input type="text" name="modifyLevel" readonly>${member.level}</td>
			</tr>
		</table>
			<input type="submit" value="수정">
	</form>
</body>
</html>