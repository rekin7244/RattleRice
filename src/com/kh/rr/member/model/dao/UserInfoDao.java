package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.rr.member.model.vo.UserInfo;

public class UserInfoDao {
	private Properties prop = new Properties();
	
	public UserInfoDao() {
		String fileName = UserInfoDao.class.getResource("/sql/member/userInfo-query.properties").getPath();
		
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
			
			if(rset.next()) {
				reqUi = new UserInfo();
				reqUi.setGender(rset.getString("GENDER"));
				reqUi.setBirthday(rset.getDate("BIRTHDAY"));
				reqUi.setJob(rset.getString("JOB"));
				reqUi.setNickName(rset.getString("NICK_NAME"));
				reqUi.setMsg(rset.getString("MESSAGE"));
				reqUi.setGrade(rset.getString("GRADE"));
				reqUi.setUserId(rset.getString("M_ID"));
				reqUi.setAccount(rset.getString("ACCOUNT"));
				reqUi.setbCode(rset.getString("BANKCODE"));
				reqUi.setHolder(rset.getString("HOLDER"));
				reqUi.setFid(rset.getInt("FID"));
				reqUi.setAge(rset.getInt("AGE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return reqUi;
	}
	
	//UserInfo에 insert
			public int insertUserInfo(Connection con, UserInfo reqUserInfo) {
				PreparedStatement pstmt = null;
				int result = 0;

				String query = prop.getProperty("insertUserInfo");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, reqUserInfo.getGender());
					pstmt.setDate(2, reqUserInfo.getBirthday());
					pstmt.setString(3, reqUserInfo.getJob());
					pstmt.setString(4, reqUserInfo.getUserId());
					pstmt.setString(5, reqUserInfo.getPhone());
					
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}

				return result;
			}
	
	
	public int updateUserInfo(Connection con, UserInfo reqUi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateUserInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqUi.getMsg());
			pstmt.setString(2, reqUi.getNickName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	

}



















