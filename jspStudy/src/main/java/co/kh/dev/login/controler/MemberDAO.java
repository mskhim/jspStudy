package co.kh.dev.login.controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.kh.dev.login.model.MemberVO;
import co.kh.dev.common.DBUtility;
public class MemberDAO {
	private final String SELECT_SQL = "SELECT * FROM MEMBER ORDER BY NO";
	private final String SELECT_BY_ID_SQL = "SELECT * FROM MEMBER WHERE ID = ?";
	private final String SELECT_LOGIN_CHECK_SQL = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
	private final String INSERT_SQL = "INSERT INTO MEMBER VALUES((SELECT NVL(MAX(NO),0)+1 FROM MEMBER),?,?,?,SYSDATE)";
	private final String DELETE_SQL = "DELETE FROM MEMBER WHERE NO = ?";
	private final String UPDATE_SQL = "UPDATE MEMBER SET NAME= ? , PWD = ? WHERE ID = ?";
	
	//전체를 DB에서 출력
	public ArrayList<MemberVO> selectDB() {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> mList = new ArrayList<MemberVO>();
		try {
			pstmt= con.prepareStatement(SELECT_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			Date regdate = rs.getDate("REGDATE");
			MemberVO mvo= new MemberVO(no, name, id, pwd, regdate);
			mList.add(mvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	//아이디를 받아서 아이디에 맞는 레코드 출력
	public MemberVO selectByIdDB(MemberVO mvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt= con.prepareStatement(SELECT_BY_ID_SQL);
			pstmt.setString(1, mvo.getId());
			rs = pstmt.executeQuery();
				rs.next();
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				Date regdate = rs.getDate("REGDATE");
				mvo= new MemberVO(no, name, id, pwd, regdate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvo;
	}
	
	//id, pwd를받아서 맞는 레코드를 출력
	public MemberVO selectLoginCheckDB(MemberVO mvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt= con.prepareStatement(SELECT_LOGIN_CHECK_SQL);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			rs = pstmt.executeQuery();
				rs.next();
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				Date regdate = rs.getDate("REGDATE");
				mvo= new MemberVO(no, name, id, pwd, regdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mvo;
	}
	
	public Boolean insertDB(MemberVO mvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt= con.prepareStatement(INSERT_SQL);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getId());
			pstmt.setString(3, mvo.getPwd());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rs==0)?false:true;
	}
	
	public Boolean deleteDB(MemberVO mvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt= con.prepareStatement(DELETE_SQL);
			pstmt.setInt(1, mvo.getNo());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rs==0)?false:true;
	}
	
	public Boolean updateDB(MemberVO mvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt= con.prepareStatement(UPDATE_SQL);
			pstmt.setString(1, mvo.getName());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getId());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rs==0)?false:true;
	}
}
