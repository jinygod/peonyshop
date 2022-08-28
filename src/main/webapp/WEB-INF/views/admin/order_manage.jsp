<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	table {
	border-collapse: collapse;
	}
	
	th {
	background-color: lightgray;
	}
	th,td {
		border :1px solid #000;
		align : center;
	}
</style>

<title>Insert title here</title>
</head>
<body align = center>
	<h1>주문내역_관리자용</h1>
	<a href= '${root}admin/main'>관리자홈</a>
	<table align = center>
		<tr>
			<th>주문번호</th>
			<th>상품번호</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>주문수량</th>
			<th>주문가격</th>
			<th>회원번호</th>
			<th>회원명</th>
			<th>생년월일</th>
			<th>휴대폰번호</th>
			<th>이메일</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>결제수단</th>
			<th>주문일자</th>

		</tr>
		<c:forEach var='obj' items="${orderManageInfo }">
			<tr>
				<td>${obj.order_idx }</td>
				<td>${obj.goods_idx }</td>
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px /></td>
				<td>${obj.goods_name }</td>
				<td>${obj.order_price }</td>
				<td>${obj.order_cnt }</td>
				<td>${obj.order_amt }</td>
				<td>${obj.user_idx }</td>
				<td>${obj.user_name }</td>
				<td>${obj.user_birth }</td>
				<td>${obj.user_phone }</td>
				<td>${obj.user_email }</td>
				<td>${obj.user_zipcode }</td>
				<td>${obj.user_addr1 }</td>
				<td>${obj.user_addr2 }</td>
				<td>${obj.order_pay_option }</td>
				<td>${obj.order_date }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>