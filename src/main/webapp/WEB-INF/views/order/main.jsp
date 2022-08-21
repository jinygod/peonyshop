<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>order main</h1>
<form:form action="${root }order/pay_pro" method='post'	modelAttribute="payInfoBean">
	<input type='hidden' name = "order_idx" value='${orderInfoBean.order_idx}'/>
	<input type='hidden' name = "user_idx" value='${orderInfoBean.user_idx }'/>
	<input type='hidden' name = "goods_idx" value='${orderInfoBean.goods_idx }'/>
	<input type='hidden' name = "goods_name" value='${orderInfoBean.goods_name }'/>
	<input type='hidden' name = "goods_thumbnail" value='${orderInfoBean.goods_thumbnail }'/>
	<input type='hidden' name = "goods_sell_price" value='${orderInfoBean.goods_sell_price }'/>
	<input type='hidden' name = "order_cnt" value='${orderInfoBean.order_cnt }'/>
	<input type='hidden' name = "order_amt" value='${orderInfoBean.order_amt }'/>
	
	<table align = center>
			<tr>
				<th>주문번호</th>
				<th>사진</th>
				<th>상품명</th>
				<th>상품금액</th>
				<th>수량</th>
				<th>총 구매금액</th>
			</tr>
			<c:forEach var='obj' items="${orderList }">
			<tr>
				<td>${obj.order_idx }</td>
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
				<td>${obj.goods_name}</td>
				<td>${obj.goods_sell_price }</td>
				<td>${obj.order_cnt }</td>
				<td>${obj.order_amt }</td>
			</tr>
			</c:forEach>
		</table>
	
		<div align = center>
		<label>이름 <input type='text'  name = "user_name" value='${userInfo.user_name}' readonly/></label><br/>
		<label>생년월일 <input type='text'  name = "user_birth" value='${userInfo.user_birth}' readonly/></label><br/>
		<label>이메일 <input type='text'  name = "user_email" value='${userInfo.user_email}' /></label><br/>
		<label>휴대폰 번호 <input type='text'  name = "user_phone" value='${userInfo.user_phone}' /></label><br/>
		<label>우편번호 <input type='text'  name = "user_zipcode" value='${userInfo.user_zipcode}' /></label><br/>
		<label>주소 <input type='text'  name = "user_addr1" value='${userInfo.user_addr1}' /></label><br/>
		<label>상세주소 <input type='text'  name = "user_addr2" value='${userInfo.user_addr2}' /></label><br/>
		<input type="radio" name="order_pay_option"  id="order_pay_option" value="신용카드" >신용카드<br/>
        <input type="radio" name="order_pay_option"  id="order_pay_option" value="계좌이체" >계좌이체<br/>
		<button type = "submit"> 구매하기 </button>
		</div>
	</form:form>
	
</body>
</html>