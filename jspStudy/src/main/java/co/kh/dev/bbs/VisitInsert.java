package co.kh.dev.bbs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "visitInsert", urlPatterns = { "/visitInsert" })
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisitInsert() {
		super();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-1. 전송된 값을 UTF-8 세팅.
		request.setCharacterEncoding("UTF-8");
		// 1-2. 정보 가져오기
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		String VISIT_INSERT = "INSERT INTO VISIT VALUES(VISIT_SEQ.NEXTVAL,?,?,SYSDATE)";

		// 2. 테이블에 저장한다.(프로토콜)
		Connection con = null;
		boolean flag = false;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String id = "webuser";
		String pw = "123456";
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문 사용할게 하는 명령문
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
			pstmt = con.prepareStatement(VISIT_INSERT);
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			int count = pstmt.executeUpdate();
			flag=(count != 0) ? true : false;
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			if (con != null) {
				try {
					con.close();

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();

				} catch (SQLException e) {
					System.out.println(e.toString());
				}
			}
		}//finally
		if(flag) {
			System.out.println("입력성공");
			response.sendRedirect("visitList");
		}else {
			System.out.println("입력실패");
		}
		
	}

}
