<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String pwd = (String) session.getAttribute("pwd");
%>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 <style>
        table {
            margin: 0 auto;
            border-collapse: collapse;
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
<body>
<%if(request.getParameter("error")!=null){ %>
	 <script>
            alert("수정할수 없는 아이디입니다.");
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