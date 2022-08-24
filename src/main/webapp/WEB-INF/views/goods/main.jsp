<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>


<style>
.content{
    padding-right: 300px;
    padding-left: 300px;
	display : flex;
	align: center;
	flex-wrap: wrap;
	width:70%;
}
a{
	text-decoration:none;
	color:black;
}
</style>
</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>

<div class = 'content'>
	<c:forEach var='obj' items='${goodsList }'>
		<a href='${root}goods/goods_detail?topmenu_name=${topmenu_name}&goods_idx=${obj.goods_idx}'>
		<img src="${root }upload/${obj.goods_thumbnail}" width=300px, height=400px/><br/>
		${obj.goods_name } <br/>${obj.goods_sell_price } <br/> </a>
		
<%-- 		<c:if test = "${fn:length(goodsList) % 3 == 0 }"> --%>
			
<%-- 		</c:if> --%>
	</c:forEach>
</div>
<footer>
<c:import url="/WEB-INF/views/include/footer.jsp"/>
</footer>
</body>
</html>