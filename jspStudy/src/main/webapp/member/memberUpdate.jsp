<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
if(session.getAttribute("name")==null){
	response.sendRedirect("/jspStudy/member/memberLogin.jsp");
}
%>
<!DOCTYPE html>
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
<form method="post" action="/jspStudy/memberUpdateSurvlet.do">
		<table>

			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="48"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" size="48"></td>
			</tr>
			
		</table>
		<div class="buttons">
			<input type="submit"value="수정"> <a href="/jspStudy/member/memberMyPage.jsp"><button type="button">취소</button></a>
					</div>
</form>
</body>
</html>