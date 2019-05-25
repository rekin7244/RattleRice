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
				hmap.put("brand",rset.getString("BRAND"));
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
