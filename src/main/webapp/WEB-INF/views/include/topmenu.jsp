<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

	<div align = 'right'>
	<c:choose>
		<c:when test="${loginUserBean.userLogin == true}">
			<a href='${root }user/modify'>정보수정</a>
			<a href='${root }user/logout'>로그아웃</a>
			<a href="${root }basket/basket_list">장바구니</a>
		</c:when>
		<c:otherwise>
			<a href='${root }user/login'>로그인</a>
			<a href='${root }user/join'>회원가입</a>
		</c:otherwise>
	</c:choose>
	<a href='${root }admin/login'>관리자페이지</a>
	</div>
	<a href = '${root }'>
	<h1 align = 'center'>PEONY SHOP</h1></a>
	<div align = 'center'>
	<c:forEach var='obj' items='${topMenuList }'>
		<a href='${root}goods/main?topmenu_name=${obj.topmenu_name}'>${obj.topmenu_name }</a>
	</c:forEach>
	</div>
	<hr>
	