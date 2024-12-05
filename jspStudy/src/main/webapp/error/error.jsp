<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true"%>

<%
response.setStatus(HttpServletResponse.SC_OK);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>문제없습니다</h1>
<h2> <%= exception.getClass().getName() %></h2>
<h2> <%= exception.getMessage() %></h2>
</body>
</html>