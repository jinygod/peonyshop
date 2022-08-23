<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<table align = center>
		<tr>
			<th>사진</th>
			<th>상품명</th>
			<th>상품수량</th>
			<th>상품가격</th>
			<th>총 가격</th>
		</tr>
		<c:forEach var='obj' items="${basketList }">
		<tr>
			<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
			<td>${obj.goods_name }</td>
			<td>${obj.order_cnt }</td>
			<td>${obj.goods_sell_price }</td>
			<td>${obj.order_amt }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>