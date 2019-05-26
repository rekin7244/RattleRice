package com.kh.rr.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.rr.board.model.vo.Board;
import com.kh.rr.board.model.vo.BoardReply;
import com.kh.rr.common.model.vo.PageInfo;

import static com.kh.rr.common.JDBCTemplate.*;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class
							.getResource("/sql/board/board-query.properties")
							.getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getFAQListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getFAQListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectFAQList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("selectFAQList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("FBID")!=null) {
					b.setFbid(rset.getInt("FBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setfCategory(rset.getString("F_CATEGORY"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getNoticeListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getNoticeListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectNoticeList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("NBID")!=null) {
					b.setNbid(rset.getInt("NBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setTarget(rset.getString("TARGET"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getReviewListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getReviewListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ArrayList<Board> selectReviewList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("RBID")!=null) {
					b.setRbid(rset.getInt("RBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setBrand(rset.getString("BRAND"));
				b.setGrade(rset.getInt("GRADE"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getSearchNoticeListCount(Connection con, String keyword, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		if(condition.equals("")) {
			sql = prop.getProperty("getSearchNoticeListCountAll");
		}else {
			sql = prop.getProperty("getSearchNoticeListCount");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			if(!condition.equals("")) {
				pstmt.setString(2, condition);				
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Board> searchNoticeList(Connection con, PageInfo pi, String keyword, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = "";
		if(!condition.equals("")) {
			sql = prop.getProperty("searchNoticeList");
		}else {
			sql = prop.getProperty("searchNoticeListAll");
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			if(!condition.equals("")) {
				pstmt.setString(2, condition);
				pstmt.setInt(3, pi.getStartPage());
				pstmt.setInt(4, pi.getEndpage());
			}else {
				pstmt.setInt(2, pi.getStartPage());
				pstmt.setInt(3, pi.getEndpage());
			}
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("NBID")!=null) {
					b.setNbid(rset.getInt("NBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setTarget(rset.getString("TARGET"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getSearchReviewListCount(Connection con, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		sql = prop.getProperty("getSearchReviewListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Board> searchReviewList(Connection con, PageInfo pi, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("searchReviewList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, pi.getStartPage());
			pstmt.setInt(3, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("RBID")!=null) {
					b.setRbid(rset.getInt("RBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setBrand(rset.getString("BRAND"));
				b.setGrade(rset.getInt("GRADE"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getSearchFaqListCount(Connection con, String keyword, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		if(condition.equals("")) {
			sql = prop.getProperty("getSearchFaqListCountAll");
		}else {
			sql = prop.getProperty("getSearchFaqListCount");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			if(!condition.equals("")) {
				pstmt.setString(2, condition);				
			}
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Board> searchFaqList(Connection con, PageInfo pi, String keyword, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = "";
		if(!condition.equals("")) {
			sql = prop.getProperty("searchFaqList");
		}else {
			sql = prop.getProperty("searchFaqListAll");
		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			if(!condition.equals("")) {
				pstmt.setString(2, condition);
				pstmt.setInt(3, pi.getStartPage());
				pstmt.setInt(4, pi.getEndpage());
			}else {
				pstmt.setInt(2, pi.getStartPage());
				pstmt.setInt(3, pi.getEndpage());
			}
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("FBID")!=null) {
					b.setFbid(rset.getInt("FBID"));
				}
				b.setWriter(rset.getString("M_NAME"));
				b.setfCategory(rset.getString("F_CATEGORY"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Board> selectFreeBoardList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("selectFreeBoardList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("FBBID")!=null) {
					b.setFbbid(rset.getInt("FBBID"));
				}
				b.setTitle(rset.getString("TITLE"));
				b.setWriter(rset.getString("M_NAME"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setbContent(rset.getString("BCONTENT"));
				list.add(b);
			}
			System.out.println("freeBoardList : " + list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getFreeBoardListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getFreeBoardListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	//자유게시판 등록된 게시글 개수 카운트하는 메소드
	public int getSearchFreeBoardListCount(Connection con, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		sql = prop.getProperty("getSearchFreeBoardListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	//자유게시판 키워드 검색 메소드
	public ArrayList<Board> searchFreeBoardList(Connection con, PageInfo pi, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = prop.getProperty("searchFreeBoardList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, pi.getStartPage());
			pstmt.setInt(3, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("FBBID")!=null) {
					b.setFbbid(rset.getInt("FBBID"));
				}
				b.setTitle(rset.getString("TITLE"));
				b.setWriter(rset.getString("M_NAME"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setbContent(rset.getString("BCONTENT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	//자유게시판 상세보기
	public Board selectOneFreeBoard(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board fb = null;
		
		String query = prop.getProperty("selectOneFreeBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				fb = new Board();
				fb.setFbbid(rset.getInt("FBBID"));
				fb.setTitle(rset.getString("TITLE"));
				fb.setWriter(rset.getString("M_ID"));
				fb.setbDate(rset.getDate("BDATE"));
				fb.setbCount(rset.getInt("BCOUNT"));
				fb.setbContent(rset.getString("BCONTENT"));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return fb;
	}

	//자유게시판 조회수 증가
	public int updateFreeBoardCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateFreeBoardCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		System.out.println("자유게시판 조회수 증가!");
		return result;
	}

	//자유게시판 게시글 등록
	public int insertFreeBoard(Connection con, Board fb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFreeBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			//유저 아이디 받아오기
			pstmt.setString(1, fb.getWriter());
			pstmt.setString(2, fb.getTitle());
			pstmt.setString(3, fb.getbContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		 
		
		return result;
	}

	//자유게시판 게시글 삭제하는 메소드
	public int deleteFreeBoard(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteFreeBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	//자유게시판 게시글 수정하는 메소드
	public int updateFreeBoard(Connection con, int num, Board fb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateFreeBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fb.getTitle());
			pstmt.setString(2, fb.getbContent());
			pstmt.setInt(3, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}
	
	//직업 게시판 개수 조회하는 메소드
	public int getJobBoardListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("getJobBoardListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}

	//직업 게시판 목록 조회하는 메소드
	public ArrayList<Board> selectJobBoardList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String query = prop.getProperty("selectJobBoardList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pi.getStartPage());
			pstmt.setInt(2, pi.getEndpage());
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("JBBID")!=null) {
					b.setJbbid(rset.getInt("JBBID"));
				}
				b.setjCategory(rset.getString("J_CATEGORY"));
				b.setTitle(rset.getString("TITLE"));
				b.setWriter(rset.getString("M_NAME"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setbContent(rset.getString("BCONTENT"));
				list.add(b);
			}
			System.out.println("JobBoardList : " + list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getSearchJobListCount(Connection con, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = "";
		sql = prop.getProperty("getSearchJobListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, condition);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Board> searchJobList(Connection con, PageInfo pi, String condition) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		String sql = "";
		if(!condition.equals("")) {
			sql = prop.getProperty("searchJobList");
		}else {
			sql = prop.getProperty("searchJobListAll");
		}
		try {
			pstmt = con.prepareStatement(sql);
			
			if(!condition.equals("")) {
				pstmt.setString(1, condition);
				pstmt.setInt(2, pi.getStartPage());
				pstmt.setInt(3, pi.getEndpage());
			}else {
				pstmt.setInt(1, pi.getStartPage());
				pstmt.setInt(2, pi.getEndpage());
			}
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board();
				b.setBid(rset.getInt("BID"));
				if(rset.getString("JBBID")!=null) {
					b.setJbbid(rset.getInt("JBBID"));
				}
				b.setjCategory(rset.getString("J_CATEGORY"));
				b.setTitle(rset.getString("TITLE"));
				b.setWriter(rset.getString("M_NAME"));
				b.setbDate(rset.getDate("BDATE"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setbContent(rset.getString("BCONTENT"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	//직군게시판 게시글 등록 메소드
	public int insertJobBoard(Connection con, Board jb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertJobBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			//유저 아이디 받아오기
			pstmt.setString(1, jb.getWriter());
			pstmt.setString(2, jb.getTitle());
			pstmt.setString(3, jb.getbContent());
			pstmt.setString(4, jb.getjCategory());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			
		return result;
	}

	//직군게시판 조회수 증가 메소드
	public int updateJobBoardCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateJobBoardCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		System.out.println("직군게시판 조회수 증가!");
		return result;
	}

	//직군게시판 상세보기
	public Board selectOneJobBoard(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board jb = null;
		
		String query = prop.getProperty("selectOneJobBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				jb = new Board();
				jb.setJbbid(rset.getInt("JBBID"));
				jb.setjCategory(rset.getString("J_CATEGORY"));
				jb.setTitle(rset.getString("TITLE"));
				jb.setWriter(rset.getString("M_ID"));
				jb.setbDate(rset.getDate("BDATE"));
				jb.setbCount(rset.getInt("BCOUNT"));
				jb.setbContent(rset.getString("BCONTENT"));			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return jb;
	}

	//직군게시판 게시글 수정 메소드
	public int updateJobBoard(Connection con, int num, Board jb) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateJobBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, jb.getTitle());
			pstmt.setString(2, jb.getbContent());
			pstmt.setInt(3, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	//직군게시판 게시글 삭제 메소드
	public int deleteJobBoard(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteJobBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	//게시판의 BID 가져오는 메소드
	public int selectfbBid(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bid = 0;
		
		String query = prop.getProperty("selectfbBid");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bid = rset.getInt("BID");			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return bid;
	}

	//게시판에 댓글 달기
	public int insertFBR(Connection con, HashMap<String, Object> hmap) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFBR");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, (int) hmap.get("bid"));
			pstmt.setString(2, (String) hmap.get("writer"));
			pstmt.setString(3, (String) hmap.get("content"));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	//게시판 댓글 가져오기
	public ArrayList<HashMap<String, Object>> selectReply(Connection con, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> list = null;
		
		String query = prop.getProperty("selectReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				HashMap<String, Object> hmap = new HashMap<String, Object>();
				
				hmap.put("reid", rset.getInt("REID"));
				hmap.put("bid", rset.getInt("BID"));
				hmap.put("rwriter", rset.getString("RWRITER"));
				hmap.put("rcontent", rset.getString("RCONTENT"));
				hmap.put("rdate", rset.getString("RDATE"));
				
				if(list != null) {
					list.add(hmap);					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
				
		return list;
	}

	public int insertFBR(Connection con, BoardReply br) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertFBR");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, br.getBid());
			pstmt.setString(2, br.getrWriter());
			pstmt.setString(3, br.getrContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		return result;
	}

	//자유게시판 댓글다는 메소드
	public ArrayList<BoardReply> selectReplyList(Connection con, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardReply> list = null;
		
		String query = prop.getProperty("selectReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<BoardReply>();
			
			while(rset.next()) {
				BoardReply br = new BoardReply();
				
				br.setReid(rset.getInt("REID"));
				br.setBid(rset.getInt("BID"));
				br.setrWriter(rset.getString("RWRITER"));
				br.setrContent(rset.getString("RCONTENT"));
				br.setrDate(rset.getDate("RDATE"));
				
				list.add(br);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
				
		return list;
	}
}