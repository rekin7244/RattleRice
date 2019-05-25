package com.kh.rr.admin.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.getConnection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		
		//csv 작성
		ArrayList<HashMap<String,Object>> storeList = new StatisticsDao().getStores(con);
		int result = createCSV(storeList,"places","/web/files/");
		
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

	public ArrayList<HashMap<String, Object>> statisticsCoinUse() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String,Object>> list = new StatisticsDao().statisticsCoinUse(con);
		
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
	
	public int createCSV(List<HashMap<String,Object>> list, String title, String filePath) {
		int resultCount = 0;
		
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(filePath+"/"+title+".csv",true));
			
			for (HashMap<String, Object> h : list) {
				fw.write(h.get("name")+","+h.get("lat")+","+h.get("lon"));
				fw.newLine();
				resultCount++;
				if(resultCount % 100 == 0) {
					//log.info("resultCount : "+ resultCount + "/" + list.size());
				}
				
				fw.flush();
				fw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultCount;
	}
	
}
