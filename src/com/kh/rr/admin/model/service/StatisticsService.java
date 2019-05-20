package com.kh.rr.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.admin.model.dao.StatisticsDao;
import static com.kh.rr.common.JDBCTemplate.*;

public class StatisticsService {
	//회원 통계 메소드
	public int[] statisticsMember() {
		Connection con = getConnection();
		
		int[] mArr = new StatisticsDao().statisticsMember(con);
		
		close(con);
		
		return mArr;
	}
	
	//매장 통계 메소드
	public ArrayList<HashMap<String, Object>> statisticsStore() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new StatisticsDao().statisticsStore(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsSales() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsSales(con);
		
		close(con);
		
		return list;
	}
	
}
