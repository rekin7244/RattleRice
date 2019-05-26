package com.kh.rr.admin.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.admin.model.dao.StatisticsDao;

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

	public ArrayList<HashMap<String, Object>> statisticsCoinCharge() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsCoinCharge(con);
		
		close(con);
		
		return list;
	}


	public ArrayList<HashMap<String, Object>> statisticsSettle() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsSettle(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsRefund() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsRefund(con);
		
		close(con);
		
		return list;
	}
	
	public ArrayList<HashMap<String,Object>> getStores(){
		Connection con = getConnection();
		//csv 작성
		ArrayList<HashMap<String,Object>> storeList = new StatisticsDao().getStores(con);
		
		close(con);
		
		return storeList;
	}

	public ArrayList<HashMap<String, Object>> statisticsServiceTime() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().serviceTime(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsServicePlace() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().servicePlace(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsServiceCategory() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsServiceCategory(con);
		
		close(con);
		
		return list;
	}

	public ArrayList<HashMap<String, Object>> statisticsMemberbyJob() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsMemberbyJob(con);
		
		close(con);
		
		return list;
	}
	
}
