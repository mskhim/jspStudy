<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String pwd = (String) session.getAttribute("pwd");
if(session.getAttribute("name")==null){
	response.sendRedirect("/jspStudy/member/memberLogin.jsp");
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 <link rel="stylesheet" href="./member.css" />
</head>
<body>
<%if(request.getParameter("error")!=null){ %>
	 <script>
            alert("수정이 실패했습니다.");
   </script>
	<%} %>
	<h1 >마이페이지</h1>
	<table width="300" border="1" align="center">
		<tr>
			<td align="center">이름 = <%=name%></td>
		</tr>
		<tr>
			<td align="center">ID = <%=id%></td>
		</tr>
		<tr>
			<td align="center">비밀번호 = <%=pwd%></td>
		</tr>
	</table>
		<div class="buttons">
		<a href="/jspStudy/member/memberUpdate.jsp"> <input
					type="button" value="회원정보 수정">
			</a> <a href="/jspStudy/member/memberLogin.jsp"> <input type="button"
					value="뒤로가기">
			</a>
		</div>

</body>
</html>