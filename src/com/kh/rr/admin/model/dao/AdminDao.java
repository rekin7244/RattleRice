package com.kh.rr.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.rr.common.JDBCTemplate.*;

import com.kh.rr.admin.model.vo.SMS;

public class AdminDao {

	private Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = AdminDao.class.getResource("sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertSms(Connection con, SMS newsms) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertSms");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, newsms.getSmsId());
			pstmt.setDate(2, newsms.getSmsDate());
			pstmt.setString(3, newsms.getContent());
			pstmt.setString(4, newsms.getAid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
			close(pstmt);
		}
		

		return result;
	}

}
