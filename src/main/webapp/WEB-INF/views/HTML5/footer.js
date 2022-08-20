/*5.4메인 페이지의 스크립트 */
	
/*5.4.01 gnb의 작동 */
/*
	1.메인 메뉴에 마우스가 닿으면 숨겨져 있던 서브 메뉴가 나옵니다.
	2.메뉴 표시 기능을 저장하기 위해 isOver1에 true 를 기억시킵니다.
	3. 쿼리문이 모바일 외의 환경에서 작동되도록 header의 가로폭이 800이상일 때 실행합니다.
	4. 키보드 접근성을 부여하기 위해 tab키로 접근할 때도 같은 작동을 하도록 focus에도 같은 코딩을 구현합니다.
*/
	$(document).ready ( function() {
		//gnb_depth2_1
		$('.openAll1').mouseover(function(){
			if (parseInt($('header').css('width'))>800) $('.gnb_depth2_1').
	fadeIn('fase');
			isOver = true;
		});
		$('.openAll1').focus(function(){
			if( parseInt($('header').css('width')) > 800 ) $ ('.gnb_depth2_1').fadeIn('fast');
				isOver1 = true;
		});
/*
	메뉴에서 마우스가 벗어나고 서브 메뉴에서도 벗어나야 서브 메뉴를 사라지게 해야 하기 때문에 사라지는 것은 즉시하지 않고 goHide1함수로 가서 물어보고 합니다.
	다만 메인 메뉴에서 마우스가 벗어나거나 tab키로 벗어났을때 그 사실을 기억하기 위해 변수isOver에 false를 기억시킵니다.
	
*/

			$('.openAll1').mouseout(function(){
				isOver1 = false;
				setTimeout("goHide1()",200);
			});
			$('.gnb_depth2_1 li:last-child a').blur(function(){
				isOver1 = false;
				setTimeout("goHidel()",200);
			});
		});

/*
	서브 메뉴에 마우스가 닿아 있을때 아직 서브 메뉴가 꺼지면 안되기에 그 사실을 기억하기 우해 변수 isOver2에 treu를 기억시킵니다.
	키보드 접근성을 부여하기 위해 tab키로 벗어났을 때에도 같은 동작을 하도록 focus에도 같은 코딩을 넣습니다.
*/
	$(document).ready(function(){
		$('.gnb_depth2_1').mouseover(function(){
			isOver=true;
		});
		$('.gnb_depth2_1').focus(function(){
			isOver2 = true;
		});
	
	});

	
/*
	서브 메뉴에서 마우스가 벗어났을 때 그 사실을 기억하기 우해 변수 isOver2에 false를 기억시키고 goHide1()함수로 갑니다. 메인 메뉴에서도 벗어났는지 물어보고 서브 메뉴를 감추기 위해서입니다. 
	키보트 접근성을 부여하기 위해 tab키로 벗어날 때도 같은 동작을 하도록.focus에도 같은 코딩을 넣습니다.
*/
	$(document).ready(function(){
		$('.gnb_depth2_1').mouseout(function(){
			isOver = false;
			setTimeout("goHide1()",200);
		});
		$('.gnb_depth2_1').blur(function(){
			isOver2 = false;
			setTimeout("goHide1()",200);
		});
	});

/*
	스크립트 상단에 전역변수로 isOver1과 isOver2를 선언합니다.
	goHide()함수에서는 두 변수가 모두 false일 때, 즉 메인 메뉴에도 서브 메뉴에도 서브 메뉴에도 마우스가 닿아 있지 않음을 확인하고 서브 메뉴를 사라지게 해줍니다. 
	나머지 메뉴들도 동일한 방식으로 코딩합니다.
*/


/*5.4.02 모바일 메뉴 띄우기 */
/*
	삼선 메뉴를 클릭했을 때 header색상을 변경하기 위해 on클래스를 부여하고, 
	서브 메뉴를 나타나게 하고, 
	닫기 버튼을 보이도록 하고, 
	화면이 터치로 움직이지 않도록 고정합니다. 
	반대로 닫기 버튼을 누르면 서브 메뉴가 닫히며 반대의 효과들이 일어납니다.
*/
	$(document).ready(function() {
			$('header').addClass('on');
			$('header .header_cont').slideDown('fast');
			$('header .header_area .header_cont .closePop').show();
			$("body").bind('touchmove',function(e){e.preventDefault()});
	});
	$('header .header_cont .closePop').click(function(){
			$('.header_cont').slideUp('fast');
			$('header').removeClass('on');
			$("body").unbind('touchmove');
	});

/*pc브라우저에서  gnb사라짐 방지*/
/*
	pc에서 반응형 체크를 위해 브라우저를 좁혀서 메뉴를 닫고 다시 넓히면 gnb가 사라진 채로 있게 됩니다.
	새로고침을 수행하면 문제가 없지만 오류인 것처럼 느껴지므로, 브라우저 넓힐 대 gnb가 노출되도록 해줍니다.
*/
$(document),ready(function() {
	$(window).resize(function() {
		if(parseInt($('header').css('width'))>800 ) $ ('.header_cont').show();
	});
});

/* 5.5 서브페이지의 시안 점검 */
/*
	gnb와 footer는 모든 페이지 공통이기 때문에 서브 페이지에서는 상단과 콘텐츠 부분만을 다룰 것입니다.
*/

/* 5.5.1 회원가입 페이지 시안 */

