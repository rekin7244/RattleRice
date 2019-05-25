package com.kh.rr.common.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.common.model.dao.ReservationDao;
import com.kh.rr.common.model.vo.PageInfo;

public class ReservationService {

	public int reserveSettleListCount() {
		Connection con = getConnection();
		
		int listCount = new ReservationDao().reserveSettleListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> reserveSettleList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ReservationDao().reserveSettleList(con,pi);
		
		close(con);
		
		return list;
	}

	public int reserveSettleSearchListCount(String brand) {
		Connection con = getConnection();
		
		int listCount = new ReservationDao().reserveSettleSearchListCount(con,brand);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<HashMap<String, Object>> reserveSettleSearchList(PageInfo pi, String brand) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ReservationDao().reserveSettleSearchList(con,pi,brand);
		
		close(con);
		
		return list;
	}
	
	

}
