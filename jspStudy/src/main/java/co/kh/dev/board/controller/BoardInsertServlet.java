package co.kh.dev.board.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.board.model.BoardDAO;
import co.kh.dev.board.model.BoardVO;

@WebServlet({ "/boardInsertServlet.do" })
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardInsertServlet() {
        super();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    BoardDAO bDAO = new BoardDAO();
    	HttpSession session=request.getSession();
    int no = (int)session.getAttribute("no");
    BoardVO bvo= new BoardVO(no, request.getParameter("title"), request.getParameter("text"));
    bDAO.insertDB(bvo);
    try {
		response.sendRedirect("/jspStudy/board/boardMain.jsp");
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}

}
