<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="jsp.JavaTest" %>

<%
	JavaTest hw = new JavaTest();
	String str = hw.Method();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	This sentence is from JSP<br />
	<%= str %>
</body>
</html>