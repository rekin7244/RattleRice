package com.kh.rr.matching.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.rr.matching.model.vo.ChattingRoom;

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

	public int insertPremiumChattingRoom(Connection con, ChattingRoom reqCr) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPremiumChattingRoom");
		
		try {
			pstmt = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}




























