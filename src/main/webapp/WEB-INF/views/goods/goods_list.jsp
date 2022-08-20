<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	table {
	border-collapse: collapse;
	}
	
	th {
	background-color: lightgray;
	}
	th,td {
		border :1px solid #000;
		align : center;
	}
</style>

<title>Insert title here</title>
</head>
<body align = center>
	<h1>상품리스트_관리자용</h1>
	<a href='${root }goods/goods_reg'>상품 등록</a>
	<a href= '${root}admin/main'>관리자홈</a>
	<table align = center>
		<tr>
			<th>썸네일</th>
			<th>상품 번호</th>
			<th>카테고리</th>
			<th>상품명</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var='obj' items="${adminGoodsList }">
		<tr>
			<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
			<td>${obj.goods_idx }</td>
			<td>${obj.goods_category }</td>
			<td><a href = "${root }goods/goods_detail?goods_idx=${obj.goods_idx }&topmenu_name=${obj.goods_category}">${obj.goods_name }</a></td>
			<td>${obj.goods_sell_price }</td>
			<td><a href= '${root }goods/modify?goods_idx=${obj.goods_idx}'>수정</a></td>
			<td><a href= '${root }goods/delete?goods_idx=${obj.goods_idx}'>삭제</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>