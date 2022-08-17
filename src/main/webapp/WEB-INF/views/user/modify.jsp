<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp" />
	<div>
	<form:form action='${root }user/modify_pro' method='post'
		modelAttribute="modifyUserBean">
		<form:label path="user_name">이름</form:label>
		<form:input path="user_name" readonly="true" />
		<br />
		<form:label path="user_id">아이디</form:label>
		<form:input path="user_id" readonly="true" />
		<br />
		<form:label path="user_pw">비밀번호</form:label>
		<form:password path="user_pw" />
		<form:errors path='user_pw' style='color:red' />
		<br />
		<form:label path="user_pw2">비밀번호 확인</form:label>
		<form:password path="user_pw2" />
		<form:errors path='user_pw2' style='color:red' />
		<br />
		<form:label path="user_birth">생년월일</form:label>
		<form:input path="user_birth" readonly="true" />
		<form:errors path='user_birth' style='color:red' />
		<br />
		<form:label path="user_email">이메일</form:label>
		<form:input path="user_email" />
		<form:errors path='user_email' style='color:red' />
		<br />
		<form:label path="user_phone">휴대폰 번호</form:label>
		<form:input path="user_phone" />
		<form:errors path='user_phone' style='color:red' />
		<br />
		<form:label path="user_zipcode">우편번호</form:label>
		<form:input path="user_zipcode" />
		<form:errors path='user_zipcode' style='color:red' />
		<br />
		<form:label path="user_addr1">주소</form:label>
		<form:input path="user_addr1" />
		<form:errors path='user_addr1' style='color:red' />
		<br />
		<form:label path="user_addr2">상세주소</form:label>
		<form:input path="user_addr2" />
		<form:errors path='user_addr2' style='color:red' />
		<br />
		<form:button>확인</form:button>
	</form:form>
	</div>
</body>
</html>