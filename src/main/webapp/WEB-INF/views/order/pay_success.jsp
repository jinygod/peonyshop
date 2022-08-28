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
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
	<table align = center  border = 'solid' '1px'>
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
				<td><input type='text' id="order_idx" name ="order_idx" value = "${obj.order_idx }" readonly></td>
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
				<td><input type='text' id="goods_name" name ="goods_name" value = "${obj.goods_name }" readonly></td>
				<td><input type='text' id="order_price" name ="order_price" value = "${obj.order_price }" readonly></td>
				<td><input type='text' id="order_cnt" name ="order_cnt" value = "${obj.order_cnt }" readonly></td>
				<td><input type='text' id="order_amt" name ="order_amt" value = "${obj.order_amt }" readonly></td>
			</tr>
			</c:forEach>
		</table>
	
		<div align = center>
		<h1>유저 정보</h1>
		<label>이름 <input type='text'  name = "user_name" value='${payInfoBean.user_name}' readonly/></label><br/>
		<label>생년월일 <input type='text'  name = "user_birth" value='${payInfoBean.user_birth}' readonly/></label><br/>
		<label>이메일 <input type='text'  name = "user_email" value='${payInfoBean.user_email}' readonly/></label><br/>
		<label>휴대폰 번호 <input type='text'  name = "user_phone" value='${payInfoBean.user_phone}' readonly/></label><br/>
		<label>우편번호 <input type='text'  name = "user_zipcode" value='${payInfoBean.user_zipcode}' readonly/></label><br/>
		<label>주소 <input type='text'  name = "user_addr1" value='${payInfoBean.user_addr1}' readonly/></label><br/>
		<label>상세주소 <input type='text'  name = "user_addr2" value='${payInfoBean.user_addr2}' readonly/> </label><br/>
		<label>결제방법<input type='text'  name = "order_pay_option" value='${payInfoBean.order_pay_option}' readonly/></label><br/>
		<a href = ${root }> 홈으로 </a>
		</div>
</body>
</html>
