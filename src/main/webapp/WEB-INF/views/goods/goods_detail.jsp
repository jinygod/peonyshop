<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<script>

</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
</head>
<body>
	<form:form action='${root }buy_pro' method='post' modelAttribute="buyGoodsBean">
	<img src="${root }upload/${goodsDetail.goods_thumbnail}" width=300px, height=400px/><br/>
	<h1>상품명: ${goodsDetail.goods_name}</h1><br/>
	가격 : ${goodsDetail.goods_sell_price}<br/>
	수량 : <input type='number' id='cnt' name='cnt' value='1' min='1' max='10'><br/>
	총 가격 : <br/>
	상세내용 : ${goodsDetail.goods_content}<br/>
	
<%-- 	<a href="${root}goods/basket">구매</a>
	<a href="${root}goods/basket?user_idx=${user_idx}">장바구니</a> --%>
    <input type="submit" value="바로구매" onclick="javascript: form.action='${root}goods/buy?user_idx=${user_idx }';"/>
    <input type="submit" value="장바구니" onclick="javascript: form.action='${root}goods/basket?user_idx=1';"/>
	
	</form:form>
</body>
</html>