package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Member loginCheck(Connection con, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member loginUser = null;
		
		String query = prop.getProperty("loginCheck");
		/*System.out.println(query);
		System.out.println(userId);
		System.out.println(password);*/
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member();
				
				loginUser.setUserId(rset.getString("USER_Id"));
				loginUser.setUserPwd(rset.getString("USER_PWD"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setMemberKind(rset.getString("MEMBER_KIND"));
				loginUser.setStatus(rset.getString("STATUS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("dao에서 보낸 member객체" + loginUser);
		
		return loginUser;
	}

	public int insertMember(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getUserId());
			pstmt.setString(2, reqMember.getUserPwd());
			pstmt.setString(3, reqMember.getUserName());
			pstmt.setString(4, reqMember.getMemberKind());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertBusinessMember(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertBusinessMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getUserId());
			pstmt.setString(2, reqMember.getUserPwd());
			pstmt.setString(3, reqMember.getUserName());
			pstmt.setString(4, reqMember.getMemberKind());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
