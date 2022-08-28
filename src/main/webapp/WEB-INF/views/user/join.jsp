<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>peony 회원가입</title>
</head>
<script>
function checkUserIdExist(){
	
	var user_id = $("#user_id").val()
	
	if(user_id.length < 4){
		if(user_id.length == 0) {
		alert('아이디를 입력해주세요')
		} else {
		alert('아이디는 4글자 이상 입력해주세요')
		}
		return
	}
	
	$.ajax({
		url : '${root}user/checkUserIdExist/' + user_id,
		type : 'get',
		dataType : 'text',
		success : function(result){
			if(result.trim() == 'true'){
				alert('사용할 수 있는 아이디입니다')
				$("#userIdExist").val('true')
			} else {
				alert('사용할 수 없는 아이디 입니다')
				$("#userIdExist").val('false')
			}
		}
	})
}

function resetUserIdExist(){
	$("#userIdExist").val('false')
}
</script>
<body>
<c:import url="/WEB-INF/views/include/topmenu.jsp"/>
	<div align = center>
	<form:form action="${root }user/join_pro" method='post' modelAttribute="joinUserBean" >
		<form:hidden path="userIdExist" />
		<div>
			<form:label path="user_id">아이디</form:label>
			<form:input path="user_id" onkeypress="resetUserIdExist()" />
			<button type="button" onclick='checkUserIdExist()'>중복확인</button>
			<form:errors path='user_id' style='color:red' />

			<br />
		</div>
		<form:label path="user_pw">비밀번호</form:label>
		<form:password path="user_pw" />
		<form:errors path='user_pw' style='color:red' />
		<br />

		<form:label path="user_pw2">비밀번호 확인</form:label>
		<form:password path="user_pw2" />
		<form:errors path='user_pw2' style='color:red' />
		<br />

		<form:label path="user_name">이름</form:label>
		<form:input path="user_name" />
		<form:errors path='user_name' style='color:red' />
		<br />

		<form:label path="user_birth">생년월일</form:label>
		<form:input path="user_birth" placeholder="ex) 20000212"/>
		<form:errors path='user_birth' style='color:red' />
		<br />

		<form:label path="user_email">이메일</form:label>
		<form:input path="user_email" placeholder="ex) peony@peony.com"/>
		<form:errors path='user_email' style='color:red' />
		<br />

		<form:label path="user_phone">휴대폰 번호</form:label>
		<form:input path="user_phone" placeholder="ex) 01012345678"/>
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
	
<footer>
<c:import url="/WEB-INF/views/include/footer.jsp"/>
</footer>
</body>
</html>