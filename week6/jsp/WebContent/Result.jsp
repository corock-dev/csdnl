<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%@ page import="jsp.Calc" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Factorial Result</title>
</head>
<body>
	<%
		/**
		 * @method getParameter
		 * 	input 태그의 name 값을 가져 옴
		 *	인자 타입이 String이므로 Input.jsp의 type을 text 처리
		 */
		String str = request.getParameter("input_str");
		int num = Integer.parseInt(str);
		
		/**
		 * Factorial을 수행할 Calc 클래스 생성
		 * 폼 태그에서 가져온 num의 값을 인자로 넘겨주어 결과 값을 반환받아 num에 설정
		 */
		Calc calc = new Calc();
		num = calc.factorial(num);
	%>
	
	<%-- 결과 값 표시 --%>
	<%= num %>
</body>
</html>