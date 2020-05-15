<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Factorial Input Page</title>
</head>
<body>
	<!-- 입력 창과 버튼 하나를 생성한 뒤 html form 태그로 감싼 후 Result.jsp로 전송 -->
	<form action="Result.jsp">
		<input type="text" name="input_str" placeholder="값 입력">
		<input type="submit" value="factorial">
	</form>
</body>
</html>
