package com.kh.rr.common.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kh.rr.common.model.vo.IndexInfo;
import static com.kh.rr.common.JDBCTemplate.*;

public class IndexDao {
	private Properties prop = new Properties();
	
	public IndexDao() {
		String fileName = IndexDao.class
					.getResource("/sql/common/index-query.properties")
					.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IndexInfo selectIndexInfo(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectIndexInfo");
		IndexInfo info = null;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			info = new IndexInfo();
			while(rset.next()) {
				info.setsInfo(rset.getString("SINFO"));
				info.setsService(rset.getString("SSERVICE"));
				info.setTerms(rset.getString("TERMS"));
				//info.setContact(rset.getString("CONTACT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return info;
	}

	public int disableSiteInfo(Connection con) {
		Statement stmt = null;
		int result = 0;
		String sql = prop.getProperty("disableSiteInfo");
		
		try {
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return result;
	}
	
	public int updateSiteInfo(Connection con, IndexInfo info, IndexInfo oldInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateSiteInfo");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getsInfo());
			pstmt.setString(2, oldInfo.getsService());
			pstmt.setString(3, oldInfo.getTerms());
			pstmt.setString(4, info.getContact());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateTerms(Connection con, String terms, IndexInfo oldInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateSiteInfo");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oldInfo.getsInfo());
			pstmt.setString(2, oldInfo.getsService());
			pstmt.setString(3, terms);
			pstmt.setString(4, oldInfo.getContact());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
