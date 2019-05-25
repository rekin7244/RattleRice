package com.kh.rr.common.model.dao;

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

import com.kh.rr.common.model.vo.PageInfo;

public class ReservationDao {
	private Properties prop = new Properties();
	
	public ReservationDao() {
		String fileName = ReservationDao.class.getResource("/sql/common/reserve-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int reserveSettleListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserveSettleListCount");
		int listCount = 0;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> reserveSettleList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserveSettleList");
		ArrayList<HashMap<String, Object>> list = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				HashMap<String, Object> hmap = new HashMap<String,Object>();
				hmap.put("sum",rset.getInt(1));
				hmap.put("rid", rset.getString("RID"));
				hmap.put("bcode", rset.getString("BCODE"));
				hmap.put("brand",rset.getString("BRAND"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("bankcode", rset.getString("BANKCODE"));
				hmap.put("price", rset.getString("SUM"));
				hmap.put("rDate",rset.getString("rDate"));
				hmap.put("status", rset.getString("STATUS"));
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public int reserveSettleSearchListCount(Connection con, String brand) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserveSettleSearchListCount");
		int listCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, brand);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> reserveSettleSearchList(Connection con, PageInfo pi, String brand) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reserveSettleSearchList");
		ArrayList<HashMap<String, Object>> list = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, brand);
			pstmt.setInt(2, pi.getStartPage());
			pstmt.setInt(3, pi.getEndpage());
			rset = pstmt.executeQuery();
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				HashMap<String, Object> hmap = new HashMap<String,Object>();
				hmap.put("sum",rset.getInt(1));
				hmap.put("rid", rset.getString("RID"));
				hmap.put("bcode", rset.getString("BCODE"));
				hmap.put("brand",rset.getString("BRAND"));
				hmap.put("account", rset.getString("ACCOUNT"));
				hmap.put("bankcode", rset.getString("BANKCODE"));
				hmap.put("price", rset.getString("SUM"));
				hmap.put("rDate",rset.getString("rDate"));
				hmap.put("status", rset.getString("STATUS"));
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

}
