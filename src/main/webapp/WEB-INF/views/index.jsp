<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>PEONY SHOP</h1>
	<a href='${root }user/login'>로그인</a><br/>
	<a href='${root }user/join'>회원가입</a><br/>
	<a href='${root }user/modify'>정보수정</a><br/>
	<a href='${root }user/logout'>로그아웃</a><br/>
	<a href='${root }admin/login'>관리자 로그인</a><br/>
	<a href='${root }notice/main'>공지사항</a><br/>
</body>
</html>