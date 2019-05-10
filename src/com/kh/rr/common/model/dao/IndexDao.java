package com.kh.rr.common.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return info;
	}
	
	
}
