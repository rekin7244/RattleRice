package com.kh.rr.matching.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.rr.common.JDBCTemplate.*;
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
				cr.setpKind(rset.getString("PERSON_KIND"));
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

}




























