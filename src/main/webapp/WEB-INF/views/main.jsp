<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<<<<<<< Updated upstream
	<title>Insert title here</title>
=======
	<title>PEONY SHOP</title>
>>>>>>> Stashed changes
<!-- 	<script>
		if(login) {
			alert('로그인 되었습니다')
		}
		// location.href='${root}main'
	</script> -->

</head>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>

<%-- 	<h1>PEONY SHOP</h1>
	<c:choose>
		<c:when test="${loginUserBean.userLogin == true}">
			<a href='${root }user/modify'>정보수정</a>
			<br />
			<a href='${root }user/logout'>로그아웃</a>
			<br />
		</c:when>
		<c:otherwise>
			<a href='${root }user/login'>로그인</a>
			<br />
			<a href='${root }user/join'>회원가입</a>
			<br />
		</c:otherwise>
	</c:choose>
	<a href='${root }admin/login'>관리자 로그인</a>
	<br />
	<a href='${root }notice/main'>공지사항</a>
	<br /> --%>
</body>
</html>