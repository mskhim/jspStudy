package co.kh.dev.board.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/boardViewTime.do" })
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardSelectServlet() {
        super();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    		try {
				if (request.getParameter("viewTime")!=null&&request.getParameter("viewTime").equals("20")) {
					response.sendRedirect("/jspStudy/board/boardMain.jsp?viewTime=20");
					}else {
						response.sendRedirect("/jspStudy/board/boardMain.jsp?viewTime=10");
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
