package com.kh.w6.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.w6.member.controller.JoinServlet;
import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.vo.Member;
import static com.kh.w6.common.JDBCTemplate.*;

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

	// 로그인 요청 상태 확인용 메소드
	public int checkStatus(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 99;

		String query = prop.getProperty("checkStatus");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserId());

			rset = pstmt.executeQuery();

			String userId = "";
			String password = "";

			if (rset.next()) {
				userId = rset.getString("USER_ID");
				password = rset.getString("USER_PWD");
			}

			if (requestMember.getUserId().equals(userId) && requestMember.getUserPwd().equals(password)) {
				result = LoginServlet.LOGIN_OK;
			} else if (requestMember.getUserId().equals(userId) && !requestMember.getUserPwd().equals(password)) {
				result = LoginServlet.WRONG_PASSWORD;
			} else {
				result = LoginServlet.ID_NOT_EXIST;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;

		String query = prop.getProperty("selectMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserId());
			pstmt.setString(2, requestMember.getUserPwd());

			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginUser = new Member();

				loginUser.setUserId(rset.getString("USER_ID"));
				loginUser.setUserPwd(rset.getString("USER_PWD"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setAge(rset.getInt("AGE"));
				loginUser.setEmail(rset.getString("EMAIL"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setAddress(rset.getString("ADDRESS"));
				loginUser.setHobby(rset.getString("HOBBY"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUser;
	}
	
	public int insertMember(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMember");
		
		System.out.println(query);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, requestMember.getUserId());
			pstmt.setString(2, requestMember.getUserPwd());
			pstmt.setString(3, requestMember.getUserName());
			pstmt.setString(4, requestMember.getGender());
			pstmt.setInt(5, requestMember.getAge());
			pstmt.setString(6, requestMember.getEmail());
			pstmt.setString(7, requestMember.getPhone());
			pstmt.setString(8, requestMember.getAddress());
			pstmt.setString(9, requestMember.getHobby());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/*public int checkMember(Connection con, Member requestMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = JoinServlet.JOIN_OK;

		String query = prop.getProperty("checkAll");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			String userId = "";

			while (rset.next()) {

				userId = rset.getString("USER_ID");

				if (requestMember.getUserId().equals(userId)) {
					result = JoinServlet.JOIN_X;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}*/

	

}
