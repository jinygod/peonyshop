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

	<div align = center>
	<form:form action="${root }user/login_pro" method='post' modelAttribute="tempLoginUserBean">
			<form:label path="user_id">아이디</form:label>
			<form:input path="user_id" placeholder="4 ~ 14글자 사이로 입력"/><br/>
			<form:errors path='user_id' style='color:red' /><br/>
			
			<form:label path="user_pw">비밀번호</form:label>
			<form:password path="user_pw" /><br/>
			<form:errors path='user_pw' style='color:red' /><br/>
			
			<form:button>확인</form:button>
	</form:form>
	</div>
	
<footer>
<c:import url="/WEB-INF/views/include/footer.jsp"/>
</footer>
</body>
</html>