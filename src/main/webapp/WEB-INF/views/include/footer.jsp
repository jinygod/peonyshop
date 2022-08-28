<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html lang="ko">
<head>
<title>peony_footer</title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimun-scale=1, mazimum-scale=1">
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<link rel="stylesheet" href="css/footer.css">
<script src="js/footer.js"></script>
<style>
footer{
}
</style>
</head>
<body>
<hr/>
	<footer>
		<div class="foot_area box_inner">
			<h2><strong>peony</strong></h2>
			<p class ="addr">경기도 성남시 분당구
				<span class="gubun">/</span>
				<span class="br_line">대표전화
					<span class="space0">031-1234-5678</span>
					<span class="gubun">/</span>
					<span class="br_line">E-mail : 
						<span class="space0">peony@peony.com</span>
					</span>
				</span>
			</p>
			<p class="copy box_inner">Copyright(c) peony.co.kr all right reserved</p>
			<ul class="snslink clear">
				<li ><a href="javascript:;">blog</a></li> 
				<li><a href="javascript:;">facebook</a></li>
				<li><a href="javascript:;">instagram</a></li>
			</ul>
			<ul class="foot_list clear">
				<li><a href="이용약관.html"> 이용약관</a></li>
				<li><a href="개인정보취급방침.html"> 개인정보취급방침</a></li>
				
				<li><a  href='${root }admin/login'>관리자페이지</a></li>
			</ul>
		</div>
	</footer>
	
	
</body>
</html>
