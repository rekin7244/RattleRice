package com.kh.rr.member.model.service;

import static com.kh.rr.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.member.model.dao.ReservationDao;
import com.kh.rr.member.model.vo.Member;

public class ReservationService {

	public ArrayList<HashMap<String, Object>> selectReservation(Member loginUser) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ReservationDao().selectReservation(con, loginUser);
				
		close(con);
		
		return list;
	}

}
