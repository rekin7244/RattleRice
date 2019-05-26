package com.kh.rr.admin.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

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
				hmap.put("value", rset.getInt("count"));
				hmap.put("location",rset.getString("location"));
				
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

	public ArrayList<HashMap<String, Object>> statisticsCoinCharge(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsCoin");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> hmap = new HashMap<String,Object>();
				hmap.put("charge", rset.getInt("charge"));
				hmap.put("use",rset.getInt("use"));
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

	public ArrayList<HashMap<String, Object>> statisticsSettle(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsSettle");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("sum", rset.getInt("sumPrice"));
				h.put("month",rset.getString("MONTH"));
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsRefund(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsRefund");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("sum",rset.getInt("sum"));
				h.put("month",rset.getString("month"));
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> getStores(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getStoreLocation");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("brand", rset.getString("BRAND"));
				h.put("lat",rset.getDouble("LAT"));
				h.put("lon", rset.getDouble("LON"));
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> serviceTime(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("serviceTime");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("time", rset.getString("time"));
				h.put("value", rset.getInt("value"));
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> servicePlace(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("servicePlace");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				String str[] = rset.getString("place").split(" ");
				if(str.length > 1) {
					h.put("place", str[1]);
				}else {
					h.put("place",rset.getString("place"));
				}
				h.put("value", rset.getInt("value"));
				
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsServiceCategory(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("serviceCategory");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("category", rset.getString("category"));
				h.put("value", rset.getInt("value"));
				
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsMemberbyJob(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("statisticsJob");
		ArrayList<HashMap<String,Object>> list = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<HashMap<String,Object>>();
			while(rset.next()) {
				HashMap<String,Object> h = new HashMap<String,Object>();
				h.put("job", rset.getString("JOB"));
				h.put("count", rset.getInt("COUNT"));
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}

}
