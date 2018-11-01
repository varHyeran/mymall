<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
		<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:if>
	<c:if test="${loginMember != null}">
		${loginMember.level}권한 로그인<br>
		${loginMember.id}님 반갑습니다.
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a><br>
		<a href="${pageContext.request.contextPath}/itemList">상품리스트</a>
	</c:if>
</body>
</html>