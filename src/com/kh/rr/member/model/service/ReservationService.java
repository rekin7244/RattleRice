package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.member.model.dao.ReservationDao;
import com.kh.rr.member.model.vo.Member;
import com.kh.rr.member.model.vo.Reservation;

public class ReservationService {

	public ArrayList<Reservation> selectReservation(Member loginUser) {
		Connection con = getConnection();
		
		ArrayList<Reservation>  list = new ReservationDao().selectReservation(con, loginUser);
		
		close(con);
		
		return list;
	}

}
