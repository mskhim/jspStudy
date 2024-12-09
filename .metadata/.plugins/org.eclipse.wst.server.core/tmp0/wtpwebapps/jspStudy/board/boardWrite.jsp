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
<script src="https://kit.fontawesome.com/6ff644124c.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./boardWrite.css" />
<style>

.participation:nth-of-type(2) {
  background-color: #4a4a4a; /* 짙은 회색 */
  color: white; /* 텍스트 흰색 */
  font-weight: bold; /* 텍스트 굵게 */
  margin: 0px 10px;
}
</style>
</head>
<body>
	<header>
		<a href="#"><img src="./media/slide-1.jpg" alt="" id="img1" /></a> <a
			href="#"><img src="./media/slide-2.jpg" alt="" id="img4" /></a> <a
			href="#"><img src="./media/slide-3.jpg" alt="" id="img3" /></a> <a
			href="#"><img src="./media/slide-4.jpg" alt="" id="img2" /></a> <i
			class="fa-solid fa-circle-chevron-left" id="navgateleft"></i> <i
			class="fa-solid fa-circle-chevron-right" id="navgateright"></i>
		<div id="indicator">
			<a href="#" class="active"> <i class="fa-solid fa-circle-dot"></i>
			</a> <a href="#"> <i class="fa-solid fa-circle-dot"></i></a><a href="#">
				<i class="fa-solid fa-circle-dot"></i>
			</a><a href="#"> <i class="fa-solid fa-circle-dot"></i></a>
		</div>
	</header>
	<main>
		<nav>
			<h2>국민소통</h2>
			<h4>국민참여</h4>
			<ul>
				<li class="participation"><a href="#">이벤트</a></li>
				<li class="participation"><a href="#">칭찬합시다</a></li>
				<li class="participation"><a href="#">궁급합니다</a></li>
				<li class="participation"><a href="#">제안합니다</a></li>
				<li class="participation"><a href="#">국민신고방(불법산행)</a></li>
			</ul>
			<h4>혁신제안</h4>
			<ul>
				<a href="#"><li>기업성장응답센터</li></a>
				<a href="#"><li>사회적가치, 혁신 우수사례</li></a>
			</ul>
			<h4>클린신고센터</h4>
			<ul>
				<a href="#"><li>공익신고</li></a>
				<a href="#"><li>소득행정신고</li></a>
				<a href="#"><li>갑질신고</li></a>
				<a href="#"><li>청탁금지법 위반신고</li></a>
				<a href="#"><li>사이버감사실</li></a>
				<a href="#"><li>예산낭비신고</li></a>
				<a href="#"><li>갑질행위 공개</li></a>
			</ul>
		</nav>
		<section>
			<article class="article1">
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
				<form action="/jspStudy/boardInsertServlet.do" method="get" name="boardWrite">
				<h2>제목 입력</h2>
				<input type="text" name="title" class="title">
				<h2>내용</h2>
				<textarea name="text" class="text">
				</textarea>
					<button type="submit" id="writeButton">등록</button>
				</form>
		</section>
	</main>
	<script src="./board.js"></script>
</body>
</html>
