package co.kh.dev.login.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import co.kh.dev.login.model.MemberDAO;
import co.kh.dev.login.model.MemberVO;

@WebServlet({ "/memberloginCheckServlet.do" })
public class MemberLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDAO mDAO = new MemberDAO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVO mvo = new MemberVO(null, id, pwd);
		MemberVO idCheckmvo = mDAO.selectByIdDB(mvo);
		MemberVO loginCheckmvo = mDAO.selectLoginCheckDB(mvo);
		
		try {
			if (idCheckmvo == null) {
				response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=2");//아이디일치 x
			}else {
				if (loginCheckmvo== null) {
					response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=1");//비밀번호일치 x
				}else {
					session.setAttribute("no", loginCheckmvo.getNo());
					session.setAttribute("id", loginCheckmvo.getId());
					session.setAttribute("pwd", loginCheckmvo.getPwd());
					session.setAttribute("name", loginCheckmvo.getName());
					response.sendRedirect("/jspStudy/member/memberLogin.jsp");
				}
				
			}

			
		} catch (Exception e) {
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
