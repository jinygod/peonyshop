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
<body align = center>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
	<form:form action="${root }notice/write_pro" method='post' modelAttribute="writeNoticeBean">
		<form:label path="notice_title">글 제목</form:label><br/>
		<form:input path="notice_title" /><br/>
		<form:errors path='notice_title' style='color:red' /><br/>
		
		<form:label path="notice_content">글 내용</form:label><br/>
		<form:textarea path="notice_content" /><br/>
		<form:errors path='notice_content' style='color:red' /><br/>
		
		<form:button>확인</form:button>
	</form:form>
</body>
</html>