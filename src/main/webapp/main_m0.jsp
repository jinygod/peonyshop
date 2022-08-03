<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<hteml lang="ko">
<head>
<mata charset="utf-8">
<title> peony</title>
<style type="text/css">
	/*-----------------------------------p244----------------------------------*/

	body,header,div,footer,h1,p,ul,li {margin: 0; padding:0; }
	li { list-style-type: none; }
	.clear:after { content:""; display: block; clear: both; }
	body { font: 14px 'Malgun Gochic', '맑은고딕';}
	
	
	/*---------------------------------------------------------------------*/
	ul {padding: 0; margin:0;}
	li {list-style-type: none;}
	h1 {padding: 10px 20px; background: darkred; color:  darkred; font-size: 20px}
	.gnb{
		display: flex;
		display: -webkit -flex;
		display: -ms -flexbox;
		flex-direction: column;
		-wibkit-flex-directon:column;
		-ms-flex-direction: column;
	}
	/*--------------------------------------------------------------------*/
	@media all and (min-width:768px) {
		.gnb {
			flex-direction:row;
			-webkit-flex-direction:row;
			-ms-flex-direction: row;
			justify-content: space-around;
			-webkit-justify-content: space-around;
			background: lightcoral;
			}
			.gnb > li {
				flex: 0 0 80px;
				-wibkit-flex: 0 0 80px;
				-ms-flex: 0 0 80px;
				margin: 10px;
			}
			.gnb li a {padding: 0;}
		}
	/*--------------------------------------------------------------------*/
	@media all and (min-width:1025px) {
		.gnb {
			justify-content: flex-start;
			-webkit-justify-content: flex-start;
		}
	}
	/*--------------------------------------------------------------------*/
	
	.gnb > li {
		flex:1;
		-webkit-flex: 1;
		-ms-flex: 1;
		margin: 2px;
	}
	.gnb li a{
		display: block; padding: 10px; text-decoration: none;
		background: lightcoral; color: darkred;
	}
	</style>
</head>
<body>

		<h1><a href ="main_m0.html">peony</a></h1>
		<!---------------------------------------------------------------------- -->
		<div id="wrap">	
		<header class="clear_m">
			<ul class="gnb">
				<li><a href="main_m1-1.html">menu1</a></li>
				<li><a href="main_m1-2.html">menu2</a></li>
				<li><a href="main_m1-3.html">menu3</a></li>
				<li><a href="main_m1-4.html">menu4</a></li>
			</ul>
		</header>
		<!---------------------------------------------------------------------- -->
		<div class="contant_area">
			<p>content<br> content<br> <p>content<br> content<br> <p>content<br> content<br>
			</div>
		<!---------------------------------------------------------------------- -->
		</div>
		<footer>
			<p>copyright</p>
			<li><a href="javascript:;">blog</a></li>
			<li><a href="javascript:;">facebook</a></li>
			<li><a href="javascript:;">instagram</a></li>
			
		</footer>
	</div>
</body>
</html>