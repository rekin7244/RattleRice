package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import com.kh.rr.member.model.vo.UserInfo;

public class UserInfoDao {
	private Properties prop = new Properties();
	
	public UserInfoDao() {
		String fileName = UserInfoDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//사용자 정보 조회용 메소드
	public UserInfo userInfo(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserInfo reqUi = null;
		String query = prop.getProperty("userInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				reqUi = new UserInfo();
				reqUi.setGender(rset.getString("GENDER"));
				reqUi.setBirthday(rset.getDate("BIRTHDAY"));
				
				//생일 정보에서 출생 년도 값 가져옴
				SimpleDateFormat ch = new SimpleDateFormat("yyyy-MM-dd");
				String bDay = ch.format(reqUi.getBirthday());
				String bArr [] = bDay.split("-");
				int bYear = Integer.parseInt(bArr[0]);
				
				//캘린더에서 현재 년도 값 가져옴
				Calendar cal = Calendar.getInstance();
				int sysyear = cal.get(Calendar.YEAR);
				
				//나이 설정
				int age = sysyear - bYear + 1;
				reqUi.setAge(age);
				
				reqUi.setJob(rset.getString("JOB"));
				reqUi.setNickName(rset.getString("NICK_NAME"));
				reqUi.setMsg(rset.getString("MESSAGE"));
				reqUi.setGrade(rset.getString("GRADE"));
				reqUi.setUserId(rset.getString("M_ID"));
				reqUi.setAccount(rset.getString("ACCOUNT"));
				reqUi.setbCode(rset.getString("BANKCODE"));
				reqUi.setHolder(rset.getString("HOLDER"));
				reqUi.setPhone(rset.getInt("PHONE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return reqUi;
	}
	
	//사용자 정보 수정용 메소드
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



















