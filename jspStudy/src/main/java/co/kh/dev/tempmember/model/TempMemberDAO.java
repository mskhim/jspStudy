package co.kh.dev.tempmember.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.kh.dev.common.DBUtility;

public class TempMemberDAO {
	private final String SELECT_SQL = "SELECT * FROM TempMember ";

	// 전체를 DB에서 출력
	public ArrayList<TempMemberVO> selectDB() {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TempMemberVO> mList = new ArrayList<TempMemberVO>();
		try {
			pstmt = con.prepareStatement(SELECT_SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");            // 사용자 ID
				String passwd = rs.getString("PASSWD");    // 비밀번호
				String name = rs.getString("NAME");        // 이름
				String memNum1 = rs.getString("MEM_NUM1"); // 주민등록번호 앞자리
				String memNum2 = rs.getString("MEM_NUM2"); // 주민등록번호 뒷자리
				String email = rs.getString("E_MAIL");     // 이메일
				String phone = rs.getString("PHONE");      // 전화번호
				String zipcode = rs.getString("ZIPCODE");  // 우편번호
				String address = rs.getString("ADDRESS");  // 주소
				String job = rs.getString("JOB");          // 직업
				TempMemberVO mvo = new TempMemberVO(id, passwd, name, memNum1, memNum2, email, phone, zipcode, address, job);
				mList.add(mvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtility.dbClose(con, rs, pstmt);
		return mList;
	}

}
