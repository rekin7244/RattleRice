package com.kh.rr.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.rr.member.model.vo.StoreInfo;

import static com.kh.rr.common.JDBCTemplate.*;

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
		
		String query = prop.getProperty("updateBusinessInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, storeUser.getCotact());
			pstmt.setString(2, storeUser.getLocation());
			pstmt.setString(3, storeUser.getOpening_hore());
			pstmt.setString(4, storeUser.getClose_hore());
			pstmt.setString(5, storeUser.getIntro());
			pstmt.setString(6, storeUser.getbId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		
		return result;
	}

}






























