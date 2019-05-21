package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.member.model.vo.Attachment;
import com.kh.rr.member.model.vo.BusinessMan;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;
import com.kh.rr.member.model.vo.StoreMenuInfo;


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
		System.out.println("dao 실행");
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

	public ArrayList<HashMap<String, Object>> logincheckBusiness(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
		
		StoreInfo storeinfo = null;
		StoreMenuInfo storeMenu = null;
		BusinessMan businessman = null;
		Attachment attachment = null;
		
		String query = prop.getProperty("loginCheckBusiness");
			
		try {
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
		    rset = pstmt.executeQuery();
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				//BusinessMan
				//hmap.put("bId", rset.getString("B_ID"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("bCode", rset.getString("BCODE"));
				hmap.put("bankcode",rset.getString("BANKCODE"));
				hmap.put("holder", rset.getString("HOLDER"));
				//StoreInfo
				hmap.put("contact", rset.getString("CONTACT"));
				hmap.put("location", rset.getString("LOCATION"));
				hmap.put("opening_hore", rset.getString("OPENING_HOUR"));
				hmap.put("intro", rset.getString("INTRO"));
				hmap.put("brand", rset.getString("BRAND"));
				hmap.put("sId", rset.getInt("S_ID"));
				hmap.put("status", rset.getString("STATUS"));
				hmap.put("sCode", rset.getInt("S_CODE"));
				hmap.put("close_hore", rset.getString("CLOSE_HOUR"));
				//StoreMenuInfo
				hmap.put("menu", rset.getString("MENU"));
				hmap.put("price", rset.getInt("PRICE"));
				hmap.put("origin",rset.getString("ORIGIN"));
				hmap.put("mId",rset.getInt("MID"));
				
				//Attachment
				hmap.put("fid", rset.getInt("FID"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("originName",rset.getString("ORIGIN_NAME"));
				hmap.put("changeName",rset.getString("CHANGE_NAME"));
				hmap.put("status",rset.getString("STATUS"));
				hmap.put("type",rset.getString("TYPE"));
		
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
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

	public int updatePwd(Connection con, Member member, String newUserPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updatePwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newUserPwd);
			pstmt.setString(2, member.getUserId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection con, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginUser.getUserId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> BusinessUpdateForm(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
		
		StoreInfo storeinfo = null;
		StoreMenuInfo storeMenu = null;
		BusinessMan businessman = null;
		Attachment attachment = null;
		
		String query = prop.getProperty("loginCheckBusiness");
			
		try {
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
		    rset = pstmt.executeQuery();
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				//BusinessMan
				//hmap.put("bId", rset.getString("B_ID"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("bCode", rset.getString("BCODE"));
				hmap.put("bankcode",rset.getString("BANKCODE"));
				hmap.put("holder", rset.getString("HOLDER"));
				//StoreInfo
				hmap.put("contact", rset.getString("CONTACT"));
				hmap.put("location", rset.getString("LOCATION"));
				hmap.put("opening_hore", rset.getString("OPENING_HOUR"));
				hmap.put("intro", rset.getString("INTRO"));
				hmap.put("brand", rset.getString("BRAND"));
				hmap.put("sId", rset.getInt("S_ID"));
				hmap.put("status", rset.getString("STATUS"));
				hmap.put("sCode", rset.getInt("S_CODE"));
				hmap.put("close_hore", rset.getString("CLOSE_HOUR"));
				//StoreMenuInfo
				hmap.put("menu", rset.getString("MENU"));
				hmap.put("price", rset.getInt("PRICE"));
				hmap.put("origin",rset.getString("ORIGIN"));
				hmap.put("mId",rset.getInt("MID"));
				//
				hmap.put("fid", rset.getInt("FID"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("originName",rset.getString("ORIGIN_NAME"));
				hmap.put("changeName",rset.getString("CHANGE_NAME"));
				hmap.put("status",rset.getString("STATUS"));
				hmap.put("type",rset.getString("TYPE"));
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public int pointCharge(Connection con, String amount, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("pointCharge");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, amount);
			pstmt.setString(2, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int defaultPointCharge(Connection con, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("defaultPointCharge");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "1000");
			pstmt.setString(2, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//카카오톡 로그인 시 기존 회원 인지 판단하는 매소드
	public Member kakaoCheck(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member reqMember = null;
		
		String query = prop.getProperty("kakaoCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reqMember = new Member();
				reqMember.setUserId(rset.getString("M_ID"));
				reqMember.setUserPwd(rset.getString("M_PWD"));
				reqMember.setUserName(rset.getString("M_NAME"));
				reqMember.setMemberType(rset.getString("M_TYPE"));
				reqMember.setStatus(rset.getString("M_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return reqMember;
	}





}
