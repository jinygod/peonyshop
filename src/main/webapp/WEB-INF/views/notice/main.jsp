<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	table {
	border-collapse: collapse;
	}
	
	th {
	background-color: lightgray;
	}
	th,td {
		border :1px solid #000;
		align : center;
	}
</style>

<title>Insert title here</title>
</head>
<body>
	<h1>공지사항</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var='obj' items="${noticeList }">
		<tr>
			<td>${obj.notice_idx }</td>
			<td><a href = "${root }notice/read">${obj.notice_title }</a></td>
			<td>${obj.notice_content }</td>
			<td>${obj.notice_date }</td>
		</tr>
		</c:forEach>
	</table>
	<a href = "${root }notice/write">글쓰기</a>
</body>
</html>