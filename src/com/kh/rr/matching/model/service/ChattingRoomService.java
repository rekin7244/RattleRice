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

	
}
