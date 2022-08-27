<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<%-- <c:set var='login' value="${loginUserBean }" scope="page" /> --%>

<!DOCTYPE html>
<html>
<head>

<script>
	
	function totalAmt() {
		let price = document.querySelector('#price').value;
		let cnt  = document.querySelector('#cnt').value;
		var tot = price * cnt;
		amt.value = tot;

	}
			
</script>
<style>
	.img {
		display : flex;
		justify-content : right;
		padding-right : 20px;
	}
	
	#grid {
	display : grid;
	grid-template-columns: 1fr 1fr;
	}
	
</style>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
</head>
<body>
	
	<form:form action='${root }order/order_pro' method='post' modelAttribute="orderInfoBean" >
	<input type='hidden' name = "user_idx" value='${loginUserBean.user_idx }'/>
	<input type='hidden' name = "user_name" value='${loginUserBean.user_name }'/>
	<input type='hidden' name = "user_phone" value='${loginUserBean.user_phone }' />
	<input type='hidden' name = "user_email" value='${loginUserBean.user_email }' />
	<input type='hidden' name = "user_birth" value='${loginUserBean.user_birth }' />
	<input type='hidden' name = "user_zipcode" value='${loginUserBean.user_zipcode }'/>
	<input type='hidden' name = "user_addr1" value='${loginUserBean.user_addr1 }'/>
	<input type='hidden' name = "user_addr2" value='${loginUserBean.user_addr2 }'/>
	<input type='hidden' name = "goods_idx" value='${goodsDetail.goods_idx }' />
	<input type='hidden' name = "goods_name" value='${goodsDetail.goods_name }' />
	<input type='hidden' name = "goods_thumbnail" value='${goodsDetail.goods_thumbnail }' />
	<input type='hidden' name = "goods_category" value='${goodsDetail.goods_category }' />
	<input type='hidden' name = "topmenu_name" value='${topmenu_name }' />
	
	<div id = grid>
	<p class = img>
	<img src="${root }upload/${goodsDetail.goods_thumbnail}"  width=300px, height=400px/><br/>
	</p>
		<div>
		<h1>${goodsDetail.goods_name}</h1>
	<table>
		<tr>
			<th>배송구분</th>
			<td>무료배송</td>
		</tr>
		<tr>
			<th>배송예상</th>
			<td>전체 오늘출발 가능</td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type='text' id="price" name = "goods_sell_price" value='${goodsDetail.goods_sell_price}' readonly/></td>
		</tr>
		<tr>
			<th>수량</th>
			<td><input type='number' id='cnt' name='order_cnt' value='1' min='1' max='10' onClick="totalAmt()"></td>
		</tr>
		<tr>
			<th>총 가격</th>
			<td><input type='text' id="amt" name = "order_amt" value="${goodsDetail.goods_sell_price}" readonly/></td>
		</tr>
		
	</table>
<%-- 	<h1>${goodsDetail.goods_name}</h1><br/>
	<p>배송구분 : 무료배송</p>
	<p>배송예상 : 전체 오늘출발 가능</p>
	가격 : <br/>
	수량 : <input type='number' id='cnt' name='order_cnt' value='1' min='1' max='10' onClick="totalAmt()"><br/>
	총 가격 : <input type='text' id="amt" name = "order_amt" value="${goodsDetail.goods_sell_price}" readonly/><br/> --%>
	

	<input type = "submit"  name = order_basket value = "장바구니">
	<input type = "submit"  name = order_basket value = "바로구매">

	</form:form>
		</div>
	</div>
	<p align = center>상세내용 : ${goodsDetail.goods_content}<br/></p>
	

	<%-- 		"#{user_idx}, #{user_name}, #{user_phone}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, #{order_date})")
 --%></body>
</html>