package com.kh.rr.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.rr.board.model.vo.Board;
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
}