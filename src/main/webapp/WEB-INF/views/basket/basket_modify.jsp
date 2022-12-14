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

	

	// 장바구니 버튼 클릭 (url에 파라미터값 받기)
	/* function basket(){
		
			var url = "/peonyshop/basket/main";

			var price = document.getElementById('price').value;
			var cnt = document.getElementById('cnt').value;
			var amt = price * cnt;
			
			url += "?price=" + price;
			url += "&cnt=" + cnt;
			url += "&amt=" + amt;
			
		//	alert(url);
			location.href = url;
			
	} */
/* 	
	// tot 값 셋팅
	function totalAmt() {
		/* var price = document.getElementById('price').value;
		var cnt = document.getElementById('cnt').value;
		var tot = price * cnt;
		var amt = document.getElementById('amt');
		amt.value = tot;  */
	
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
	<form:form action='${root }basket/basket_modify_pro' method='post' modelAttribute="modifyBasketBean" >
	<input type='hidden' name = "user_idx" value='${loginUserBean.user_idx }'/>
	<input type='hidden' name = "user_name" value='${loginUserBean.user_name }'/>
	<input type='hidden' name = "user_phone" value='${loginUserBean.user_phone }' />
	<input type='hidden' name = "user_email" value='${loginUserBean.user_email }' />
	<input type='hidden' name = "user_birth" value='${loginUserBean.user_birth }' />
	<input type='hidden' name = "user_zipcode" value='${loginUserBean.user_zipcode }'/>
	<input type='hidden' name = "user_addr1" value='${loginUserBean.user_addr1 }'/>
	<input type='hidden' name = "user_addr2" value='${loginUserBean.user_addr2 }'/>
<%-- 	<input type='hidden' name = "goods_idx" value='${basketList.goods_idx }' />
	<input type='hidden' name = "goods_name" value='${basketList.goods_name }' />
	<input type='hidden' name = "goods_thumbnail" value='${basketList.goods_thumbnail }' />
	<input type='hidden' name = "goods_category" value='${basketList.goods_category }' /> --%>
	<input type='hidden' name = "basket_idx" value='${basket_idx }' />
	<input type='hidden' name = "goods_idx" value='${modifyBasketInfo.goods_idx }' />
	
	<div id = grid>
	<p class = img>
	<img src="${root }upload/${modifyBasketInfo.goods_thumbnail}"  width=300px, height=400px/><br/>
	</p>
		<div>
		<h1>${modifyBasketInfo.goods_name}</h1>
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
			<td><input type='text' id="price" name = "goods_sell_price" value='${modifyBasketInfo.goods_sell_price}' readonly/></td>
		</tr>
		<tr>
			<th>수량</th>
			<td><input type='number' id='cnt' name='order_cnt' value='${modifyBasketInfo.basket_goods_cnt }' min='1' max='10' onClick="totalAmt()"></td>
		</tr>
		<tr>
			<th>총 가격</th>
			<td><input type='text' id="amt" name = "order_amt" value="${modifyBasketInfo.order_amt}" readonly/></td>
		</tr>
		
	</table>

	<input type = "submit"  value = "수정완료">
	<a href= "${root }basket/basket_list"><input type = "button"  value = "취소"></a>

	</form:form>
		</div>
	</div>
	<p align = center>상세내용 : ${modifyBasketInfo.goods_content}<br/></p>
	

</body>
</html>