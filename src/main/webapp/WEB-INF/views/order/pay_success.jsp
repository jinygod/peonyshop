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
	<table align = center>
			<tr>
				<th>주문번호</th>
				<th>사진</th>
				<th>상품명</th>
				<th>상품금액</th>
				<th>수량</th>
				<th>총 구매금액</th>
			</tr>
			<c:forEach var='obj' items="${payInfo }">
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
		<h1>유저 정보</h1>
		<label>이름 <input type='text'  name = "user_name" value='${payUserInfo.user_name}' readonly/></label><br/>
		<label>생년월일 <input type='text'  name = "user_birth" value='${payUserInfo.user_birth}' readonly/></label><br/>
		<label>이메일 <input type='text'  name = "user_email" value='${payUserInfo.user_email}' readonly/></label><br/>
		<label>휴대폰 번호 <input type='text'  name = "user_phone" value='${payUserInfo.user_phone}' readonly/></label><br/>
		<label>우편번호 <input type='text'  name = "user_zipcode" value='${payUserInfo.user_zipcode}' readonly/></label><br/>
		<label>주소 <input type='text'  name = "user_addr1" value='${payUserInfo.user_addr1}' readonly/></label><br/>
		<label>상세주소 <input type='text'  name = "user_addr2" value='${payUserInfo.user_addr2}' readonly/> </label><br/>
		<label>결제방법<input type='text'  name = "order_pay_option" value='${order_pay_option}' readonly/></label><br/>
		<a href = ${root }> 홈으로 </a>
		</div>
</body>
</html>
