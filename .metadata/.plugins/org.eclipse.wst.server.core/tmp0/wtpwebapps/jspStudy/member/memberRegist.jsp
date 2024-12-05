<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
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
	<form method="post" action="/jspStudy/memberRegistServlet.do">
		<table align="center" border="1">
	<%if(request.getParameter("error")!=null){ %>
	 <script>
            alert("사용할 수 없는 계정입니다. 다시 입력해주세요.");
   </script>
	<%} %>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="60"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" size="60"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" size="60"></td>
			</tr>
		</table>
			<div class="buttons">
		<input type="submit"
					value="회원가입">&nbsp;&nbsp; <input type="button" value="취소" onclick="location.href='/jspStudy/member/memberLogin.jsp';">
			</div>
	</form>
</body>
</html>