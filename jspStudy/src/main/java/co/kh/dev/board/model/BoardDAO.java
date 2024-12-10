package co.kh.dev.board.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kh.dev.common.DBUtility;
public class BoardDAO {
	private final String SELECT_SQL = "SELECT ROWNUM, NO, NAME,TITLE,TEXT,COUNT,SUBDATE  FROM BOARD_J_MEMBER";
	private final String SELECT_BY_TITLE_SQL = "SELECT ROWNUM, NO, NAME,TITLE,TEXT,COUNT,SUBDATE  FROM BOARD_J_MEMBER WHERE TITLE LIKE '%?%'";
	private final String SELECT_BY_RNUM_SQL = "SELECT * FROM BOARD_J_MEMBER_ROWNUM WHERE RNUM=?";
	private final String SELECT_RECORD_SQL = "SELECT COUNT(*) COUNT FROM BOARD_J_MEMBER";
	private final String INSERT_SQL = "INSERT INTO Board VALUES((SELECT NVL(MAX(NO),0)+1 FROM Board),?,?,?,0,SYSDATE)";
//	private final String DELETE_SQL = "DELETE FROM Board WHERE NO = ?";
//	private final String UPDATE_fzSQL = "UPDATE Board SET TITLE = ? , TEXT = ? WHERE NO = ?";
	
	
	//전체를 DB에서 출력
	public ArrayList<BoardVO> selectDB() {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> mList = new ArrayList<BoardVO>();
		try {
			pstmt= con.prepareStatement(SELECT_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			int rownum = rs.getInt("ROWNUM");
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String text = rs.getString("TEXT");
			int count = rs.getInt("COUNT");
			Date subdate = rs.getDate("SUBDATE");
			BoardVO mvo= new BoardVO(rownum, no, name, title, text, count, subdate);
			mList.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtility.dbClose(con,rs,pstmt);
		return mList;
	}
	
	//제목을 입력받아서 비슷한 내용들을출력
	public ArrayList<BoardVO> selectByTitleDB(BoardVO bvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> mList = new ArrayList<BoardVO>();
		try {
			pstmt= con.prepareStatement(SELECT_BY_TITLE_SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			int rownum = rs.getInt("ROWNUM");
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String title = rs.getString("TITLE");
			String text = rs.getString("TEXT");
			int count = rs.getInt("COUNT");
			Date subdate = rs.getDate("SUBDATE");
			BoardVO mvo2= new BoardVO(rownum, no, name, title, text, count, subdate);
			mList.add(mvo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtility.dbClose(con,rs,pstmt);
		return mList;
	}
	
	//ROWNUM 입력받아서 비슷한 내용들을출력
	public BoardVO selectByRowNumDB(BoardVO bvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt= con.prepareStatement(SELECT_BY_RNUM_SQL);
			pstmt.setInt(1, bvo.getRownum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int rownum = rs.getInt("RNUM");
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String title = rs.getString("TITLE");
				String text = rs.getString("TEXT");
				int count = rs.getInt("COUNT");
				Date subdate = rs.getDate("SUBDATE");
				bvo= new BoardVO(rownum, no, name, title, text, count, subdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtility.dbClose(con,rs,pstmt);
		return bvo;
	}
	
	//BOARD의 레코드 개수를 출력
	public int selectRecordDB() {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt= con.prepareStatement(SELECT_RECORD_SQL);
			rs = pstmt.executeQuery();
				if(rs.next()) {
				count = rs.getInt("COUNT");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}DBUtility.dbClose(con,rs,pstmt);
		return count;
	}
	
	public Boolean insertDB(BoardVO bvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			pstmt= con.prepareStatement(INSERT_SQL);
			pstmt.setInt(1, bvo.getMemberNo());
			pstmt.setString(2, bvo.getTitle());
			pstmt.setString(3, bvo.getText());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtility.dbClose(con,pstmt);
		return (rs==0)?false:true;
	}
	
//	public Boolean deleteDB(BoardVO mvo) {
//		Connection con = DBUtility.dbCon();
//		PreparedStatement pstmt = null;
//		int rs = 0;
//		try {
//			pstmt= con.prepareStatement(DELETE_SQL);
//			pstmt.setInt(1, mvo.getNo());
//			rs = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DBUtility.dbClose(con,pstmt);
//		return (rs==0)?false:true;
//	}
	
//	public Boolean updateDB(BoardVO mvo) {
//		Connection con = DBUtility.dbCon();
//		PreparedStatement pstmt = null;
//		int rs = 0;
//		try {
//			pstmt= con.prepareStatement(UPDATE_SQL);
//			pstmt.setString(1, mvo.getName());
//			pstmt.setString(2, mvo.getPwd());
//			pstmt.setString(3, mvo.getId());
//			rs = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		DBUtility.dbClose(con,pstmt);
//		return (rs==0)?false:true;
//	}
}