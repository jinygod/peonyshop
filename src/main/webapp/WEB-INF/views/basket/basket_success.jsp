<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<script>
	alert('장바구니에 추가되었습ㄴ디ㅏ')
	location.href='${root}goods/goods_detail?topmenu_name=${topmenu_name}&goods_idx=${goods_idx}'
</script>
