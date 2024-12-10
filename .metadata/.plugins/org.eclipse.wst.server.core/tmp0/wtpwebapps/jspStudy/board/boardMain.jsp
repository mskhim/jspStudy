<%@page import="co.kh.dev.board.model.BoardDAO"%>
<%@page import="co.kh.dev.board.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardDAO bDAO = new BoardDAO();
int viewTime = 10;
int pageNum = 1;
if (request.getParameter("viewTime") != null) {
	viewTime = Integer.parseInt(request.getParameter("viewTime"));
}
if (request.getParameter("pageNum") != null) {
	pageNum = Integer.parseInt(request.getParameter("pageNum"));
}
ArrayList<BoardVO> bList = new ArrayList<BoardVO>();
bList = bDAO.selectDB();//전체 db를 출력
int recordCount = bDAO.selectRecordDB();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://kit.fontawesome.com/6ff644124c.js"	crossorigin="anonymous"></script>
<jsp:include page="/board/css/allCss.jsp" />
<style>
.participation:nth-of-type(2) {
	background-color: #4a4a4a; /* 짙은 회색 */
	color: white; /* 텍스트 흰색 */
	font-weight: bold; /* 텍스트 굵게 */
	margin: 0px 10px;
}
li a.pageNumber:nth-of-child(1) {
	background-color: rgb(114, 114, 114);
	color: white;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/board/carousel.jsp" />
	</header>
	<main>
		<section>
			<article class="article1" align="center">
				<div class="head">
					<h1>칭찬합시다</h1>
				</div>
				<div class="head">
					<ul>
						<a href=""><li><i class="fa-solid fa-house"></i></li></a>
						<a href=""><li>국립공원공단 ></li></a>
						<a href=""><li>국민소통 ></li></a>
						<a href=""><li>국민참여 ></li></a>
						<a href=""><li>칭찬합시다</li></a>
					</ul>
				</div>
			</article>
			<article class="article2">
				<p class="notice">- 본 게시판과 관련이 없거나 상업적인 내용, 특정인이나 특정사안을 비방하는 내용
					등은 예고없이 삭제될 수 있습니다.</p>
			</article>
			<article class="article3">
				<div class="all">
					<form method="get" action="/jspStudy/boardViewTimeServlet.do">
						<select name="viewTime" id="view">
							<option value="10">10개씩</option>
							<option value="20">20개씩</option>
						</select>
						<button type="submit" id="BoardViewButton">보기</button>
					</form>
					<form method="get" action="boardFind.do">
						<select name="find" id="find">
							<option value="1">제목</option>
							<option value="2">내용</option>
						</select> <input type="text" name="findText" id="findText" />
						<button type="button" id="findButton">검색</button>
					</form>
				</div>
			</article>
			<article class="article4">
				<table>
					<tr>
						<th>번호</th>
						<th>공원명</th>
						<th width="300">제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>등록일</th>
					</tr>
					<%
					int viewNum = viewTime;
					if ((recordCount - (pageNum) * viewTime) < 0) {
						viewNum = recordCount % viewTime;
					}
					for (int i = 1; i <= viewNum; i++) {//viewTime 개수만큼 보여주고 num같은경우는 pageNum을 이용해서 원하는 번호가 출력되게 만들어야함.
						int num = recordCount - i - ((pageNum - 1) * viewTime);
					%>
					<tr>
						<td class="tbNum"><%=bList.get(num).getRownum()%></td>
						<td class="tbName">북한산</td>
						<td class="tbMain"><a
							href=" <%=request.getContextPath()%>/board/boardWriteInside.jsp?rowNum=<%=num + 1%>"><%=bList.get(num).getTitle()%></a></td>
						<td class="tbWriter"><%=bList.get(num).getName()%></td>
						<td class="tbView"><%=bList.get(num).getCount()%></td>
						<td class="tbDate"><%=bList.get(num).getSubdate()%></td>
					</tr>
					<%
					}
					%>

				</table>
			</article>
			<article class="article5">
					<ul>
						<a href="#">
							<li><i class="fa-solid fa-angles-left"></i></li>
						</a>
						<a href="#">
							<li><i class="fa-solid fa-angle-left"></i></li>
						</a>
						<%
						int pgNum = recordCount / viewTime + 1;
						int pageEndNum = 10;
						int pageStartNum = 1;
						if (pgNum > 10) {
							pageEndNum = 10;
						}else{
							pageEndNum = pgNum;
						}
						for (int i = pageStartNum; i <= pageEndNum; i++) {
						%>
						<li>
						<a class="pageNumber" href="<%= request.getRequestURI()%>?pageNum=<%=i%>&viewTime=<%=viewTime%>">
						<%=i%>
						</a>
						</li>
						<%
						}
						%>
						<a href="#">
							<li><i class="fa-solid fa-chevron-right"></i></li>
						</a>
						<a href="#">
							<li><i class="fa-solid fa-angles-right"></i></li>
						</a>
					</ul>

				<form action="#" method="get" name="boardWrite.do">
					<button type="button" id="writeButton"
						onclick="location.href='/jspStudy/board/boardWrite.jsp';">글쓰기</button>
				</form>
			</article>
		</section>
	
		<section class="loginSection">
		<%@ include file="/member/memberLogin.jsp" %>
		</section>
	</main>
	<footer>
	<section>
	<h1>footer</h1>
	</section>
	</footer>
	<script src="./js/board.js"></script>
</body>
</html>
