<%@page contentType="text/html; charset=UTF-8"%>
<%@page errorPage="/error/error.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
<%
String name = request.getParameter("name").toUpperCase();
out.print("사용자가 입력한 이름은"+name);
%>
</body>
</html>