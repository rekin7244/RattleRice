package com.kh.rr.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import static com.kh.rr.common.JDBCTemplate.*;

public class StatisticsDao {
	private Properties prop = new Properties();
	
	public StatisticsDao() {
		String fileName = StatisticsDao.class.getResource("/sql/admin/statistics-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] statisticsMember(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsMember");
		int[] mArr = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			mArr = new int[3];
			int idx = 0;
			while(rset.next()) {
				mArr[idx++] = rset.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return mArr;
	}

	public ArrayList<HashMap<String, Object>> statisticsStore(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsStore");
		ArrayList<HashMap<String, Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<HashMap<String, Object>>();
			while(rset.next()) {
				HashMap<String, Object> hmap = new HashMap<String, Object>();
				hmap.put("value", rset.getInt("COUNT(*)"));
				hmap.put("location",rset.getString("LOCATION"));
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsSales(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsSales");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> hmap = new HashMap<String,Object>();
				hmap.put("sales", rset.getInt("sumPrice"));
				hmap.put("month", rset.getString("month"));
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

}
