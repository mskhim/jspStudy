package co.kh.dev.login.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.common.MyUtility;
import co.kh.dev.login.model.MemberDAO;
import co.kh.dev.login.model.MemberVO;

@WebServlet({ "/memberRegistServlet.do" })
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	MemberDAO mDAO = new MemberDAO();
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charSet=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberAfterRegist.jsp");
			String name = request.getParameter("name");
			String uid = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			if(MyUtility.isNullOrEmpty(name)||MyUtility.isNullOrEmpty(uid)||MyUtility.isNullOrEmpty(pwd)) {
				response.sendRedirect("/jspStudy/member/memberRegist.jsp?error=2");
				return;
			}
			
			MemberVO mvo = new MemberVO(name, uid, pwd);
			MemberVO checkMvo = mDAO.selectByIdDB(mvo);
			if(checkMvo==null) {
				mDAO.insertDB(mvo);
				request.setAttribute("name", name);
				request.setAttribute("id", uid);
				request.setAttribute("pwd", pwd);
				rd.forward(request, response);
			}else {
				response.sendRedirect("/jspStudy/member/memberRegist.jsp?error=1");
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		} 
    	
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}

}
