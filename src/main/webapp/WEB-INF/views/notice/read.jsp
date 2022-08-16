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
	<h1>공지사항</h1>
		<label for="notice_writer">작성자</label>
		<input type="text"
				id="notice_writer" name="notice_writer" 
				value="${readNotice.notice_writer }" disabled="disabled" />
			
		<label for="notice_date">작성날짜</label> <input type="text"
			id="notice_date" name="notice_date"
			value="${readNotice.notice_date }" disabled="disabled" /><br/>
			
		<label for="notice_title">제목</label> <input type="text"
			id="notice_title" name="notice_title"
			value="${readNotice.notice_title }" disabled="disabled" /><br/>
			
		<label for="notice_content">내용</label>
		<textarea id="notice_content" name="notice_content"
			rows="10" style="resize: none" disabled="disabled">${readNotice.notice_content }</textarea>
			
		<a href= '${root }notice/main'>목록</a>	
		<a href= '${root }notice/modify'>수정</a>
		<a href= '${root }notice/delete?notice_idx=${notice_idx}'>삭제</a>	
</body>
</html>