package co.kh.dev.login.controler;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kh.dev.login.model.MemberVO;

@WebServlet({ "/memberUpdateSurvlet.do" })
public class MemberUpdateSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
	try {
		MemberDAO mDAO = new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String id = (String)session.getAttribute("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO mvo = new MemberVO(name, id, pwd);
		boolean updateFlag = mDAO.updateDB(mvo);
		if(updateFlag) {
			session.setAttribute("name",name);
			session.setAttribute("pwd",pwd);
		response.sendRedirect("/jspStudy/member/memberMyPage.jsp");}
		else {
			response.sendRedirect("/jspStudy/member/memberMyPage.jsp?error=1");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}
}
