<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
</head>
<body>
	<div>
	<form:form action="${root }goods/modify_pro" method='post' modelAttribute="modifyGoodsBean" enctype="multipart/form-data">
		<form:label path="goods_name" >상품명</form:label><br/>
		<form:input path="goods_name" value='${goodsInfo.goods_name }'/><br/>
		
		<form:label path="goods_category" >카테고리</form:label>
		<form:select path="goods_category" value='${goodsInfo.goods_category }'>
		<form:option value="top" label="top" />
		<form:option value="bottom" label="bottom" />
		<form:option value="dress" label="dress" />
		<form:option value="shoes" label="shoes" />
		<form:option value="accessory" label="accessory" />
		</form:select><br/>
				
		<form:label path="goods_content" >상세정보</form:label><br/>
		<form:input path="goods_content" value='${goodsInfo.goods_content }'/><br/>
		<form:errors path='goods_content' style='color:red' /><br/>
		
		<form:label path="goods_sell_price" >판매가</form:label><br/>
		<form:input path="goods_sell_price" value='${goodsInfo.goods_sell_price }'/><br/>
		<form:errors path='goods_sell_price' style='color:red' /><br/>

		<div>
		<form:label path="upload_thumbnail">썸네일사진</form:label><br />
		<c:if test="${goodsInfo.goods_thumbnail != null }">
		<img src="${root }upload/${goodsInfo.goods_thumbnail}" width="100px" />
		<form:hidden path="goods_thumbnail" />
		</c:if>
		<form:input path="upload_thumbnail" type='file' accept="image/*" />
		</div>
			<form:button>수정완료</form:button>
		</form:form>
	</div>
</body>
</html>