package com.kh.rr.matching.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.matching.model.dao.ChattingRoomDao;
import com.kh.rr.matching.model.vo.ChattingRoom;
import static com.kh.rr.common.JDBCTemplate.*;
public class ChattingRoomService {

	public ArrayList<ChattingRoom> selectAll() {
		Connection con = getConnection();
		ArrayList<ChattingRoom> list = new ChattingRoomDao().selectAll(con);
			
		return list;
	}

	public int insertChattingRoom(ChattingRoom reqCr) {
		Connection con = getConnection();
		int result = 0;
		
		//프리미엄 조건인 성별선택이 null이 아니라면 프리미엄 생성으로
		if(reqCr.getsRatio() != null) {
			result = new ChattingRoomDao().insertPremiumChattingRoom(con,reqCr);
		//비어있으면 일반 생성으로
		}else {
			result = new ChattingRoomDao().insertChattingRoom(con, reqCr);
		}
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
			
		
		return result;
	}

	public int getCurrval(ChattingRoom reqCr) {
		Connection con = getConnection();
		int currval = new ChattingRoomDao().getCurrval(con, reqCr);
		
		return currval;
	}




	
}
