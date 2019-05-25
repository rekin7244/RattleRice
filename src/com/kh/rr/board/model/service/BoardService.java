package com.kh.rr.board.model.service;

import static com.kh.rr.common.JDBCTemplate.close;
import static com.kh.rr.common.JDBCTemplate.commit;
import static com.kh.rr.common.JDBCTemplate.getConnection;
import static com.kh.rr.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.rr.admin.model.dao.AdminDao;
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

	public ArrayList<Board> selectFreeBoardList(PageInfo pi) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectFreeBoardList(con,pi);
		
		close(con);
		
		return list;
	}

	public int getFreeBoardListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getFreeBoardListCount(con);
		
		close(con);
		
		return listCount;
	}

	public int getSearchNoticeListCount(String keyword, String condition) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchNoticeListCount(con, keyword, condition);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> searchNoticeList(PageInfo pi, String keyword, String condition) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().searchNoticeList(con,pi,keyword,condition);
		
		close(con);
		
		return list;
	}

	public int getSearchReviewListCount(String keyword) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchReviewListCount(con, keyword);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> searchReviewList(PageInfo pi, String keyword) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().searchReviewList(con,pi,keyword);
		
		close(con);
		
		return list;
	}

	public int getSearchFaqListCount(String keyword, String condition) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchFaqListCount(con, keyword, condition);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> searchFaqList(PageInfo pi, String keyword, String condition) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().searchFaqList(con,pi,keyword,condition);
		
		close(con);
		
		return list;
	}

	public int getSearchFreeBoardListCount(String keyword) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchFreeBoardListCount(con, keyword);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> searchFreeBoardList(PageInfo pi, String keyword) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().searchFreeBoardList(con,pi,keyword);
		
		close(con);
		
		return list;
	}

	//자유게시판 상세보기
	public Board selectOneFreeBoard(int num) {
		Connection con = getConnection();
		
		Board fb = new BoardDao().selectOneFreeBoard(con, num);
		
		if(fb != null) {
			//자유게시판 조회수 증가
			int result = new BoardDao().updateFreeBoardCount(con, num);
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		close(con);

		return fb;
	}

	//자유게시판 게시글 등록
	public int insertFreeBoard(Board fb) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertFreeBoard(con, fb);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//자유게시판 게시글 삭제하는 메소드
	public int deleteFreeBoard(int num) {
		Connection con = getConnection();
		
		int result = new BoardDao().deleteFreeBoard(con, num);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//자유게시판 게시글 수정하는 메소드
	public int updateFreeBoard(int num, Board fb) {
		Connection con = getConnection();
		
		int result = new BoardDao().updateFreeBoard(con, num, fb);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//직업 게시판 개수 조회하는 메소드
	public int getJobBoardListCount() {
		Connection con = getConnection();
		
		int result = new BoardDao().getJobBoardListCount(con);
		
		close(con);
		
		return result;
	}

	//직업 게시판 목록 조회하는 메소드
	public ArrayList<Board> selectJobBoardList(PageInfo pi) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectJobBoardList(con, pi);
		
		close(con);
		
		return list;
	}
	
	public int getSearchJobListCount(String condition) {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getSearchJobListCount(con, condition);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> searchJobList(PageInfo pi, String condition) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().searchJobList(con,pi,condition);
		
		close(con);
		
		return list;
	}

	//직군게시판 게시글 등록 메소드
	public int insertJobBoard(Board jb) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertJobBoard(con, jb);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//직군게시판 상세보기
	public Board selectOneJobBoard(int num) {
		Connection con = getConnection();
		
		Board jb = new BoardDao().selectOneJobBoard(con, num);
		
		if(jb != null) {
			//자유게시판 조회수 증가
			int result = new BoardDao().updateJobBoardCount(con, num);
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		close(con);

		return jb;
	}

	//직군게시판 게시글 수정 메소드
	public int updateJobBoard(int num, Board jb) {
		Connection con = getConnection();
		
		int result = new BoardDao().updateJobBoard(con, num, jb);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//직군게시판 게시글 삭제 메소드
	public int deleteJobBoard(int num) {
		Connection con = getConnection();
		
		int result = new BoardDao().deleteJobBoard(con, num);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//게시판의 BID 가져오는 메소드
	public int selectfbBid(int num) {
		Connection con = getConnection();
		
		int bid = new BoardDao().selectfbBid(con, num);
		
		close(con);
		
		return bid;
	}

	//게시판에 댓글 달기
	public int insertFBR(HashMap<String, Object> hmap) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertFBR(con, hmap);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	//게시판 댓글 가져오기
	public ArrayList<HashMap<String, Object>> selectReply(int bid) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new BoardDao().selectReply(con, bid);
		
		close(con);
		
		return list;
	}
	
}