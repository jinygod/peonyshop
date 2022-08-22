<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>

<html>
<head>


<script>

	// 장바구니 버튼 클릭 (url에 파라미터값 받기)
	function basket(){
		
			var url = "/peonyshop/basket/main";

			var price = document.getElementById('price').value;
			var cnt = document.getElementById('cnt').value;
			var amt = price * cnt;
			
			url += "?price=" + price;
			url += "&cnt=" + cnt;
			url += "&amt=" + amt;
			
		//	alert(url);
			location.href = url;
			
	}
	
	// tot 값 셋팅
	function totalAmt() {
		var price = document.getElementById('price').value;
		var cnt = document.getElementById('cnt').value;
		var tot = price * cnt;
		var amt = document.getElementById('amt');
		amt.value = tot;
	}
			
</script>

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
	<input type='hidden' name = "topmenu_name" value='${topmenu_name}' />
	<img src="${root }upload/${goodsDetail.goods_thumbnail}"  width=300px, height=400px/><br/>
	<h1>상품명: ${goodsDetail.goods_name}</h1><br/>
	가격 : <input type='text' id="price" name = "goods_sell_price" value='${goodsDetail.goods_sell_price}' readonly/><br/>
	수량 : <input type='number' id='cnt' name='order_cnt' value='1' min='1' max='10' onClick="totalAmt()"><br/>
	총 가격 : <input type='text' id="amt" name = "order_amt" value='${goodsDetail.goods_sell_price}' readonly/><br/>
	상세내용 : ${goodsDetail.goods_content}<br/>

	<button name = order_basket>주문하기</button>
	<input type = "submit"  name = order_basket onClick = "basket()" value = "장바구니">

	</form:form>


	<%-- 		"#{user_idx}, #{user_name}, #{user_phone}, #{user_zipcode}, #{user_addr1}, #{user_addr2}, #{order_date})")
 --%></body>
</html>