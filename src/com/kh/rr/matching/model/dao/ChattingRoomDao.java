package com.kh.rr.matching.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.matching.model.vo.ChattingRoom;
import com.kh.rr.member.model.vo.Member;

public class ChattingRoomDao {
	private Properties prop = new Properties();
	public ChattingRoomDao() {
		String fileName = ChattingRoomDao.class
						.getResource("/sql/matching/matching-query.properties")
						.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//전체 채팅방 목록 조회
	public ArrayList<ChattingRoom> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<ChattingRoom> list = null;
		
		String query = prop.getProperty("selectChat");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<ChattingRoom>();
			while(rset.next()) {
				ChattingRoom cr = new ChattingRoom();
				cr.setRno(rset.getInt("RNO"));
				cr.setpDate(rset.getDate("PDATE"));
				cr.setCategory(rset.getString("CATEGORY"));
				cr.setpTime(rset.getString("PTIME"));
				cr.setmPerson(rset.getInt("MAX_PERSON"));
				cr.setpPerson(rset.getInt("P_PERSON"));
				cr.setLocation(rset.getString("LOCATION"));
				cr.setdTime(rset.getString("DTIME"));
				cr.setStatus(rset.getString("STATUS"));
				cr.setcDate(rset.getDate("CREATE_DATE"));
				cr.setrKind(rset.getString("ROOM_KIND"));
				cr.setrTitle(rset.getString("RTITLE"));
				list.add(cr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}

	//일반 채팅방 생성 메소드
	public int insertChattingRoom(Connection con, ChattingRoom reqCr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertChattingRoom");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqCr.getrTitle());
			pstmt.setDate(2, reqCr.getpDate());
			pstmt.setString(3, reqCr.getCategory());
			pstmt.setString(4, reqCr.getpTime());
			pstmt.setInt(5, reqCr.getmPerson());
			pstmt.setString(6, reqCr.getLocation());
			pstmt.setString(7, reqCr.getrKind());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//프리미엄 채팅방 생성 메소드
	public int insertPremiumChattingRoom(Connection con, ChattingRoom reqCr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPremiumChattingRoom");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqCr.getrTitle());
			pstmt.setDate(2, reqCr.getpDate());
			pstmt.setString(3, reqCr.getCategory());
			pstmt.setString(4, reqCr.getpTime());
			pstmt.setInt(5, reqCr.getmPerson());
			pstmt.setString(6, reqCr.getLocation());
			pstmt.setString(7, reqCr.getrKind());
			pstmt.setString(8, reqCr.getsRatio());
			pstmt.setString(9, reqCr.getJob());
			pstmt.setInt(10, reqCr.getAge());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int getCurrval(Connection con, ChattingRoom reqCr) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int currval = 0;
		
		
		String query = prop.getProperty("getCurrval");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqCr.getrTitle());
			pstmt.setDate(2, reqCr.getpDate());
			pstmt.setString(3, reqCr.getCategory());
			pstmt.setString(4, reqCr.getpTime());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				currval = rset.getInt("RNO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return currval;
	}
	
	//채팅방 입장시 RoomRecord 테이블에 정보 삽입 하는 메소드
	public int insertRoomRecord(Connection con, Member loginUser, int rno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertRoomRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			pstmt.setString(2, "USER");
			pstmt.setString(3, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//방장이 채팅방 생성시 RoomRecord 테이블에 정보 삽입하는 메소드
	public int insertMasterRoomRecord(Connection con, Member loginUser, int currval) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertMasterRoomRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, currval);
			pstmt.setString(2, "MASTER");
			pstmt.setString(3, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Member checkUserType(Connection con, Member loginUser, int rno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member checkUser = null;
		String query = prop.getProperty("checkUserType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginUser.getUserId());
			pstmt.setInt(2, rno);
			
			rset = pstmt.executeQuery();
			
			checkUser = new Member();
			if(rset.next()) {
				checkUser.setUserId(rset.getString("M_ID"));
				checkUser.setUserName(rset.getString("M_NAME"));
				checkUser.setStatus(rset.getString("M_STATUS"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return checkUser;
	}

	//방장이 나갔을때 그 방을 없애는 메소드
	public int deleteChattingRoom(Connection con, int rno) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteChattingRoom");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	//방장이 채팅방을 나갔을때 관련된 룸레코드를 전부 없애는 메소드
	public int deleteAllRoomRecord(Connection con, int rno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteAllRoomRecord");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//일반 사용자가 채팅방을 나갔을 때 사용자와 관련된 룸레코드 전부 없애는 메소드
	public int deleteRoomRecord(Connection con, Member loginUser, int rno) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteRoomRecord");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			pstmt.setString(2, loginUser.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	//채팅방에 있는 사용자 정보 불러오는 메소드
	public ArrayList<Member> getUserList(Connection con, int rno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		String query = prop.getProperty("getUserList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("M_ID"));
				m.setUserName(rset.getString("M_NAME"));
				m.setStatus(rset.getString("M_STATUS"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	//채팅방 조건검색 메소드
	public ArrayList<ChattingRoom> searchChattingRoom(Connection con, HashMap<String, Object> searchMap) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChattingRoom> list = null;
		
		String query = "SELECT * FROM CHATTINGROOM WHERE STATUS ='Y'";
		
		try {
			
			//넘어온 값에 따라서 동적으로 쿼리 생성
			if(!searchMap.get("location").equals("0")) {
				query += " AND LOCATION LIKE '%'||?||'%'";
			}
			
			if(searchMap.get("date") != null) {
				System.out.println(searchMap.get("date"));
				query += " AND PDATE =?";
			}
			
			if(!searchMap.get("time").equals("undefined")) {
				query += " AND PTIME LIKE '%'||?||'%'";
			}
			
			if(!searchMap.get("member").equals("0")) {
				query += " AND MAX_PERSON =?";
			}
			
			if(!searchMap.get("category").equals("0")) {
				query += " AND CATEGORY IS ?";
			}
			if(!searchMap.get("age").equals("0")) {
				query += " AND AGE IS ?";
			}
			
			if(!searchMap.get("job").equals("0")) {
				query += " AND JOB IS ?";
			}
			
			pstmt = con.prepareStatement(query);
			
			//분기에따라 달라질 pstmt값을 위한 변수 count
			int count = 1;
			if(!searchMap.get("location").equals("0")) {
				pstmt.setString(count, (String)searchMap.get("location"));
				++count;
			}
			if(searchMap.get("date") != null) {
				pstmt.setDate(count, java.sql.Date.valueOf((String) searchMap.get("date")));
				++count;
			}
			
			if(!searchMap.get("time").equals("undefined")) {
				pstmt.setString(count, (String) searchMap.get("time"));
				++count;
			}
			
			if(!searchMap.get("member").equals("0")) {
				pstmt.setInt(count, Integer.parseInt((String) searchMap.get("member")));
				++count;
			}
			
			if(!searchMap.get("category").equals("0")) {
				pstmt.setString(count, (String) searchMap.get("category"));
			}
			if(!searchMap.get("age").equals("0")) {
				pstmt.setInt(count, Integer.parseInt((String) searchMap.get("age")));
				++count;
			}
			
			if(!searchMap.get("job").equals("0")) {
				pstmt.setString(count, (String) searchMap.get("job"));
			}
		
			list = new ArrayList<ChattingRoom>();
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ChattingRoom cr = new ChattingRoom();
				cr.setRno(rset.getInt("RNO"));
				cr.setpDate(rset.getDate("PDATE"));
				cr.setCategory(rset.getString("CATEGORY"));
				cr.setpTime(rset.getString("PTIME"));
				cr.setmPerson(rset.getInt("MAX_PERSON"));
				cr.setpPerson(rset.getInt("P_PERSON"));
				cr.setLocation(rset.getString("LOCATION"));
				cr.setdTime(rset.getString("DTIME"));
				cr.setStatus(rset.getString("STATUS"));
				cr.setcDate(rset.getDate("CREATE_DATE"));
				cr.setrKind(rset.getString("ROOM_KIND"));
				cr.setrTitle(rset.getString("RTITLE"));
				list.add(cr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	//방장으로 들어온건지 아닌지 판단해주는 메소드
	//룸레코드 DB에 기록이 있는지 체크한다
	public int checkMasterRecord(Connection con, Member loginUser, int rno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkMasterRecord");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, rno);
			pstmt.setString(2, loginUser.getUserId());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		return result;
	}

	//마감시간 설정하는 메소드
	public int updateChattingRoom(Connection con, int rno, ChattingRoom reqCr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateChattingRoom");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqCr.getdTime());
			pstmt.setInt(2, rno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
















