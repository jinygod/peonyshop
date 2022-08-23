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
	

</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table align = center  border = 'solid' '1px' >
		<tr>
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
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
				<td>${obj.goods_name }</td>
				<td><input type='text' id="price_${obj.goods_idx}" name = "goods_sell_price" value='${obj.goods_sell_price}' readonly/></td>
				<td><input type='number' id="cnt_${obj.goods_idx}" name='order_cnt' value='${obj.order_cnt }' min='1' max='10' onClick="totalAmt('${status.index}')"></td>
				<td><input type='text' id="amt_${obj.goods_idx}" name = "order_amt" value="${obj.order_amt}" readonly/></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>