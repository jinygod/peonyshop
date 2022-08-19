<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

<<<<<<< Updated upstream
=======

<style>
.content{
    padding-right: 300px;
    padding-left: 300px;
	background-color: green;
	display : flex;
	align: center;
	
}
</style>
>>>>>>> Stashed changes
</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>

<<<<<<< Updated upstream
for
<div>
<a href = "${root }">
<img src="${root }goods/goods_detail?goods_idx=${goodsRegBean.goods_idx}&goods_thumbnail=${goodsRegBean.goods_thumbnail }" width=200px/>
상품명
가격
</a>
</div>

이미지
상품명
가격

이미지
상품명
가격
<br/>

=======
<div class = 'content'>
<c:forEach var='obj' items='${goodsList }'>
		<a href='${root}goods/goods_detail?topmenu_name=${topmenu_name}&goods_idx=${obj.goods_idx}'>
		<img src="${root }upload/${obj.goods_thumbnail}" width=300px, height=400px/><br/>
		${obj.goods_name } <br/>${obj.goods_sell_price } <br/> </a>
	</c:forEach>
</div>
>>>>>>> Stashed changes
</body>
</html>