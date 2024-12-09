<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%
String name = (String)request.getAttribute("name");
String id = (String)request.getAttribute("id");
String pwd = (String)request.getAttribute("pwd");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<body>
	<h1 align="center">회원가입이 완료되었습니다.</h1>
	<table align="center" >
		<tr>
			<td align="center">이름 = <%=name%> <!-- name 값 -->
			</td>
		</tr>
		<tr>
			<td align="center">id = <%=id%> <!-- uid 값 -->
			</td>
		</tr>
		<tr>
			<td align="center">비밀번호 = <%=pwd%> <!-- pwd 값 -->
			</td>
		</tr>
	</table>
	<div class="buttons">
	<a href="/jspStudy/member/memberLogin.jsp"> <input
					type="button" value="로그인">
			</a>
			</div>
</body>
</html>