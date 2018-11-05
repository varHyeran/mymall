<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>orderList</h1>
	<!-- 주문하기 item pk, session member pk -->
		<a href="${pageContext.request.contextPath}/index">메인으로</a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>orderDate</th>
				<th>itemNo</th>
				<th>itemName</th>
				<th>itemPrice</th>
			</tr>
			<c:forEach var="memberItemList" items="${memberItemList}">
			<tr>
				<td>${memberItemList.memberItemNo}</td>
				<td>${memberItemList.orderDate}</td>
				<td>${memberItemList.itemNo}</td>
				<td>${memberItemList.itemName}</td>
				<td>${memberItemList.itemPrice}</td>
			</tr>
			</c:forEach>
		</table>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/orderList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/orderList?currentPage=${currentPage+1}">다음</a>
		</c:if>
</body>
</html>