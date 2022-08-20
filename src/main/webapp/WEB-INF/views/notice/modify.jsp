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
	<div>
	<form:form action='${root }notice/modify_pro' method='post'
		modelAttribute="modifyNoticeBean">
		<form:label path="notice_writer">작성자</form:label>
		<form:input path="notice_writer" value = "${noticeInfo.notice_writer }" readonly="true" />
		<br />
		<form:label path="notice_date">작성날짜</form:label>
		<form:input path="notice_date" value = "${noticeInfo.notice_date }" readonly="true" />
		<br />
		<form:label path="notice_title">제목</form:label>
		<form:input path="notice_title" value = "${noticeInfo.notice_title }"/>
		<form:errors path='notice_title' style='color:red' />
		<br />
		<form:label path="notice_content">내용</form:label>
		<form:input path="notice_content" value = "${noticeInfo.notice_content }" />
		<form:errors path='notice_content' style='color:red' />
		<br />
		<form:button>확인</form:button>
	</form:form>
	</div>
</body>
</html>