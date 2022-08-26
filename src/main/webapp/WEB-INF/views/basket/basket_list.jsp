<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script>
	var xgoods = new Array();
	
	function totalAmt(idx) {
		var goods_idx = xgoods[idx];
		
		let price_goods_idx = document.getElementById('price_' + goods_idx).value;
		let cnt_goods_idx = document.getElementById('cnt_' + goods_idx).value;
		var tot = price_goods_idx * cnt_goods_idx;
		let amt_goods_idx = document.getElementById('amt_' + goods_idx);
		amt_goods_idx.value = tot;
	} 	
	
		
	/* function checkbox(idx) {
		var goods_idx = xgoods[idx];
		var idx_goods_idx = document.getElementById('idx_' + goods_idx).value;
		var basket_check_idx = document.getElementById('basket_check_idx').value;
		basket_check_idx.value = idx_goods_idx;
		alert(idx_goods_idx);
		}
		
	}
	 */
		/* $('input:checkbox[name=goods_idx]:checked').each(function() {
		var goods_idx = xgoods[idx];
		var idx_goods_idx = document.getElementById('idx_' + goods_idx).value;
		alert(idx_goods_idx);
		}
		 */
	
	 /* $(function() {
		$(#basketOrder).submit(function() {
			var obj = $("[name=goods_idx]");
			var chkArray = new Array();
			
			$('input:checkbox[name=goods_idx]:checked').each(function() {
				chkArray.push(this.value);
			});
			
			var chkArrays = chkArray.join(',');
			alert('### ' + chkArrays);
			$('basket_check_idx').val(chkArrays);
			
		});
	  }); */
	
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
<form:form action="${root }order/order_pro" method='post' id='basketOrder' modelAttribute="orderInfoBean">

<h1>장바구니</h1>
		<table align = center  border = 'solid' '1px' >
		<tr>
<!-- 			<th>선택</th> -->
			<th>사진</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>상품수량</th>
			<th>수정</th>
			<th>총 가격</th>
			<th>삭제</th>
		</tr>
		<c:forEach var='obj' items="${basketList }" varStatus="status">
			<input type='hidden' name = "goods_category" value='${obj.goods_category}' />
			<input type='hidden' name = "goods_idx" value='${obj.goods_idx}' />
<!-- 			<input type='hidden' name="basket_check_idx" id="basket_check_idx" value=""/> -->
			<c:set var='goods' value="${obj}"/>
			<script>
				xgoods.push('${goods.goods_idx}');
			</script>
			<tr>
<%-- 				<td><input type="checkbox" id="idx_${obj.goods_idx}" name = "goods_idx" value = "${obj.goods_idx}" ></td> --%>
				<td><img src="${root }upload/${obj.goods_thumbnail}" width=100px, height=100px/><br/></td>
				<td><input type='text' id="goods_name" name="goods_name" value = "${obj.goods_name }"></td>
				<td><input type='text' id="price_${obj.goods_idx}" name = "goods_sell_price" value='${obj.goods_sell_price}' readonly/></td>
				<td><input type='text' id="cnt_${obj.goods_idx}" name='order_cnt' value='${obj.order_cnt }' readonly ></td>
				<td><a href = '${root }basket/basket_modify'> <input type = 'button' value = '수정'></a></td>
				<td><input type='text' id="amt_${obj.goods_idx}" name = "order_amt" value="${obj.order_amt}" readonly/></td>
				<td><a href = '${root }basket/basket_delete'> <input type = 'button' value = '삭제'></a></td>
			</tr>	
		</c:forEach>
	</table>
	<input type='hidden' name = "user_idx" value='${loginUserBean.user_idx }'/>
	<input type='hidden' name = "user_name" value='${loginUserBean.user_name }'/>
	<input type='hidden' name = "user_phone" value='${loginUserBean.user_phone }' />
	<input type='hidden' name = "user_email" value='${loginUserBean.user_email }' />
	<input type='hidden' name = "user_birth" value='${loginUserBean.user_birth }' />
	<input type='hidden' name = "user_zipcode" value='${loginUserBean.user_zipcode }'/>
	<input type='hidden' name = "user_addr1" value='${loginUserBean.user_addr1 }'/>
	<input type='hidden' name = "user_addr2" value='${loginUserBean.user_addr2 }'/>
	<input type = "submit"  name = order_basket value = "구매하기" >
</form:form>



</body>
</html>