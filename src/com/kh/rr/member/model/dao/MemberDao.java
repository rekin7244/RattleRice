package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;
import com.kh.rr.member.model.vo.UserInfo;


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
		StoreInfo storeinfo = null;
		
		String query = prop.getProperty("loginCheck");
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member();
				
				loginUser.setUserId(rset.getString("M_ID"));
				loginUser.setUserPwd(rset.getString("M_PWD"));
				loginUser.setUserName(rset.getString("M_NAME"));
				loginUser.setMemberType(rset.getString("M_TYPE"));
				loginUser.setStatus(rset.getString("M_STATUS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
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
			pstmt.setString(4, reqMember.getMemberType());

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
			pstmt.setString(4, reqMember.getMemberType());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> logincheckBusiness(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginCheckBusiness");
			
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				//BusinessMan
				hmap.put("bId", rset.getString("B_ID"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("bankcode",rset.getString("BANKCODE"));
				hmap.put("holder", rset.getString("HOLDER"));
				hmap.put("bCode", rset.getString("BCODE"));
				//StoreInfo
				hmap.put("contact", rset.getString("CONTACT"));
				hmap.put("location", rset.getString("LOCATION"));
				hmap.put("opening_hore", rset.getString("OPENING_HOUR"));
				hmap.put("intro", rset.getString("INTRO"));
				hmap.put("brand", rset.getString("BRAND"));
				hmap.put("sId", rset.getString("S_ID"));
				hmap.put("status", rset.getString("STATUS"));
				hmap.put("sCode", rset.getString("S_CODE"));
				hmap.put("close_hore", rset.getString("CLOSE_HOUR"));
				//StoreMenuInfo
				hmap.put("menu", rset.getString("MENU"));
				hmap.put("price", rset.getInt("PRICE"));
				hmap.put("origin",rset.getString("ORIGIN"));
				hmap.put("mId",rset.getString("MID"));
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}

	public int idCheck(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("idCheck");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}





}
