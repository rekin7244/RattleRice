package com.kh.rr.board.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.rr.board.model.dao.BoardDao;
import com.kh.rr.board.model.vo.Board;
import com.kh.rr.common.model.vo.PageInfo;

public class BoardService {

	public int getFAQListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getFAQListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectFAQList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectFAQList(con,pi);
		
		close(con);
		
		return list;
	}

	public int getNoticeListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getNoticeListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectNoticeList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectNoticeList(con,pi);
		
		close(con);
		
		return list;
	}

	public int getReviewListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getReviewListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectReviewList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectReviewList(con,pi);
		
		close(con);
		
		return list;
	}
	
}
