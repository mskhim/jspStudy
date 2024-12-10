<%@page import="co.kh.dev.tempmember.model.TempMemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.kh.dev.tempmember.model.TempMemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
TempMemberDAO tDAO = new TempMemberDAO();
ArrayList<TempMemberVO> tList = tDAO.selectDB();
%>
	
<!DOCTYPE html>
<html>
<head>
<title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
	<h2>JSP 스크립틀릿에서 데이터베이스 연동 예제입니다....</h2>
	<br></br>
	<h3>회원정보</h3>
	<table bordercolor="#0000ff" border="1">
		<tr>
			<td><strong>ID</strong></td>
			<td><strong>PASSWD</strong></td>
			<td><strong>NAME</strong></td>
			<td><strong>MEM_NUM1</strong></td>
			<td><strong>MEM_NUM2</strong></td>
			<td><strong>E_MAIL</strong></td>
			<td><strong>PHONE</strong></td>
			<td><strong>ZIPCODE/ADDRESS</strong></td>
			<td><strong>JOB</strong></td>
		</tr>
		
		<%
		int count = 0;
		for(TempMemberVO data : tList){
		%>
		<tr>
<td><%= data.getId() %></td>
<td><%= data.getPasswd() %></td>
<td><%= data.getName() %></td>
<td><%= data.getMemNum1() %></td>
<td><%= data.getMemNum2() %></td>
<td><%= data.getEmail() %></td>
<td><%= data.getPhone() %></td>
<td><%= data.getZipcode() %> / <%= data.getAddress() %></td>
<td><%= data.getJob() %></td>
		<%
		count++;
		}
		%>
</tr>
</table><br></br>
total records : <%= count %>
</body>
</html>