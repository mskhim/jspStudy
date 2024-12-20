package co.kh.dev.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "visitList", urlPatterns = { "/visitList" })
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisitList() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head><title>방명록 리스트</title></head>");
			out.println("<body>");
			String VISIT_INSERT = "select * from visit order by no desc";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webuser", "123456");
				pstmt = con.prepareStatement(VISIT_INSERT);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int no = rs.getInt("no");
					String writer = rs.getString("writer");
					String memo = rs.getString("memo");
					java.sql.Date regdate = rs.getDate("regdate");
					out.println("<table align=center width=500 border=1>");
					out.println("<tr>");
					out.println("<th width=50>번호</th>");
					out.println("<td width=50 align=center>" + no + "</td>");
					out.println("<th width=70>작성자</th>");
					out.println("<td width=180 align=center>" + writer + "</td>");
					out.println("<th width=50>날짜</th>");
					out.println("<td width=100 align=center>" + regdate + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<th width=50>내용</th>");
					out.println("<td colspan=5>&nbsp;<textarea rows=3 cols=50>" + memo + "</textarea></td>");
					out.println("</tr>");
					out.println("</table>");
					out.println("<p>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
				} catch (SQLException e) {
				}
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
				}
			}
			out.println("<p align=center><a href=/jspStudy/bbs/write.html>글쓰기</a></p>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}

	}

}
