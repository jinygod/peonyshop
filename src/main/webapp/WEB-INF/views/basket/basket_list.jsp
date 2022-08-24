<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>

<script>
	var xgoods = new Array();
	
	function totalAmt(idx) {
		var goods_idx = xgoods[idx];
		
		/*
		for(var idx=0; idx < xgoods.length; idx++) {
			alert(xgoods[idx]);
		}
		*/
		
		let price = document.getElementById('price_' + goods_idx).value;
		let cnt = document.getElementById('cnt_' + goods_idx).value;
		var tot = price * cnt;
		let amt = document.getElementById('amt_' + goods_idx);
		amt.value = tot;
	} 

	
	/* function basket_check(){
		
		var chk = document.getElementById("basket_check").checked;	// true, false
		var idx = document.getElementByID("basket_check").value;
		if (chk == true) {
			for(var i=0; i<xgoods.length; i++) {
				var arraychk[i] = idx;
			}
		}
		var arraychk = document.getElementsByName("chk");	//basket_no
		var len = arraychk.length;
			for(var i=0; i<len; i++) {
					arraychk[i].checked = chk;	// chk가 true면 arraychk도 true
			}
		
		/* for(var idx=0; idx < xgoods.length; idx++) {
			var basket_check = basket_check[idx];
			
			alert('데이터가 담겼습니다')
		} 
		
	} */
	

</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
<form:form action="${root }order/pay_pro" method='post'	modelAttribute="payInfoBean">
<h1>장바구니</h1>
		<table align = center  border = 'solid' '1px' >
		<tr>
			<th>선택</th>
			<th>사진</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품수량</th>
			<th>총 가격</th>
		</tr>
		<c:forEach var='obj' items="${basketList }" varStatus="status">
			<c:set var='goods' value="${obj}"/>
			<script>
				xgoods.push('${goods.goods_idx}');
			</script>
			<tr>
				<td><input type="checkbox" id = "basket_check" name = "basket_check" value = "${obj.goods_idx }" onClick = "basket_check()"></td>
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
				<td>${obj.goods_name }</td>
				<td><input type='text' id="price_${obj.goods_idx}" name = "goods_sell_price" value='${obj.goods_sell_price}' readonly/></td>
				<td><input type='number' id="cnt_${obj.goods_idx}" name='order_cnt' value='${obj.order_cnt }' min='1' max='30' onClick="totalAmt('${status.index}')"></td>
				<td><input type='text' id="amt_${obj.goods_idx}" name = "order_amt" value="${obj.order_amt}" readonly/></td>
			</tr>	
		</c:forEach>
	</table>

	<input type='hidden' name = "user_idx" value='${loginUserBean.user_idx }'/>

	<button type = "submit"> 구매하기 </button>
</form:form>
</body>
</html>