package com.kh.rr.matching.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.matching.model.dao.ChattingRoomDao;
import com.kh.rr.matching.model.vo.ChattingRoom;
import com.kh.rr.member.model.vo.Member;

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
			
		close(con);
		
		return result;
	}

	public int getCurrval(ChattingRoom reqCr) {
		Connection con = getConnection();
		int currval = new ChattingRoomDao().getCurrval(con, reqCr);
		
		close(con);
		
		return currval;
	}
	
	//채팅방 입장시 RoomRecord 테이블에 정보 삽입 하는 메소드
	public int insertRoomRecord(Member loginUser, int rno) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().insertRoomRecord(con, loginUser, rno);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int insertMasterRoomRecord(Member loginUser, int currval) {
		Connection con = getConnection();
		int result = new ChattingRoomDao().insertMasterRoomRecord(con, loginUser, currval);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}




	
}
