<%@ page contentType="text/html; charset=UTF-8"%>
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("/jspStudy/member/memberLogin.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
<link rel="stylesheet" href="./member.css" />
</head>
<body>
	<form method="post" action="/jspStudy/memberUpdateSurvlet.do">
		<table>

			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>

		</table>
		<div class="buttons">
			<input type="submit" value="수정"> <a
				href="/jspStudy/member/memberMyPage.jsp"><button type="button">취소</button></a>
		</div>
	</form>
</body>
</html>