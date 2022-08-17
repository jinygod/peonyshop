<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body align = center>
	<form:form action="${root }admin/goods_reg_pro" method='post' modelAttribute="goodsRegBean" enctype="multipart/form-data">
		<form:label path="goods_name">상품명</form:label><br/>
		<form:input path="goods_name" /><br/>
		<form:errors path='goods_name' style='color:red' /><br/>
		
		<form:select path="goods_category">카테고리<br/>
		<form:option value="top" label="top" />
		<form:option value="bottom" label="bottom" />
		<form:option value="dress" label="dress" />
		<form:option value="shoes" label="shoes" />
		<form:option value="accessory" label="accessory" />
		</form:select>
				
		<form:label path="goods_content">상세정보</form:label><br/>
		<form:textarea path="goods_content" /><br/>
		<form:errors path='goods_content' style='color:red' /><br/>
		
		<form:label path="goods_sell_price">판매가</form:label><br/>
		<form:input path="goods_sell_price" /><br/>
		<form:errors path='goods_sell_price' style='color:red' /><br/>
		
		<form:label path="upload_thumbnail">썸네일사진</form:label><br/>
		<form:input type='file' path="upload_thumbnail" accept="image/*"/><br/>
				
		<form:button>확인</form:button>
	</form:form>
</body>
</html>