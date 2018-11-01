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
	<!-- 주문하기 item pk, session member pk -->
	<form>
		<table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Order</th>
			</tr>
				<c:forEach var="list" items="${itemList}">
					<tr>
						<td>${list.no}</td>
						<td>${list.name}</td>	
						<td>${list.price}</td>
						<td><a href="${pageContext.request.contextPath}/order">주문</a></td>
					</tr>
				</c:forEach>
		</table>
	</form>
</body>
</html>