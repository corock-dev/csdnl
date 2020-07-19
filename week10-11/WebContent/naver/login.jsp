<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>
<!-- region 네이버 아이디로 로그인 버튼 노출 영역 -->
<div id="naverIdLogin"></div>
<!-- endregion 네이버 아이디로 로그인 버튼 노출 영역 -->

<!-- region 네이버 아디디로 로그인 초기화 스크립트 -->
<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			// 할당받은 클라이언트 아이디와 콜백 URI 세팅
			clientId: "XOASHFZE9HIMm9dxBD67",
			callbackUrl: "http://localhost:8080/week10-11/naver/callback.jsp",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
	/* 설정 정보를 초기화하고 연동을 준비 */
	naverLogin.init();
	
</script>
<!-- endregion 네이버 아이디로 로그인 초기화 스크립트 -->
</body>
</html>
