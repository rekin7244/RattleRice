package com.kh.rr.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.rr.member.model.vo.UserInfo;
import static com.kh.rr.common.JDBCTemplate.*;

public class UserInfoDao {
	private Properties prop = new Properties();
	
	public UserInfoDao() {
		String fileName = UserInfoDao.class.getResource("/sql/member/memberquery.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public UserInfo userInfo(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserInfo reqUi = null;
		String query = prop.getProperty("userInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			reqUi = new UserInfo();
			if(rset.next()) {
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return reqUi;
	}

}



















