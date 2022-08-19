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
			
			alert(url);
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
	<form:form action='${root }order/order_pro' method='post' modelAttribute="orderInfoBean" id = "frm" name = "frm">
<%-- 	<form:hidden path='${loginUserBean.user_idx }'/> --%>
	<img src="${root }upload/${goodsDetail.goods_thumbnail}" width=300px, height=400px/><br/>
	<h1>상품명: ${goodsDetail.goods_name}</h1><br/>
	가격 : <input type='text' id="price" value='${goodsDetail.goods_sell_price}' readonly/><br/>
	수량 : <input type='number' id='cnt' name='cnt' value='1' min='1' max='10' onClick="totalAmt()"><br/>
	총 가격 : <input type='text' id="amt" value='${goodsDetail.goods_sell_price}' readonly/><br/>
	상세내용 : ${goodsDetail.goods_content}<br/>
	<form:button>주문하기</form:button>
	<input type = "button"  onClick = "basket()" value = "장바구니">
	</form:form>

</body>
</html>