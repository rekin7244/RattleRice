package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.StoreInfo;
import com.kh.rr.member.model.vo.StoreMenuInfo;

public class BusinessDao {
	private Properties prop = new Properties();
	
	public BusinessDao() {
		String fileName = BusinessDao.class.getResource("/sql/business/business-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int businessInfoUpdate(Connection con, StoreInfo storeUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(storeUser.getbId());
		String query = prop.getProperty("updateBusinessInfo");
		
		//브랜드 추가
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, storeUser.getCotact());
			pstmt.setString(2, storeUser.getLocation());
			pstmt.setString(3, storeUser.getOpening_hore());
			pstmt.setString(4, storeUser.getClose_hore());
			pstmt.setString(5, storeUser.getIntro());
			pstmt.setString(6, storeUser.getBrand());
			pstmt.setString(7, storeUser.getbId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		
		return result;
	}

	public int insertStoreInfo(Connection con, StoreInfo storeInfo, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertStoreInfo");
		
		System.out.println(member.getUserId());
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, storeInfo.getCotact());
			pstmt.setString(2, storeInfo.getLocation());
			pstmt.setString(3, storeInfo.getOpening_hore());
			pstmt.setString(4, storeInfo.getIntro());
			pstmt.setString(5, storeInfo.getBrand());
			pstmt.setString(6, member.getUserId());
			
			result = pstmt.executeUpdate();
			
			System.out.println(storeInfo);
			System.out.println("비즈니스 dao 가게 정보" +  query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	public int insertStoreInfo(Connection con, StoreMenuInfo storeMenuInfo, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		
		String selectQuery = prop.getProperty("selectStoreInfo");
		System.out.println(selectQuery); 
		
		
		try {
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, member.getUserId());
			
			rset= pstmt.executeQuery();
			hmap = new HashMap<String, Object>();
			while (rset.next()) {
				hmap.put("s_id", rset.getInt("S_ID"));
				hmap.put("s_code", rset.getInt("S_CODE"));
			}
			System.out.println("hmap : " + hmap);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			//close(rset);
		}
				
		
		String query = prop.getProperty("insertMenuInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, storeMenuInfo.getMenu());
			pstmt.setString(2, storeMenuInfo.getPrice());
			pstmt.setString(3, storeMenuInfo.getOrigin());
			pstmt.setInt(4, (int) hmap.get("s_id"));
			pstmt.setInt(5, (int) hmap.get("s_code"));
			
			result = pstmt.executeUpdate();
			
			System.out.println(storeMenuInfo);
			System.out.println("비지니스 dao 메뉴" + query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMenu(Connection con, StoreMenuInfo menuInfo, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		/*ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		
		String selectQuery = prop.getProperty("selectStoreInfo");
		
		
		
		try {
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, loginUser.getUserId());
			
			rset= pstmt.executeQuery();
			hmap = new HashMap<String, Object>();
			while (rset.next()) {
				hmap.put("s_id", rset.getInt("S_ID"));
				hmap.put("s_code", rset.getInt("S_CODE"));
			}
			System.out.println("hmap : " + hmap);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			//close(rset);
		}*/
		
		String query = prop.getProperty("menuUpdate");
		System.out.println(query);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menuInfo.getMenu());
			pstmt.setString(2, menuInfo.getPrice());
			pstmt.setString(3, menuInfo.getOrigin());
			pstmt.setString(4, menuInfo.getmId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	public int insertMenu(Connection con, StoreMenuInfo menuInfo, Member loginUser) {
		System.out.println("insertMenuDao들어옴");
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		
		String selectQuery = prop.getProperty("selectStoreInfo");
		System.out.println(selectQuery); 
		
		
		try {
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, loginUser.getUserId());
			
			rset= pstmt.executeQuery();
			hmap = new HashMap<String, Object>();
			while (rset.next()) {
				hmap.put("s_id", rset.getInt("S_ID"));
				hmap.put("s_code", rset.getInt("S_CODE"));
			}
			System.out.println("hmap : " + hmap);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			//close(rset);
		}
		
		String query = prop.getProperty("insertMenu");
		System.out.println(query);
		System.out.println(menuInfo);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menuInfo.getMenu());
			pstmt.setString(2, menuInfo.getPrice());
			pstmt.setString(3, menuInfo.getOrigin());
			pstmt.setInt(4, (int) hmap.get("s_id"));
			pstmt.setInt(5, (int) hmap.get("s_code"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return result;
	}

	

}





