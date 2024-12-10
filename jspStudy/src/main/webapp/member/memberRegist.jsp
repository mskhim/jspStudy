<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="./member.css" />
</head>
<body>
	<form method="post" action="/jspStudy/memberRegistServlet.do">
		<table align="center" border="1">
			<script>
			<%
			String err =request.getParameter("error");
			if (err != null&&err.equals("1")) {
			%>
				alert("중복된 아이디 입니다. 다시 입력해주세요.");
			<%
			}else{if(err!=null&&err.equals("2")){
			%>
				alert("입력되지 않은 정보가있습니다. 다시 입력해주세요.");
			<%	
			}}
			%>
			</script>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
		</table>
		<div class="buttons">
			<input type="submit" value="회원가입">&nbsp;&nbsp; <input
				type="button" value="취소"
				onclick="location.href='/jspStudy/member/memberLogin.jsp';">
		</div>
	</form>
</body>
</html>