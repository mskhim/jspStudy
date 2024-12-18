package co.kh.dev.login.controler;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			if (idCheckmvo.getRegdate() != null) {

				if (loginCheckmvo.getRegdate() != null) {
					session.setAttribute("id", mvo.getId());
					session.setAttribute("pwd", mvo.getPwd());
					session.setAttribute("name", mvo.getName());
					response.sendRedirect("/jspStudy/member/memberLogin.jsp");
				} else {
					response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=1");//비밀번호일치 x
				}
			} else {
				response.sendRedirect("/jspStudy/member/memberLogin.jsp?error=2");//아이디일치 x
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
