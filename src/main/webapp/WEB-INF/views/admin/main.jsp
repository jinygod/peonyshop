<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Main</title>
</head>
<body>
	<a href='${root }goods/goods_list'>상품 목록</a>
	<a href='${root }goods/goods_reg'>상품 등록</a>
</body>
</html>