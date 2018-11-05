<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Item List</h1>
	<a href="${pageContext.request.contextPath}/index">메인으로</a>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Order</th>
			</tr>
			<c:forEach var="itemList" items="${itemList}">
			<tr>
				<td>${itemList.no}</td>
				<td>${itemList.name}</td>	
				<td>${itemList.price}</td>
				<td><a href="${pageContext.request.contextPath}/OrderController?itemNo=${itemList.no}">주문</a></td>
			</tr>
			</c:forEach>
		</table>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/itemList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/itemList?currentPage=${currentPage+1}">다음</a>
		</c:if>
</body>
</html>