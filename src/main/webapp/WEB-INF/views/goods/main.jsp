<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>

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

</body>
</html>