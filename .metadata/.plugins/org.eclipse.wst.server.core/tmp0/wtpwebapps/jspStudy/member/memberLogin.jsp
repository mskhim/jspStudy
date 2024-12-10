<%@page import="co.kh.dev.common.MyUtility"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
 <link rel="stylesheet" href="./member.css" />
</head>
<html>
<%
String name = (String) session.getAttribute("name");
if (MyUtility.isNullOrEmpty(name)) {
%>
<body>
	 <script>
	<%if(request.getParameter("error")!=null&&request.getParameter("error").equals("2")){ %>
            alert("아이디 또는 비밀번호가 맞지 않습니다.");
	<%} else{ if(request.getParameter("error")!=null&&request.getParameter("error").equals("1")){ %>
            alert("비밀번호가 맞지 않습니다.");
	
	<%}}  %>
   </script>
	<form method="post" action="/jspStudy/memberloginCheckServlet.do">
		<table align="center">
			<tr>
				<th >아이디</th>
				<td >&nbsp;<input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>&nbsp;<input type="password" name="pwd"></td>
			</tr>
		</table>
		<div class="buttons">
			<a href="/jspStudy/member/memberRegist.jsp"><input type="button"
						value="회원가입"></a> &nbsp; &nbsp; <input type="submit"
					value="로그인">
			</div>
	</form>
</body>
<%
} else {
%>
<body>
	<table border="1" width="300" align="center">
		<tr>
			<td width="300" align="center"><%=name%> 님 로그인 되었습니다.</td>
		</tr>
	</table>
	<div class="buttons">
	<a href="/jspStudy/member/memberMyPage.jsp"><input type="button"
						value="마이페이지"></a>
				&nbsp;&nbsp;<a href="/jspStudy/board/boardMain.jsp"><input type="button"
						value="게시판"></a>
				&nbsp;&nbsp; <a href="/jspStudy/memberLogoutServlet.do"><input type="button"
						value="로그아웃"></a>
		</div>
</body>
<%
}
%>
</html>