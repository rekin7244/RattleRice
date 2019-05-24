package com.kh.rr.member.model.dao;

import static com.kh.rr.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.Reservation;

public class ReservationDao {
	private Properties prop = new Properties();
	
	public ReservationDao() {
		String fileName = ReservationDao.class.getResource("/sql/reservation/reservation-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Reservation> selectReservation(Connection con, Member loginUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reservation reservation = null;
		ArrayList<Reservation> list = null;
		
		
		String query = prop.getProperty("reservation");
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, loginUser.getUserId());
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Reservation>();
					
			
			while(rset.next()) {
				reservation = new Reservation();
				
				reservation.setUserName(rset.getString("M_NAME"));
				reservation.setmCount(rset.getInt("COUNT"));
				reservation.setPrice(rset.getInt("PRICE"));
				reservation.setrTime(rset.getString("R_TIME"));
				
				list.add(reservation);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}




