<%@page import="co.kh.dev.login.model.MemberVO"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		현재 날짜 시간은 =
		<%=(new Date()).toString()%></h1>
	<h1>
		<%MemberVO mvo = new MemberVO();
		mvo.setName("kms");
		String name = mvo.getName();
		
		%>
		<%=mvo.toString()%>
	</h1>
</body>
</html>