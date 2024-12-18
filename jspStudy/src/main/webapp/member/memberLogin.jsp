<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
 <style>
        table {
            margin: 0 auto;
            border-collapse: collapse;
        }
        tr {
            text-align: center;
            padding: 10px;
            border: 1px solid #ccc;
        }
        td {
            text-align: center;
            padding: 10px;
            border: 1px solid #ccc;
        }
        h1 {
            text-align: center;
        }
        .buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 10px;
        }
    </style>
</head>
<html>
<%
String name = (String) session.getAttribute("name");
if (name == null) {
%>
<body>
	<%if(request.getParameter("error")!=null&&request.getParameter("error").equals("2")){ %>
	 <script>
            alert("아이디 또는 비밀번호가 맞지 않습니다.");
   </script>
	<%} else{ if(request.getParameter("error")!=null&&request.getParameter("error").equals("1")){ %>
	 <script>
            alert("비밀번호가 맞지 않습니다.");
   </script>
	
	<%}}  %>
	<form method="post" action="/jspStudy/memberloginCheckServlet.do">
		<table width="300" align="center">
			<tr>
				<th width="100">아이디</th>
				<td width="200">&nbsp;<input type="text" name="id"></td>
			</tr>
			<tr>
				<th width="100">비밀번호</th>
				<td width="200">&nbsp;<input type="password" name="pwd"></td>
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
				&nbsp;&nbsp; <a href="/jspStudy/memberLogoutServlet.do"><input type="button"
						value="로그아웃"></a>
		</div>
</body>
<%
}
%>
</html>