package co.kh.dev.login.controler;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kh.dev.login.model.MemberVO;

@WebServlet({ "/memberRegistServlet.do" })
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	MemberDAO mDAO = new MemberDAO();
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charSet=UTF-8");
			String name = request.getParameter("name");
			String uid = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			MemberVO mvo = new MemberVO(name, uid, pwd);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberAfterRegist.jsp");
			boolean insertFlag = mDAO.insertDB(mvo);
			if(insertFlag) {
				request.setAttribute("name", name);
				request.setAttribute("id", uid);
				request.setAttribute("pwd", pwd);
				rd.forward(request, response);
			}else {
				response.sendRedirect("/jspStudy/member/memberRegist.jsp?error=1");
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
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
