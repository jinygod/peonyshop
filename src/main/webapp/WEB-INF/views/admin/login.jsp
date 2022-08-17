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
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
	<form:form action="${root }admin/login_pro" method='post' modelAttribute="tempLoginAdminBean">
			<form:label path="admin_code">관리자 코드</form:label>
			<form:password path="admin_code" />
			<form:errors path='admin_code' style='color:red' />
			<form:button>확인</form:button>
	</form:form>
</body>
</html>