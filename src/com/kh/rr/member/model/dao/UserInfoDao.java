package com.kh.rr.member.model.dao;


import static com.kh.rr.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;
import com.kh.rr.member.model.vo.Member;
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
				reqUi.setPhone(rset.getString("PHONE"));
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
			pstmt.setString(6, reqUserInfo.getEmail());
			pstmt.setString(7, reqUserInfo.getMsg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
		
	//사용자 정보 수정용 메소드
	public int ChatUpdateUserInfo(Connection con, UserInfo reqUi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("chatUpdateUserInfo");
		
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

	public int updateProfile(Connection con, UserInfo ui) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateProfile");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ui.getNickName());
			pstmt.setString(2, ui.getMsg());
			pstmt.setString(3, ui.getUserId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateInfo(Connection con, UserInfo ui) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateUserInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ui.getPhone());
			pstmt.setDate(2, ui.getBirthday());
			pstmt.setString(3, ui.getJob());
			pstmt.setString(4, ui.getEmail());
			pstmt.setString(5, ui.getUserId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectUserPoint(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectUserPoint");
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<HashMap<String, Object>>();

			while (rset.next()) {
				hmap = new HashMap<String, Object>();
				hmap.put("point", rset.getInt("POINT"));
				hmap.put("bell", rset.getInt("BELL"));
				hmap.put("date", rset.getDate("TDATE"));
				hmap.put("price", rset.getInt("TPRICE"));
				hmap.put("type", rset.getString("TYPE"));
				hmap.put("unit", rset.getString("UNIT"));
				
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
	
	public int updatePoint(Connection con, String amount, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updatePoint");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, amount);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public HashMap<String, Object> selectCheckEmail(Connection con, String userName, String userId, String email) {
		
		PreparedStatement pstmt = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectCheckEmail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, userName);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("email", rset.getString("EMAIL"));
				hmap.put("userId", rset.getString("M_ID"));
				hmap.put("userName", rset.getString("M_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return hmap;
		
	}

	public int selectCheckEmailPwd(Connection con, String userName, String userId, String email) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("selectCheckEmailPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, userId);
			pstmt.setString(3, userName);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int updateCheckEmailPwd(Connection con, String userId, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCheckEmailPwd");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	//벨 충전 시키는 메소드
	public int chargeBell(Connection con, int bell, Member loginUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("chargeBell");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bell);
			pstmt.setInt(2, bell);
			pstmt.setString(3, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> SelectMyWrite(Connection con, String userId, PageInfo pi) {
		PreparedStatement pstmt = null;
		ArrayList<Board> list = null;
		Board board = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectMyWrite");
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while (rset.next()) {
				board = new Board();
				
				board.setBid(rset.getInt("BID"));
				board.setbType(rset.getString("BTYPE"));
				board.setTitle(rset.getString("TITLE"));
				board.setWriter(rset.getString("M_ID"));
				board.setbDate(rset.getDate("BDATE"));
				board.setbCount(rset.getInt("BCOUNT"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
		
	}

	public int getListCount(Connection con, String userId) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("listCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;
	}

	
	
	

}



















