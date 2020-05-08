<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = request.getParameter("input_str");
		int num = Integer.parseInt(str);
	%>
	<%= num %>
</body>
</html>