<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${root }user/login_pro" method='post' modelAttribute="tempLoginUserBean">
			<form:label path="user_id">아이디</form:label>
			<form:input path="user_id" class='form-control' />
			<form:errors path='user_id' style='color:red' />
			<form:button>확인</form:button>
	</form:form>
</body>
</html>